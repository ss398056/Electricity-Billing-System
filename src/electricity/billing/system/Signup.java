package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.*;

import electricity.billing.system.helper.ConnectionProvider;

public class Signup extends JFrame implements ActionListener{
	
	JButton signup,back;
	Choice accountType;
	JTextField meterNo,username,name;
	JPasswordField password;
	
	public Signup() {
		super("Signup Page");
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel jp1 = new JPanel();
		jp1.setBounds(30,30,640,350);
		jp1.setBackground(Color.WHITE);
		jp1.setLayout(null);
		jp1.setBorder(new TitledBorder(new LineBorder(new Color(73,75,245,255)), "CREATE AN ACCOUNT",TitledBorder.LEADING,TitledBorder.TOP,null,new Color(73,75,245,255)));
		add(jp1);
		
		JLabel heading = new JLabel("Fill all required fields.");
		heading.setForeground(Color.GRAY);
		heading.setFont(new Font("Tahoma",Font.BOLD,14));
		heading.setBounds(50,40,200,20);
		jp1.add(heading);
		
		
		JLabel jlat = new JLabel("Account Type : ");
		jlat.setBounds(40,80,100,20);
		jp1.add(jlat);
		
		accountType = new Choice();
		accountType.add("Admin");
		accountType.add("Customer");
		accountType.setBounds(150,80,150,20);
		jp1.add(accountType);
		
		
		JLabel jlmeter = new JLabel("Meter No. : ");
		jlmeter.setBounds(40,120,100,20);
		jp1.add(jlmeter);
		
		meterNo = new JTextField();
		meterNo.setBounds(150,120,150,20);
		jp1.add(meterNo);
		
		
		JLabel jlusername = new JLabel("Username : ");
		jlusername.setBounds(40,160,100,20);
		jp1.add(jlusername);
		
		username = new JTextField();
		username.setBounds(150,160,150,20);
		jp1.add(username);
		
		JLabel jlname = new JLabel("Full Name : ");
		jlname.setBounds(40,200,100,20);
		jp1.add(jlname);
		
		name = new JTextField();
		name.setBounds(150,200,150,20);
		jp1.add(name);
		
		
		JLabel jlpassword = new JLabel("Password : ");
		jlpassword.setBounds(40,240,100,20);
		jp1.add(jlpassword);
		
		password = new JPasswordField();
		password.setBounds(150,240,150,20);
		jp1.add(password);
		
		
		signup = new JButton("Signup");
		signup.setBounds(40,280,100,30);
		signup.addActionListener(this);
		jp1.add(signup);
		
		back = new JButton("Back");
		back.setBounds(180,280,100,30);
		back.addActionListener(this);
		jp1.add(back);
		
		
		ImageIcon banner = new ImageIcon(ClassLoader.getSystemResource("images/signup-banner.jpg"));
		Image i2 = banner.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300,30,300,300);
		jp1.add(image);
		
		
		setSize(700,430);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Signup();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == signup) {
			
			if(!meterNo.getText().equals("") && !name.getText().equals("") && !username.getText().equals("") && !password.getPassword().equals("") && !accountType.getSelectedItem().equals("")) {
				
				String at = accountType.getSelectedItem();
				String meterno = meterNo.getText();
				String fname = name.getText();
				String uname  = username.getText();
				String pass = new String(password.getPassword());
				long mno = Long.parseLong(meterno);
				
				if(ConnectionProvider.addUser(fname,mno,uname,pass,at)) {
					JOptionPane.showMessageDialog(this, "Account Created Sccessfully.", "Success Message", JOptionPane.PLAIN_MESSAGE);
					setVisible(false);
					dispose();
					new Login();
				}else {
					JOptionPane.showMessageDialog(this, "Something went wrong!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "Please enter all details!", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		
		if(e.getSource() == back) {
			setVisible(false);
			dispose();
			new Login();
		}
		
	}
	
	

}
