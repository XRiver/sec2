/**
 * 营业厅装车单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import vo.LoadNoteOnServiceVO;
import vo.NoteVO;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadNoteOnServicePO extends NotePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4136800709346156198L;

	private String date;

	/**
	 * 本营业厅编号
	 */
	private String hallNumber;

	/**
	 * 汽运编号
	 */
	private String transpotationNumber;

	/**
	 * 目的地
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
	 * 货物条形码
	 */
	private ArrayList<String> barcodes;

    private double transferPrice;

	public LoadNoteOnServicePO(String date, String hallNumber, String transpotationNumber, String destination,
			String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.hallNumber = hallNumber;
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

	public String getHallNumber() {
		return hallNumber;
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

    public double getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(double transferPrice) {
        this.transferPrice = transferPrice;
    }

    @Override
    public NoteVO toVO() {
        return new LoadNoteOnServiceVO(this.date, this.hallNumber, this.transpotationNumber,
                this.Destination, this.carNumber, this.guardMan, this.supercargoMan, this.barcodes);
    }

    @Override
    public String getID() {
        return this.transpotationNumber;
    }
}