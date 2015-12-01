/**
 * 录入中转中心装车单数据接口
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
import po.LoadNoteOnTransitPO;
import util.ResultMsg;

public interface LoadNoteOnTransitDataService extends Remote, Serializable {
	/**
	 * 在数据库中增加一个po记录
	 */
    ResultMsg insert(LoadNoteOnTransitPO po) throws RemoteException, SQLException, ElementNotFoundException;

    ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransit() throws SQLException;
}
