package businesslogicservice.logisticblservice;

import util.ResultMsg;
import vo.ReceivingNoteVO;

/**
 * 输入收件单逻辑接口
 * 
 * @author kylin
 *
 */
public interface ReceivingNoteInputBLService {
	
	/**
	 * 快递员输入收件单信息
	 *
	 * @param receiveDocVO 收件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputReceiveDoc(ReceivingNoteVO receiveDocVO);
	
	/**
	 * 快递员核对信息后要求提交单据
	 * 
	 * @param receiveDocVO 收件单VO
	 * @return 
	 */
	public ResultMsg submitSendDoc(ReceivingNoteVO receiveDocVO);
	
}
