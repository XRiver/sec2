/**
 * 出库单信息PO类
 * @author wQY
 * @data 2015/10/17
 */

package po;

import java.io.Serializable;
import java.util.ArrayList;

public class StorageOutPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4577241133330282111L;

	/**
	 * 快递编号
	 */
	private ArrayList<String> expressCode;

	/**
	 * 日期
	 */
	private String date;
	/**
	 * 目的地
	 */
	private String destination;
	/**
	 * 装运形式
	 */
	private String type;
	/**
	 * 中转单编号
	 */
	private String transferCode;
	/**
	 * 汽运编号
	 */
	private String carCode;
	
	/**
	 * 中转单编号或汽运编号,true为中转单编号，false为汽运编号
	 */
	boolean TransferOrCar;

	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageOutPO(ArrayList<String> expressCode,String date,
			String destination,String type
			,String transferCode,boolean TorC){
		this.date = date;
		this.expressCode = expressCode;
		this.destination = destination;
		this.type = type;
		this.TransferOrCar=TorC;
		if(TorC==true)
			this.transferCode = transferCode;
		else
			this.carCode = transferCode;

	}

	public String getDate() {
		return date;
	}

	public ArrayList<String> getExpressCode() {
		return expressCode;
	}

	public String getDestination() {
		return destination;
	}

	public String getType() {
		return type;
	}

	public String getTransferCode() {
		return transferCode;
	}
	
	public String getCarCode() {
		return carCode;
	}

	public boolean isTransferOrCar() {
		return TransferOrCar;
	}


}