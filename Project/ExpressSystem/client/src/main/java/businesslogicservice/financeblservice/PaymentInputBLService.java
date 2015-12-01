/**
 * 新增付款记录
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.financeblservice;

import util.ResultMsg;
import vo.PaymentVO;

public interface PaymentInputBLService {
	
	/**
	 * 输入付款记录信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addPaymentRecord(PaymentVO vo);
    
    /**
     * 提交付款记录
     * @param vo
     * @return
     */
    public ResultMsg submitPaymentRecord(PaymentVO vo);
}
