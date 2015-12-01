package dataservice.infodataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DriverPO;
import po.VehiclePO;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class DriverVehicleManagementDataService_Stub implements DriverVehicleManagementDataService {


	@Override
	public boolean addDriver(DriverPO driver) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add driver success");
		return true;
	}

	@Override
	public boolean addVehicle(VehiclePO vehicle) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add vehicle success");
		return true;
	}

	@Override
	public boolean removeDriver(DriverPO driver) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove driver success");
		return true;
	}

	@Override
	public boolean removeVehicle(VehiclePO vehicle) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove vehicle success");
		return true;
	}

	@Override
	public boolean modifyDriver(DriverPO originalDriver, DriverPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modify driver success");
		return true;
	}

	@Override
	public boolean modifyVehicle(VehiclePO originalVehicle, VehiclePO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modifi vehicle success");
		return true;
	}

	@Override
	public ArrayList<DriverPO> getAllDriver() throws RemoteException {
		System.out.println("success getting");
		return null;
	}

	@Override
	public ArrayList<VehiclePO> getAllVehicles() throws RemoteException {
		System.out.println("success getting");
		return null;
	}

	@Override
	public ArrayList<DriverPO> inquireDriver(DriverPO keywords)
			throws RemoteException, ElementNotFoundException {
		System.out.println("inquire success");
		return null;
	}

	@Override
	public ArrayList<VehiclePO> inquireVehicle(VehiclePO keywords)
			throws RemoteException {
		System.out.println("inquire success");
		return null;
	}



}
