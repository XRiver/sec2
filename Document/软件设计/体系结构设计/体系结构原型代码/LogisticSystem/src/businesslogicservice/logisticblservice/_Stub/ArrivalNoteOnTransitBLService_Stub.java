package businesslogicservice.logisticblservice._Stub;

import java.util.ArrayList;

import vo.ArrivalNoteOnTransitVO;
import vo.GoodsInfoVO;
import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;

public class ArrivalNoteOnTransitBLService_Stub implements ArrivalNoteOnTransitBLService{
	String transferNumber;
	String centerNumber;
	String date;

	ArrayList<GoodsInfoVO> GoodsInfoVOs;
	public ArrivalNoteOnTransitBLService_Stub(){

	}
	public ArrivalNoteOnTransitBLService_Stub(String transferNumber, String centerNumber, String date,
			ArrayList<GoodsInfoVO> goodsInfoVOs) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		GoodsInfoVOs = goodsInfoVOs;
	}
	@Override
	//输入到中转中心达单界面得到对输入的到达单的反馈检查结果
	public ResultMsg inputCenterArrivalDoc(
			ArrivalNoteOnTransitVO centerArrivalDocVO) {
		if(centerArrivalDocVO.getTransferNumber().equals("025000201510120000003"))
			return new ResultMsg(true,"输入的中转中心到达单格式正确");
		else
			return new ResultMsg(false,"输入的中转中心到达单格式不正确");
	}
	//提交界面得到对提交的中转中心到达单的反馈结果
	@Override
	public ResultMsg submitCenterArrivalDoc(
			ArrivalNoteOnTransitVO centerArrivalDocVO) {
		if(centerArrivalDocVO.getTransferNumber().equals("025000201510120000003"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
