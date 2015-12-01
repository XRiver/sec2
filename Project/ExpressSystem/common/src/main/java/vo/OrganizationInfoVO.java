package vo;

import java.util.ArrayList;

import po.OrganizationPO;
import util.FormatCheck;
import util.ResultMsg;
import util.enums.OrganizationType;

public class OrganizationInfoVO {
	
	/**
	 * 机构编号
	 */
	private String organizationNum;
	
	/**
	 * 机构名称
	 */
	private String name;
	
	/**
	 * 机构类型
	 */
	private OrganizationType type;
	
    /**
     * 机构内人员信息
     */
	private ArrayList<StaffVO> staffinfo;
	
	/**
	 * @param organizationNum
	 * @param staffinfo
	 */
	public OrganizationInfoVO(String organizationNum,OrganizationType type,String name,ArrayList<StaffVO> staffinfo){
		this.organizationNum = organizationNum;
		this.staffinfo = staffinfo;
		this.type = type;
		this.name = name;
	}

	public String getOrganizationNum() {
		return organizationNum;
	}

	public String getName() {
		return name;
	}

	public OrganizationType getType() {
		return type;
	}

	public ArrayList<StaffVO> getStaffinfo() {
		return staffinfo;
	}

	public ResultMsg checkFormat() {
		
		ResultMsg msg = null;
		
		msg = FormatCheck.isOrganizationName(name);
		if(!msg.isPass()) return msg;
		
		if(type==OrganizationType.SERVICE_HALL) {
			msg = FormatCheck.isServiceHallNumber(organizationNum);
		} else if(type==OrganizationType.TRANSIT_CENTER) {
			msg = FormatCheck.isTransitCenterNumber(organizationNum);
		} else {
			msg = new ResultMsg(true);
		}
		
		return msg;
	}
	
	public Object toPO() {
		OrganizationPO po = new OrganizationPO(organizationNum, type, name);
		return po;
	}

}
