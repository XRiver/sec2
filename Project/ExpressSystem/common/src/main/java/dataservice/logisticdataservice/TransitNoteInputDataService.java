/**
 * 发送中转单数据接口
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
import po.TransitNotePO;
import util.ResultMsg;

public interface TransitNoteInputDataService extends Remote, Serializable {

	/**
	 * 在数据库中增加一个po记录
	 */
    ResultMsg insert(TransitNotePO po) throws RemoteException, SQLException, ElementNotFoundException;

    ArrayList<TransitNotePO> getTransitNotePO() throws SQLException;
}