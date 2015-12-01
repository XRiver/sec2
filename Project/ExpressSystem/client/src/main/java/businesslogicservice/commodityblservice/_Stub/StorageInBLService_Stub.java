package businesslogicservice.commodityblservice._Stub;

import java.util.ArrayList;

import vo.CommodityGoodsVO;
import vo.StorageInVO;
import businesslogicservice.commodityblservice.StorageInBLService;
import util.ResultMsg;
import util.enums.InventoryStatus;

public class StorageInBLService_Stub implements StorageInBLService{
	String date;
	ArrayList<CommodityGoodsVO> GoodsInStorageInfo;
	public StorageInBLService_Stub(){
		date = "2015-10-22";
		GoodsInStorageInfo = new ArrayList<CommodityGoodsVO>(); 
	}
	public StorageInBLService_Stub(String date,ArrayList<CommodityGoodsVO> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}

//新增入库单
	public ResultMsg addPutInStorgaeDoc(StorageInVO putInStorageVo) {
		if(putInStorageVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"输入的入库单格式正确");
		else
			return new ResultMsg(false,"输入的入库单格式不正确");
	}
//提交入库单
	public ResultMsg submitPutInStorageDoc(StorageInVO putInStorageVo) {
		if(putInStorageVo.getDate().equals("2015-11-11"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

	public InventoryStatus alarm() {
		GoodsInStorageInfo =new ArrayList<CommodityGoodsVO>();
		
		if(date.equals("2011-11-11"))
			return InventoryStatus.SAFE;
		
			else
		return InventoryStatus.DANGER;
	}
	
}
