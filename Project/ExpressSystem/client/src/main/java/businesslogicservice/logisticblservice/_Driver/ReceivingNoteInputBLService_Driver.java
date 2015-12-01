package businesslogicservice.logisticblservice._Driver;

import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;
import util.ResultMsg;
import vo.ReceivingNoteVO;

public class ReceivingNoteInputBLService_Driver {
	public static void main(String[] args){
		ReceivingNoteInputBLService a=new ReceivingNoteInputBLService_Stub();
		ReceivingNoteInputBLService_Driver b=new ReceivingNoteInputBLService_Driver();
		b.driver(a);
	}
	public void driver(	ReceivingNoteInputBLService a){


		ReceivingNoteVO receiveDocVO=new ReceivingNoteVO("1234567890", "李明","2011-11-11");
		ResultMsg result=a.inputReceiveDoc(receiveDocVO);
		if(result.isPass()==true)
			System.out.println("输入的收件单格式正确");
		else
			System.out.println("输入的收件单格式不正确");
		ResultMsg result1=a.submitSendDoc(receiveDocVO);
		if(result1.isPass()==true)
			System.out.println("提交成功");
		else
			System.out.println("提交失败");
	}
}
