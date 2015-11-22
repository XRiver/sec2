/**
 * 管理系统用户
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice._stub;

import java.util.ArrayList;

import businesslogicservice.infoblservice.SystemUserManagementBLService;
import util.LogInMsg;
import util.ResultMsg;
import vo.UserVO;

public class SystemUserManagementBLService_Stub implements SystemUserManagementBLService{
	

	public ResultMsg add(UserVO vo){
		System.out.println("added user!");
		return new ResultMsg(true, "Success!");
	};
	

	public ResultMsg delete(UserVO vo){
		System.out.println("deleted user!");
		return new ResultMsg(true, "Success!");
	};	
	

	public ResultMsg modify(UserVO vo){
		System.out.println("modified user!");
		return new ResultMsg(true, "Success!");
	};
	

	public ArrayList<UserVO> find(UserVO vo){
		System.out.println("found user");
		return new ArrayList<UserVO>();
	}

    @Override
    public LogInMsg logIn(String userNum, String initialPassword) {
        return null;
    }


	@Override
	public ResultMsg modify(UserVO origunal, UserVO modified) {
		// TODO Auto-generated method stub
		return null;
	}


}
