
package electricity.billing.system;

import java.awt.Choice;
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


public class MeterInfo extends JFrame implements ActionListener {
	
	Choice clocation,metertype,phasecode,billtype;
	JButton submit;
	long meterNo;
	
	public MeterInfo(long meterno) {
		super("Meter Information");
		this.meterNo = meterno;
		JPanel p1 = new JPanel();
		
		p1.setLayout(null);
		p1.setBackground(new Color(164,221,230,255));
		add(p1);
		
		JLabel heading = new JLabel("Meter Information");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(150,20,300,30);
		p1.add(heading);
		
		
		JLabel jl1meterNo = new JLabel("Meter Number : ");
		jl1meterNo.setBounds(100,80,200,20);
		p1.add(jl1meterNo);
		
		JLabel jl2meterNo = new JLabel(""+meterNo+"");
		jl2meterNo.setBounds(250,80,200,20);
		p1.add(jl2meterNo);
		
		
		JLabel jllocation = new JLabel("Meter Location : ");
		jllocation.setBounds(100,120,150,20);
		p1.add(jllocation);
		
		clocation = new Choice();
		clocation.add("Outside");
		clocation.add("Inside");
		clocation.setBounds(250,120,200,20);
		p1.add(clocation);
				
		
		JLabel jlmetertype = new JLabel("Meter Type : ");
		jlmetertype.setBounds(100,160,150,20);
		p1.add(jlmetertype);
		
		metertype = new Choice();
		metertype.add("Electric Meter");
		metertype.add("Solor Meter");
		metertype.add("Smart Meter");
		metertype.setBounds(250,160,200,20);
		p1.add(metertype);
	
		
		JLabel jlphasecode = new JLabel("Phasecode : ");
		jlphasecode.setBounds(100,200,150,20);
		p1.add(jlphasecode);
		
		phasecode = new Choice();
		phasecode.add("054");
		phasecode.add("055");
		phasecode.add("096");
		phasecode.add("098");
		phasecode.add("0106");
		phasecode.setBounds(250,200,100,20);
		p1.add(phasecode);
		
		
		JLabel jlbilltype = new JLabel("Bill Type : ");
		jlbilltype.setBounds(100,240,150,20);
		p1.add(jlbilltype);
		
		billtype = new Choice();
		billtype.add("Normal");
		billtype.add("Industrial");
		billtype.setBounds(250,240,200,20);
		p1.add(billtype);
		
		
		JLabel jlnote = new JLabel("Note : Bill will be generated for 30 days");
		jlnote.setForeground(Color.RED);
		jlnote.setBounds(100,300,400,20);
		p1.add(jlnote);
		
		
		
		submit = new JButton("Submit");
		submit.setBounds(150,380,100,30);
		p1.add(submit);
		submit.addActionListener(this);
		
	
		
		setSize(600,500);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == submit) {
			String meterLocation = clocation.getSelectedItem();
			String meterType = metertype.getSelectedItem();
			String phaseCode = phasecode.getSelectedItem();
			String billType = billtype.getSelectedItem();
			if(ConnectionProvider.addMeterInfo(meterNo, meterLocation, meterType, phaseCode, billType)) {
				JOptionPane.showMessageDialog(this, "New Customer Created Sccessfully.", "Success Message", JOptionPane.PLAIN_MESSAGE);
				setVisible(false);
			}else {
				JOptionPane.showMessageDialog(this, "Something went wrong!\nplease try again.", "Warning Message", JOptionPane.WARNING_MESSAGE);
			}
		}
			
	}

}
