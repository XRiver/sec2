package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.ArrivalNoteOnTransitVO;

public interface ArrivalNoteOnTransitBLService {

	/**
	 * 营业厅业务员输入中转中心到达单信息
	 *
	 * @param centerArrivalDocVO 中转中心到达单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO);

	/**
	 * 营业厅业务员核对信息后要求提交单据
	 *
	 * @param centerArrivalDocVO 中转中心到达单VO
	 * @return 
	 */
	public ResultMsg submitCenterArrivalDoc(ArrivalNoteOnTransitVO centerArrivalDocVO);
	
	
}
