package businesslogicservice.logisticblservice._Stub;

import vo.ReceingNoteVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;

public class ReceivingNoteInputBLService_Stub implements ReceivingNoteInputBLService{
	public ReceivingNoteInputBLService_Stub(){

	}
	//输入收件单界面得到对输入的收件单的反馈检查结果
	@Override
	public ResultMsg inputReceiveDoc(ReceingNoteVO receiveDocVO) {
		if(receiveDocVO.getReceiveCustomer().equals("李明"))
			return new ResultMsg(true,"输入的收件单格式正确");
		else
			return new ResultMsg(false,"输入的收件单格式不正确");
	}

	//输入收件单界面得到对输入的收件单的反馈检查结果
	@Override
	public ResultMsg submitSecdDoc(ReceingNoteVO receiveDocVO) {
		if(receiveDocVO.getReceiveCustomer().equals("李明"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交成功");
	}

}
