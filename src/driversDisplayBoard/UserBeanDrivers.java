package driversDisplayBoard;

public class UserBeanDrivers {
	int did;
	String name, mobile, address, dl, uid;
	public UserBeanDrivers(int did, String name, String mobile, String address, String dl, String uid) {
		super();
		this.did = did;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.dl = dl;
		this.uid = uid;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
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
	public String getDl() {
		return dl;
	}
	public void setDl(String dl) {
		this.dl = dl;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
}
