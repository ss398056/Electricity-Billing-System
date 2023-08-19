package electricity.billing.system.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import electricity.billing.system.entity.Bill;
import electricity.billing.system.entity.Customer;

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
	
	public static boolean addUser(String name, String username, String password, String accountType) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "insert into user(name,username,password,accountType) values(?,?,?,?)";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,name);
			st.setString(2,username);
			st.setString(3,password);
			st.setString(4,accountType);
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
	
	public static Customer getCustomerIdByMeterNo(long meterno) {
		Customer customer = null;
		try {
			
			Connection conn = getConnection();
			String query = "select * from customer where meterNo=?";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("id");
				long meterNo = rs.getLong("meterNo");
				long mobile = rs.getLong("mobile");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				Timestamp created_on = rs.getTimestamp("created_on");
				
				customer = new Customer(id, meterNo, mobile, name, email, address, city, state, created_on);
				
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	public static boolean isValidMeterNo(long meterno,String name) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "select * from customer where meterNo=? and name=?";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			st.setString(2, name);
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
	
	public static boolean addMeterInfo(long meterno, String meterlocation, String metertype, String phasecode, String billtype) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			
			if(getCustomerIdByMeterNo(meterno)!=null) {
				Customer cust = getCustomerIdByMeterNo(meterno);
				int id = cust.getId();
				String query2 = "insert into meter_info(customer_id,meterNo,meter_location,meter_type,phasecode,bill_type) values(?,?,?,?,?,?)";
				
				PreparedStatement stm = conn.prepareStatement(query2);
				stm.setInt(1,id);
				stm.setLong(2,meterno);
				stm.setString(3,meterlocation);
				stm.setString(4,metertype);
				stm.setString(5,phasecode);
				stm.setString(6,billtype);
				
				int i = stm.executeUpdate();
				
				if(i>0) {
					flag = true;
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public static ArrayList<Customer> getAllCustomer() {
		ArrayList<Customer> customer= new ArrayList<>();
		
		try {
			
			Connection conn = getConnection();
			String query = "select * from customer order by id desc";
			
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("id");
				long meterno = rs.getLong("meterNo");
				long mobile = rs.getLong("mobile");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				Timestamp created_on = rs.getTimestamp("created_on");
				
				customer.add(new Customer(id, meterno, mobile, name, email, address, city, state, created_on));
			}
	
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
	public static boolean addBillDetails(long meterno, int consumedUnit, String month, int totalbillamt, String status ) {
		boolean flag = false;
		
		try {
			
			Connection conn = getConnection();
			String query = "insert into bill(meterNo,consumed_units,month,totalbillamt,status) values(?,?,?,?,?)";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			st.setInt(2,consumedUnit);
			st.setString(3,month);
			st.setInt(4,totalbillamt);
			st.setString(5,status);
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
	
	
	public static Bill getBillByMeterNoAndMonth(long meterno,String month) {
		Bill bill = null;
		try {
			
			Connection conn = getConnection();
			String query = "select * from bill where meterNo=? and month=?";
			
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1,meterno);
			st.setString(2,month);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				long meterNo = rs.getLong("meterNo");
				int cunit = rs.getInt("consumed_units");
				int totalbill = rs.getInt("totalbillamt");
				String months = rs.getString("month");
				String status = rs.getString("status");
				
				bill = new Bill(meterNo, cunit, totalbill, months, status);
				
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bill;
	}
	
	public static ArrayList<Bill> getAllBill() {
		ArrayList<Bill> bill = new ArrayList<>();
		try {
			
			Connection conn = getConnection();
			String query = "select * from bill";
			
			PreparedStatement st = conn.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				long meterNo = rs.getLong("meterNo");
				int cunit = rs.getInt("consumed_units");
				int totalbill = rs.getInt("totalbillamt");
				String months = rs.getString("month");
				String status = rs.getString("status");
				
				bill.add( new Bill(meterNo, cunit, totalbill, months, status));
				
			}
	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return bill;
	}
	
}
