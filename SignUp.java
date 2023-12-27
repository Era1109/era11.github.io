
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SignUp extends JFrame implements ActionListener{
	JPanel panel;
	JLabel loginLabel,userLabel, passwordLabel,emailLabel, genderLabel, confirmPassLabel;
	JTextField userTF,emailTF;
	JPasswordField passwordTF, confirmPasswordTF;
	JButton signUpBtn,backBtn;
	JRadioButton r1,r2,r3;
	ButtonGroup bg;
	JLabel dobLabel;
    JComboBox date, month, year;
	ImageIcon bgImage;
	Color color1,color2;
    Font font2;
	Users us = new Users();
	Login lg;
	
	private EmailValidator emailValidator = new EmailValidator();

	
	public SignUp(Users us,Login lg){
		super("Sign Up");
		this.setSize(690, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		
		color1 = new Color(251, 205, 218);
        color2 = new Color(204,150,248);
        color2 = new Color(204,150,248);
        font2 = new Font("Arial", Font.PLAIN | Font.BOLD, 15);
		
		this.lg = lg;
		this.us = us;
		
		bgImage = new ImageIcon("Images/lgin.jpg");

		panel = new JPanel(){
           
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(bgImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
		
		panel.setLayout(null);
		
		loginLabel = new JLabel("SignUp in to HarmonyHub");
        loginLabel.setBounds(130, 25, 500, 50);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Aharoni", Font.PLAIN | Font.BOLD, 36));
        panel.add(loginLabel);
		
		userLabel = new JLabel("User name: "); 
		userLabel.setBounds(150, 100, 100, 30);
		userLabel.setForeground(Color.BLACK);
        userLabel.setFont(font2);
		panel.add(userLabel);
		
		userTF = new JTextField("Enter your username...");
		userTF.setBounds(250,100,220,30);
		userTF.setBackground(color1);
		userTF.setForeground(Color.BLACK);
		userTF.setFont(font2);
		userTF.addActionListener(this);
		userTF.addFocusListener(new FocusListener() {
			
			public void focusGained(FocusEvent e) {
				if (userTF.getText().equals("Enter your username...")) {
					userTF.setText("");
					userTF.setOpaque(true);
				}
			}
			
			public void focusLost(FocusEvent e) {
				if (userTF.getText().equals("")) {
					userTF.setText("Enter your username...");
					userTF.setOpaque(false);
				}
			}
		});
		panel.add(userTF);
		
		emailLabel = new JLabel("Email: "); 
		emailLabel.setBounds(150, 150, 100, 30);
		emailLabel.setFont(font2);
		panel.add(emailLabel);
		
		emailTF = new JTextField("Enter a valid email...");
		emailTF.setBounds(250,150,220,30);
		emailTF.setOpaque(false);
	    emailTF.setBackground(color1);
		emailTF.setFont(font2);
		emailTF.setForeground(Color.BLACK);
		emailTF.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (emailTF.getText().equals("Enter a valid email...")) {
					emailTF.setText("");
					emailTF.setOpaque(true);
				}
			}

			public void focusLost(FocusEvent e) {
				if (emailTF.getText().equals("")) {
					emailTF.setText("Enter a valid email...");
					emailTF.setOpaque(false);
				}
			}
		});
		emailTF.addActionListener(this);
		panel.add(emailTF);
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(150, 200, 100, 30);
		passwordLabel.setFont(font2);
		panel.add(passwordLabel);
		
		passwordTF = new JPasswordField("Enter your password...");
		passwordTF.setBounds(250,200,220,30);
		passwordTF.setBackground(color1);
		passwordTF.setOpaque(false);
		passwordTF.setFont(font2);
        passwordTF.setEchoChar((char)0);
		passwordTF.addActionListener(this);
		passwordTF.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (passwordTF.getText().equals("Enter your password...")) {
					passwordTF.setText("");
					passwordTF.setEchoChar('\u2022');
					passwordTF.setOpaque(true);
				}
			}
			
			public void focusLost(FocusEvent e) {
				if (passwordTF.getText().equals("")) {
					passwordTF.setText("Enter your password...");
					passwordTF.setEchoChar((char)0);
					passwordTF.setOpaque(false);
				}
			}
		});
		panel.add(passwordTF);
		
		confirmPassLabel = new JLabel("Confirm Password: ");
		confirmPassLabel.setBounds(90, 250, 150, 30);
		confirmPassLabel.setFont(font2);
		panel.add(confirmPassLabel);
		
		confirmPasswordTF = new JPasswordField("Enter your password again...");
		confirmPasswordTF.setBounds(250,250,220,30);
		confirmPasswordTF.setOpaque(false);
		confirmPasswordTF.setEchoChar((char)0);
		confirmPasswordTF.setBackground(color1);
        confirmPasswordTF.setForeground(Color.BLACK);
		confirmPasswordTF.setFont(font2);
		confirmPasswordTF.addActionListener(this);
		confirmPasswordTF.addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent e) {
				if (confirmPasswordTF.getText().equals("Enter your password again...")) {
					confirmPasswordTF.setText("");
					confirmPasswordTF.setEchoChar('\u2022');
					confirmPasswordTF.setOpaque(true);
				}
			}
			
			public void focusLost(FocusEvent e) {
				if (confirmPasswordTF.getText().equals("")) {
					confirmPasswordTF.setText("Enter your password again...");
					confirmPasswordTF.setEchoChar((char)0);
					confirmPasswordTF.setOpaque(false);
				}
			}
		});
		panel.add(confirmPasswordTF);
	
			
		genderLabel = new JLabel("Gender: ");
		genderLabel.setBounds(150, 300, 100, 30);
	    genderLabel.setFont(font2);
		panel.add(genderLabel);


		r1 = new JRadioButton("Male");
		r1.setBounds(160,350,100,30);
		r1.setBackground(color1);
		r1.setOpaque(false);
		r1.setEnabled(true);
		r1.setFocusable(false);
		r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(270,350,100,30);
		r2.setBackground(color1);
		r2.setOpaque(false);
		r2.setFocusable(false);
		r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(r2);
		
		r3 = new JRadioButton("Other");
		r3.setBounds(380,350,100,30);
		r3.setBackground(color1);
		r3.setOpaque(false);
		r3.setFocusable(false);
		r3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(r3);
		
		bg = new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		dobLabel = new JLabel("Date of Birth:");
		dobLabel.setBounds(150, 400, 100, 30);
		dobLabel.setFont(font2);
		panel.add(dobLabel);
		
		String dates[]= {"1","2","3","4","5","6","7","8","9",
						"10","11","12","13","14","15","16","17",
						"18","19","20","21","22","23","24","25",
						"26","27","28","29","30","31"};
		date = new JComboBox(dates);
		date.setBounds(160,450,50,30);
		date.setBackground(color1);
		panel.add(date);
		
		String months[]= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG", "SEP","OCT","NOV","DEC"};
		month = new JComboBox(months);
		month.setBounds(220,450,80,30);
		month.setBackground(color1);
		panel.add(month);
		
		String years[]= {"1990","1991","1992","1993","1994",
		                 "1995","1996","1997","1998","1999","2000",
						 "2001","2002","2003","2004","2005","2006",
						 "2007","2008","2009","2010","2011","2012",
						 "2013","2014","2015","2016","2017","2018",
						 "2019","2020","2021","2022","2023"};
		year = new JComboBox(years);
		year.setBounds(330,450,80,30);
		year.setBackground(color1);
		panel.add(year);
		
		
		
		signUpBtn = new JButton("Sign Up");
		signUpBtn.setBounds(280,500,150,50);
		signUpBtn.setBackground(color2);
        signUpBtn.setForeground(Color.BLACK);
        signUpBtn.setOpaque(true);
        signUpBtn.setFont(font2);
		signUpBtn.setFocusable(false);
		signUpBtn.addActionListener(this);
		//signUpBtn.setBorder(null);
		signUpBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(signUpBtn);
		
		ImageIcon backBtnImage = new ImageIcon("Images/back.jpg");
        backBtn = new JButton(backBtnImage);
        backBtn.setBounds(450,500,100,50);
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
		
		
		if(ae.getSource() == userTF){
			if(userTF.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter a User Name.");
					userTF.requestFocus();
				}else{
					emailTF.requestFocus();
				}
			
		}
		
		if(ae.getSource() == emailTF){
			if(emailTF.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Please enter your E-mail.");
					emailTF.requestFocus();
				}else{
					bg.setSelected(r1.getModel(), true);
					passwordTF.requestFocus();
				}
		}
		
		if(ae.getSource() == passwordTF){
			if(String.valueOf(passwordTF.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(null,"You must have to enter a password.");
					passwordTF.requestFocus();
				}else{
					signUpBtn.requestFocusInWindow();
				}
		}
		
		if(ae.getSource() == confirmPasswordTF){
			if(String.valueOf(confirmPasswordTF.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(null,"You must have to enter a confirm password.");
					confirmPasswordTF.requestFocus();
				}else{
					signUpBtn.requestFocusInWindow();
				}
		}
		
		if(ae.getSource() == signUpBtn){
			String name = userTF.getText();
			
			if (name.contains(" ") || name.contains(",") || name.contains("(") || name.contains(")") ||
					name.contains("{") || name.contains("}") || name.contains("[") || name.contains("]"))
				{
					JOptionPane.showMessageDialog(null, "Username can only contain Characters, Special Characters & Numbers");
					userTF.setText("Enter your username...");
					return;
				}else if(name.isEmpty()){
					JOptionPane.showMessageDialog(null,"Username can not be empty!");
					return;
				}
				String mail = emailTF.getText();
				
				 if(mail.isEmpty()){
					JOptionPane.showMessageDialog(null,"E-mail can not be empty!");
					return;
				}else if (!emailValidator.validate(mail)) {
					JOptionPane.showMessageDialog(null,"Invalid email address!");
					emailTF.setText("Enter a valid email...");
					emailTF.setOpaque(false);
					return;
				}				
					
		
				String gender = "";
				if (r1.isSelected()) {
					gender = "Male";
				} else if (r2.isSelected()) {
					gender = "Female";
				} else if (r3.isSelected()) {
					gender = "Other";
				} 
				
				String dt = date.getSelectedItem().toString();
			    String mnth = month.getSelectedItem().toString();
			    String yr = year.getSelectedItem().toString();
			    String dob = dt+"/"+mnth+"/"+yr;
				 
				String email = emailTF.getText(); 
				String myPass=""; 
				String pass = String.valueOf(passwordTF.getPassword()); 
				String confirmPass = String.valueOf(confirmPasswordTF.getPassword());
				if((!pass.isEmpty()) && (!confirmPass.isEmpty()) && (pass.equals(confirmPass))){
					myPass = pass;
					if((!email.isEmpty()) && (!name.isEmpty()) && (!gender.isEmpty())){
						User u = new User(name,myPass,email,gender,dob);
					    us.addUser(u);
					    JOptionPane.showMessageDialog(this, "User registered successfully.");
				
					    lg.setVisible(true);
					    this.setVisible(false);
					}else{
					JOptionPane.showMessageDialog(this, "Information missing!");
				    }
				}else{
				JOptionPane.showMessageDialog(this, "Password missmatch/missing!");
			    }
				
				
				}
				
			  if (ae.getSource() == backBtn){
			  lg.setVisible(true);
			  this.setVisible(false);
		      }
				
			} 
		}