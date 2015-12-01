package data.financedata;

import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.PaymentInputDataService;
import po.PaymentPO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/16.
 */
public class PaymentInputData implements PaymentInputDataService {
    @Override
    public boolean addPayment(PaymentPO payment) throws RemoteException, FailToPassApprovingException {
        return false;
    }
}
