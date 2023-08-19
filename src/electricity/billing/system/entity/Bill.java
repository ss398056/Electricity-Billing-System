package electricity.billing.system.entity;

public class Bill {
	private long meterNo;
	private int cunit,totalbill;
	private String month,status;
	
	public Bill() {
		// TODO Auto-generated constructor stub
	}

	public Bill(long meterNo, int cunit, int totalbill, String month, String status) {
		super();
		this.meterNo = meterNo;
		this.cunit = cunit;
		this.totalbill = totalbill;
		this.month = month;
		this.status = status;
	}

	public long getMeterNo() {
		return meterNo;
	}

	public void setMeterNo(long meterNo) {
		this.meterNo = meterNo;
	}

	public int getCunit() {
		return cunit;
	}

	public void setCunit(int cunit) {
		this.cunit = cunit;
	}

	public int getTotalbill() {
		return totalbill;
	}

	public void setTotalbill(int totalbill) {
		this.totalbill = totalbill;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bill [meterNo=" + meterNo + ", cunit=" + cunit + ", totalbill=" + totalbill + ", month=" + month
				+ ", status=" + status + "]";
	}
	
	

}
