/**
 * 管理银行账户
 * @author wwz
 * date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import vo.BankAccountVO;


public interface BankAccountManagementBLService {
	
	/**
	 * 根据账户名称模糊查找账户
	 * @param name
	 * @return
	 */
	public ArrayList<BankAccountVO> find(BankAccountVO vo);
	
	/**
	 * 增加账户
	 * @param vo
	 * @return
	 */
	public ResultMsg add(BankAccountVO vo);
	
	/**
	 * 删除账户
	 * @param vo
	 * @return
	 */
	public ResultMsg delete(BankAccountVO vo);
	
	/**
	 * 更新账户
	 * @param vo
	 * @return
	 */
	public ResultMsg update(BankAccountVO vo);
	
	/**
	 * 显示所有账户信息
	 * @return
	 */
	public ArrayList<BankAccountVO> show();

}
