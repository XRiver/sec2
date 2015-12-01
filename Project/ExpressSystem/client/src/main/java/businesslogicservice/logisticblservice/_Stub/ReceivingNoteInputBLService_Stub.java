package businesslogicservice.logisticblservice._Stub;

import vo.ReceivingNoteVO;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import util.ResultMsg;

public class ReceivingNoteInputBLService_Stub implements ReceivingNoteInputBLService{
	public ReceivingNoteInputBLService_Stub(){

	}
	//输入收件单界面得到对输入的收件单的反馈检查结果
	public ResultMsg inputReceiveDoc(ReceivingNoteVO receiveDocVO) {
		if(receiveDocVO.getReceiveCustomer().equals("李明"))
			return new ResultMsg(true,"输入的收件单格式正确");
		else
			return new ResultMsg(false,"输入的收件单格式不正确");
	}

	//输入收件单界面得到对输入的收件单的反馈检查结果
	public ResultMsg submitSendDoc(ReceivingNoteVO receiveDocVO) {
		if(receiveDocVO.getReceiveCustomer().equals("李明"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交成功");
	}

}
