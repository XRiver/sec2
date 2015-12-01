package businesslogicservice.commodityblservice._Driver;

import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import businesslogicservice.commodityblservice._Stub.StorageInquiryAllBLService_Stub;
import util.ResultMsg;

public class StorageInquiryAllBLService_Driver {
	public static void main(String[] args){
		StorageInquiryAllBLService a=new StorageInquiryAllBLService_Stub();
		StorageInquiryAllBLService_Driver b=new StorageInquiryAllBLService_Driver();
		b.drive(a);
	}
	public void drive(StorageInquiryAllBLService a){
		ResultMsg result2 =a.inputFirst("2011-11-11");
		if(result2.isPass()==true)
			System.out.println("success");
		else
			System.out.println("fail");
		}
}
