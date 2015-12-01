package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.ArrivalNoteOnTransitDataService;
import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.DocState;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnTransitData extends NoteInputData implements ArrivalNoteOnTransitDataService {

    public ArrivalNoteOnTransitData() throws RemoteException {
    }

    @Override
    public ResultMsg insert(ArrivalNoteOnTransitPO po) throws RemoteException, SQLException, ElementNotFoundException {
        System.out.println("insert(ArrivalNoteOnTransitPO ");
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_arrival_on_transit` " +
                "( `date`, `barcodes`, `departurePlace`, `centerNumber`, `transferNumber`) " +
                "values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, po.getDate());
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<BarcodeAndState> barcodeAndState = po.getBarcodeAndStates();
        for (BarcodeAndState history : barcodeAndState) {
            stringBuilder.append(history.getBarcode());
            stringBuilder.append(';');
        }
        statement.setString(2, stringBuilder.toString());
        statement.setString(3, po.getDeparturePlace());
        statement.setString(4, po.getCenterNumber());
        statement.setString(5, po.getTransferNumber());
        //向数据库添加到达单
        statement.executeUpdate();
        statement.close();
        //记录系统日志
        LogInsHelper.insertLog(po.getOrganization()+" 业务员 "+po.getUserName()+
                "新增中转中心到达单,单据编号:" + po.getTransferNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_arrival_on_transit",
                "transferNumber", po.getTransferNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("ArrivalNoteOnTransitPO is passed!");
            //追加修改物流信息
            for (BarcodeAndState history : barcodeAndState) {
                this.updateOrder(history.getBarcode(),
                        history.getState(), "已到达"+po.getTransferNumber());
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("ArrivalNoteOnTransitPO is failed!");
            String advice = this.getFailedAdvice("note_arrival_on_transit",
                    "transferNumber", po.getTransferNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitPO> getArrivalNoteOnTransit() throws SQLException {
        ArrayList<ArrivalNoteOnTransitPO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_arrival_on_transit` where isPassed = 0";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        ArrivalNoteOnTransitPO arrivalNoteOnServicePO;
        while(resultSet.next()){
            String transferNumber = resultSet.getString(1);
            String centerNumber = resultSet.getString(2);
            String date = resultSet.getString(3);
            String departure = resultSet.getString(4);
            String barcodes = resultSet.getString(5);
            arrivalNoteOnServicePO = new ArrivalNoteOnTransitPO
                    (transferNumber,centerNumber,date,departure,null);
            result.add(arrivalNoteOnServicePO);
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result;
    }

}
