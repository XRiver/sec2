package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.OrganizationPO;
import po.StaffPO;

/**
* @author River
*/
public interface StaffOrganizationManagementDataService extends Remote {
	/**
	 * Data向数据库中添加对应StaffPO项
     *
	 * @param staff
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addStaff(StaffPO staff)
			throws RemoteException,InterruptWithExistedElementException;

	/**
	 * Data向数据库中添加对应OrganizationPO项
     *
	 * @param org
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addOrganization(OrganizationPO org)
			throws RemoteException,InterruptWithExistedElementException;

	/**
	 * Data删除对应StaffPO记录
     *
	 * @param staff
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeStaff(StaffPO staff)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data删除对应OrganizationPO记录
     *
	 * @param org
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeOrganization(OrganizationPO org)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data将originalStaffPO替换为modifiedStaffPO
     *
	 * @param original
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyStaff(StaffPO original,StaffPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;
	// TODO 替换的参数一个还是两个问题
	/**
	 * Data将originalOrganizationPO数据替换为modifiedOrganizationPO
     *
	 * @param original
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyOrganization(OrganizationPO original,OrganizationPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;

	/**
     * Data返回符合关键字的员工数据
     *
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<StaffPO> findStaff(StaffPO info)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data返回符合关键字的机构记录
     *
	 * @param name
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<OrganizationPO> findOrganization(OrganizationPO info)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data返回所有员工数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<StaffPO> getAllStaff()
			throws RemoteException;

	/**
     * Data返回所有机构数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrganizationPO> getAllOrganizations()
			throws RemoteException;
	
	
}
