package electricity.billing.system.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionProvider {
	private static Connection conn;
	private static String url = "jdbc:mysql://localhost:3306/electricity_billing_system";
	private static String username = "root";
	private static String password = "root";
	
	public static Connection getConnection() {
		
		try {
			if(conn==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url,"root","root");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static boolean addUser(String name, long meterno, String username, String password, String accountType) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "insert into user(meterno,name,username,password,accountType) values(?,?,?,?,?)";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			st.setString(2,name);
			st.setString(3,username);
			st.setString(4,password);
			st.setString(5,accountType);
			int i = st.executeUpdate();
			
			if(i>0) {
				flag = true;
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean userAuth(String username, String password, String accountType) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "select * from user where username=? and password=? and  accountType=?";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,username);
			st.setString(2,password);
			st.setString(3,accountType);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				flag = true;
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	public static boolean addCustomer(String name, long meterno, long mobile, String email, String address, String city, String state) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "insert into customer(meterNo,name,mobile,email,address,city,state) values(?,?,?,?,?,?,?)";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			st.setString(2,name);
			st.setLong(3,mobile);
			st.setString(4,email);
			st.setString(5,address);
			st.setString(6,city);
			st.setString(7,state);
			int i = st.executeUpdate();
			
			if(i>0) {
				flag = true;
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
}
