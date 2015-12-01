package dataservice.financedataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;

import dataservice.financedataservice.PaymentInputDataService;
import dataservice.financedataservice._Stub.PaymentInputDataService_Stub;
import dataservice.exception.FailToPassApprovingException;
import po.PaymentPO;

public class PaymentInputDataService_Driver {
	private PaymentPO paymentPO;
	
	public PaymentInputDataService_Driver() {
		BigDecimal b = new BigDecimal(200);
		paymentPO = new PaymentPO("2015-11-11","徐江河","1029384756",b,"运费","双十一来了呢！wow好开森");
	}
	
	public void drive(PaymentInputDataService paymentInputDataService) throws RemoteException, FailToPassApprovingException {
		paymentInputDataService.addPayment(paymentPO);
		if(paymentInputDataService.addPayment(paymentPO))
			System.out.println("success");
		else
			System.out.println("fail");
		
	}
	
	public static void main(String[] args) throws RemoteException, FailToPassApprovingException {
		PaymentInputDataService_Stub stub = new PaymentInputDataService_Stub();
		PaymentInputDataService_Driver driver = new PaymentInputDataService_Driver();
		driver.drive(stub);
	}

}
