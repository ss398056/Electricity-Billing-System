package electricity.billing.system;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainPanel extends JFrame {
	
	public MainPanel() {
		super("Electricity Billing System");
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/main-banner.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		
		JMenu jm1 = new JMenu("Master");
		jm1.setFont(new Font("Arial",Font.BOLD,17));
		jm1.setForeground(new Color(155, 130, 232));
		mb.add(jm1);
		
		JMenuItem newCustomer = new JMenuItem("New Customer");
		newCustomer.setFont(new Font("Arial",Font.PLAIN,15));
		newCustomer.setBackground(Color.WHITE);
		newCustomer.setMnemonic('D');
		newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
		jm1.add(newCustomer);
		
		
		/*JMenuItem existingCustomer = new JMenuItem("Existing Customer");
		existingCustomer.setFont(new Font("Arial",Font.PLAIN,15));
		existingCustomer.setBackground(Color.WHITE);
		existingCustomer.setMnemonic('F');
		existingCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,ActionEvent.CTRL_MASK));
		jm1.add(existingCustomer);
		*/
		
		JMenuItem customerDetails = new JMenuItem("Customer Details");
		customerDetails.setFont(new Font("Arial",Font.PLAIN,15));
		customerDetails.setBackground(Color.WHITE);
		customerDetails.setMnemonic('G');
		customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
		jm1.add(customerDetails);
		
		JMenuItem depositDetails = new JMenuItem("Deposit Details");
		depositDetails.setFont(new Font("Arial",Font.PLAIN,15));
		depositDetails.setBackground(Color.WHITE);
		depositDetails.setMnemonic('H');
		depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		jm1.add(depositDetails);
		
		JMenuItem calculateBill = new JMenuItem("Calculate Bill");
		calculateBill.setFont(new Font("Arial",Font.PLAIN,15));
		calculateBill.setBackground(Color.WHITE);
		calculateBill.setMnemonic('J');
		calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
		jm1.add(calculateBill);
		
		
		JMenu jm2 = new JMenu("Information");
		jm2.setFont(new Font("Arial",Font.BOLD,17));
		jm2.setForeground(new Color(155, 130, 232));
		mb.add(jm2);
		
		JMenuItem updateinfo = new JMenuItem("Update Information");
		updateinfo.setFont(new Font("Arial",Font.PLAIN,15));
		updateinfo.setBackground(Color.WHITE);
		updateinfo.setMnemonic('K');
		updateinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
		jm2.add(updateinfo);
		
		JMenuItem viewinfo = new JMenuItem("View Information");
		viewinfo.setFont(new Font("Arial",Font.PLAIN,15));
		viewinfo.setBackground(Color.WHITE);
		viewinfo.setMnemonic('L');
		viewinfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
		jm2.add(viewinfo);
		
		
		JMenu jm3 = new JMenu("User");
		jm3.setFont(new Font("Arial",Font.BOLD,17));
		jm3.setForeground(new Color(155, 130, 232));
		mb.add(jm3);
		
		JMenuItem paybill = new JMenuItem("Pay Bill");
		paybill.setFont(new Font("Arial",Font.PLAIN,15));
		paybill.setBackground(Color.WHITE);
		paybill.setMnemonic('M');
		paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,ActionEvent.CTRL_MASK));
		jm3.add(paybill);
		
		JMenuItem billDetails = new JMenuItem("Bill Details");
		billDetails.setFont(new Font("Arial",Font.PLAIN,15));
		billDetails.setBackground(Color.WHITE);
		billDetails.setMnemonic('N');
		billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		jm3.add(billDetails);
		
		
		JMenu jm4 = new JMenu("Report");
		jm4.setFont(new Font("Arial",Font.BOLD,17));
		jm4.setForeground(new Color(155, 130, 232));
		mb.add(jm4);
		
		JMenuItem generatebill = new JMenuItem("Generate Bill");
		generatebill.setFont(new Font("Arial",Font.PLAIN,15));
		generatebill.setBackground(Color.WHITE);
		generatebill.setMnemonic('O');
		generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
		jm4.add(generatebill);
		
		
		JMenu jm5 = new JMenu("Utility");
		jm5.setFont(new Font("Arial",Font.BOLD,17));
		jm5.setForeground(new Color(155, 130, 232));
		mb.add(jm5);
		
		JMenuItem notepad = new JMenuItem("Notepad");
		notepad.setFont(new Font("Arial",Font.PLAIN,15));
		notepad.setBackground(Color.WHITE);
		notepad.setMnemonic('P');
		notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		jm5.add(notepad);
		
		JMenuItem calculator = new JMenuItem("Calculator");
		calculator.setFont(new Font("Arial",Font.PLAIN,15));
		calculator.setBackground(Color.WHITE);
		calculator.setMnemonic('R');
		calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		jm5.add(calculator);
		
		
		JMenu jm6 = new JMenu("Exit");
		jm6.setFont(new Font("Arial",Font.BOLD,17));
		jm6.setForeground(new Color(155, 130, 232));
		mb.add(jm6);
		
		JMenuItem quit = new JMenuItem("Quit");
		quit.setFont(new Font("Arial",Font.PLAIN,15));
		quit.setBackground(Color.WHITE);
		quit.setMnemonic('Q');
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,ActionEvent.CTRL_MASK));
		jm6.add(quit);
		
		
		
		setLayout(new FlowLayout());
		setVisible(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	
	public static void main(String args[]) {
		new MainPanel();
	}

}
