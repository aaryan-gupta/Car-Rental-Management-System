package customersDisplayBoard;

public class UserBeanCustomers {
	int cid, days, status;
	String name, mobile, address, date, time, destination, requirement;

	public UserBeanCustomers(int cid, String name, String mobile, String address, String date, String time,
			String destination, int days, String requirement) {
		super();
		this.cid = cid;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.date = date;
		this.time = time;
		this.destination = destination;
		this.days = days;
		this.requirement = requirement;
	}
	
	public UserBeanCustomers(String mobile, int status) {
		super();
		this.mobile = mobile;
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	
}
