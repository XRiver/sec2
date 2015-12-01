package businesslogicservice.logisticblservice._Driver;

import java.util.ArrayList;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnTransitVO;

public class ArrivalNoteOnTransitBLService_Driver {
	public static void main(String[] args){
		ArrivalNoteOnTransitBLService a=new ArrivalNoteOnTransitBLService_Stub();
		ArrivalNoteOnTransitBLService_Driver driver=new ArrivalNoteOnTransitBLService_Driver();
		driver.drive(a);
	}
	public void drive(ArrivalNoteOnTransitBLService arrivalNoteOnTransitBLService){

		ArrayList<BarcodeAndState> c=new ArrayList<BarcodeAndState>();
		BarcodeAndState b=new BarcodeAndState("1234567890", GoodsState.COMPLETE);
		c.add(b);
		ArrivalNoteOnTransitVO centerArrivalDocVO=new ArrivalNoteOnTransitVO("02500100199009", "025001", null, null, null);
		ResultMsg result=arrivalNoteOnTransitBLService.inputCenterArrivalDoc(centerArrivalDocVO);
		if(result.isPass()==true)
			System.out.println("输入的中转中心到达单格式正确");
		else
			System.out.println("输入的中转中心到达单格式不正确");
		ResultMsg result1=arrivalNoteOnTransitBLService.submitCenterArrivalDoc(centerArrivalDocVO);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
