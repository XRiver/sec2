package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import vo.InventoryVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageInquiryPartBLService;

public class StorageInquiryPartBLService_Stub implements StorageInquiryPartBLService{

	@Override
	public ResultMsg inputTime(String time1, String time2) {
		if(time1.equals("2011-11-11"))
			return new ResultMsg(true,"success");
		else
			return new ResultMsg(false,"failure");
	}

	@Override
	public ArrayList<InventoryVO> show(String time1, String time2) {
		return new ArrayList<InventoryVO>();
	}

}
