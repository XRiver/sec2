package vo;

import java.util.ArrayList;

/**
 * 中转中心装车单VO
 * 
 * @author kylin
 *
 */
public class LoadNoteOnTransitVO extends NoteVO {


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

	public LoadNoteOnTransitVO(String date, String transpotationNumber, String destination, String carNumber,
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
