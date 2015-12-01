/**
 * 中转中心装车单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadNoteOnTransitPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -136116233905646805L;

	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 本中转中心汽运编号
	 */
	private String transpotationNumber;

	/**
	 * 目的地（营业厅）
	 */
	private String Destination;

	/**
	 * 车辆代号
	 */
	private String carNumber;

	/**
	 * 监装员信息
	 */
	private String guardMan;

	/**
	 * 押运员信息
	 */
	private String supercargoMan;

	/**
	 * 装箱所有货物条形码
	 */
	private ArrayList<String> barcodes;

	public LoadNoteOnTransitPO(String date, String transpotationNumber, String destination, String carNumber,
			String guardMan, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.transpotationNumber = transpotationNumber;
		Destination = destination;
		this.carNumber = carNumber;
		this.guardMan = guardMan;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
	}

	public String getDate() {
		return date;
	}

	public String getTranspotationNumber() {
		return transpotationNumber;
	}

	public String getDestination() {
		return Destination;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getGuardMan() {
		return guardMan;
	}

	public String getSupercargoMan() {
		return supercargoMan;
	}

	public ArrayList<String> getBarcodes() {
		return barcodes;
	}

}