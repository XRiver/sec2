package dataservice.infodataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import po.UserPO;
import util.LogInMsg;
import util.enums.Authority;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class SystemUserManagementDataService_Stub implements SystemUserManagementDataService{

	public boolean addUser(UserPO user) throws RemoteException,
			InterruptWithExistedElementException {
		System.out.println("add success");
		return false;
	}

	public boolean removeUser(UserPO user) throws RemoteException,
			ElementNotFoundException {
		System.out.println("remove success");
		return false;
	}

	public boolean modifyUser(UserPO originalUser, UserPO modified)
			throws RemoteException, ElementNotFoundException,
			InterruptWithExistedElementException {
		System.out.println("modift success");
		return false;
	}

	public ArrayList<UserPO> getAllUsers() throws RemoteException {
		System.out.println("get success");
		return null;
	}

	public ArrayList<UserPO> inquireUser(UserPO info) throws RemoteException,
			ElementNotFoundException {
		System.out.println("inquireUser success");
		return null;
	}

	@Override
	public LogInMsg logIn(String account, String password)
			throws SQLException {
		
		return new LogInMsg(true, Authority.ACCOUNTANT_HIGH, "登录成功！");
	}
	

}
