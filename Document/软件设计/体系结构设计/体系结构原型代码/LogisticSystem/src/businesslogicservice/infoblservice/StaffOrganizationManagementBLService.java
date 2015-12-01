/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffInfoVO;

public interface StaffOrganizationManagementBLService {
	
	/**
	 * 新增人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addStaff(StaffInfoVO vo);
	
	/**
	 * 删除人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delStaff(StaffInfoVO vo);
	
	/**
	 * 修改人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg ModifyStaff(StaffInfoVO vo);
	
	/**
	 * 关键字查找人员信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<StaffInfoVO> findStaffInfo(StaffInfoVO vo);
	
	/**
	 * 新增机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addOrganization(OrganizationInfoVO vo);
	
	/**
	 * 删除机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delOrganization(OrganizationInfoVO vo);
	
	/**
	 * 修改机构信息
	 * @param vo
	 * @return
	 */
	public ResultMsg ModifyOrganization(OrganizationInfoVO vo);
	
	/**
	 * 关键字查找机构信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> findOrgInfo(OrganizationInfoVO vo);
	
	/**
	 * 显示所有机构人员信息
	 * @return
	 */
	public ArrayList<OrganizationInfoVO> showAll();

}
