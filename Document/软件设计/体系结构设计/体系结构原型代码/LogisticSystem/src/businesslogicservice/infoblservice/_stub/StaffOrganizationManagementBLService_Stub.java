/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;

public class StaffOrganizationManagementBLService_Stub implements StaffOrganizationManagementBLService {
	
	
	public ResultMsg addStaff(StaffInfoVO vo){
		System.out.println("added staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg delStaff(StaffInfoVO vo){
		System.out.println("deleted staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ResultMsg ModifyStaff(StaffInfoVO vo){
		System.out.println("modified staff!");
		return new ResultMsg(true, "Success!");
	};
	
	
	public ArrayList<StaffInfoVO> findStaffInfo(StaffInfoVO vo){
		System.out.println("found staff");
		return new ArrayList<>();
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
		return new ArrayList<>();
	};
	
	
	public ArrayList<OrganizationInfoVO> showAll(){
		System.out.println("showing all");
		return new ArrayList<>();
	};

}
