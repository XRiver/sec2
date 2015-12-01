package businesslogicservice.logisticblservice._Driver;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;
import vo.ArrivalNoteOnTransitVO;
import vo.GoodsInfoVO;

public class ArrivalNoteOnTransitBLService_Driver {
	public static void main(String[] args){
		ArrivalNoteOnTransitBLService a=new ArrivalNoteOnTransitBLService_Stub();
		ArrivalNoteOnTransitBLService_Driver driver=new ArrivalNoteOnTransitBLService_Driver();
		driver.drive(a);
	}
	public void drive(ArrivalNoteOnTransitBLService arrivalNoteOnTransitBLService){

		ArrayList<GoodsInfoVO> c=new ArrayList<GoodsInfoVO>();
		GoodsInfoVO b=new GoodsInfoVO("1234567890", "完整", "南京");
		c.add(b);
		ArrivalNoteOnTransitVO centerArrivalDocVO=new ArrivalNoteOnTransitVO("025000201510120000003","025000","2011-11-11",c); 
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
