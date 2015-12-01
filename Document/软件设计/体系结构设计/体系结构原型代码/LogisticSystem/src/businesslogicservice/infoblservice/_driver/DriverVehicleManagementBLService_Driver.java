package businesslogicservice.infoblservice._driver;

import java.io.File;

import vo.DriverVO;
import vo.VehicleInfoVO;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;

public class DriverVehicleManagementBLService_Driver{
	

	public void drive(DriverVehicleManagementBLService service){
		
		if(service.addDriver(new DriverVO("00210", "Mark", "2001-10-04", null, null, null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.deleteDriver(new DriverVO("00210", "Mark", "2001-10-04", null, null, null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.modifyDriver(new DriverVO("00210", "Mark", "2001-10-04", null, null, null, null)).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.addVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.txt"))).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.deleteVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.yxy"))).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.modifyVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehicle.tx"))).isPass()){
			System.out.println("Passed");
		}else{
			System.out.println("Failed");
		}
		
		if(service.findDriver(new DriverVO("00210", "Mark", "2001-10-04", null, null, null, null))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}
		
		if(service.findVehicle(new VehicleInfoVO("00120", "21221", null,new File("vehilce.txt")))!=null){
			System.out.println("Got list");
		}else{
			System.out.println("Null return");
		}
	}

}
