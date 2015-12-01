package data.commoditydata.MockObject;

import java.util.ArrayList;

import po.CommodityGoodsPO;
import po.InventoryPO;

public class MockInventoryPO extends InventoryPO {

    String time = null;

    public MockInventoryPO(String outNum, String inNum, String money,
                           ArrayList<CommodityGoodsPO> goodsInfo, String time) {
        super(outNum, inNum, money, goodsInfo);
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
