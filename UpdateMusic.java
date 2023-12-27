import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;


public class UpdateMusic extends JFrame implements ActionListener{
	JPanel panel;
	JLabel nameLable,artistLable,durationLable,genreLable, MusicpathLable;
	JTextField nameTF,artistTF,durationTF,genreTF,MusicpathTF,thumpathTF;
	JButton addBtn,backBtn,upThumbnail, updateBtn;;
	ImageIcon bgImage;
	private String thumbPath;
	Color color1,color2;
    Font font2;
	Musics ms;
	Login lg;
	 private JButton openTableButton;
	
	public UpdateMusic(Musics ms){
		super("Update Music");
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		
		color1 = new Color(251, 205, 218);
        color2 = new Color(204,150,248);
        color2 = new Color(204,150,248);
        font2 = new Font("Arial", Font.PLAIN | Font.BOLD, 15);
		
		this.ms = ms;
		
				bgImage = new ImageIcon("Images/pic1.png");

		panel = new JPanel(){
           
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
		
		panel.setLayout(null);
		
		nameLable = new JLabel("Music Name: "); 
		nameLable.setBounds(90, 100, 100, 30);
		nameLable.setForeground(Color.BLACK);
        nameLable.setFont(font2);
		panel.add(nameLable);
		
		nameTF = new JTextField("");
		nameTF.setBounds(190,100,220,30);
		nameTF.setBackground(color1);
		nameTF.setForeground(Color.BLACK);
		nameTF.setFont(font2);
		nameTF.addActionListener(this);
		panel.add(nameTF);
		
		artistLable = new JLabel("Artist: "); 
		artistLable.setBounds(90, 150, 100, 30);
		artistLable.setFont(font2);
		panel.add(artistLable);
		
		artistTF = new JTextField("");
		artistTF.setBounds(190,150,220,30);
	    artistTF.setBackground(color1);
		artistTF.setFont(font2);
		artistTF.setForeground(Color.BLACK);
		artistTF.addActionListener(this);
		panel.add(artistTF);
		
		durationLable = new JLabel("Duration: ");
		durationLable.setBounds(90, 200, 100, 30);
		durationLable.setFont(font2);
		panel.add(durationLable);
		
		durationTF = new JTextField("");
		durationTF.setBounds(190,200,220,30);
		durationTF.setBackground(color1);
		durationTF.setFont(font2);
		durationTF.addActionListener(this);
		panel.add(durationTF);
		
		
		MusicpathLable = new JLabel("Music: "); 
		MusicpathLable.setBounds(90, 250, 100, 30);
		MusicpathLable.setForeground(Color.BLACK);
        MusicpathLable.setFont(font2);
		panel.add(MusicpathLable);
		
		MusicpathTF = new JTextField("");
		MusicpathTF.setBounds(190,250,220,30);
		MusicpathTF.setBackground(color1);
		MusicpathTF.setForeground(Color.BLACK);
		MusicpathTF.setFont(font2);
		MusicpathTF.addActionListener(this);
		panel.add(MusicpathTF);
	
			
		addBtn = new JButton("Add");
		addBtn.setBounds(100,320,150,50);
		addBtn.setBackground(color1);
        addBtn.setForeground(Color.BLACK);
        addBtn.setOpaque(true);
        addBtn.setFont(font2);
		addBtn.setFocusable(false);
		addBtn.addActionListener(this);
		addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(addBtn);
		
		openTableButton = new JButton("View Music");
        openTableButton.setBounds(260,320,150,50);
        openTableButton.setBackground(color1);
        openTableButton.setForeground(Color.BLACK);
        openTableButton.setOpaque(true);
        openTableButton.setFont(font2);
        openTableButton.setFocusable(false);
        openTableButton.addActionListener(this);
        openTableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(openTableButton);
		
		upThumbnail = new JButton("Thumbnail");
		upThumbnail.setBounds(260,380,150,50);
		upThumbnail.setBackground(color1);
        upThumbnail.setForeground(Color.BLACK);
        upThumbnail.setOpaque(true);
        upThumbnail.setFont(font2);
		upThumbnail.setFocusable(false);
		upThumbnail.addActionListener(this);
		upThumbnail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(upThumbnail);
		

        updateBtn = new JButton("Update");
        updateBtn.setBounds(100,380,150,50);
        updateBtn.setBackground(color1);
        updateBtn.setForeground(Color.BLACK);
        updateBtn.setOpaque(true);
        updateBtn.setFont(font2);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(this);
        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        panel.add(updateBtn);

		
		
		ImageIcon backBtnImage = new ImageIcon("Images/back.jpg");
        backBtn = new JButton(backBtnImage);
        backBtn.setBounds(20,350,100,50);
		backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backBtn.addActionListener(this);
        backBtn.setFont(font2);
        panel.add(backBtn);
		
		this.add(panel);
		this.setVisible(true);
	}
	

	    public void actionPerformed(ActionEvent ae){
			String name = nameTF.getText();
			String artist = artistTF.getText();
			String duration = durationTF.getText();
			String Musicpath =MusicpathTF.getText();
			String contentPath = thumbPath;
			
			if (ae.getSource() == openTableButton) {
            openMusicTable();
        }
			

        if (ae.getSource() == updateBtn) {
            
            if (!name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Music updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter the music name to update.");
            }
        }
			
			if(ae.getSource()==addBtn){
				if((!name.isEmpty()) && (!artist.isEmpty()) && (!duration.isEmpty()) && (!Musicpath.isEmpty()) && (!contentPath.isEmpty())){
						Music m = new Music(name,artist,duration,Musicpath,contentPath);
					    ms.addMusic(m);
					    JOptionPane.showMessageDialog(this, "User registered successfully.");
						
						nameTF.setText("");
						artistTF.setText("");
						durationTF.setText("");
						MusicpathTF.setText("");
						upThumbnail.setText("Thumbnail");
				
					}else{
					JOptionPane.showMessageDialog(this, "Please enter the music name to add");
				    }
			}
			if(ae.getSource()==upThumbnail){
				JFileChooser thumbChoose = new JFileChooser();
                 thumbChoose.setFileFilter(new FileNameExtensionFilter("Images","jpg","jpeg","png"));
                    int res = thumbChoose.showOpenDialog(UpdateMusic.this);
                    if(res == JFileChooser.APPROVE_OPTION){
                     File selectedFile = thumbChoose.getSelectedFile();
 
                       try{
                      Image selectedImage = ImageIO.read(selectedFile);
                          thumbPath = selectedFile.getAbsolutePath();
 
                                     if(thumbPath != null){
                      upThumbnail.setText(thumbPath);
                  }else{
                  upThumbnail.setText("Thumbnail");
                }
 
                       }catch(IOException ex){
                   JOptionPane.showMessageDialog(null,"This file can not be added","Error",JOptionPane.WARNING_MESSAGE);
                }
                  }
			}
			
			if (ae.getSource() == backBtn){
			  new Admin(lg);
			  this.setVisible(false);
			}
		}
		
		 private void openMusicTable() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Music Name");
        model.addColumn("Artist");
        model.addColumn("Duration");
        model.addColumn("Music Path");
        model.addColumn("Thumbnail Path");

        // Add existing music data to the table model if needed

        new MusicTableFrame(ms);
    }

		
	}