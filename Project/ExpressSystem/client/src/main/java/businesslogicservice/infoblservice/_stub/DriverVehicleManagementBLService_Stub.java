/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import vo.DriverVO;
import vo.VehicleVO;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;
import util.ResultMsg;

public class DriverVehicleManagementBLService_Stub implements DriverVehicleManagementBLService {
	

	public ResultMsg addVehicle(VehicleVO vo){
		System.out.println("added vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg deleteVehicle(VehicleVO vo){
		System.out.println("deleted vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg modifyVehicle(VehicleVO vo){
		System.out.println("modified vehicle!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg addDriver(DriverVO vo){
		System.out.println("added driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg deleteDriver(DriverVO vo){
		System.out.println("deleted driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg modifyDriver(DriverVO vo){
		System.out.println("modified driver!");
		return new ResultMsg(true, "Success!");
	};
	

	public ArrayList<VehicleVO> findVehicle(VehicleVO vo){
		System.out.println("found vehicle");
		return new ArrayList<VehicleVO>();
	};
	

	public ArrayList<DriverVO> findDriver(DriverVO vo){
		System.out.println("found driver");
		return new ArrayList<DriverVO>();
	};
	
	

}
