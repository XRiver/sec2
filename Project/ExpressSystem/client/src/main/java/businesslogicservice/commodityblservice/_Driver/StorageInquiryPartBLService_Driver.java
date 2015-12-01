package businesslogicservice.commodityblservice._Driver;


import businesslogicservice.commodityblservice.StorageInquiryPartBLService;
import businesslogicservice.commodityblservice._Stub.StorageInquiryPartBLService_Stub;
import util.ResultMsg;

public class StorageInquiryPartBLService_Driver {

	public static void main(String [] args) {
		StorageInquiryPartBLService a=new StorageInquiryPartBLService_Stub();
		StorageInquiryPartBLService_Driver b=new StorageInquiryPartBLService_Driver();
		b.drive(a);
	}
	public void drive(StorageInquiryPartBLService a) {
		ResultMsg result=a.inputTime("2011-11-11", "2011-11-12");
		if(result.isPass()==true)
			System.out.println("success");
		else
			System.out.println("fail");
		a.show("2011-11-11", "2011-11-12");

	}
}
