package po;

import java.io.Serializable;

/**
 * 表示司机信息的PO
 * @author River
 */
public class DriverPO implements Serializable {

	private static final long serialVersionUID = 5894748451667870139L;
	
	
	public DriverPO(String driverNumber, String hallNumber, String name,
			String birthday, String iDCardNumber, String phoneNumber,
			String gender, String licenseDate) {
		super();
		this.driverNumber = driverNumber;
		this.hallNumber = hallNumber;
		this.name = name;
		this.birthday = birthday;
		IDCardNumber = iDCardNumber;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.licenseDate = licenseDate;
	}
	
	/**
	 * 司机编号
	 */
	String driverNumber = null;
	
	/**
	 * 营业厅编号
	 */
	String hallNumber = null;
	
	/**
	 * 司机姓名
	 */
	String name = null;
	
	/**
	 * 司机生日
	 */
	String birthday = null;
	
	/**
	 * 司机身份证号
	 */
	String IDCardNumber = null;
	
	/**
	 * 司机电话号码
	 */
	String phoneNumber = null;
	
	/**
	 * 司机性别：“Male”，“Female”
	 */
	String gender = null;
	
	/**
	 * 驾照过期时间
	 */
	String licenseDate = null;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getDriverNumber() {
		return driverNumber;
	}
	public String getHallNumber() {
		return hallNumber;
	}
	public String getName() {
		return name;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public String getLicenseDate() {
		return licenseDate;
	}
	
}
