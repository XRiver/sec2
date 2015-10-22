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
	 * 前置条件；经验证的财务人员选择新增付款记录的功能
	 * 后置条件：系统检查输入信息的格式，要求财务人员核对确认
	 * @param vo
	 * @return
	 */
	public ResultMsg addPaymentRecord(PaymentRecordVO vo);
	
	/**
	 * 输入付款记录信息
	 * 前置条件；付款单经过格式检验，财务人员核对无误，要求提交单据
	 * 后置条件：系统提示单据信息录入成功，并提交单据给总经理审批
	 * @param vo
	 * @return
	 */
	public ResultMsg submitPaymentRecord(PaymentRecordVO vo);

}
