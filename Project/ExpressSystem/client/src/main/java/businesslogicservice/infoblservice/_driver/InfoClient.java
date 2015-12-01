package businesslogicservice.infoblservice._driver;

import businesslogicservice.infoblservice._stub.DriverVehicleManagementBLService_Stub;
import businesslogicservice.infoblservice._stub.StaffOrganizationManagementBLService_Stub;
import businesslogicservice.infoblservice._stub.SystemUserManagementBLService_Stub;

public class InfoClient {
	public static void main(String[] args) {
		DriverVehicleManagementBLService_Driver driver1 = new DriverVehicleManagementBLService_Driver();
		driver1.drive(new DriverVehicleManagementBLService_Stub());
		
		StaffOrganizationManagementBLService_Driver driver2 = new StaffOrganizationManagementBLService_Driver();
		driver2.drive(new StaffOrganizationManagementBLService_Stub());
		
		SystemUserManagementBLService_Driver driver3 = new SystemUserManagementBLService_Driver();
		driver3.drive(new SystemUserManagementBLService_Stub());
	}
}
