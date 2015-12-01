package data.financedata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import data.financedata.MockObject.MockCreditNoteInput;
import dataservice.exception.FailToPassApprovingException;

public class CreditNoteInput_Test {
	 @Test
	 public void testAddCreditNote() throws RemoteException, FailToPassApprovingException{
		 MockCreditNoteInput a=new MockCreditNoteInput("李明");
		 CreditNoteInputData b=new CreditNoteInputData();
		// assertEquals(true, b.addCreditNote(a));
	 }

}
