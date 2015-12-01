/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffVO;

public class StaffOrganizationManagementBLService_Stub implements StaffOrganizationManagementBLService {
	
	
	public ResultMsg addStaff(StaffVO vo){
		System.out.println("added staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg delStaff(StaffVO vo){
		System.out.println("deleted staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg ModifyStaff(StaffVO vo){
		System.out.println("modified staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ArrayList<StaffVO> findStaffInfo(StaffVO vo){
		System.out.println("found staff");
		return new ArrayList<StaffVO>();
	};
	
	
	public ResultMsg addOrganization(OrganizationInfoVO vo){
		System.out.println("added org!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg delOrganization(OrganizationInfoVO vo){
		System.out.println("deleted org!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg ModifyOrganization(OrganizationInfoVO vo){
		System.out.println("modified org!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ArrayList<OrganizationInfoVO> findOrgInfo(OrganizationInfoVO vo){
		System.out.println("found org");
		return new ArrayList<OrganizationInfoVO>();
	};
	
	
	public ArrayList<OrganizationInfoVO> showAll(){
		System.out.println("showing all");
		return new ArrayList<OrganizationInfoVO>();
	}

}
