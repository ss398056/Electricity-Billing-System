package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import electricity.billing.system.helper.ConnectionProvider;


public class NewCustomer extends JFrame implements ActionListener {
	
	JTextField name,city,state,email,mobile;
	JTextArea address;
	JButton next,cancel;
	long meterNo;
	
	public NewCustomer() {
		super("New Customer");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(null);
		p1.setBackground(new Color(164,221,230,255));
		add(p1);
		
		JLabel heading = new JLabel("Create New Customer");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(150,20,300,30);
		p1.add(heading);
		
		JLabel jlname = new JLabel("Full Name : ");
		jlname.setBounds(100,80,200,20);
		p1.add(jlname);
		
		name = new JTextField();
		name.setBounds(250,80,200,20);
		p1.add(name);
		
		
		Random rand = new Random();
		meterNo = rand.nextInt();
		JLabel jl1meterNo = new JLabel("Meter Number : ");
		jl1meterNo.setBounds(100,120,200,20);
		p1.add(jl1meterNo);
		
		JLabel jl2meterNo = new JLabel(""+Math.abs(meterNo)+"");
		jl2meterNo.setBounds(250,120,200,20);
		p1.add(jl2meterNo);
		
		
		JLabel jladdress = new JLabel("Address : ");
		jladdress.setBounds(100,160,200,20);
		p1.add(jladdress);
		
		address = new JTextArea();
		address.setBounds(250,160,200,50);
		p1.add(address);
		
	
		JLabel jlcity = new JLabel("City : ");
		jlcity.setBounds(100,230,200,20);
		p1.add(jlcity);
		
		city = new JTextField();
		city.setBounds(250,230,200,20);
		p1.add(city);
		
		
		JLabel jlstate = new JLabel("State : ");
		jlstate.setBounds(100,270,200,20);
		p1.add(jlstate);
		
		state = new JTextField();
		state.setBounds(250,270,200,20);
		p1.add(state);
		
		
		JLabel jlmobile = new JLabel("Mobile No. : ");
		jlmobile.setBounds(100,310,200,20);
		p1.add(jlmobile);
		
		mobile = new JTextField();
		mobile.setBounds(250,310,200,20);
		p1.add(mobile);
		
		
		JLabel jlemail = new JLabel("Email : ");
		jlemail.setBounds(100,350,200,20);
		p1.add(jlemail);
		
		email = new JTextField();
		email.setBounds(250,350,200,20);
		p1.add(email);
		
		
		
		next = new JButton("Next");
		next.setBounds(100,420,100,30);
		p1.add(next);
		next.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300,420,100,30);
		p1.add(cancel);
		cancel.addActionListener(this);
		
		
		
		setSize(600,600);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new NewCustomer();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == next) {
			if(mobile.getText().length()==10) {
				if(!name.getText().equals("") && !email.getText().equals("") && !address.getText().equals("") && !city.getText().equals("") && !state.getText().equals("") ) {
					String fname = name.getText();
					long mobileNo = Long.parseLong(mobile.getText());
					long meterno = meterNo;
					String cemail = email.getText();
					String caddress = address.getText();
					String ccity = city.getText();
					String cstate = state.getText();
					if(ConnectionProvider.addCustomer(fname, meterno, mobileNo, cemail, caddress, ccity, cstate)) {
						if(ConnectionProvider.addUser(fname, meterno, " ", "", "")) {
							JOptionPane.showMessageDialog(this, "New Customer Account Created Sccessfully.", "Success Message", JOptionPane.PLAIN_MESSAGE);
							setVisible(false);
							new MeterInfo();
						}
					}
				}else {
					JOptionPane.showMessageDialog(this, "Please enter all details!", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Mobile no should be numaric and 10 number length.", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		if(e.getSource() == cancel) {
			System.out.println("Cancel Button");
		}
	}

}
