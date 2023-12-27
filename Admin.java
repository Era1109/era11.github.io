
import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.imageio.*;
import java.lang.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;

public class Admin extends JFrame implements ActionListener{
	private JLabel l1,dashboardLabel, userinfoLabel,l4, updateLabel,l6; 
	private JButton signoutButton, userinfoButton,b2, updateButton,b4,b5;
	public JPanel p1;
	public Login lg;
	Users us;
    Musics ms;
	
	 public Admin(Login lg){

		super("Admin Dashboard");
		this.lg = lg;
		this.setSize(900,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setUndecorated(true);
		this.setResizable(false);
		this.setLayout(null);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
			
		p1 = new JPanel();
		p1.setBounds(0,0,850,600);
		p1.setBackground(Color.WHITE);
		this.setLocationRelativeTo(null);
		p1.setLayout(null);

		dashboardLabel = new JLabel("Admin Dashboard");
		dashboardLabel.setFont(new Font("Segoe UI",Font.BOLD,30));
		dashboardLabel.setBounds(460,40,400,35);
		dashboardLabel.setForeground(Color.BLACK);
		p1.add(dashboardLabel);	
		
		userinfoLabel = new JLabel("User information");
		userinfoLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
		userinfoLabel.setBounds(560,250,400,30);
		userinfoLabel.setForeground(Color.BLACK);
		p1.add(userinfoLabel);

		ImageIcon icon2 = new ImageIcon("Images/userinfo.jpg");
		userinfoButton = new JButton(icon2);
		userinfoButton.setBounds(540,120,170,130);
		userinfoButton.addActionListener(this);
		userinfoButton.setFocusPainted(false);
	    userinfoButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    userinfoButton.setContentAreaFilled(false);
		userinfoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(userinfoButton);		
		
		updateLabel = new JLabel("Update Music");
		updateLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
		updateLabel.setBounds(580,470,400,30);
		updateLabel.setForeground(Color.BLACK);
		p1.add(updateLabel);

		ImageIcon icon4 = new ImageIcon("Images/adminInfo.jpg");
		updateButton = new JButton(icon4);
		updateButton.setBounds(540,340,170,130);
		updateButton.addActionListener(this);
		updateButton.setFocusPainted(false);
	    updateButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    updateButton.setContentAreaFilled(false);
		updateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(updateButton);

		signoutButton = new JButton("Sign out");
		signoutButton.setFont(new Font("Segoe UI",Font.BOLD,20));                       
	    signoutButton.setForeground(Color.PINK);
		signoutButton.setFocusPainted(false);
	    signoutButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    signoutButton.setContentAreaFilled(false);
	    signoutButton.setBorder(null);
	    signoutButton.setBounds(720,10,120,40);
	    signoutButton.addActionListener(this);
	    signoutButton.setFocusable(false);
	    signoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    p1.add(signoutButton);

	    ImageIcon i1 = new ImageIcon("Images/admin.png");
		JLabel l7 = new JLabel(i1);
    	l7.setBounds(30,170,320,283);
    	p1.add(l7);
		
    	ImageIcon ic = new ImageIcon("Images/imgg.jpg");
    	JLabel l8 = new JLabel(ic);
    	l8.setBounds(0,0,900,600);
    	p1.add(l8);

	    this.add(p1);
    	this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){

	    if(e.getSource() == signoutButton){
			this.setVisible(false);
			Login lg = new Login(us,ms);
			lg.setVisible(true);
		}
		else if(e.getSource() == userinfoButton){

			this.setVisible(false);
			new UserInformation(this, lg);
		}
		else if(e.getSource() == updateButton){
			Musics ms = new Musics();
              new UpdateMusic(ms);
			this.setVisible(false);
			//new UpdateProducts(this,lg);
		}
	}

	
	
}