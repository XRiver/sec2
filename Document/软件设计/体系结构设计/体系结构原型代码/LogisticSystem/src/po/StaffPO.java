package po;

import java.io.Serializable;

/**
 * 用于人员增删改查的PO
 * @author River
 *
 */
public class StaffPO implements Serializable {

	private static final long serialVersionUID = 7037298481421583099L;
	
	public StaffPO(String name, String organization, String iDCardNumber,
			double salary, String phoneNumber, String position, double workHour) {
		super();
		this.name = name;
		this.organization = organization;
		IDCardNumber = iDCardNumber;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
		this.position = position;
		this.workHour = workHour;
	}
	
	/**
	 * 人员姓名
	 */
	String name = null;
	
	/**
	 * 机构编号
	 */
	String organization = null;
	
	/**
	 * 身份证号
	 */
	String IDCardNumber = null;
	
	/**
	 * 薪水数目
	 */
	double salary = 0.0;
	
	/**
	 * 电话号码
	 */
	String phoneNumber = null;
	
	/**
	 * 职务
	 */
	String position = null;
	
	/**
	 * 工作时间
	 */
	double workHour = 0.0;

	public String getName() {
		return name;
	}
	public String getOrganization() {
		return organization;
	}
	public String getIDCardNumber() {
		return IDCardNumber;
	}
	public double getSalary() {
		return salary;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getPosition() {
		return position;
	}
	public double getWorkHour() {
		return workHour;
	}
}
