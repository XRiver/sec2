/**
 * 管理机构人员信息
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrganizationInfoVO;
import vo.StaffVO;

public interface StaffOrganizationManagementBLService {
	
	/**
	 * 新增人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addStaff(StaffVO vo);
	
	/**
	 * 删除人员信息
	 * @param vo
	 * @return
	 */
	public ResultMsg delStaff(StaffVO vo);
	
	/**
	 * 修改人员信息
	 * @param vo--IDCardNumber为唯一标识符不可修改，其它根据IDCard进行人员辨认
	 * @return
	 */
	public ResultMsg ModifyStaff(StaffVO staff);
	
	/**
	 * 关键字查找人员信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<StaffVO> findStaffInfo(StaffVO vo);
	
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
	 * @param vo--编号为唯一标识符，不可修改，其它属性可改
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
