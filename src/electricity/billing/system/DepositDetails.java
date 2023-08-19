package electricity.billing.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import electricity.billing.system.entity.Bill;
import electricity.billing.system.entity.Customer;
import electricity.billing.system.helper.ConnectionProvider;

public class DepositDetails extends JFrame implements ActionListener {
	DefaultTableModel model;
	JTable jt;
	Choice meterNo,month;
	long meterno;
	JButton search,print;
	public DepositDetails() {
		super("Deposit Details");
		
		JLabel heading = new JLabel("Deposite Details");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(250,20,300,30);
		this.add(heading);
		
		
		
		JLabel jlmeterno = new JLabel("By Meter No : ");
		jlmeterno.setBounds(50,80,100,20);
		this.add(jlmeterno);
		meterNo = new Choice();
		meterNo.setBounds(150,80,150,20);
		if(ConnectionProvider.getAllCustomer()!=null) {
			ArrayList<Customer> customers = ConnectionProvider.getAllCustomer();
			for(Customer cust : customers) {
				meterNo.add(""+cust.getMeterno());
			}
		}
		this.add(meterNo);
		
		JLabel jlmonth = new JLabel("By Month : ");
		jlmonth.setBounds(400,80,100,20);
		this.add(jlmonth);
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
		month.setBounds(500,80,150,20);
		this.add(month);
		
		search = new JButton("Search");
		search.setBounds(250,120,80,25);
		this.add(search);
		search.addActionListener(this);
		
		
		
		
		ArrayList<Bill> bills = ConnectionProvider.getAllBill();
		
		model = new DefaultTableModel();
	
		jt = new JTable(model);
		
		model.addColumn("Meter NO.");
		model.addColumn("Consumed Units");
		model.addColumn("Total Bill Amount(₹)");
		model.addColumn("Month");
		model.addColumn("Status");
		for(Bill b : bills) {
			model.insertRow(0, new Object[]{b.getMeterNo(),b.getCunit(),b.getTotalbill(),b.getMonth(),b.getStatus()});
		}
		jt.setCellSelectionEnabled(false);
		JScrollPane sp=new JScrollPane(jt);
		sp.setBounds(20,170,650,320);
		this.add(sp);          
		
		
		
		print = new JButton("Print");
		print.setBounds(530,500,80,25);
		this.add(print);
		print.addActionListener(this);
		
		setSize(700,600);
		setLocation(400,100);
		setLayout(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DepositDetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==search) {
			long meterno = Long.parseLong(meterNo.getSelectedItem());
			String months = month.getSelectedItem();
			if(ConnectionProvider.getBillByMeterNoAndMonth(meterno,months)!=null) {
				model.setRowCount(0);
				Bill bill = ConnectionProvider.getBillByMeterNoAndMonth(meterno,months);
				model.insertRow(0, new Object[]{bill.getMeterNo(),bill.getCunit(),bill.getTotalbill(),bill.getMonth(),bill.getStatus()});
			}else {
				JOptionPane.showMessageDialog(this, "Bill not found.", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
			
			
		}
		
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
