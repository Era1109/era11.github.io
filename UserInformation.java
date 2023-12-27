

import javax.swing.*;    
import java.awt.event.*;  
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.table.*;

public class UserInformation extends JFrame implements ActionListener{

	private JLabel userInfo,userInfoImage,nameLabel,genderLabel,emailLabel,dobLabel,historyLabel,l1,l2,l3,l4;
	private JButton backButton,signoutButton,removeButton,clearButton;
	private JPanel panel;
	private DefaultTableModel model;
	private JTable table;
	public Admin ad;
	public Login lg;
	public Users us;
	public Musics ms;
	public int row = -1;
	
	public UserInformation(Admin ad, Login lg){

		super("User Information");
		this.ad = ad;
		this.lg = lg;
		initializeForm();
		createTable();
		
		this.setVisible(true);
	}
	public void initializeForm(){

		this.setSize(800,700);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setLayout(null);
		this.setLocationRelativeTo(null);
		
	    panel = new JPanel();
	    panel.setBounds(0,0,800,700);
	    panel.setBackground(Color.WHITE);
	    panel.setLayout(null);
		

        userInfo = new JLabel("User Information");
	    userInfo.setFont(new Font("Segoe UI",Font.BOLD,30));
	    userInfo.setBounds(70,15,450,32);
	    userInfo.setForeground(Color.BLACK);
	    panel.add(userInfo);	
	 
	 	ImageIcon icon = new ImageIcon("Images/users-icon.png");
	    userInfoImage = new JLabel(icon);
	    userInfoImage.setBounds(335,50,130,125);
	    panel.add(userInfoImage);
		
		nameLabel = new JLabel("Name    : ");
		nameLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		nameLabel.setBounds(25,220,150,25);
		nameLabel.setForeground(Color.BLACK);
		panel.add(nameLabel);
	 
		l1 = new JLabel();
		l1.setFont(new Font("Segoe UI",Font.BOLD,20));
		l1.setBounds(140,220,250,25);
		l1.setForeground(Color.BLACK);
		panel.add(l1);
	 
		genderLabel = new JLabel("Gender    : ");
		genderLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		genderLabel.setBounds(430,220,150,25);
		genderLabel.setForeground(Color.BLACK);
		panel.add(genderLabel);
	 
		l2 = new JLabel();
		l2.setFont(new Font("Segoe UI",Font.BOLD,20));
		l2.setBounds(540,220,233,25);
		l2.setForeground(Color.BLACK);
		panel.add(l2);
	 
		emailLabel = new JLabel("E-mail   : ");
		emailLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		emailLabel.setBounds(25,270,150,25);
		emailLabel.setForeground(Color.BLACK);
		panel.add(emailLabel);
	 
		l3 = new JLabel();
		l3.setFont(new Font("Segoe UI",Font.BOLD,20));
		l3.setBounds(140,270,250,25);
		l3.setForeground(Color.BLACK);
		panel.add(l3);
	 
		dobLabel = new JLabel("Date of Birth : ");
		dobLabel.setFont(new Font("Segoe UI",Font.BOLD,20));
		dobLabel.setBounds(430,270,200,25);
		dobLabel.setForeground(Color.BLACK);
		panel.add(dobLabel);
		
		l4 = new JLabel();
		l4.setFont(new Font("Segoe UI",Font.BOLD,20));
		l4.setBounds(580,270,170,25);
		l4.setForeground(Color.BLACK);
		panel.add(l4);
	  
		historyLabel = new JLabel("User History");
		historyLabel.setFont(new Font("Segoe UI",Font.BOLD,23));
		historyLabel.setBounds(20,380,200,28);
		historyLabel.setForeground(Color.BLACK);
		panel.add(historyLabel);

		signoutButton = new JButton("Sign out");
		signoutButton.setFont(new Font("Segoe UI",Font.BOLD,20));
	    signoutButton.setForeground(Color.RED);
		signoutButton.setFocusPainted(false);
	    signoutButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    signoutButton.setContentAreaFilled(false);
	    signoutButton.setBorder(null);
		signoutButton.setBounds(670,20,80,28);
		signoutButton.setFocusable(false);
		signoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		signoutButton.addActionListener(this);
		panel.add(signoutButton);
	 
		clearButton = new JButton("Clear");
		clearButton.setFont(new Font("Segoe UI",Font.BOLD,15));
	    clearButton.setForeground(Color.BLUE);
		clearButton.setBounds(560,625,90,28);
		clearButton.setFocusable(false);
		clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearButton.addActionListener(this);
		panel.add(clearButton);
	 
		removeButton = new JButton("Remove");
		removeButton.setFont(new Font("Segoe UI",Font.BOLD,15));
	    removeButton.setForeground(Color.BLUE);
		removeButton.setBounds(660,625,100,28);
		removeButton.setFocusable(false);
		removeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removeButton.addActionListener(this);
		panel.add(removeButton);

		ImageIcon icon1 = new ImageIcon("Images/back.jpg");
		backButton = new JButton(icon1);
		backButton.setBounds(13,15,35,35);
		backButton.setForeground(Color.BLACK);
		backButton.setFocusPainted(false);
	    backButton.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
	    backButton.setContentAreaFilled(false);
	    backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.addActionListener(this);
		panel.add(backButton);
	 
		this.add(panel);
	}
	
	public void createTable(){

		model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Gender");
        model.addColumn("Date of Birth");

		
		table = new JTable(model);
		table.setFont(new Font("Segoe UI",Font.BOLD,12));
		table.setBackground(new Color(174,247,255));
		table.setRowHeight(25);
		table.setSelectionBackground(new Color(255, 153, 51));
		table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,15));
		table.addMouseListener(
			new MouseAdapter(){
				public void mouseClicked(MouseEvent me){

					try{

						row = table.getSelectedRow();
						
						String name = model.getValueAt(row,0).toString();
						String email = model.getValueAt(row,1).toString();
						String gender = model.getValueAt(row,2).toString();
						String dateOfBirth = model.getValueAt(row,3).toString();
						l1.setText(name);
						l2.setText(gender);
				        l3.setText(email);
				        l4.setText(dateOfBirth);

					}
					catch(Exception exp){
					 exp.printStackTrace();
					}
				}
			}
		);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(20,415,745,200);
		
		try {
        Scanner sc = new Scanner(new File("Files/userList.txt"));
        while (sc.hasNextLine()) {

           String sp[] = sc.nextLine().split(",");
				model.addRow(
					new Object[]{
						//taking from userList array
						sp[0],
						sp[2],
						sp[3],
						sp[4]
					});
        }
            sc.close();
        }   catch (IOException ex) {
            ex.printStackTrace();
          }
		
		panel.add(scroll);
	}
	
	public void actionPerformed(ActionEvent e){

		if(e.getSource() == removeButton){

			if(table.getSelectedRow() != -1){

				int option = JOptionPane.showConfirmDialog(this,"Are you Sure to Confirm Update??");
				if(option == JOptionPane.YES_OPTION){
				
					String email = "";
				    model.removeRow(row);
						
					try{

					    File newfile = new File("Files/UserTempInfo.txt");
						File oldfile = new File("Files/userList.txt");
						FileWriter fw = new FileWriter(newfile,true);
			            Scanner sc = new Scanner(oldfile);
			
	                    while(sc.hasNextLine()){

					        String sp[] = sc.nextLine().split(",");
							if(sp[2].equals(l3.getText())){
								

								email = sp[2];
								
							}
							else{

								fw.write(sp[0]+","+sp[1]+","+sp[2]+","+sp[3]+","+sp[4]+"\n");
								
							}
					    }

					    sc.close();
					    fw.close();
					    oldfile.delete();
				        File dump = new File("Files/userList.txt");
				        newfile.renameTo(dump);
				    }
				    catch(IOException ioe){

					   ioe.printStackTrace();
				    }
				    JOptionPane.showMessageDialog(this,(email+" Using Person Remove Successfull"));
				    table.clearSelection();
					l1.setText("");
					l2.setText("");
					l3.setText("");
					l4.setText("");

				}
			}
			else{

				JOptionPane.showMessageDialog(this,"You must have to Select a Row First","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == clearButton){

			table.clearSelection();
			l1.setText("");
			l2.setText("");
			l3.setText("");
			l4.setText("");

		}
		if(e.getSource() == backButton){

			this.setVisible(false);
			ad.setVisible(true);
		}
		if(e.getSource() == signoutButton){

			this.setVisible(false);
			Login lg = new Login(us,ms);
			lg.setVisible(true);
		}
	}

}