package data.infodata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.StaffPO;
import data.database.DatabaseFactoryMysqlImpl;
import dataservice.exception.ElementNotFoundException;
import dataservice.infodataservice.StaffOrganizationManagementDataService;

public class UserInfoHelper {
	private static StaffOrganizationManagementDataService dataSer = null;
	
	private UserInfoHelper(){}
	
	static {
		try {
			dataSer = DatabaseFactoryMysqlImpl.getInstance().getStaffOrganizationManagementDataService();
		} catch (RemoteException e) {
			System.err.println("UserInfoHelper failed to get service from DatabaseFactory");
		}
	}
	
	public static String getOrg(String staffID) throws RemoteException, ElementNotFoundException, SQLException {
		return getStaff(staffID).getOrganization();
	}
	
	public static String getName(String staffID) throws RemoteException, ElementNotFoundException, SQLException {
		return getStaff(staffID).getName();
	}
	
	private static StaffPO getStaff(String staffID) throws ElementNotFoundException, RemoteException, SQLException {
		ArrayList<StaffPO> po = dataSer.findStaff(new StaffPO(staffID, null, null, null, null, 0, null, null, 0));
		if(po.size()==0) throw new ElementNotFoundException();
		return po.get(0);
	}
}
