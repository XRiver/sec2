package po;

import java.io.Serializable;

import util.enums.StaffType;
import vo.StaffVO;

/**
 * 用于人员增删改查的PO
 * @author River
 *
 */
public class StaffPO implements Serializable {

	private static final long serialVersionUID = 7037298481421583099L;

    public StaffPO(String staffID, String name, String organization, String gender,
                   String IDCardNumber, double salary, String phoneNumber,
                   StaffType position, double workHour) {
        this.staffID = staffID;
        this.name = name;
        this.organization = organization;
        this.gender = gender;
        this.IDCardNumber = IDCardNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.workHour = workHour;
    }

    /**
     * 新增:人员编号(唯一ID)
     */
	String staffID;

	/**
	 * 人员姓名
	 */
	String name = null;
	
	/**
	 * 机构名
	 */
	String organization = null;
	
	/**
	 * 性别
	 */
	String gender = null;
	
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
    StaffType position = null;

    /**
     * 工作时间
	 */
	double workHour = 0.0;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getOrganization() {
        return organization;
    }

    public String getGender() {
        return gender;
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

    public StaffType getPosition() {
        return position;
    }

    public double getWorkHour() {
        return workHour;
    }


    public Object toVO() {
    	
    	StaffVO vo = new StaffVO(staffID,name, gender, organization, position, IDCardNumber, (int) workHour, phoneNumber, salary+"");
        
        return vo;
    }
}
