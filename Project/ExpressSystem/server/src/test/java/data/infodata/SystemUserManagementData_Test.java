package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.database.DatabaseFactoryMysqlImpl;
import data.database.DatabaseFactory;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice.SystemUserManagementDataService;

import org.junit.Test;
import po.UserPO;
import util.enums.Authority;

public class SystemUserManagementData_Test {

    private SystemUserManagementDataService service;

    public SystemUserManagementData_Test() throws RemoteException {
        service = new SystemUserManagementData();
    }

//    @Test
	public void testAddUser() throws Exception {
		UserPO po = new UserPO("toDelete","sbsbsb",Authority.ACCOUNTANT_LOW);
		assertEquals(true,service.addUser(po));
	}

//	@Test
	public void testRemoveUser() throws Exception {
        UserPO po = new UserPO("toDelete","sbsbsb", Authority.ACCOUNTANT_LOW);
        assertEquals(true,service.removeUser(po));
	}

//    @Test
    public void testInquireUser() throws Exception {
        UserPO a=new UserPO("admin",null,Authority.ACCOUNTANT_HIGH);
        ArrayList<UserPO> result = service.inquireUser(a);
        for (UserPO po2:result) {
            System.out.println(po2);
        }
    }

	@Test
	public void testGetAllUsers() throws Exception {
        SystemUserManagementData service = new SystemUserManagementData();
        ArrayList<UserPO> result = service.getAllUsers();
        for (UserPO po2:result) {
            System.out.println(po2);
        }
	}

}
