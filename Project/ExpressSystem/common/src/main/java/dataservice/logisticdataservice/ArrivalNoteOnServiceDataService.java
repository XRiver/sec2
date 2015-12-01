/**
 * 处理营业厅到达件数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.exception.ElementNotFoundException;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;
import util.ResultMsg;


public interface ArrivalNoteOnServiceDataService extends Remote, Serializable {

    /**
     * 在数据库中插入单一持久化对象
     */
    ResultMsg insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException;

    ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnService() throws SQLException;

    /**
     * 在数据库中插入单一持久化对象
     */
    ResultMsg insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException;

    ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnService() throws RemoteException,SQLException;
}
