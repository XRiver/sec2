package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;
import util.ResultMsg;
import util.enums.DocState;
import util.enums.GoodsState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransitData extends NoteInputData implements LoadNoteOnTransitDataService {

    public LoadNoteOnTransitData() throws RemoteException {
    }

    @Override
    public ResultMsg insert(LoadNoteOnTransitPO po) throws RemoteException, SQLException, ElementNotFoundException {

        String sql = "insert into `note_load_on_transit` ( `barcodes`, `destination`, `supercargoMan`," +
                " `guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseManager.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> barcodes = po.getBarcodes();
        for (String barcode : barcodes) {
            stringBuilder.append(barcode);
            stringBuilder.append(';');
        }
        statement.setString(1, stringBuilder.toString());
        statement.setString(2,po.getDestination());
        statement.setString(3,po.getSupercargoMan());
        statement.setString(4,po.getGuardMan());
        statement.setString(5,po.getDate());
        statement.setString(6,po.getCarNumber());
        statement.setString(7,po.getHallNumber());
        statement.setString(8,po.getTranspotationNumber());
        statement.executeUpdate();
        statement.close();

        //记录系统日志
        LogInsHelper.insertLog(po.getOrganization()+" 业务员"+po.getUserName()+
                "新增中转中心装车单,单据编号:" + po.getTranspotationNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_load_on_transit",
                "transpotationNumber", po.getTranspotationNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("LoadNoteOnTransit is passed!");
            //追加修改物流信息
            for (String barcode : barcodes) {
                this.updateOrder(barcode,GoodsState.COMPLETE,
                        "已从"+po.getOrganization()+"装车发往本地营业厅");
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("LoadNoteOnTransit is failed!");
            String advice = this.getFailedAdvice("note_load_on_transit",
                    "transpotationNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransit() throws SQLException {
        ArrayList<LoadNoteOnTransitPO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_load_on_transit` where isPassed = 0";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        LoadNoteOnTransitPO loadNoteOnTransitPO;
        while(resultSet.next()){
            String date = resultSet.getString(1);
            String hallNumber = resultSet.getString(2);
            String transNumber = resultSet.getString(3);
            String des = resultSet.getString(4);
            String car = resultSet.getString(5);
            String guard = resultSet.getString(6);
            String supercargo = resultSet.getString(7);
            String barcodes = resultSet.getString(8);
            loadNoteOnTransitPO = new LoadNoteOnTransitPO(date,hallNumber,transNumber,des,car,
                    guard,supercargo,null);
            result.add(loadNoteOnTransitPO);
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result;
    }

}
