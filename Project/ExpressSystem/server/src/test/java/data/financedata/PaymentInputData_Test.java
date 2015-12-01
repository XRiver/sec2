package data.financedata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.financedata.MockObject.MockPaymentInput;
import dataservice.exception.FailToPassApprovingException;

public class PaymentInputData_Test {

	@Test
	public void testAddPayment() throws RemoteException, FailToPassApprovingException {
		MockPaymentInput a=new MockPaymentInput("2011-11-11");
		PaymentInputData b=new PaymentInputData();
		// assertEquals(true,	b.addPayment(a));
	}

}
