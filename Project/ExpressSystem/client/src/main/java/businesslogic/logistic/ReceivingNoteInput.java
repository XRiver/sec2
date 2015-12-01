package businesslogic.logistic;

import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ReceivingNoteInputDataService;
import po.ReceivingNotePO;
import util.ResultMsg;
import vo.ReceivingNoteVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class ReceivingNoteInput implements ReceivingNoteInputBLService {

    private ReceivingNotePO po;

    private ReceivingNoteInputDataService dataService;

    public ReceivingNoteInput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ReceivingNoteInputDataService) getter.getObjectByName("ReceivingNoteInputDataService");
    }

    @Override
    public ResultMsg inputReceiveDoc(ReceivingNoteVO receiveDocVO) {
        ResultMsg formatCheck = receiveDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitSendDoc(ReceivingNoteVO receiveDocVO) {
        try {
            this.po = receiveDocVO.toPO();
            this.po.setOrganization(receiveDocVO.getOrganization());
            this.po.setUserName(receiveDocVO.getUserName());
            this.dataService.insert(this.po);
            return new ResultMsg(true,"收件单已提交!");
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
