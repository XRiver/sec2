package businesslogic.logistic;

import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class LoadNoteOnService implements LoadNoteOnServiceBLService {

    private LoadNoteOnServiceDataService dataService;

    private LoadNoteOnServicePO po;

    public LoadNoteOnService(LoadNoteOnServiceDataService dataService) {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService = (LoadNoteOnServiceDataService) getter.getObjectByName("LoadNoteOnServiceDataService");
    }

    @Override
    public ResultMsg inputHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        ResultMsg formatCheck = hallLoadDocVO.checkFormat();
        return formatCheck;
    }

    @Override
    public ResultMsg submitHallLoadDoc(LoadNoteOnServiceVO hallLoadDocVO) {
        try {
            this.po = hallLoadDocVO.toPO();
            this.po.setOrganization(hallLoadDocVO.getOrganization());
            this.po.setUserName(hallLoadDocVO.getUserName());
            this.dataService.insert(this.po);
            return new ResultMsg(true,"营业厅装车单已提交!");
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
