package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
import vo.LoadNoteOnTransitVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class LoadNoteOnTransit implements LoadNoteOnTransitBLService {

    private LoadNoteOnTransitDataService dataService;

    private LoadNoteOnTransitPO po;

    public LoadNoteOnTransit(LoadNoteOnTransitDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (LoadNoteOnTransitDataService) getter.getObjectByName("LoadNoteOnTransitDataService");
    }

    @Override
    public ResultMsg inputCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
        ResultMsg formatCheck = centerLoadDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
        try {
            this.po = centerLoadDocVO.toPO();
            this.po.setUserName(centerLoadDocVO.getUserName());
            this.po.setOrganization(centerLoadDocVO.getOrganization());
            this.dataService.insert(this.po);
            return new ResultMsg(true,"中转中心装车单已提交!");
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
