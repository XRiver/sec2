package dataservice.financedataservice._Driver;
/**
 * @author wwz 
 * @data 2015/10/21
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;

import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.financedataservice._Stub.CreditNoteInputDataService_Stub;
import dataservice.exception.FailToPassApprovingException;
import po.CreditNotePO;

public class CreditNoteInputDataService_Driver {
	
	private CreditNotePO creditNotePO;
	
	public CreditNoteInputDataService_Driver() {

		creditNotePO = new CreditNotePO("2015-10-10","王小二","2000");
	}
	
	public void drive(CreditNoteInputDataService creditNoteInputDataService) throws RemoteException, FailToPassApprovingException {
		creditNoteInputDataService.addCreditNote(creditNotePO);
		if(creditNoteInputDataService.addCreditNote(creditNotePO))
		   System.out.println("success");
		else
			System.out.println("fail");
	}
	
	public static void main(String[] args) throws RemoteException,FailToPassApprovingException {
		CreditNoteInputDataService_Stub creditNoteDataService_Stub = new CreditNoteInputDataService_Stub();
		
		CreditNoteInputDataService_Driver driver = new CreditNoteInputDataService_Driver();
		driver.drive(creditNoteDataService_Stub);
	
	}

}
