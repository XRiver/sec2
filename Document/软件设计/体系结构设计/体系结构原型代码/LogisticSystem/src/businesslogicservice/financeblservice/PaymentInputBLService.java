/**
 * 新增付款记录
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import businesslogic.util.ResultMsg;
import vo.PaymentRecordVO;

public interface PaymentInputBLService {
	
	/**
	 * 输入付款记录信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addPaymentRecord(PaymentRecordVO vo);

}
