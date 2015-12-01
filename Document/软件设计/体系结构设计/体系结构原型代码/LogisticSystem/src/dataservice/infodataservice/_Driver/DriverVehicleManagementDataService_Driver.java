package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice._Stub.DriverVehicleManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DriverPO;
import po.VehiclePO;

public class DriverVehicleManagementDataService_Driver {
	private DriverPO driverPO1;
	private DriverPO driverPO2;
	private DriverPO  driverPO3;
	private VehiclePO vehiclePO1;
	private VehiclePO vehiclePO2;
	private VehiclePO vehiclePO3;
	
	public DriverVehicleManagementDataService_Driver() {
		driverPO1 = new DriverPO("025010009","0251010","魏彦淑","1995-12-12"
				,"320323199512122345","18362921190","女","2014-09-20");
		driverPO2 = new DriverPO("025010007","0251010","王会","1996-11-12"
				,"320323199611122345","18362922345","男","2015-09-20");
		driverPO3 = new DriverPO("025010007","0251010","王小二","1997-11-12"
				,"320323199711122345","18367922345","男","2015-01-20");
		vehiclePO1 = new VehiclePO("025010001","0251010",null, "2013-01-01");
		vehiclePO2 = new VehiclePO("025010002","0251010",null,"2013-02-01");
		vehiclePO3 = new VehiclePO("025010002","0251010",null,"2013-03-01");	
		ArrayList<DriverPO> driverList = new ArrayList<DriverPO>();
	    ArrayList<VehiclePO> vehicleList = new ArrayList<VehiclePO>();
	    driverList.add(driverPO1);
		driverList.add(driverPO2);
		vehicleList.add(vehiclePO2);
		vehicleList.add(vehiclePO3);
	}
	
	public void drive(DriverVehicleManagementDataService driverVehicleManagementDataService) throws RemoteException, 
	InterruptWithExistedElementException, ElementNotFoundException {
	
		driverVehicleManagementDataService.addDriver(driverPO1);
		driverVehicleManagementDataService.addDriver(driverPO2);
		driverVehicleManagementDataService.addDriver(driverPO3);
		driverVehicleManagementDataService.addVehicle(vehiclePO1);
		driverVehicleManagementDataService.addVehicle(vehiclePO2);
		driverVehicleManagementDataService.addVehicle(vehiclePO3);
		driverVehicleManagementDataService.modifyVehicle(vehiclePO1, vehiclePO2);
		driverVehicleManagementDataService.modifyDriver(driverPO1, driverPO2);
		driverVehicleManagementDataService.removeDriver(driverPO2);
		driverVehicleManagementDataService.removeVehicle(vehiclePO1);
		driverVehicleManagementDataService.inquireDriver(new DriverPO(null, null, null, null, null, null, null, null));
		driverVehicleManagementDataService.inquireVehicle(new VehiclePO(null, null,null, null));
		driverVehicleManagementDataService.getAllDriver();
		driverVehicleManagementDataService.getAllVehicles();	
		
		if(driverVehicleManagementDataService.addDriver(driverPO1))
			System.out.println("success");
		else
			System.out.println("fail");		
		if(driverVehicleManagementDataService.addDriver(driverPO2))
			System.out.println("success");
		else
			System.out.println("fail");		
		if(driverVehicleManagementDataService.addDriver(driverPO3))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.addVehicle(vehiclePO1))
			System.out.println("success");
		else
			System.out.println("fail");	
		if(driverVehicleManagementDataService.addVehicle(vehiclePO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.addVehicle(vehiclePO3))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.modifyVehicle(vehiclePO1, vehiclePO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.modifyDriver(driverPO1, driverPO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.removeDriver(driverPO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(driverVehicleManagementDataService.removeVehicle(vehiclePO1))
			System.out.println("success");
		else
			System.out.println("fail");
			
	}
	
	public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		DriverVehicleManagementDataService_Stub stub = new DriverVehicleManagementDataService_Stub();
		DriverVehicleManagementDataService_Driver driver  = new DriverVehicleManagementDataService_Driver();
		driver.drive(stub);
		
	}

}
