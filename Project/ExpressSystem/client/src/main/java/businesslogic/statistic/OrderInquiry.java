package businesslogic.statistic;

import businesslogicservice.statisticblservice.OrderInquiryBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import util.ResultMsg;
import vo.OrderVO;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/17.
 */
public class OrderInquiry implements OrderInquiryBLService {

    private OrderInquiryDataService dataService;

    private OrderVO orderVO;
    private OrderPO resultPO;
    private OrderVO resultVO;

    public OrderInquiry() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (OrderInquiryDataService)getter.getObjectByName("OrderInquiryDataService");
    }

    @Override
    public ResultMsg inputBarcode(String inputBarcode) {
        this.orderVO = new OrderVO(inputBarcode,null,null);
        ResultMsg resultMsg = this.orderVO.checkFormat();
        return resultMsg;
    }

    @Override
    public OrderVO submitBarcode(String inputBarcode) {
        try {
            this.resultPO = dataService.findOrder(inputBarcode);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        this.resultVO = new OrderVO(this.resultPO.getBarcode(), resultPO.getGoodsState(),
                resultPO.getHistory());
        return this.resultVO;
    }
}
