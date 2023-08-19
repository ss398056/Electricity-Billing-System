package electricity.billing.system.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Customer {
	private int id;
	private long meterno,mobile;
	private String name,email,address,city,state;
	private Timestamp created_on;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, long meterno, long mobile, String name, String email, String address, String city,
			String state, Timestamp created_on) {
		super();
		this.id = id;
		this.meterno = meterno;
		this.mobile = mobile;
		this.name = name;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.created_on = created_on;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMeterno() {
		return meterno;
	}

	public void setMeterno(long meterno) {
		this.meterno = meterno;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}
	
	
}
