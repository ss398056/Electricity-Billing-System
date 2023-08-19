package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import electricity.billing.system.entity.Bill;
import electricity.billing.system.entity.Customer;
import electricity.billing.system.helper.ConnectionProvider;

public class CustomerDetails extends JFrame implements ActionListener {
	JButton print;
	DefaultTableModel model;
	JTable jt;
	public CustomerDetails() {
		super("Customer Details");
		
		JLabel heading = new JLabel("Customer Details");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(500,20,300,30);
		this.add(heading);
		
		ArrayList<Customer> customers = ConnectionProvider.getAllCustomer();
		
		model = new DefaultTableModel();
	
		jt = new JTable(model);
		model.addColumn("ID");
		model.addColumn("Meter NO.");
		model.addColumn("Name");
		model.addColumn("Mobile NO.");
		model.addColumn("Email");
		model.addColumn("Address");
		model.addColumn("City");
		model.addColumn("State");
		model.addColumn("Created On");
		for(Customer c : customers) {
			model.insertRow(0, new Object[]{c.getId(),c.getMeterno(),c.getName(),c.getMobile(),c.getEmail(),c.getAddress(),c.getCity(),c.getState(),c.getCreated_on()});
		}
		jt.setCellSelectionEnabled(false);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(10,50,1170,450);
		this.add(sp);          
		
		
		
		print = new JButton("Print");
		print.setBounds(550,510,80,25);
		this.add(print);
		print.addActionListener(this);
		
		setSize(1200,600);
		setLocation(100,50);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CustomerDetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==print) {
			try {
				jt.print();
			} catch (PrinterException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
