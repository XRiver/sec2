package dataservice.infodataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

/**
* @author River
*/
public interface StaffOrganizationManagementDataService extends Remote, Serializable {
	/**
	 * Data向数据库中添加对应StaffPO项
     *
	 * @param staff
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addStaff(StaffPO staff)
            throws RemoteException, InterruptWithExistedElementException, SQLException;

	/**
	 * Data向数据库中添加对应OrganizationPO项
     *
	 * @param org
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addOrganization(OrganizationPO org)
            throws RemoteException, InterruptWithExistedElementException, SQLException;

	/**
	 * Data删除对应StaffPO记录
     *
	 * @param staff
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeStaff(StaffPO staff)
            throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException;

	/**
	 * Data删除对应OrganizationPO记录
     *
	 * @param org
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeOrganization(OrganizationPO org)
            throws RemoteException, ElementNotFoundException, SQLException, InterruptWithExistedElementException;

	/**
	 * Data将originalStaffPO替换为modifiedStaffPO
     *
	 * @param staff--唯一标识符为IDCardNumber，不可修改
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyStaff(StaffPO staff)
            throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException;
	/**
	 * Data将originalOrganizationPO数据替换为modifiedOrganizationPO
     *
	 * @param org--唯一标识符为编号，不可修改
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyOrganization(OrganizationPO org)
            throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException, SQLException;

	/**
     * Data返回符合关键字的员工数据
     *
	 * @param info
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<StaffPO> findStaff(StaffPO info)
            throws RemoteException, ElementNotFoundException, SQLException;

	/**
	 * Data返回符合关键字的机构记录
     *
	 * @param info
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
            throws RemoteException, ElementNotFoundException, SQLException;

	/**
	 * Data返回所有员工数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StaffPO> getAllStaff()
            throws RemoteException, SQLException;

	/**
     * Data返回所有机构数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrganizationPO> getAllOrganizations()
            throws RemoteException, SQLException;
	
	
}
