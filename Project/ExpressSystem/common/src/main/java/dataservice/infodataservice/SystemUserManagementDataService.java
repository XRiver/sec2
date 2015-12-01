package dataservice.infodataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.UserPO;
import util.LogInMsg;

/**
* @author River
 * 接口必须继承自java.rmi.Remote
 *
*/
public interface SystemUserManagementDataService extends Remote, Serializable {

    /**
	 * Data向数据库中添加对应UserPO记录
     *
     * 每个RMI接口方法都必须抛出java.rmi.RemoteException异常
     *
     * 每个RMI接口方法的参数类型、返回类型、异常类型都必须实现序列化接口
     *
	 * @param user
	 * @return true for successful add operation
	 * @throws RemoteException
	 * @throws InterruptWithExistedElementException
	 */
	public boolean addUser(UserPO user)
            throws RemoteException, InterruptWithExistedElementException, SQLException;

	/**
	 * Data从数据库中删除对应UserPO条目
     *
	 * @param user
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean removeUser(UserPO user)
            throws RemoteException, ElementNotFoundException, SQLException;

	/**
	 * Data将originalUserPO替换为modifiedUserPO
     *
	 * @param originalUser
	 * @param modified
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public boolean modifyUser(UserPO originalUser,UserPO modified)
			throws RemoteException, ElementNotFoundException, SQLException, InterruptWithExistedElementException;
	/**
	 * Data查询对应的用户并返回其UserPO
     *
	 * @param info
	 * @return
	 * @throws RemoteException
	 * @throws ElementNotFoundException
	 */
	public ArrayList<UserPO> inquireUser(UserPO info)
            throws RemoteException, ElementNotFoundException, SQLException;

	/**
	 * Data返回所有的UserPO
     *
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<UserPO> getAllUsers()
            throws RemoteException, ElementNotFoundException, SQLException;

	/**
	 * 登录接口
	 * @param account
	 * @param password
	 * @return 登录是否成功，若失败，则会附送失败信息
	 * @throws SQLException 
	 * @throws ElementNotFoundException 
	 */
	public LogInMsg logIn(String account,String password) throws SQLException;
}
