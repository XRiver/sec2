package dataservice.infodataservice._Driver;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.infodataservice._Stub.SystemUserManagementDataService_Stub;
import po.UserPO;
import util.enums.Authority;

public class SystemUserManagementDataService_Driver {
	private UserPO userPO1;
    private UserPO userPO2;
    private UserPO userPO3;
	private ArrayList<UserPO> list = new ArrayList<UserPO>();

	public SystemUserManagementDataService_Driver() {
		userPO1 = new UserPO("test1","test1",Authority.ACCOUNTANT_HIGH);
		userPO2 = new UserPO("test2","test2",Authority.ACCOUNTANT_LOW);
		userPO3 = new UserPO("test3","test3",Authority.DELIVERY_MAN);
		list.add(userPO1);
		list.add(userPO2);
		list.add(userPO3);
	}
	
	public void drive(SystemUserManagementDataService sumDataService) throws Exception {
		if(sumDataService.addUser(userPO1))
			System.out.println("success");
		else
			System.out.println("fail");

        if(sumDataService.addUser(userPO2))
            System.out.println("success");
        else
            System.out.println("fail");

        if(sumDataService.addUser(userPO3))
            System.out.println("success");
        else
            System.out.println("fail");

		if(sumDataService.removeUser(userPO2))
			System.out.println("success");
		else
			System.out.println("fail");
		if(sumDataService.modifyUser(userPO1, userPO3))
			System.out.println("success");
		else
			System.out.println("fail");
		
	}
	
	public static void main(String[] args) throws Exception {
		SystemUserManagementDataService_Stub userManagementData = new SystemUserManagementDataService_Stub();
		SystemUserManagementDataService_Driver driver = new SystemUserManagementDataService_Driver();
		driver.drive(userManagementData);
	}
	
	

}
