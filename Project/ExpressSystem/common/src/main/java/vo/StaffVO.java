package vo;

import javax.print.DocFlavor.READER;

import po.StaffPO;
import util.FormatCheck;
import util.ResultMsg;
import util.enums.StaffType;

public class StaffVO {
	
	/**
	 * 人员唯一辨识码：员工编号
	 */
	private String staffID;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 所属机构
	 */
	private String organization;
	
	/**
	 * 职位
	 */
    private StaffType postion;

    /**
	 * 身份证
	 */
	private String IDNum;
	
	/**
	 * 工作时长（按月）
	 */
	private int workingtime;
	
	/**
	 * 手机
	 */
	private String phoneNum;
	
	/**
	 * 工资
	 */
	private String wage;
	
	/**
	 * @param name
	 * @param sex
	 * @param postion
	 * @param IDNum
	 * @param workingtime
	 * @param phoneNum
	 * @param wage
	 */
    public StaffVO(String staffID,String name, String sex, String organization, StaffType postion, String IDNum, int workingtime, String phoneNum, String wage) {
        this.staffID = staffID;
    	this.name = name;
		this.sex = sex;
		this.IDNum = IDNum;
		this.organization = organization;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingtime = workingtime;
	}

    public String getStaffID() {
    	return staffID;
    }
    
	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

    public StaffType getPostion() {
        return postion;
	}

	public String getIDNum() {
		return IDNum;
	}

	public int getWorkingtime() {
		return workingtime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getWage() {
		return wage;
	}
	
	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[6];
		
		msgs[0] = FormatCheck.isChineseName(name);
		msgs[1] = FormatCheck.isGender(sex);
		msgs[2] = FormatCheck.isPhoneNumber(phoneNum);
		msgs[3] = FormatCheck.isIDNumber(IDNum);
        msgs[4].setPass(true);
        msgs[5] = FormatCheck.isSalary(wage);
		msgs[6] = workingtime>0?new ResultMsg(true):new ResultMsg(false,"工作时间应为正数");

		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) return  msgs[i];
		}
		
		return new ResultMsg(true);
		
	}

	public Object toPO() {
		
		StaffPO po = new StaffPO(staffID, name, organization, sex, IDNum, Double.parseDouble(wage), phoneNum, postion, workingtime);
		return po;
	}
	
}
