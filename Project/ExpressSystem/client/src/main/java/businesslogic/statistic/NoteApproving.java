package businesslogic.statistic;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.NotePO;
import util.enums.DocType;
import vo.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class NoteApproving implements NoteApprovingBLService {

    private NoteApprovingDataService dataService;

    public NoteApproving() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (NoteApprovingDataService)getter.getObjectByName("NoteApprovingDataService");
    }

    @Override
    public ArrayList<ArrivalNoteOnServiceVO> getArrivalNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServiceVO> getDeliverNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitVO> getArrivalNoteOnTransitVO() {
        return null;
    }

    @Override
    public ArrayList<DeliveryNoteVO> getDeliveryNoteVO() {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnServiceVO> getLoadNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnTransitVO> getLoadNoteOnTransitVO() {
        return null;
    }

    @Override
    public ArrayList<ReceivingNoteVO> getReceivingNoteVO() {
        return null;
    }

    @Override
    public ArrayList<TransitNoteOnTransitVO> getTransitNoteVO() {
        return null;
    }

    @Override
    public void passAllDoc() {
        ArrayList<NoteVO> noteVOArrayList = this.getAllDoc();
        for (NoteVO vo:noteVOArrayList)
            this.passDoc(vo);
    }

    @Override
    public void passDoc(NoteVO docVO) {
        try {
            dataService.passDoc(docVO.toPO());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inputAdvice(NoteVO docVO, String advice) {
        try {
            dataService.failDoc(docVO.toPO(),advice);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<NoteVO> getAllDoc() {
        return null;
    }
}
