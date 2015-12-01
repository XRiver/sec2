package data.commoditydata.MockObject;

import java.util.ArrayList;

import po.CommodityGoodsPO;
import po.StorageInPO;

public class MockStorageInPO extends StorageInPO {

    public MockStorageInPO(String date,
                           ArrayList<CommodityGoodsPO> GoodsInStorageInfo) {
        super(date, GoodsInStorageInfo);
    }

}
