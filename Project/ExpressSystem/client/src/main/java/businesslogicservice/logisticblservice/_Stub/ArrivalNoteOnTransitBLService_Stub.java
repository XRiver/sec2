package businesslogicservice.logisticblservice._Stub;

import java.util.ArrayList;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import util.BarcodeAndState;
import util.ResultMsg;
import vo.ArrivalNoteOnTransitVO;

public class ArrivalNoteOnTransitBLService_Stub implements ArrivalNoteOnTransitBLService{
	String transferNumber;
	String centerNumber;
	String date;

	ArrayList<BarcodeAndState> GoodsInfoVOs;
	public ArrivalNoteOnTransitBLService_Stub(){

	}
	public ArrivalNoteOnTransitBLService_Stub(String transferNumber, String centerNumber, String date,
			ArrayList<BarcodeAndState> goodsInfoVOs) {
		super();
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		GoodsInfoVOs = goodsInfoVOs;
	}
	//输入到中转中心达单界面得到对输入的到达单的反馈检查结果
	public ResultMsg inputCenterArrivalDoc(
			ArrivalNoteOnTransitVO centerArrivalDocVO) {
		if(centerArrivalDocVO.getTransferNumber().equals("025000201510120000003"))
			return new ResultMsg(true,"输入的中转中心到达单格式正确");
		else
			return new ResultMsg(false,"输入的中转中心到达单格式不正确");
	}
	//提交界面得到对提交的中转中心到达单的反馈结果
	public ResultMsg submitCenterArrivalDoc(
			ArrivalNoteOnTransitVO centerArrivalDocVO) {
		if(centerArrivalDocVO.getTransferNumber().equals("025000201510120000003"))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
