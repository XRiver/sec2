package businesslogicservice.logisticblservice._Driver;

import java.util.ArrayList;

import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnServiceBLService_Stub;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

public class LoadNoteOnServiceBLService_Driver {
	public static void main(String[] args){
		LoadNoteOnServiceBLService a=new LoadNoteOnServiceBLService_Stub();
		LoadNoteOnServiceBLService_Driver b=new LoadNoteOnServiceBLService_Driver();
		b.driver(a);
	}
	public void driver(LoadNoteOnServiceBLService a){
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
        LoadNoteOnServiceVO loadNoteOnServiceVO = new LoadNoteOnServiceVO("2015-11-11", "0251000",
                "02510002015092100000", "北京", "025000000", "李明", "张三", bar);
        ResultMsg result=a.inputHallLoadDoc(loadNoteOnServiceVO);
		if(result.isPass()==true)
			System.out.println("输入的营业厅装车单格式正确");
		else
			System.out.println("输入的营业厅装车单格式不正确");
		ResultMsg result1=a.submitHallLoadDoc(loadNoteOnServiceVO);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
