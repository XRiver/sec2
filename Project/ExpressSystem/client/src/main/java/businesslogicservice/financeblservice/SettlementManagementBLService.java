/**
 * 结算管理
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.IncomeNoteVO;

public interface SettlementManagementBLService {
	
	/**
	 * 新增收款记录
	 * @param vo
	 * @return
	 */
	public ResultMsg addReceiveRecord(IncomeNoteVO vo);
	
	/**
	 * 查询收款记录
	 * @param vo
	 * @return
	 */
	public ArrayList<IncomeNoteVO> find(IncomeNoteVO vo);

}
