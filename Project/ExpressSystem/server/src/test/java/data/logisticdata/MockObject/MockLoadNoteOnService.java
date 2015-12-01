package data.logisticdata.MockObject;

import po.LoadNoteOnServicePO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockLoadNoteOnService extends LoadNoteOnServicePO {
    public MockLoadNoteOnService(String date, String hallNumber, String transpotationNumber,
                                 String destination, String carNumber, String guardMan,
                                 String supercargoMan, ArrayList<String> barcodes) {
        super(date, hallNumber, transpotationNumber, destination, carNumber, guardMan,
                supercargoMan, barcodes);
    }

    public MockLoadNoteOnService(String transpotationNumber,String destination, String carNumber){
        super(null, null, transpotationNumber, destination, carNumber, null,
                null, null);
    }

}
