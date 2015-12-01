package businesslogicservice.logisticblservice;

import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

public interface LoadNoteOnServiceBLService {

	/**
	 * 营业厅业务员输入营业厅装车单信息
	 *
	 * @param hallLoadDocVO 营业厅装车单VO
	 * @return 单据信息格式检查结果
	 */
	public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO);
	
	/**
	 * 营业厅业务员核对信息后要求提交单据
	 * 
	 * @param hallLoadDocVO 营业厅装车单VO
	 * @return 
	 */
	public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO);
	
}
