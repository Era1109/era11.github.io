package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class forgotPassword extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel userLabel, passwordLabel, confirmPassLabel;
	JTextField userTF;
	JPasswordField passwordTF, confirmPasswordTF;
	JButton searchBtn,cancelBtn;
	Color color1,color2, color3;
    Font font2, font3;
	ImageIcon bgImage,icon;
	Login lg;
	Users us;
	
	public forgotPassword(Users us,Login lg){
		super("Forgot password");
		this.setSize(600,700);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		this.lg =lg;
		this.us = us;
		
		color1 = new Color(251, 205, 218);
        color2 = new Color(204,150,248);
        color2 = new Color(204,150,248);
        color3 = new Color(146, 166, 252);
        font2 = new Font("Arial", Font.PLAIN | Font.BOLD, 15);
        font3 = new Font("Aharonit", Font.PLAIN, 23);
		
		bgImage = new ImageIcon("Images/lgin.jpg");

        panel = new JPanel() {
           
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);
		
		userLabel = new JLabel("Enter user name: "); 
		userLabel.setBounds(50,50,230,30);
		userLabel.setFont(font3);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(240,50,250,30);
		userTF.setFont(font2);
		panel.add(userTF);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(350,100,90,30);
		searchBtn.setFont(font2);
		searchBtn.setBackground(color2);
		searchBtn.setForeground(Color.BLACK);
		searchBtn.addMouseListener(this);
		searchBtn.addActionListener(this);
		searchBtn.setBorder(null);
		panel.add(searchBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(250,100,90,30);
		cancelBtn.setFont(font2);
		cancelBtn.setBackground(color2);
		cancelBtn.setForeground(Color.BLACK);
		cancelBtn.addMouseListener(this);
		cancelBtn.addActionListener(this);
		cancelBtn.setBorder(null);
		panel.add(cancelBtn);

		this.add(panel);
		//this.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){}  
	public void mouseReleased(MouseEvent me){} 

	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(searchBtn.getText().equals(command)){
			String name = userTF.getText();
			int index = us.userExists(name);
			
			if(index!=-1){
				UpdatePassword up = new UpdatePassword(us,lg,name,index);
				up.setVisible(true);
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "Username doesn't exist!");
			}
		}else if(cancelBtn.getText().equals(command)){
			lg.setVisible(true);
			this.setVisible(false);
		}else{}
	}
}