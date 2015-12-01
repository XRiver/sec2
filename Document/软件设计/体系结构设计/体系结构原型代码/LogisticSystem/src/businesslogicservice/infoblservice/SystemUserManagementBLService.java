/**
 * 管理系统用户
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
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
	public ResultMsg modify(UserVO vo);
	
	/**
	 * 通过账号查找账户信息
	 * @param userNum
	 * @return
	 */
	public ArrayList<UserVO> find(UserVO vo);
		
	
 
}
