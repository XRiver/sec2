package vo;

import java.util.ArrayList;

import po.StorageOutPO;
import util.FormatCheck;
import util.ResultMsg;

public class StorageOutVO {
	/**
	 * 条形码
	 */
	private ArrayList<String> barcode;
	
	/**
	 * 日期
	 */
	private String date;
	
	/**
	 *目的地 
	 */
	private String destination;
	
	/**
	 * 汽运编号或中转单编号
	 */
	private String truckNum;
	
	/**
	 * 装运方式
	 */
	private String shippingForm;
	
	/**
	 * 中转单编号或汽运编号,true为中转单编号，false为汽运编号
	 */
	boolean TransferOrCar;
	
	/**
	 * 构造方法
	 * @param date
	 * @param destination
	 * @param truckNum
	 * @param transferNum
	 * @param shippingForm
	 * @param barcode
	 */
	public StorageOutVO(String date,String destination,String transferNum,String shippingForm,
			ArrayList<String>barcode,boolean TorC){
		this.date = date;
		this.destination = destination;
		this.shippingForm = shippingForm;
		this.barcode = barcode;
		TransferOrCar = TorC;
		this.truckNum = transferNum;
	}

	public String getDate() {
		return date;
	}

	public String getDestination() {
		return destination;
	}

	public String getTruckNum() {
		return truckNum;
	}

	public String getShippingForm() {
		return shippingForm;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}

	public boolean isTransferOrCar() {
		return TransferOrCar;
	}

	public ResultMsg checkFormat() {
		ResultMsg[] msgs = new ResultMsg[3];
		
		msgs[0] = FormatCheck.isDate(date);
		msgs[1] = FormatCheck.isCity(destination);
		if(TransferOrCar) {
			msgs[2] = FormatCheck.isTransitNoteNumber(truckNum);
		} else {
			msgs[2] = FormatCheck.isCenterLoadNumber(truckNum);
		}
		
		for(ResultMsg m:msgs) {
			if(!m.isPass()) return m;
		}
		
		ResultMsg messa = null;
		
		for(String b:barcode) {
			messa = FormatCheck.isBarcode(b);
			if(!messa.isPass()) return messa;
		}
		
		
		return new ResultMsg(true);
	}

	public Object toPO() {
		StorageOutPO po = new StorageOutPO(barcode, date, destination, shippingForm, truckNum, TransferOrCar);
		return po;
	}
}
