package businesslogicservice.logisticblservice._Stub;

import java.util.ArrayList;

import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;
import businesslogic.util.GoodsState;
import businesslogic.util.ResultMsg;
import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;

public class ArrivalNoteOnServiceBLService_Stub implements ArrivalNoteOnServiceBLService{
	String date;
	GoodsState state;
	ArrayList<String> barCodes;
	String TransferNumber;
	public ArrivalNoteOnServiceBLService_Stub(){

	}

	public ArrivalNoteOnServiceBLService_Stub(String date, GoodsState state, ArrayList<String> barCodes, String transferNumber) {
		super();
		this.date = date;
		this.state = state;
		this.barCodes = barCodes;
		this.TransferNumber = transferNumber;
	}
	@Override
	//输入到达单界面得到对输入的到达单的反馈检查结果
	public ResultMsg inputHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		if(arrialDocVO.getBarCodes().equals(bar))
			return new ResultMsg(true,"输入的到达单格式正确");
		else
			return new ResultMsg(false,"输入的到达单格式不正确");
	}
	@Override
	//提交界面得到对提交的到达单的反馈结果
	public ResultMsg submitHallArrivalDoc(ArrivalNoteOnServiceVO arrialDocVO) {
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		if(arrialDocVO.getBarCodes().equals(bar))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}
	@Override
	//输入派件单界面得到对输入的派件单的反馈检查结果
	public ResultMsg inputHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		if(deliverDocVO.getBarCode().equals(bar))
			return new ResultMsg(true,"输入的派件单格式正确");
		else
			return new ResultMsg(false,"输入的派件单格式不正确");
	}
	@Override
	//提交界面得到对提交的派件单的反馈结果
	public ResultMsg submitHallDeliverDoc(DeliverNoteOnServiceVO deliverDocVO) {
		ArrayList<String> bar=new ArrayList<String>();
		bar.add("1234567890");
		if(deliverDocVO.getBarCode().equals(bar))
			return new ResultMsg(true,"提交成功");
		else
			return new ResultMsg(false,"提交失败");
	}

}
