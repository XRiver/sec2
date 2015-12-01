package businesslogicservice.logisticblservice._Driver;

import java.util.ArrayList;

import util.enums.TransitType;
import vo.TransitNoteOnTransitVO;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.TransitNoteInputBLService_Stub;
import util.ResultMsg;

public class TransitNoteInputBLService_Driver {
	public static void main(String [] args){
		TransitNoteInputBLService a=new TransitNoteInputBLService_Stub();
		TransitNoteInputBLService_Driver b=new TransitNoteInputBLService_Driver();
		b.driver(a);
	}
	public void driver(TransitNoteInputBLService a){
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
        TransitNoteOnTransitVO transitNoteOnTransitVO = new TransitNoteOnTransitVO("2011-11-11",
                "025000201510120000003", "MF8190", TransitType.Aircraft, "北京",
                "南京", "001", null);
        ResultMsg result=a.inputCenterTransitDoc(transitNoteOnTransitVO);
		if(result.isPass()==true)
			System.out.println("输入的中转单格式正确");
		else
			System.out.println("输入的中转单格式不正确");
		ResultMsg result2=a.submitCenterTransitDoc(transitNoteOnTransitVO);
		if(result2.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
