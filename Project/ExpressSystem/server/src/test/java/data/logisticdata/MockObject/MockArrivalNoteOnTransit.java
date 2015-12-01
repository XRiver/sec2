package data.logisticdata.MockObject;


import java.util.ArrayList;

import po.ArrivalNoteOnTransitPO;
import util.BarcodeAndState;

/**
 * Created by kylin on 15/11/12.
 */
public class MockArrivalNoteOnTransit extends ArrivalNoteOnTransitPO {

	public MockArrivalNoteOnTransit(String transferNumber, String centerNumber, String date, String departurePlace,
			ArrayList<BarcodeAndState> barcodeAndStates) {
		super(transferNumber, centerNumber, date, departurePlace, barcodeAndStates);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
