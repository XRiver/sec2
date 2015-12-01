package businesslogicservice.statisticblservice;

import businesslogic.util.ResultMsg;
import vo.NoteHistoryVO;

/**
 * 单据查询的逻辑接口
 * 
 * @author kylin
 *
 */
public interface OrderInquiryBLService {

	/**
	 * 输入订单条形码，返回格式检查结果
	 * 
	 * @param inputBarcode
	 * @return
	 */
	public ResultMsg inputBarcode(String inputBarcode);
	
	/**
	 * 确认查询单据，返回单据的货运状态与历史轨迹
	 * 
	 * @param inputBarcode
	 * @return
	 */
	public NoteHistoryVO submitBarcode(String inputBarcode);
	
}
