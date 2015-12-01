package businesslogicservice.logisticblservice._Stub;

import vo.TransitNoteOnTransitVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;

public class TransitNoteInputBLService_Stub implements TransitNoteInputBLService{
	//输入中转单界面得到对输入的中转单的反馈检查结果
	@Override
	public ResultMsg inputCenterTransitDoc(
			TransitNoteOnTransitVO centerTransitDocVO) {
		if(centerTransitDocVO.getSupercargoMan().equals("李明"))
			return new ResultMsg(true,"输入的中转单格式正确");
		else
			return new ResultMsg(false,"输入的中转单格式不正确");
	}
	//输入中转单界面得到对输入的中转单的反馈检查结果
	@Override
	public ResultMsg submitCenterTransitDoc(
			TransitNoteOnTransitVO centerTransitDocVO) {
		if(centerTransitDocVO.getSupercargoMan().equals("李明"))
			return new ResultMsg(true,"提交");
		else
			return new ResultMsg(false,"提交");
	}

}
