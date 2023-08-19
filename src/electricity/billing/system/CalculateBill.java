package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import electricity.billing.system.entity.Customer;
import electricity.billing.system.helper.ConnectionProvider;


public class CalculateBill extends JFrame implements ActionListener {
	String address,name,city,state;
	JTextField unit;
	JLabel jl2name,jl2address,jl2citystate,calculatedbill;
	Choice month,meterno;
	JButton calculate,cancel;
	long meterNo;
	
	public CalculateBill() {
		super("Calculate Bill");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		
		p1.setLayout(null);
		p1.setBackground(new Color(164,221,230,255));
		add(p1);
		
		JLabel heading = new JLabel("Calculate Bill");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(200,20,300,30);
		p1.add(heading);
		
		JLabel jl1meterno = new JLabel("Meter No : ");
		jl1meterno.setBounds(100,80,150,20);
		p1.add(jl1meterno);
		
		meterno = new Choice();
		meterno.setBounds(250,80,200,20);
		if(ConnectionProvider.getAllCustomer()!=null) {
			ArrayList<Customer> customer = ConnectionProvider.getAllCustomer();
			for(Customer cust : customer) {
				meterno.add(""+cust.getMeterno()+"");
			}
		}
		p1.add(meterno);
		
		meterNo = Long.parseLong(meterno.getSelectedItem());
		Customer cust = ConnectionProvider.getCustomerIdByMeterNo(meterNo);
		meterno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				meterNo = Long.parseLong(meterno.getSelectedItem());
				Customer cust = ConnectionProvider.getCustomerIdByMeterNo(meterNo);
				name = cust.getName();
				address = cust.getAddress();
				city = cust.getCity();
				state = cust.getState();
				jl2name.setText(name);
				jl2address.setText(address);
				jl2citystate.setText(city+", "+state);
				
			}
		});
		
		
		JLabel jl1name = new JLabel("Full Name : ");
		jl1name.setBounds(100,120,150,20);
		p1.add(jl1name);
		
		name = cust.getName();
		jl2name = new JLabel(name);
		jl2name.setBounds(250,120,200,20);
		p1.add(jl2name);
		
		
		JLabel jl1address = new JLabel("Address : ");
		jl1address.setBounds(100,160,200,20);
		p1.add(jl1address);
		
		
		address = cust.getAddress();
		city = cust.getCity();
		state = cust.getState();
		jl2address = new JLabel(address);
		jl2address.setBounds(250,160,300,20);
		p1.add(jl2address);
		jl2citystate = new JLabel(city+", "+state);
		jl2citystate.setBounds(250,180,200,20);
		p1.add(jl2citystate);
		
	
		JLabel jlunitconsumed = new JLabel("Unit Consumed : ");
		jlunitconsumed.setBounds(100,220,200,20);
		p1.add(jlunitconsumed);
		
		unit = new JTextField();
		unit.setBounds(250,220,200,20);
		p1.add(unit);
		
		
		JLabel jlmonth = new JLabel("Month : ");
		jlmonth.setBounds(100,270,150,20);
		p1.add(jlmonth);
		
		month = new Choice();
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");
		month.setBounds(250,270,200,20);
		p1.add(month);
		
		
		JLabel jlcalculatebill = new JLabel("Total Bill Amount : ");
		jlcalculatebill.setBounds(100,310,150,20);
		p1.add(jlcalculatebill);
		
		calculatedbill = new JLabel("");
		calculatedbill.setBounds(250,310,150,20);
		p1.add(calculatedbill);
		
		calculate = new JButton("Calculate");
		calculate.setBounds(100,420,100,30);
		p1.add(calculate);
		calculate.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300,420,100,30);
		p1.add(cancel);
		cancel.addActionListener(this);
		
		
		
		setSize(600,550);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new CalculateBill();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == calculate) {
			
			if(!unit.getText().equals("")) {
				int cunit = Integer.parseInt(unit.getText());
				String months = month.getSelectedItem();
				long meterNumber = Long.parseLong(meterno.getSelectedItem());
				int unitPrice = 7;
				int serviceTax = 250;
				int totalbillamt = serviceTax+(cunit*unitPrice);
				calculatedbill.setText("Rs."+totalbillamt);
				if(ConnectionProvider.addBillDetails(meterNumber, cunit, months, totalbillamt,"not paid")) {
					JOptionPane.showMessageDialog(this, "Bill generated Successfully.", "Success Message", JOptionPane.PLAIN_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(this, "Something went wrong!\nplease try again.", "Warning Message", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(this, "Enter consumed unit.", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource() == cancel) {
			setVisible(false);
			new MainPanel();
		}
		
	}

}
