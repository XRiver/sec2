package businesslogicservice.logisticblservice._Driver;

import java.util.ArrayList;

import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnTransitBLService_Stub;
import vo.LoadNoteOnTransitVO;

public class LoadNoteOnTransitBLService_Driver {
	public static void main(String[] args){
		LoadNoteOnTransitBLService a=new LoadNoteOnTransitBLService_Stub();
		LoadNoteOnTransitBLService_Driver b=new LoadNoteOnTransitBLService_Driver();
		b.driver(a);
	}
	public void driver(LoadNoteOnTransitBLService a){
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		LoadNoteOnTransitVO centerLoadDocVO=new LoadNoteOnTransitVO("2011-11-11", "025000201509091234567", "北京","025010222",
				"李明", "张三", bar);
		ResultMsg result=a.inputCenterLoadDoc(centerLoadDocVO);
		if(result.isPass()==true)
			System.out.println("输入的中转中心装车单格式正确");
		else
			System.out.println("输入的中转中心装车单格式不正确");
		ResultMsg result1=a.submitCenterLoadDoc(centerLoadDocVO);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
