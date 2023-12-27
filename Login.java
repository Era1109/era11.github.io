import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame implements MouseListener, ActionListener {

    private JPanel panel;
    private JLabel loginLabel, emailLabel, passwordLabel, quesLabel;
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private JButton lgnBtn, backBtn, signUpBtn,forgotBtn;
    private Color color1,color2, color3;
    private Font font2, font3;
    private ImageIcon bgImage;
	private String user;
	private boolean flag;
	Users us = new Users();
	Musics ms;
	User u = null;

    public Login(Users us,Musics ms) {
        super("HarmonyHub");
        this.setSize(690, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
		this.setResizable(false);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		
		this.us = us;
        this.ms = ms;
		
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

        loginLabel = new JLabel("Log in to HarmonyHub");
        loginLabel.setBounds(160, 50, 400, 50);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Aharoni", Font.PLAIN | Font.BOLD, 36));
        panel.add(loginLabel);

        emailLabel = new JLabel(" Email: ");
        emailLabel.setBounds(200, 200, 200, 25);
        emailLabel.setForeground(Color.BLACK);
        emailLabel.setFont(font2);
        panel.add(emailLabel);

        emailTF = new JTextField();
        emailTF.setBounds(200, 230, 300, 50);
        emailTF.setBackground(color1);
        emailTF.setForeground(Color.BLACK);
        emailTF.setOpaque(true);
        emailTF.setFont(font2);
        panel.add(emailTF);

        passwordLabel = new JLabel(" Password: ");
        passwordLabel.setBounds(200, 300, 200, 25);
        passwordLabel.setForeground(Color.BLACK);
        passwordLabel.setFont(font2);
        panel.add(passwordLabel);

        passwordTF = new JPasswordField();
        passwordTF.setBounds(200, 330, 300, 50);
        passwordTF.setBackground(color1);
        passwordTF.setForeground(Color.BLACK);
        passwordTF.setOpaque(true);
        passwordTF.setFont(font2);
        passwordTF.setEchoChar('*');
        panel.add(passwordTF);

        lgnBtn = new JButton("Log In");
        lgnBtn.setBounds(200, 450, 260, 50);
        lgnBtn.setBackground(color2);
        lgnBtn.setForeground(Color.BLACK);
        lgnBtn.setOpaque(true);
        lgnBtn.addMouseListener(this);
        lgnBtn.addActionListener(this);
        lgnBtn.setFont(font2);
        panel.add(lgnBtn);

        ImageIcon backBtnImage = new ImageIcon("back.jpg");
        backBtn = new JButton(backBtnImage);
        backBtn.setBounds(480, 450, 80, 40);
		backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backBtn.addActionListener(this);
        backBtn.setFont(font2);
        panel.add(backBtn);

        quesLabel = new JLabel("Don't have an Account?");
        quesLabel.setBounds(250, 580, 280, 50);
        quesLabel.setForeground(Color.BLACK);
        quesLabel.setFont(font3);
        panel.add(quesLabel);

        signUpBtn = new JButton("Sign Up Now");
        signUpBtn.setBounds(270, 650, 160, 40);
        signUpBtn.setBackground(color2);
        signUpBtn.setForeground(Color.BLACK);
        signUpBtn.setOpaque(true);
        signUpBtn.setFont(font2);
		signUpBtn.addActionListener(this);
        panel.add(signUpBtn);
		
		forgotBtn = new JButton("Forgotten password?");
		forgotBtn.setBounds(257, 520, 160, 40);
		forgotBtn.setFont(font2);
		forgotBtn.setBackground(color2);
		forgotBtn.setForeground(Color.MAGENTA);
		forgotBtn.addMouseListener(this);
		forgotBtn.addActionListener(this);
		forgotBtn.setBorder(null);
		panel.add(forgotBtn);

        this.add(panel);
		//this.setVisible(true);
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == lgnBtn) {
            lgnBtn.setBackground(Color.PINK);
			lgnBtn.setForeground(Color.WHITE);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(color1);
            backBtn.setForeground(Color.BLACK);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == lgnBtn) {
            lgnBtn.setBackground(color2);
            lgnBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == backBtn) {
            backBtn.setBackground(color1);
            backBtn.setForeground(Color.BLACK);
        }
    }


    public void mouseClicked(MouseEvent e) {
        // Implement the mouseClicked logic
    }

    public void mousePressed(MouseEvent e) {
        // Implement the mousePressed logic
    }

    public void mouseReleased(MouseEvent e) {
        // Implement the mouseReleased logic
    }
	
	public void actionPerformed(ActionEvent ae) {
    String command = ae.getActionCommand();
    if (lgnBtn.getText().equals(command)) {
        String email = emailTF.getText();
        String pass = passwordTF.getText();
		String LoginInfo = email+","+pass;
		String adminLoginInfo = "admin"+","+"admin";
		
		if (adminLoginInfo.equals(LoginInfo)){
            this.setVisible(false);
            new Admin(this);
			return;
        }

        int index = us.userExists(email);
        if (index != -1) {
            u = us.getUser(index, pass);
            if (u != null) {
                JOptionPane.showMessageDialog(this, "Login successfull!");
                Home h = new Home(u, us, this,ms);
                h.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Password incorrect!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "User doesn't exist!");
        }
    } else if (backBtn.getText().equals(command)) {
		this.setVisible(false);
        new Welcome(this);
    } else if (signUpBtn.getText().equals(command)) {
        SignUp su = new SignUp(us, this);
        su.setVisible(true);
        this.setVisible(false);
    }else if(forgotBtn.getText().equals(command)){
			forgotPassword fp = new forgotPassword(us,this);
			fp.setVisible(true);
			this.setVisible(false);
		}else{}
}
}

   