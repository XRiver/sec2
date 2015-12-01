package businesslogicservice.logisticblservice._Driver;

import vo.SendingNoteVO;
import businesslogic.util.DeliverCategory;
import businesslogic.util.ResultMsg;
import businesslogic.util.sendDocMsg;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.DeliveryNoteInputBLService_Stub;

public class DeliveryNoteInputBLService_Driver {
	public static void main(String [] args){
		DeliveryNoteInputBLService a=new DeliveryNoteInputBLService_Stub();
		DeliveryNoteInputBLService_Driver b=new DeliveryNoteInputBLService_Driver();
		b.driver(a);
	}
	public void driver(DeliveryNoteInputBLService a){
		SendingNoteVO sendDocVO1=new SendingNoteVO("李明", "南京大学仙林校区", "南京大学", "1388888888",
				"1", 1.0, 1.0, "书", DeliverCategory.ECNOMIC,  5.0,
				"0123456789");
		ResultMsg result=a.inputSendDoc(sendDocVO1);
		if(result.isPass()==true)
			System.out.println("输入的寄件单格式正确");
		else
			System.out.println("输入的寄件单格式不正确");
		sendDocMsg result2=a.submitSendDoc(sendDocVO1);
		if(result2.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
