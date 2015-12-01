package data.financedata;

import dataservice.exception.FailToPassApprovingException;
import dataservice.financedataservice.CreditNoteInputDataService;
import po.CreditNotePO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/16.
 */
public class CreditNoteInputData implements CreditNoteInputDataService{
    @Override
    public boolean addCreditNote(CreditNotePO note) throws RemoteException, FailToPassApprovingException {
        return false;
    }
}
