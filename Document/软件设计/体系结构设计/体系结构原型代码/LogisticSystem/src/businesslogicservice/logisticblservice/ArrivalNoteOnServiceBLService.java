package businesslogicservice.logisticblservice;

import vo.DeliverNoteOnServiceVO;
import businesslogic.util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;

/**
 * 处理营业厅到达件，录入到达单与派件单的逻辑接口
 * 
 * @author kylin
 *
 */
public interface ArrivalNoteOnServiceBLService {
	/**
	 * 营业厅业务员输入到达单信息
	 *
	 * @param arrialDocVO 到达单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO);
	
	/**
	 * 营业厅业务员核对信息后要求提交单据
	 *
	 * @param arrialDocVO 到达单VO
	 * @return 
	 */
	public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO);
	
	/**
	 * 营业厅业务员输入派件信息
	 *
	 * @param deliverDocVO 派件单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO);
	
	/**
	 * 营业厅业务员核对信息后要求提交单据
	 *
	 * @param deliverDocVO 派件单VO
	 * @return 
	 */
	public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO);
	
}
