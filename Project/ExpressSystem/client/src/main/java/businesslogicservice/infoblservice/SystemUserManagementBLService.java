/**
 * 管理系统用户
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import util.LogInMsg;
import util.ResultMsg;
import vo.UserVO;

public interface SystemUserManagementBLService {
	
	/**
	 * 增加用户
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg add(UserVO vo);
	
	/**
	 * 删除用户
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg delete(UserVO vo);	
	
	/**
	 * 更新用户信息
	 * @param vo
	 * @return 结果消息
	 */
	public ResultMsg modify(UserVO origunal,UserVO modified);
	
	/**
	 * 通过账号查找账户信息
	 * @param vo
	 * @return
	 */
	public ArrayList<UserVO> find(UserVO vo);

    /**
     * 用户登陆接口
     *
     * @param userNum
     * @param initialPassword
     * @return
     * @throws SQLException 
     * @throws ElementNotFoundException 
     */
	public LogInMsg logIn(String userNum, String initialPassword);
 
}
