package businesslogicservice.logisticblservice;

import util.ResultMsg;
import util.SendDocMsg;
import vo.DeliveryNoteVO;

/**
 * 输入寄件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface DeliveryNoteInputBLService {

	/**
	 * 快递员输入寄件单信息
	 *
	 * @param sendDocVO 寄件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputSendDoc(DeliveryNoteVO sendDocVO);
	
	/**
	 * 快递员核对信息后要求提交单据
	 * 
	 * @param sendDocVO 寄件单VO
	 * @return 寄件报价、预计到达日期信息
	 */
    public SendDocMsg submitSendDoc(DeliveryNoteVO sendDocVO);

}
