package data.logisticdata.MockObject;

import po.TransitNotePO;
import util.BarcodesAndLocation;
import util.enums.TransitType;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockTransitNote extends TransitNotePO {


    public MockTransitNote(String transitDocNumber,String flightNumber,String desitination){
        super(transitDocNumber, flightNumber, desitination, TransitType.Aircraft, null, null, null, null);
    }

    public MockTransitNote(String date, String transitDocNumber, String flightNumber, String departurePlace, String desitination, String supercargoMan, ArrayList<BarcodesAndLocation> barcodes) {
        super(date, transitDocNumber, flightNumber, TransitType.Aircraft, departurePlace, desitination, supercargoMan, barcodes);
    }
}
