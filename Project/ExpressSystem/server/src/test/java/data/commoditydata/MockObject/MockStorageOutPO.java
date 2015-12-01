package data.commoditydata.MockObject;

import java.util.ArrayList;

import po.StorageOutPO;

public class MockStorageOutPO extends StorageOutPO {

    public MockStorageOutPO(ArrayList<String> expressCode, String date,
                            String destination, String type, String transferCode, boolean TorC) {
        super(expressCode, date, destination, type, transferCode, TorC);
    }

}