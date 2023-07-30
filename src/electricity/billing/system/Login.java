package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import electricity.billing.system.helper.ConnectionProvider;

public class Login extends JFrame implements ActionListener {
	JTextField username;
	JPasswordField password;
	Choice logginin;
	JButton login,signup,cancel;
	public Login() {
		super("Login Page");
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon banner = new ImageIcon(ClassLoader.getSystemResource("images/login-banner.jpg"));
		Image i2 = banner.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,300,300);
		add(image);
		
		JLabel jlusername = new JLabel("Username : ");
		jlusername.setBounds(300,40,100,20);
		add(jlusername);
		
		username = new JTextField();
		username.setBounds(401,40,150,20);
		add(username);
		
		
		JLabel jlpassword = new JLabel("Password : ");
		jlpassword.setBounds(300,80,100,20);
		add(jlpassword);
		
		password = new JPasswordField();
		password.setBounds(400,80,150,20);
		add(password);
		
		
		JLabel jlloginas = new JLabel("Loggin in as : ");
		jlloginas.setBounds(300,120,100,20);
		add(jlloginas);
		
		logginin = new Choice();
		logginin.add("Admin");
		logginin.add("Customer");
		logginin.setBounds(400,120,150,20);
		add(logginin);
		
		
		login = new JButton("Login");
		login.setBounds(320,170,100,30);
		login.addActionListener(this);
		add(login);
		
		signup = new JButton("Signup");
		signup.setBounds(440,170,100,30);
		signup.addActionListener(this);
		add(signup);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(390,220,100,30);
		cancel.addActionListener(this);
		add(cancel);
		
		
		setSize(600,350);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Login();	
		//System.out.println(ConnectionProvider.getConnection());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == login) {
			if(!username.getText().equals("") && !password.getPassword().equals("") && !logginin.getSelectedItem().equals("")) {
				String uname = username.getText();
				String pass = new String(password.getPassword());
				String loginas = logginin.getSelectedItem();
				if(ConnectionProvider.userAuth(uname, pass, loginas)) {
					JOptionPane.showMessageDialog(this, "User successfully login.", "Success Message", JOptionPane.PLAIN_MESSAGE);
					new MainPanel();
				}else {
					JOptionPane.showMessageDialog(this, "Please enter valid username and password!", "Warning Message", JOptionPane.WARNING_MESSAGE);
					username.setText("");
					password.setText("");
				}
			}else {
				JOptionPane.showMessageDialog(this, "Please enter all details!", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
		if(e.getSource() == signup) {
			setVisible(false);
			dispose();
			new Signup();
		}
		
		
		if(e.getSource() == cancel) {
			setVisible(false);
			dispose();
		}
		
	}

	
}
