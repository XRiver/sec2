package businesslogicservice.logisticblservice;

import util.ResultMsg;
import vo.TransitNoteOnTransitVO;

public interface TransitNoteInputBLService {

	/**
	 * 中转中心业务员输入中转中心中转单信息
	 *
	 * @param centerTransitDocVO 中转中心中转单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO);
	
	/**
	 * 中转中心业务员核对信息后要求提交单据
	 * 
	 * @param centerTransitDocVO 中转中心中转单VO
	 * @return 
	 */
	public ResultMsg submitCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO);
	
}
