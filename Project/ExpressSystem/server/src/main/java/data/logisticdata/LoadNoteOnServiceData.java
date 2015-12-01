package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import data.statisticdata.LogInsertData;
import data.statisticdata.OrderInquiryData;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.LoadNoteOnServicePO;
import util.BarcodeAndState;
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
public class LoadNoteOnServiceData extends NoteInputData implements LoadNoteOnServiceDataService {

    public LoadNoteOnServiceData() throws RemoteException {
    }

    @Override
    public ResultMsg insert(LoadNoteOnServicePO po) throws RemoteException, SQLException, ElementNotFoundException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_load_on_service` ( `barcodes`, `destination`, `supercargoMan`, " +
                "`guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?)";
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
        LogInsHelper.insertLog("营业厅业务员?新增营业厅到达单,单据编号:" + po.getTranspotationNumber());

        //等待总经理审批过程,反复查询
        DocState result = this.waitForCheck("note_load_on_service",
                "transpotationNumber", po.getTranspotationNumber());
        ResultMsg resultMsg = new ResultMsg(false);
        //审批通过
        if (result == DocState.PASSED) {
            System.out.println("ArrivalNoteOnTransitPO is passed!");
            //追加修改物流信息
            for (String barcode : barcodes) {
                this.updateOrder(barcode,GoodsState.COMPLETE,
                        "已到达"+po.getOrganization());
            }
            resultMsg.setPass(true);
            //审批没有通过
        } else {
            System.out.println("ArrivalNoteOnTransitPO is failed!");
            String advice = this.getFailedAdvice("note_load_on_service",
                    "transpotationNumber", po.getTranspotationNumber());
            resultMsg.setMessage(advice);
        }
        //操作结束
        DatabaseManager.releaseConnection(connection, statement, null);
        return resultMsg;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> getLoadNoteOnService() throws SQLException {
        ArrayList<LoadNoteOnServicePO> result = new ArrayList<>();
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from `note_load_on_service` where isPassed = 0";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        LoadNoteOnServicePO arrivalNoteOnServicePO;
        while(resultSet.next()){
            String date = resultSet.getString(1);
            String hallNumber = resultSet.getString(2);
            String transNumber = resultSet.getString(3);
            String des = resultSet.getString(4);
            String car = resultSet.getString(5);
            String guard = resultSet.getString(6);
            String supercargo = resultSet.getString(7);
            String barcodes = resultSet.getString(8);
            arrivalNoteOnServicePO = new LoadNoteOnServicePO(date,hallNumber,transNumber,des,car,
                    guard,supercargo,null);
            result.add(arrivalNoteOnServicePO);
        }
        DatabaseManager.releaseConnection(connection, statement, resultSet);
        return result;
    }

}
