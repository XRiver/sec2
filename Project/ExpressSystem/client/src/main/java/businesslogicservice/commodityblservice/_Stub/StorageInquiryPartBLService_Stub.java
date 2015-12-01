package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import vo.InventoryVO;
import businesslogicservice.commodityblservice.StorageInquiryPartBLService;
import util.ResultMsg;

public class StorageInquiryPartBLService_Stub implements StorageInquiryPartBLService{

	public ResultMsg inputTime(String time1, String time2) {
		if(time1.equals("2011-11-11"))
			return new ResultMsg(true,"success");
		else
			return new ResultMsg(false,"failure");
	}
	public ArrayList<InventoryVO> show(String time1, String time2) {
		return new ArrayList<InventoryVO>();
	}

}
