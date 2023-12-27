

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements MouseListener, ActionListener{
	JPanel panel;
	JLabel userLabel, passwordLabel, deptLabel, idLabel;
	JButton logoutBtn, showBtn;
	String pass="",hiddenPass="";
	Portal p;
	User u;
	
	public Dashboard(User u, Portal p){
		super("Personal Information");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.p = p;
		this.u = u;
		
		
		panel = new JPanel();
		panel.setLayout(null);
		
		idLabel = new JLabel("ID: "+u.getID()); 
		idLabel.setBounds(50,10,300,30);
		panel.add(idLabel);
		
		userLabel = new JLabel("User name: "+u.getName()); 
		userLabel.setBounds(50,50,300,30);
		panel.add(userLabel);
		
		pass = u.getPassword();
		int passLenghth = pass.length();
		for(int i =0;i<passLenghth;i++){
			hiddenPass += '*';
		}
		passwordLabel = new JLabel("Password: "+hiddenPass);
		passwordLabel.setBounds(50,90,200,30);
		panel.add(passwordLabel);
		
		deptLabel = new JLabel("Department: "+u.getDept());
		deptLabel.setBounds(50,130,300,30);
		panel.add(deptLabel);
		
		
		logoutBtn = new JButton("Log out");
		logoutBtn.setBounds(150,250,80,30);
		logoutBtn.setFocusable(false);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		showBtn = new JButton("Show");
		showBtn.setBounds(300,95,80,25);
		showBtn.setBorder(null);
		showBtn.setFocusable(false);
		showBtn.addMouseListener(this);
		showBtn.addActionListener(this);
		panel.add(showBtn);
		
		this.add(panel);
		this.setVisible(true);
		
	}
	
	public void mouseClicked(MouseEvent me){}  
	public void mouseEntered(MouseEvent me){}  
	public void mouseExited(MouseEvent me){}  
	public void mousePressed(MouseEvent me){
		if(me.getSource() == showBtn){
			passwordLabel.setText("Password: "+pass);
		}
	}  
	public void mouseReleased(MouseEvent me){
		if(me.getSource() == showBtn){
			passwordLabel.setText("Password: "+hiddenPass);
		}
	}
	
	public void actionPerformed(ActionEvent ae){
		String command = ae.getActionCommand();
		if(logoutBtn.getText().equals(command)){
			p.setVisible(true);
			this.setVisible(false);
		}else{	
		}
	}
}
