

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Welcome extends JFrame implements ActionListener{
	private JPanel panel;
	private JLabel textLabel;
	private JButton startBtn;
	private Font myFont,myFont2;
	private Color myColor;
	private ImageIcon bgImage;
	Login lg;

	
	public Welcome(Login lg){
		super("Welcome Page");
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		
		this.lg = lg;
		
		myColor = new Color(255,133,191);
		myFont = new Font("Century",Font.ITALIC,17);
		myFont2 = new Font("SansSerif,",Font.ITALIC,26);
		
		bgImage = new ImageIcon("Images/Image.png");
		
		panel = new JPanel(){
			protected void paintComponent(Graphics g){
				super.paintComponent(g);
				//Draw the background image
				g.drawImage(bgImage.getImage(),0,0,getWidth(),getHeight(),this);
			}
		};
		panel.setLayout(null);
		
		textLabel = new JLabel("WELCOME TO HARMONY HUB");
		textLabel.setBounds(230,100,400,100);
		textLabel.setFont(myFont2);
		//textLabel.setBackground(Color.WHITE);
		textLabel.setForeground(myColor);
		textLabel.setOpaque(false);
		panel.add(textLabel);
		
		startBtn = new JButton("Get Started");
		startBtn.setBounds(300,350,250,50);
		startBtn.setFocusable(false);
		startBtn.setFont(myFont);
		startBtn.setBackground(myColor);
		startBtn.setForeground(Color.WHITE);
		//startBtn.setBorder(null);
		startBtn.addActionListener(this);
		panel.add(startBtn);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource() == startBtn){
			//this.setTitle("Artist Section");
			//Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
}