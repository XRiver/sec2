package businesslogicservice.commodityblservice._Driver;

import java.util.ArrayList;


import vo.StorageOutVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.commodityblservice.StorageOutBLService;
import businesslogicservice.commodityblservice._Stub.StorageOutBLService_Stub;

public class StorageOutBLService_Driver {
	public static void main(String[] args){
		StorageOutBLService a=new StorageOutBLService_Stub();
		StorageOutBLService_Driver b=new StorageOutBLService_Driver();
		b.drive(a);
		
	}
	public void drive(StorageOutBLService a){
		ArrayList<String>barcode=new ArrayList<String>();
		barcode.add("1234567890");
		StorageOutVO storageOutVo=new StorageOutVO("2011-11-11","北京","025000201509091234567",
				"铁路", barcode,true);
		ResultMsg result=a.addStorageOutDoc(storageOutVo);
		if(result.isPass()==true)
			System.out.println("输入的入库单格式正确");
		else
			System.out.println("输入的入库单格式不正确");
		ResultMsg result1=a.submitStorageOutDoc(storageOutVo);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");

	}
}
