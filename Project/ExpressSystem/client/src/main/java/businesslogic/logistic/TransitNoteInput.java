package businesslogic.logistic;

import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;
import util.ResultMsg;
import vo.TransitNoteOnTransitVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class TransitNoteInput implements TransitNoteInputBLService {

    private TransitNoteInputDataService dataService;

    private TransitNotePO po;

    public TransitNoteInput(TransitNoteInputDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (TransitNoteInputDataService) getter.getObjectByName("TransitNoteInputDataService");
    }

    @Override
    public ResultMsg inputCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {
        ResultMsg formatCheck = centerTransitDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitCenterTransitDoc(TransitNoteOnTransitVO centerTransitDocVO) {
        try {
            this.po = (TransitNotePO) centerTransitDocVO.toPO();
            this.po.setUserName(centerTransitDocVO.getUserName());
            this.po.setOrganization(centerTransitDocVO.getOrganization());
            this.dataService.insert(this.po);
            return new ResultMsg(true,"中转单已提交!");
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        }
    }
}
