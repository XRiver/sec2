package businesslogicservice.logisticblservice;

import businesslogic.util.ResultMsg;
import vo.LoadNoteOnTransitVO;

public interface LoadNoteOnTransitBLService {

	/**
	 * 中转中心业务员输入中转中心装车单信息
	 *
	 * @param centerLoadDocVO 中转中心装车单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO);
	
	/**
	 * 中转中心业务员核对信息后要求提交单据
	 * 
	 * @param centerLoadDocVO 中转中心装车单VO
	 * @return 
	 */
	public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO);
	
}
