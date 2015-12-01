package dataservice.financedataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.math.BigDecimal;
import java.rmi.RemoteException;

import dataservice.financedataservice.SettlementManagementDataService;
import dataservice.financedataservice._Stub.SettlementManagementDataService_Stub;
import po.BankAccountPO;
import po.IncomeNotePO;

public class SettlementManagementDataService_Driver {
	private IncomeNotePO incomeNotePO;
	private BankAccountPO bankAccountPO;
	
	public SettlementManagementDataService_Driver() {
		bankAccountPO = new BankAccountPO("金三胖","1234567890","300");
		incomeNotePO = new IncomeNotePO("2015-11-11","南京中转中心","汤恩义","六合营业厅","20",bankAccountPO);	
	}
	
	public void drive(SettlementManagementDataService settlementManagementDataService) throws RemoteException {
	   settlementManagementDataService.addIncomeNote(incomeNotePO);	
	   
	   if(settlementManagementDataService.addIncomeNote(incomeNotePO))
		   System.out.println("sucess");
	   else
		   System.out.println("fail");
	}
	
	public static void main(String[] args) throws RemoteException {
		SettlementManagementDataService_Stub stub = new SettlementManagementDataService_Stub();
		SettlementManagementDataService_Driver driver = new SettlementManagementDataService_Driver();
		driver.drive(stub);
	}
	
}
