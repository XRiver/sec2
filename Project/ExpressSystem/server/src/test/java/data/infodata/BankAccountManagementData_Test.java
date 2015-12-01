package data.infodata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import po.BankAccountPO;
import data.infodata.MockObject.MockBankAccountManagement;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BankAccountManagementData_Test {
    static BankAccountManagementData bmd;

    static {
        try {
            bmd = new BankAccountManagementData();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws RemoteException, InterruptWithExistedElementException, SQLException {
        MockBankAccountManagement bam=new MockBankAccountManagement("李明");
		bmd.addBankAccount(bam);
		MockBankAccountManagement bam1=new MockBankAccountManagement("小明");
		bmd.addBankAccount(bam1);
	}
	@Test
	public void testAddBankAccount() throws RemoteException, InterruptWithExistedElementException {
		MockBankAccountManagement bam1=new MockBankAccountManagement("lizy");
		//assertEquals(true,bmd.addBankAccount(bam1));
	}

	@Test
	public void testRemoveBankAccount() throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException {
		MockBankAccountManagement bam1=new MockBankAccountManagement("小明");
		//assertEquals(true,bmd.removeBankAccount(bam1));
	}



	@Test
	public void testFindBankAccount() throws RemoteException, ElementNotFoundException, InterruptWithExistedElementException {
		MockBankAccountManagement bam=new MockBankAccountManagement("李明");
		ArrayList<BankAccountPO> po=new ArrayList<BankAccountPO>();
		po.add(bam);
		//assertEquals(po,bmd.findBankAccount(bam));
	}


}
