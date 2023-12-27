package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdatePassword extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel userLabel, passwordLabel, confirmPassLabel;
	JPasswordField passwordTF, confirmPasswordTF;
	JButton searchBtn,cancelBtn,updateBtn;
	Color color1,color2, color3;
    Font font2, font3;
	ImageIcon icon,bgImage;
	
	Login lg;
	Users us;
	
	String pass="", confirmPass="", newPass="";
	int index = -1;
	
	public UpdatePassword(Users us,Login lg,String name,int index){
		super("Upadte password");
		this.setSize(600,700);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		this.lg = lg;
		this.us = us;
		this.index = index;
		
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
		
		userLabel = new JLabel("User name: "+ name); 
		userLabel.setBounds(50,100,300,30);
		userLabel.setFont(font3);
		panel.add(userLabel);
		
		passwordLabel = new JLabel("New Password: ");
		passwordLabel.setBounds(50,150,200,30);
		passwordLabel.setFont(font3);
		panel.add(passwordLabel);
		
		passwordTF = new JPasswordField();
		passwordTF.setBounds(260,150,250,30);
		passwordTF.setFont(font2);
		passwordTF.setEchoChar('*');
		panel.add(passwordTF);
		
		confirmPassLabel = new JLabel("Confirm Password: ");
		confirmPassLabel.setBounds(50,190,200,30);
		confirmPassLabel.setFont(font3);
		panel.add(confirmPassLabel);
		
		confirmPasswordTF = new JPasswordField();
		confirmPasswordTF.setBounds(260,190,250,30);
		confirmPasswordTF.setFont(font2);
		confirmPasswordTF.setEchoChar('*');
		panel.add(confirmPasswordTF);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(250,230,90,30);
		updateBtn.setFont(font2);
		updateBtn.setBackground(color2);
		updateBtn.setForeground(Color.BLACK);
		updateBtn.addMouseListener(this);
		updateBtn.addActionListener(this);
		updateBtn.setBorder(null);
		panel.add(updateBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(150,230,90,30);
		cancelBtn.setFont(font2);
		cancelBtn.setBackground(color2);
		cancelBtn.setForeground(Color.RED);
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
		if(updateBtn.getText().equals(command)){
			pass = passwordTF.getText();
			confirmPass = confirmPasswordTF.getText();
			if((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))){
				newPass = pass;
					
				us.updatePassword(index,newPass);
				JOptionPane.showMessageDialog(this, "Password updated. Please login to continue.");
				
				lg.setVisible(true);
				this.setVisible(false);
			}else{
				JOptionPane.showMessageDialog(this, "Password missmatch!");
			}
		}else if(cancelBtn.getText().equals(command)){
			lg.setVisible(true);
			this.setVisible(false);
		}else{}
	}
}