package businesslogic.statistic;

import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import connection.RemoteObjectGetter;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import dataservice.statisticdataservice.BaseDataBuildingDataService;
import util.ResultMsg;
import vo.CommodityInfoVO;
import vo.FinanceVO;
import vo.InstitutionInfoVO;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/17.
 */
public class BaseDataBuilding implements BaseDataBuildingBLService {

    private BaseDataBuildingDataService dataBuildingDataService;

    public BaseDataBuilding() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataBuildingDataService =
                (BaseDataBuildingDataService)getter.getObjectByName("BaseDataBuildingDataService");
    }

    @Override
    public ResultMsg restartWithoutBasis() {
        try {
            this.dataBuildingDataService.startBaseDataBuilding(false);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法开始无基础期初建账!");
        }
        return new ResultMsg(true,"已开始无基础期初建账!");
    }

    @Override
    public ResultMsg restartWithBasis() {
        try {
            this.dataBuildingDataService.startBaseDataBuilding(true);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法开始有基础期初建账!");
        }
        return new ResultMsg(true,"已开始有基础期初建账!");
    }

    @Override
    public ResultMsg endDataBuilding() {
        try {
            this.dataBuildingDataService.endBaseDataBuilding();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法结束期初建账!");
        }
        return new ResultMsg(true,"期初建账成功!");
    }
}
