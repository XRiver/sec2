package dataservice.infodataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DriverPO;
import po.VehiclePO;

/**
* @author River
*/
public interface DriverVehicleManagementDataService extends Remote {

	/**
	 * Data向数据库中添加对应司机PO项
     *
	 * @param driver
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addDriver(DriverPO driver)
			throws RemoteException,InterruptWithExistedElementException;

	/**
	 * Data向数据库中添加对应汽车PO项
     *
	 * @param vehicle
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addVehicle(VehiclePO vehicle)
			throws RemoteException,InterruptWithExistedElementException;

	/**
	 * Data删除对应司机PO记录
     *
	 * @param driver
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeDriver(DriverPO driver)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data删除对应汽车PO记录
     *
	 * @param vehicle
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeVehicle(VehiclePO vehicle)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data将originalDriver替换为modified
     *
	 * @param originalDriver
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyDriver(DriverPO originalDriver,DriverPO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;

	/**
	 * Data将originalVehicle数据替换为modified
     *
	 * @param originalVehicle
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean modifyVehicle(VehiclePO originalVehicle,VehiclePO modified)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException;

	/**
	 * Data返回所有司机数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverPO> getAllDriver()
			throws RemoteException;

	/**
	 * Data返回所有车辆数据
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<VehiclePO> getAllVehicles()
			throws RemoteException;

	/**
	 * Data返回所有符合关键字的司机数据
     *
	 * @param keywords
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException,ElementNotFoundException;

	/**
	 * Data返回所有符合关键字的车辆数据
     *
	 * @param keywords
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException;
	
	
}
