package businesslogicservice.logisticblservice._Stub;

import vo.SendingNoteVO;
import businesslogic.util.DeliverCategory;
import businesslogic.util.ResultMsg;
import businesslogic.util.sendDocMsg;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;

public class DeliveryNoteInputBLService_Stub implements DeliveryNoteInputBLService{
	String senderName;
	String senderAddress;
	String senderWorkPlace;
	String senderTeleNumber;
	String number;
	double weight;
	double volume;
	String name;	
	DeliverCategory category;
	double packPrice;
	String barCode;
	public DeliveryNoteInputBLService_Stub(){

	}
	public DeliveryNoteInputBLService_Stub(String senderName, String senderAddress, String senderWorkPlace, String senderTeleNumber,
			String number, double weight, double volume, String name, DeliverCategory category, double packPrice,
			String barCode) {
		super();
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderWorkPlace = senderWorkPlace;
		this.senderTeleNumber = senderTeleNumber;
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.packPrice = packPrice;
		this.barCode = barCode;
	}
	//输入寄件单界面得到对输入的寄件单的反馈检查结果
	@Override
	public ResultMsg inputSendDoc(SendingNoteVO sendDocVO) {
		if(sendDocVO.getNumber().equals("1"))
			return new ResultMsg(true,"输入寄件单格式正确");
		else
			return new ResultMsg(false,"输入寄件单格式不正确");
	}
	//提交界面得到对提交的寄件单的反馈结果
	@Override
	public sendDocMsg submitSendDoc(SendingNoteVO sendDocVO) {
		if(sendDocVO.getNumber().equals("1"))
			return new sendDocMsg(true,"提交成功",10,"3days");
		else
			return new sendDocMsg(false,"提交失败",0,"0");

	}

}
