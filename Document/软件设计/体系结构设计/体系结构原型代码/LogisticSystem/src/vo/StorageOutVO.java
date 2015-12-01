package vo;

import java.util.ArrayList;

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
	 * 汽运编号
	 */
	private String truckNum;
	
	/**
	 * 中转单编号
	 */
	private String transferNum;
	
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
		if(TorC==true)
			this.transferNum = transferNum;
		else
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

	public String getTransferNum() {
		return transferNum;
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
}
