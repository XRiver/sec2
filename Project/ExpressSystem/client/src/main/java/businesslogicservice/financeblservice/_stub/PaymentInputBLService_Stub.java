package businesslogicservice.financeblservice._stub;

import vo.PaymentVO;
import businesslogicservice.financeblservice.PaymentInputBLService;
import util.ResultMsg;

public class PaymentInputBLService_Stub implements PaymentInputBLService {

	public ResultMsg addPaymentRecord(PaymentVO vo) {
		System.out.println("Payment added!");
		return new ResultMsg(true, "Success!");
	}

	public ResultMsg submitPaymentRecord(PaymentVO vo) {
		return null;
	}

}
