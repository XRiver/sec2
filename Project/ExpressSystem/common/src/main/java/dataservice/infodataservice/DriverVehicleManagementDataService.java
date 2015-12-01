package dataservice.infodataservice;

import java.io.IOException;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DriverPO;
import po.VehiclePO;

/**
* @author River
*/
public interface DriverVehicleManagementDataService extends Remote, Serializable {

	/**
	 * Data向数据库中添加对应司机PO项
     *
	 * @param driver
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 * @throws SQLException 
	 */
	public boolean addDriver(DriverPO driver)
			throws RemoteException,InterruptWithExistedElementException, SQLException;

	/**
	 * Data向数据库中添加对应汽车PO项
     *
	 * @param vehicle
	 * @return
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public boolean addVehicle(VehiclePO vehicle)
			throws RemoteException,InterruptWithExistedElementException, SQLException, IOException;

	/**
	 * Data删除对应司机PO记录
     *
	 * @param driver
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws SQLException 
	 */
	public boolean removeDriver(DriverPO driver)
			throws RemoteException,ElementNotFoundException, SQLException;

	/**
	 * Data删除对应汽车PO记录
     *
	 * @param vehicle
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public boolean removeVehicle(VehiclePO vehicle)
			throws RemoteException,ElementNotFoundException, SQLException, IOException;

	/**
	 * Data将originalDriver替换为modified
     *
	 * @param driver--唯一标识符为IDCardNumber
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 * @throws SQLException 
	 */
	public boolean modifyDriver(DriverPO driver)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException, SQLException;

	/**
	 * Data将originalVehicle数据替换为modified
     *
	 * @param vehicle--唯一标识符为车辆编号
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws InterruptWithExistedElementException
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public boolean modifyVehicle(VehiclePO originalVehicle)
			throws RemoteException,ElementNotFoundException,InterruptWithExistedElementException, SQLException, IOException;

	/**
	 * Data返回所有司机数据
     *
	 * @return
	 * @throws RemoteException
	 * @throws SQLException 
	 */
	public ArrayList<DriverPO> getAllDriver()
			throws RemoteException, SQLException;

	/**
	 * Data返回所有车辆数据
     *
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public ArrayList<VehiclePO> getAllVehicles()
			throws RemoteException, SQLException, IOException;

	/**
	 * Data返回所有符合关键字的司机数据
     *
	 * @param keywords
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 * @throws SQLException 
	 */
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException,ElementNotFoundException, SQLException;

	/**
	 * Data返回所有符合关键字的车辆数据
     *
	 * @param keywords
	 * @return
	 * @throws RemoteException
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException, SQLException, IOException;
	
	
}
