package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.PaymentInputBLService;
import vo.PaymentVO;

public class PaymentInputBLService_Driver {

	public void drive(PaymentInputBLService service){
		service.addPaymentRecord(new PaymentVO(null, null, null, null, null));
	}

}
