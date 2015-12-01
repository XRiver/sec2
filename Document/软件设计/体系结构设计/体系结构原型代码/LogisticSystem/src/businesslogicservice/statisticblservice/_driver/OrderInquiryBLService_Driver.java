package businesslogicservice.statisticblservice._driver;

import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.OrderInquiryBLService;
import vo.NoteHistoryVO;

public class OrderInquiryBLService_Driver {

	public void drive(OrderInquiryBLService service){
		ResultMsg result = service.inputBarcode("0123456789");
		if(result.isPass())
			System.out.println("barcode is correct!");
		else
			System.out.println("barcode is wrong!");
		service.submitBarcode("0123456789");
		ResultMsg result2 = service.inputBarcode("0123456790");
		System.out.println("barcode is correct!");
		if(result2.isPass())
			System.out.println("barcode is correct!");
		else
			System.out.println("barcode is wrong!");
		NoteHistoryVO history = service.submitBarcode("0123456790");
		System.out.println(history.getState());
	}
	
}
