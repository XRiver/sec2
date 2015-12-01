package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice._stub.BankAccountManagemntBLService_Stub;
import businesslogicservice.financeblservice._stub.CreditNoteInputBLService_Stub;
import businesslogicservice.financeblservice._stub.PaymentInputBLService_Stub;
import businesslogicservice.financeblservice._stub.SettlementManagementBLService_Stub;

public class ClientFinance {

	public static void main(String[] args) {
		BankAccountManagemntBLService_Driver driver1 = new BankAccountManagemntBLService_Driver();
		driver1.drive(new BankAccountManagemntBLService_Stub());
		
		CreditNoteInputBLService_Driver driver2 = new CreditNoteInputBLService_Driver();
		driver2.drive(new CreditNoteInputBLService_Stub());
		
		PaymentInputBLService_Driver driver3 = new PaymentInputBLService_Driver();
		driver3.drive(new PaymentInputBLService_Stub());
		
		SettlementManagementBLService_Driver driver4 = new SettlementManagementBLService_Driver();
		driver4.drive(new SettlementManagementBLService_Stub());
	}
	
}
