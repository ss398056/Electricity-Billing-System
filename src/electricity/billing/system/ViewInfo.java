package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewInfo extends JFrame {

	public ViewInfo() {
		super("View Information");
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(164,221,230,255));
		this.add(p1);
		
		JLabel heading = new JLabel("View Information");
		heading.setFont(new Font("Arial",Font.BOLD,25));
		heading.setForeground(Color.BLUE);
		heading.setBounds(200,20,300,30);
		p1.add(heading);
		
		JLabel jbname = new JLabel("Name : ");
		jbname.setBounds(80,60,150,20);
		p1.add(jbname);
		
		JLabel jbmeterno = new JLabel("Meter No. : ");
		jbmeterno.setBounds(80,100,150,20);
		p1.add(jbmeterno);
		
		JLabel jbmobileno = new JLabel("Mobile No. : ");
		jbmobileno.setBounds(80,140,150,20);
		p1.add(jbmobileno);
		
		JLabel jbemail = new JLabel("Email Id : ");
		jbemail.setBounds(80,180,150,20);
		p1.add(jbemail);
		
		JLabel jbaddress = new JLabel("Address : ");
		jbaddress.setBounds(80,220,150,20);
		p1.add(jbaddress);
		
		JLabel jbcity = new JLabel("City : ");
		jbcity.setBounds(80,260,150,20);
		p1.add(jbcity);
		
		JLabel jbstate = new JLabel("State : ");
		jbstate.setBounds(80,300,150,20);
		p1.add(jbstate);
		setSize(600,500);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ViewInfo();
	}

}
