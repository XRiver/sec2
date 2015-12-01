package businesslogic.finance;

import java.rmi.RemoteException;

import po.PaymentPO;
import connection.RMIObjectProviderService;
import connection.RemoteObjectGetter;
import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.PaymentInputDataService;
import businesslogicservice.financeblservice.PaymentInputBLService;
import util.ResultMsg;
import vo.PaymentVO;

/**
 * Created by kylin on 15/11/17.
 * 
 * Finished.
 */
public class PaymentInput implements PaymentInputBLService {
	
	PaymentInputDataService dataService = null;
	
	public PaymentInput() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (PaymentInputDataService)getter.getObjectByName("PaymentInputDataService");
	}
	
    @Override
    public ResultMsg addPaymentRecord(PaymentVO vo) {
        ResultMsg msg = vo.checkFormat();
        return msg;
    }

    @Override
    public ResultMsg submitPaymentRecord(PaymentVO vo) {
    	
    	PaymentPO po = (PaymentPO) vo.toPO();
    	
    	try {
			boolean result = dataService.addPayment(po);
			if(result==false) {
				new ResultMsg(false,"付款单提交失败，请重试。");
			}
		} catch (RemoteException | FailToPassApprovingException e) {
			return new ResultMsg(false,e.getMessage());
		}
    	
        return new ResultMsg(true,"成功提交付款单并通过审批！");
    }
}
