package data.logisticdata;

import data.logisticdata.MockObject.MockReceivingNote;
import dataservice.exception.ElementNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import po.ReceivingNotePO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by kylin on 15/11/10.
 */
public class ReceivingNoteInput_Test {

    private ReceivingNoteInputData service;

    public ReceivingNoteInput_Test() throws RemoteException {
        service = new ReceivingNoteInputData();
    }

    @Test
    public void testInsert() throws RemoteException, SQLException, ElementNotFoundException {
        ReceivingNotePO po1 = new ReceivingNotePO("1234567893", "旭爷2", "2015-11-26 21:00");
        service.insert(po1);
    }

}
