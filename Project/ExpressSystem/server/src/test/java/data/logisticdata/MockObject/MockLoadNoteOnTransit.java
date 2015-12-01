package data.logisticdata.MockObject;

import po.LoadNoteOnTransitPO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockLoadNoteOnTransit extends LoadNoteOnTransitPO {
    public MockLoadNoteOnTransit(String date, String transpotationNumber,
                                 String destination, String carNumber, String guardMan,
                                 String supercargoMan, ArrayList<String> barcodes) {
        super(date, transpotationNumber, destination, carNumber, guardMan, supercargoMan, null,null);
    }

    public MockLoadNoteOnTransit(String transpotationNumber,
                                 String destination, String carNumber){
        super(null, transpotationNumber, destination, carNumber, null, null, null,null);
    }
}
