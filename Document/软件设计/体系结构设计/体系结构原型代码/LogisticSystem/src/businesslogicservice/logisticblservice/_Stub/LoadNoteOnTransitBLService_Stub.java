package businesslogicservice.logisticblservice._Stub;

import vo.LoadNoteOnTransitVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;

public class LoadNoteOnTransitBLService_Stub implements LoadNoteOnTransitBLService{
	public LoadNoteOnTransitBLService_Stub(){

	}
	//输入到中转中心装车单界面得到对输入的到达单的反馈检查结果
	@Override
	public ResultMsg inputCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
		if(centerLoadDocVO.getGuardMan().equals("李明"))
			return new ResultMsg(true,"输入的中转中心装车单格式正确");
		else
			return new ResultMsg(false,"输入的中转中心装车单格式不正确");
	}
	//输入到中转中心装车单界面得到对输入的到达单的反馈检查结果
	@Override
	public ResultMsg submitCenterLoadDoc(LoadNoteOnTransitVO centerLoadDocVO) {
		if(centerLoadDocVO.getGuardMan().equals("李明"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
