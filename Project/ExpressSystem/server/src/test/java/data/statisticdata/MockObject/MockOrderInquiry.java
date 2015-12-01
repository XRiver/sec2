package data.statisticdata.MockObject;

import java.util.ArrayList;

import po.OrderPO;
import util.enums.GoodsState;

public class MockOrderInquiry extends OrderPO{
    
	private static final long serialVersionUID = 1L;
	
	private String barcode;

    public MockOrderInquiry(String barcode, GoodsState goodsState, ArrayList<String> history, String barcode1) {
        super(barcode, goodsState, history);
        barcode = barcode1;
    }

    public String getBarcode() {
        return barcode;
	}

}
