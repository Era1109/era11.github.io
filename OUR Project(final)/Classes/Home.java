package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.sound.sampled.*;
import java.io.*;
 
public class Home extends JFrame implements ActionListener {
   private JButton homeBtn, myPlaylistBtn, artistsBtn, genreBtn, logoutBtn, settingsBtn; 
    private ImageIcon bgImage;
    private Color myColor1, myColor2, myColor3;
    Login lg;
    User u;
    Users us;
    Musics ms;  
    JPanel musicPanel;  
    private Clip clip;
    private Music playingMusic;
 
    public Home(User u, Users us, Login lg, Musics ms) {
        super("Home");
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));
        ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
 
        this.lg = lg;
        this.u = u;
        this.ms = ms;  
        clip = null;
        playingMusic = null;
 
        myColor1 = new Color(204, 150, 248);
        myColor2 = new Color(236, 166, 208);
        myColor3 = new Color(238, 156, 227);
 
        // Panel with buttons on the left
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1, 0, 10)); 
 
        // Set a standard size for all buttons
        int buttonWidth = 150;
        int buttonHeight = 50;
 
        homeBtn = new JButton("Home");
        homeBtn.setBackground(myColor2);
        homeBtn.setFocusable(false);
        homeBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        homeBtn.addActionListener(this);
        rightPanel.add(homeBtn);
 
        myPlaylistBtn = new JButton("My Playlist");
        myPlaylistBtn.setBackground(myColor2);
        myPlaylistBtn.setFocusable(false);
        myPlaylistBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        myPlaylistBtn.addActionListener(this);
        rightPanel.add(myPlaylistBtn);
 
        artistsBtn = new JButton("Artists");
        artistsBtn.setBackground(myColor2);
        artistsBtn.setFocusable(false);
        artistsBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        artistsBtn.addActionListener(this);
        rightPanel.add(artistsBtn);
 
        genreBtn = new JButton("About");
        genreBtn.setBackground(myColor2);
        genreBtn.setFocusable(false);
		genreBtn.addActionListener(this);
        genreBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        rightPanel.add(genreBtn);
 
        logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(myColor1);
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(this);
        logoutBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        rightPanel.add(logoutBtn);
 
        
        TitledBorder titledBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Menu");
        rightPanel.setBorder(titledBorder);
 
        bgImage = new ImageIcon("Images/Image.png");
 
        JPanel centerPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        centerPanel.setBackground(Color.white);
        centerPanel.setLayout(new BorderLayout());
 
       
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
 
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField searchBar = new JTextField(35);
        JButton searchButton = new JButton("Search");
        searchButton.setBackground(myColor3);
        topLeftPanel.add(searchBar);
        topLeftPanel.add(searchButton);
 
        JPanel topRightPanel = new JPanel();
        topRightPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel usernameLabel = new JLabel(u.getName());
        topRightPanel.add(usernameLabel);
		
        settingsBtn = new JButton("Settings");
        settingsBtn.setBackground(myColor3);
        settingsBtn.addActionListener(this);  
        topRightPanel.add(settingsBtn);



        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);
 
  
        TitledBorder topPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Search");
        topPanel.setBorder(topPanelBorder);
 
        musicPanel = new JPanel();
        musicPanel.setLayout(new GridLayout(0, 3, 10, 10)); 
        populateMusicButtons();  
 
        centerPanel.add(musicPanel, BorderLayout.CENTER);
 
        
        Dimension bottomPanelDimension = new Dimension(buttonWidth, 100); 
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(bottomPanelDimension);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitledBorder bottomPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Bottom");
        bottomPanel.setBorder(bottomPanelBorder);
 
     
        this.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);
        this.add(rightPanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
	private void addToPlaylist(Music music) {
   
    if (!isMusicInPlaylist(music)) {
        try {
            
            FileWriter writer = new FileWriter("Files/Profile/" + u.getName() + "'s_playlist.txt",true);
            
            writer.write(u.getName() + "," + music.getName() + "," + music.getArtist() + "," + music.getDuration()
                    + "," + music.getMusicpath() + "," + music.getThumpath() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(this, "Music added to My Playlist: " + music.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Music is already in My Playlist: " + music.getName());
    }
}
 
private boolean isMusicInPlaylist(Music music) {
    try {
        FileReader reader = new FileReader("Files/Profile/" + u.getName() + "'s_playlist.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
 
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6 && parts[0].equals(u.getName()) && parts[1].equals(music.getName())) {
            
                reader.close();
                return true;
            }
        }
 
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
 
    return false;
}
 
     private void populateMusicButtons() {
        
        Music[] musicList = ms.MusicList;
 
        for (Music music : musicList) {
            if (music != null) {
                
                JPanel entryPanel = new JPanel();
                entryPanel.setLayout(new BorderLayout());
 
                
                JLabel nameLabel = new JLabel(music.getName());
                entryPanel.add(nameLabel, BorderLayout.NORTH);
 
              
                JButton playButton = new JButton("");
                playButton.addActionListener(e -> {
                    playOrStopMusic(music);
                });
                entryPanel.add(playButton, BorderLayout.CENTER);
 
              
                ImageIcon buttonImageIcon = new ImageIcon(music.getThumpath());
                Image scaledImage = buttonImageIcon.getImage().getScaledInstance(270, 100, Image.SCALE_SMOOTH);
                playButton.setIcon(new ImageIcon(scaledImage));
 
               
                musicPanel.add(entryPanel);
            }
        }
    }
 
    private void playOrStopMusic(Music music) {
    boolean musicPlayed = false;
 
    while (true) {
        String[] options;
        if (!musicPlayed) {
            options = new String[]{"Play", "Add to My Playlist", "Stop (Disabled)", "Exit"};
        } else {
            options = new String[]{"Play (Disabled)","Add to My Playlist", "Stop (Playing)", "Exit"};
        }
 
        int choice = JOptionPane.showOptionDialog(this, "Choose an option:", "Music Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
 
        switch (choice) {
            case 0: 
                if (!musicPlayed) {
                    playMusic(music);
                    musicPlayed = true;
                }
                break;
            case 1: 
                addToPlaylist(music);
                break;
            case 2: 
                if (musicPlayed) {
                    stopMusic();
                    musicPlayed = false;
                }
                break;
            case 3: 
                if (musicPlayed) {
                    stopMusic();
                }
                return; 
        }
    }
}
 
    private void playMusic(Music music) {
        try {
            File audioFile = new File(music.getMusicpath());
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
 
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
 
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    stopMusic(); 
                }
            });
 
            clip.start();
            playingMusic = music;
            JOptionPane.showMessageDialog(this,
                    "Playing: " + music.getName() + "\n" +
                            "Artist: " + music.getArtist() + "\n" +
                            "Duration: " + music.getDuration() + "\n");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
 
    private void stopMusic() {
        if (clip != null && playingMusic != null) {
            clip.stop();
            clip.close();
            JOptionPane.showMessageDialog(this, "Stopped playing: " + playingMusic.getName());
            playingMusic = null;  
        }
    }
 
    public void actionPerformed(ActionEvent ae) {
       
        if (ae.getSource() instanceof JButton) {
        JButton sourceButton = (JButton) ae.getSource();
        String musicName = sourceButton.getText();
 
       
        for (Music music : ms.MusicList) {
            if (music != null && music.getName().equals(musicName)) {
                playOrStopMusic(music);  
                break;
            }
        }
    }
	
	if (ae.getSource() == genreBtn) {
			new mygui(this);
			this.setVisible(false);
        }
 
        if (ae.getSource() == artistsBtn) {
            this.setTitle("Artist Section");
            User currentUser = u;
            ArtistSection as = new ArtistSection(currentUser, us, lg, ms);
            as.setVisible(true);
            this.setVisible(false);
        }
 
        if (ae.getSource() == homeBtn) {
            this.setTitle("Home");
            User currentUser = u;
            Home home = new Home(currentUser, us, lg, ms);
            home.setVisible(true);
            this.setVisible(false);
        }
 
        if (ae.getSource() == myPlaylistBtn) {
            this.setTitle("My Playlist");
            User currentUser = u;
            MyPlaylist mp = new MyPlaylist(currentUser, us, lg, ms);
            mp.setVisible(true);
            this.setVisible(false);
        }
 
        if (ae.getSource() == logoutBtn) {
			Login lg =  new Login(us,ms);
            lg.setVisible(true);
            this.setVisible(false);
        }  
		
		if (ae.getSource() == settingsBtn) {
			new SettingsGUI(u);
        }
    }
}