package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.PaymentInputBLService;
import vo.PaymentRecordVO;

public class PaymentInputBLService_Driver {

	public void drive(PaymentInputBLService service){
		if(service.addPaymentRecord(new PaymentRecordVO(null, null, null, null, null)).isPass()){
			System.out.println("Pass");
		}else{
			System.out.println("Fail to add payment");
		}
	}

}
