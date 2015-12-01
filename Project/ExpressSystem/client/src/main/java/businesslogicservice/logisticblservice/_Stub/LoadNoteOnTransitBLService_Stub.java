package businesslogicservice.logisticblservice._Stub;

import vo.LoadNoteOnTransitVO;
import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import util.ResultMsg;

public class LoadNoteOnTransitBLService_Stub implements LoadNoteOnTransitBLService{
	public LoadNoteOnTransitBLService_Stub(){

	}
	//输入到中转中心装车单界面得到对输入的到达单的反馈检查结果
	public ResultMsg inputCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
		if(centerLoadDocVO.getGuardMan().equals("李明"))
			return new ResultMsg(true,"输入的中转中心装车单格式正确");
		else
			return new ResultMsg(false,"输入的中转中心装车单格式不正确");
	}
	//输入到中转中心装车单界面得到对输入的到达单的反馈检查结果
	public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
		if(centerLoadDocVO.getGuardMan().equals("李明"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
