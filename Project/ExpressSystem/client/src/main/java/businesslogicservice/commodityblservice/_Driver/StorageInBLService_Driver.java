package businesslogicservice.commodityblservice._Driver;

import java.util.ArrayList;

import vo.CommodityGoodsVO;
import vo.StorageInVO;
import businesslogicservice.commodityblservice.StorageInBLService;
import businesslogicservice.commodityblservice._Stub.StorageInBLService_Stub;
import util.ResultMsg;
import util.enums.InventoryStatus;

public class StorageInBLService_Driver {
	public static void main(String[] args){
		StorageInBLService a=new StorageInBLService_Stub();
		StorageInBLService_Driver b=new StorageInBLService_Driver();
		b.drive(a);

	}
	public void drive(StorageInBLService a){
		CommodityGoodsVO good=new CommodityGoodsVO("0123456789","航空区","南京","0002","0002","0002");
		ArrayList<CommodityGoodsVO> GoodsInStorageInfo=new ArrayList<CommodityGoodsVO> ();
		GoodsInStorageInfo.add(good);
		StorageInVO	putInStorageVo=new StorageInVO("2011-11-11",GoodsInStorageInfo);
		ResultMsg result=a.addPutInStorgaeDoc(putInStorageVo);
		if(result.isPass()==true)
			System.out.println("输入的入库单格式正确");
		else
			System.out.println("输入的入库单格式不正确");
		ResultMsg result1=a.submitPutInStorageDoc(putInStorageVo);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
		InventoryStatus result2=a.alarm();
		if(result2==InventoryStatus.SAFE)
			System.out.println("没有超过库存值");
		else
			System.out.println("超过库存预警，库存报警");
	}
}
