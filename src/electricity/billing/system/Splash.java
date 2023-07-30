package electricity.billing.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import electricity.billing.system.helper.ConnectionProvider;

public class Splash extends JFrame implements Runnable{
	
	public Splash() {
		
		JLabel heading = new JLabel("Electricity Billing System");
		heading.setForeground(new Color(201, 22, 40));
		heading.setFont(new Font("Arial",Font.BOLD,30));
		heading.setBounds(150,230,400,40);
		add(heading);
		
		JProgressBar b = new JProgressBar();
		b.setValue(0);
		b.setStringPainted(true);
		b.setBounds(150,350,350,20);
		b.setBackground(Color.WHITE);
		add(b);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/elec.jpg"));
		Image i2 = i1.getImage().getScaledInstance(700, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		add(image);
		
		
		setUndecorated(true);		//Used to remove top bar of frame
		setSize(700,500);
		setLocation(400,100);
		setResizable(false);
		setVisible(true);
		
		Thread t1= new Thread(this);
		t1.start();
		
		int i= 0;
		try {
			while(i<=100) {
				b.setValue(i);
				Thread.sleep(100);
				i+=3;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		new Splash();	
		
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(false);
		dispose();
		new Login();
	}

}
