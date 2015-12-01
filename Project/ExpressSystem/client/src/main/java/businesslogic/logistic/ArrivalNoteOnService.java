package businesslogic.logistic;

import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class ArrivalNoteOnService implements ArrivalNoteOnServiceBLService {

    private ArrivalNoteOnServiceDataService dataService;

    private ArrivalNoteOnServicePO arrivalNoteOnServicePO;
    private DeliverNoteOnServicePO deliverNoteOnServicePO;

    public ArrivalNoteOnService() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (ArrivalNoteOnServiceDataService) getter.getObjectByName("ArrivalNoteOnServiceDataService");
    }

    @Override
    public ResultMsg inputHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
        ResultMsg formatCheck = arrialDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
        ResultMsg resultMsg;
        try {
            this.arrivalNoteOnServicePO = arrialDocVO.toPO();
            //从VO中获取营业员的名字与工作地点
            arrivalNoteOnServicePO.setOrganization(arrialDocVO.getOrganization());
            arrivalNoteOnServicePO.setUserName(arrialDocVO.getUserName());
            resultMsg = this.dataService.insertArrivalNote(this.arrivalNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return new ResultMsg(false,"输入的到达单有误,请重新输入");
        }
        return resultMsg;
    }

    @Override
    public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        ResultMsg formatCheck = deliverDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
        try {
            this.deliverNoteOnServicePO = deliverDocVO.toPO();
            this.dataService.insertDeliverNote(this.deliverNoteOnServicePO);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,e.getMessage());
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ResultMsg(true,"营业厅装车单已提交!");
    }
}
