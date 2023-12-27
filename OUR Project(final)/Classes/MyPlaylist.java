package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class MyPlaylist extends JFrame implements ActionListener {
    private JButton homeBtn, myPlaylistBtn, artistsBtn, genreBtn, logoutBtn;
    private Color myColor1, myColor2, myColor3;
    Login lg;
    User u;
    Users us;
    Musics ms;
	private Clip clip;
    private Music playingMusic;
 

    public MyPlaylist(User u, Users us, Login lg, Musics ms) {
        super("My Playlist");
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout(10, 10));
        ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());

        this.lg = lg;
        this.u = u;
        this.us = us;
        this.ms = ms;

        myColor1 = new Color(204, 150, 248);
        myColor2 = new Color(236, 166, 208);
        myColor3 = new Color(238, 156, 227);

 
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(5, 1, 0, 10));

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
        rightPanel.add(myPlaylistBtn);

        artistsBtn = new JButton("Artists");
        artistsBtn.setBackground(myColor2);
        artistsBtn.setFocusable(false);
        artistsBtn.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        artistsBtn.addActionListener(this);
        rightPanel.add(artistsBtn);

        genreBtn = new JButton("Genre");
        genreBtn.setBackground(myColor2);
        genreBtn.setFocusable(false);
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

        topPanel.add(topLeftPanel, BorderLayout.WEST);
        topPanel.add(topRightPanel, BorderLayout.EAST);

        TitledBorder topPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Search");
        topPanel.setBorder(topPanelBorder);

       
        displayMyPlaylist();

       
        Dimension bottomPanelDimension = new Dimension(buttonWidth, 100);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(bottomPanelDimension);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitledBorder bottomPanelBorder = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Bottom");
        bottomPanel.setBorder(bottomPanelBorder);

        
        this.add(rightPanel, BorderLayout.WEST);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);

       

        this.setVisible(true);
    }

     private void displayMyPlaylist() {
    try {
        FileReader reader = new FileReader("Files/Profile/" + u.getName() + "'s_playlist.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        
        JPanel musicPanel = new JPanel();
        musicPanel.setLayout(new GridLayout(0, 3, 10, 10)); 

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 6 && parts[0].equals(u.getName())) {
               
                JPanel entryPanel = new JPanel();
                entryPanel.setLayout(new BorderLayout());

                
                ImageIcon thumbnailIcon = new ImageIcon(parts[5]); 
                JLabel thumbnailLabel = new JLabel(thumbnailIcon);
                entryPanel.add(thumbnailLabel, BorderLayout.NORTH);

                
                JLabel musicLabel = new JLabel("Music: " + parts[1]);
                entryPanel.add(musicLabel, BorderLayout.CENTER);

                
                JButton playButton = new JButton("Play");
                playButton.addActionListener(e -> {
                    
                    String musicName = parts[1];
                    String artist = parts[2];
                    String duration = parts[3];
                    String musicPath = parts[4];

                    Music music = new Music(musicName, artist, duration, musicPath, parts[5]);
                    playOrStopMusic(music);
                });
                entryPanel.add(playButton, BorderLayout.WEST);

                
                JButton removeButton = new JButton("Remove");
                removeButton.addActionListener(e -> {
                    
                    removeMusic(parts);
                    refreshPlaylist();  
                });
                entryPanel.add(removeButton, BorderLayout.EAST);

                
                musicPanel.add(entryPanel);
            }
        }

        reader.close();

        
        JScrollPane scrollPane = new JScrollPane(musicPanel);
        this.add(scrollPane, BorderLayout.CENTER);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

private void removeMusic(String[] parts) {
    int choice = JOptionPane.showConfirmDialog(this,
            "Are you sure you want to remove this music from your playlist?",
            "Remove Music", JOptionPane.YES_NO_OPTION);
    if (choice == JOptionPane.YES_OPTION) {
        try {
            File inputFile = new File("Files/Profile/" + u.getName() + "'s_playlist.txt");
            File tempFile = new File("Files/Profile/" + u.getName() + "'s_tempPlaylist.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                
                if (!currentLine.equals(String.join(",", parts))) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            writer.close();
            reader.close();

           
            if (inputFile.delete()) {
               
                if (tempFile.renameTo(inputFile)) {
                    System.out.println("Music removed successfully.");
                } else {
                    System.out.println("Error renaming temp file.");
                }
            } else {
                System.out.println("Error deleting original file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


private void refreshPlaylist() {
    
    Component[] components = this.getContentPane().getComponents();
    for (Component component : components) {
        if (component instanceof JScrollPane) {
            this.remove(component);
            break;
        }
    }
	
	
    displayMyPlaylist();
    revalidate();
    repaint();
}
	
	
	private void playOrStopMusic(Music music) {
    boolean musicPlayed = false;

    while (true) {
        String[] options;
        if (!musicPlayed) {
            options = new String[]{"Play","Stop (Disabled)", "Exit"};
        } else {
            options = new String[]{"Play (Disabled)", "Stop (Playing)", "Exit"};
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
                if (musicPlayed) {
                    stopMusic();
                    musicPlayed = false;
                }
                break;
            case 2: 
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

        if (ae.getSource() == artistsBtn) {
            this.setTitle("Artist Section");
            User currentUser = u;
            ArtistSection as = new ArtistSection(currentUser, us, lg, ms);
            as.setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == logoutBtn) {
            lg.setVisible(true);
            this.setVisible(false);
        }

    }
}
