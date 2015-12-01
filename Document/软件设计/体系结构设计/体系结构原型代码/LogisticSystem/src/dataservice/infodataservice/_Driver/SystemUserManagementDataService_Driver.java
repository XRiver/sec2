package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.infodataservice._Stub.SystemUserManagementDataService_Stub;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.UserPO;

public class SystemUserManagementDataService_Driver {
	private UserPO userPO;
	private ArrayList<UserPO> list = new ArrayList<UserPO>();

	public SystemUserManagementDataService_Driver() {
		userPO = new UserPO("1243658709","658709",3);	
		list.add(userPO);
	}
	
	public void drive(SystemUserManagementDataService sumDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		sumDataService.addUser(userPO);
		sumDataService.removeUser(userPO);
		sumDataService.modifyUser(userPO, userPO);
		sumDataService.inquireUser(new UserPO(null, null, 0));
		sumDataService.getAllUsers();
		
		if(sumDataService.addUser(userPO))
			System.out.println("success");
		else
			System.out.println("fail");
		if(sumDataService.removeUser(userPO))
			System.out.println("success");
		else
			System.out.println("fail");
		if(sumDataService.modifyUser(userPO, userPO))
			System.out.println("success");
		else
			System.out.println("fail");
		
	}
	
	public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		SystemUserManagementDataService_Stub stub = new SystemUserManagementDataService_Stub();
		SystemUserManagementDataService_Driver driver = new SystemUserManagementDataService_Driver();
		driver.drive(stub);
	}
	
	

}
