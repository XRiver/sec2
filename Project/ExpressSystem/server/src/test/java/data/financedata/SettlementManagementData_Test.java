package data.financedata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.financedata.MockObject.MockSettlementManagement;

public class SettlementManagementData_Test {

	@Test
	public void testAddIncomeNote() throws RemoteException {
		MockSettlementManagement a=new MockSettlementManagement("上海中转中心");
		SettlementManagementData b=new SettlementManagementData();
		//assertEquals(true,b.addIncomeNote(a));
	}

}
