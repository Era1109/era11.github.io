package Classes;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsGUI extends JFrame {
    private JTextField userTF, addressTF;
    private JLabel userLabel, genderLabel, dobLabel, addressLabel;
    private JComboBox<String> date, month, year;
    private JRadioButton r1, r2, r3;
    private ButtonGroup bg;
    private JButton clearBtn, updateBtn, backBtn;
    private JPanel panel;
    private Color myColor1, myColor2;
    private Font myFont, myFont2;
    private ImageIcon icon;

    public SettingsGUI(User u) {
        super("Update profile");
        this.setSize(500, 400);
     
        ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        myColor1 = new Color(251, 205, 218);
        myColor2 = new Color(204,150,248);
        myFont = new Font("Century", Font.ITALIC, 17);
        myFont2 = new Font("Times New Roman", Font.PLAIN, 16);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(myColor2);

      
        userLabel = new JLabel("User name: ");
        userLabel.setBounds(50, 90, 100, 30);
        userLabel.setFont(myFont2);
        panel.add(userLabel);

        userTF = new JTextField(u.getName());
        userTF.setBounds(160, 90, 200, 30);
        userTF.setFont(myFont2);
        panel.add(userTF);

 

        clearBtn = new JButton("Clear all");
        clearBtn.setBounds(80, 140, 150, 25);
        clearBtn.setFont(myFont);
        clearBtn.setBackground(myColor1);
        clearBtn.setForeground(Color.BLACK);
   
        clearBtn.addActionListener(new ActionListener() {
       
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(clearBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(250, 140, 100, 25);
        updateBtn.setFont(myFont);
        updateBtn.setBackground(myColor1);
        updateBtn.setForeground(Color.BLACK);
    
        updateBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        panel.add(updateBtn);
		

       ImageIcon backBtnImage = new ImageIcon("Images/back.jpg");
        backBtn = new JButton(backBtnImage);
        backBtn.setBounds(360, 140, 100, 50);
        backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                
                SettingsGUI.this.setVisible(false); 
               
            }
           
        });
        panel.add(backBtn);

        this.add(panel);
        this.setVisible(true);
    }
}
