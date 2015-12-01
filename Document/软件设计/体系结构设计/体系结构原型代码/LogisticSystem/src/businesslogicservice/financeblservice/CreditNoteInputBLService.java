/**
 * 记录快递收款单
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import businesslogic.util.ResultMsg;
import vo.CreditNoteVO;

public interface CreditNoteInputBLService {
	
	/**
	 * 新增快递收款单
	 * @param putInStorageVo
	 * @return
	 */
	public ResultMsg addReceipeDoc(CreditNoteVO vo);
	
	/**
	 * 提交收款单
	 * @param putInStorageVo
	 * @return
	 */
   public ResultMsg submitReceipeDoc(CreditNoteVO vo);
   
}
