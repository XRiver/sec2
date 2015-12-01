package data.logisticdata.MockObject;

import po.ArrivalNoteOnServicePO;
import util.BarcodeAndState;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/12.
 */
public class MockArrivalNoteOnService extends ArrivalNoteOnServicePO {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public MockArrivalNoteOnService(String date, String transferNumber,
                                    String from, ArrayList<BarcodeAndState> barcodeAndStates) {
        super(date,true, transferNumber, from, barcodeAndStates);
    }

    public MockArrivalNoteOnService(String date, String transferNumber, String from){
        super(date,true, transferNumber,from,null);
    }

}
