package Classes;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class mygui extends JFrame implements ActionListener{
	
    private JLabel l1;
    private JPanel p1;
	private JButton backBtn;
	Home h;
	
    public mygui(Home home){
		super("About Us");
		
		this.h = home;
		this.setSize(1000, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		ImageIcon iconImage = new ImageIcon("Images/img.jpg");
        this.setIconImage(iconImage.getImage());
		
		p1 = new JPanel();
		p1.setBounds(0,0,1200, 700);
		this.setLocationRelativeTo(null);
		p1.setLayout(null);

		JLabel l1 = new JLabel("Developed By");
		l1.setBounds(350,50,200,40);
		l1.setFont(new Font("Segoe UI",Font.BOLD,30));
		p1.add(l1);

		ImageIcon ic1 = new ImageIcon("Images/p1.png");
		JLabel l2 = new JLabel(ic1);
		l2.setBounds(100,140,160,160);
		p1.add(l2);

		JLabel l5 = new JLabel("Abid Rahman");
		l5.setBounds(140,320,310,40);
		l5.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l5);

		JLabel l6 = new JLabel("ID: 22-49280-3");
		l6.setBounds(145,340,320,40);
		l6.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l6);

		ImageIcon ic2 = new ImageIcon("Images/p2.png");
		JLabel l3 = new JLabel(ic2);
		l3.setBounds(300,140,160,160);
		p1.add(l3);

		JLabel l7 = new JLabel("Fareha Rahman");
		l7.setBounds(320,320,300,40);
		l7.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l7);

		JLabel l8 = new JLabel("ID: 22-49828-3");
		l8.setBounds(330,340,320,40);
		l8.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l8);

		ImageIcon ic3 = new ImageIcon("Images/p3.png");
		JLabel l4 = new JLabel(ic3);
		l4.setBounds(500,140,160,160);
		p1.add(l4);

		JLabel l9 = new JLabel("RIMON");
		l9.setBounds(540,320,260,40);
		l9.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l9);

		JLabel l10 = new JLabel("ID: 22-49762-3");
		l10.setBounds(530,340,320,40);
		l10.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l10);
		
		ImageIcon ic4 = new ImageIcon("Images/p4.png");
		JLabel l00 = new JLabel(ic4);
		l00.setBounds(700,140,160,160);
		p1.add(l00);

		JLabel l0 = new JLabel("MASHIHUR RAHMAN");
		l0.setBounds(700,320,320,40);
		l0.setFont(new Font("Segoe UI",Font.BOLD,15));
		p1.add(l0);

		JLabel l11 = new JLabel("ID: 22-49755-3");
		l11.setBounds(730,340,320,40);
		l11.setFont(new Font("Segoe UI",Font.BOLD,12));
		p1.add(l11);
		
		ImageIcon backBtnImage = new ImageIcon("Images/back.jpg");
        backBtn = new JButton(backBtnImage);
        backBtn.setBounds(30,400,100,50);
		backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        backBtn.addActionListener(this);
        p1.add(backBtn);
		
		this.add(p1);
		this.setVisible(true);
		
	}
	 public void actionPerformed(ActionEvent ae){
		  if (ae.getSource() == backBtn){
			 if (h != null) {
                h.setVisible(true);
            }
			  this.setVisible(false);
		      }
	 }
	
}