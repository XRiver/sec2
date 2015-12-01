package vo;

import java.util.ArrayList;

public class OrganizationInfoVO {
	
	/**
	 * 机构编号
	 */
	private String organizationNum;
	
    /**
     * 机构内人员信息
     */
	private ArrayList<StaffInfoVO> staffinfo;
	
	/**
	 * @param organizationNum
	 * @param staffinfo
	 */
	public OrganizationInfoVO(String organizationNum,ArrayList<StaffInfoVO> staffinfo){
		this.organizationNum = organizationNum;
		this.staffinfo = staffinfo;
	}

	public String getOrganizationNum() {
		return organizationNum;
	}

	public ArrayList<StaffInfoVO> getStaffinfo() {
		return staffinfo;
	}
}
