package dataservice.financedataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import po.PaymentPO;
import dataservice.financedataservice.PaymentInputDataService;
import dataservice.exception.FailToPassApprovingException;

public class PaymentInputDataService_Stub implements PaymentInputDataService {

	@Override
	public boolean addPayment(PaymentPO payment) throws RemoteException,
			FailToPassApprovingException {
		System.out.println("add payment success");
		return true;
	}
	
}
