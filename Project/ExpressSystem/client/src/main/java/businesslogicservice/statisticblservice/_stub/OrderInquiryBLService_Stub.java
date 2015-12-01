package businesslogicservice.statisticblservice._stub;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import util.ResultMsg;
import vo.OrderVO;

public class OrderInquiryBLService_Stub implements OrderInquiryBLService {

	public ResultMsg inputBarcode(String inputBarcode) {
		System.out.println("inputBarcode succeed");
		return new ResultMsg(true,null);
	}

	public OrderVO submitBarcode(String inputBarcode) {
		System.out.println("submitBarcode succeed");
		return new OrderVO(null,null, null);
	}

}
