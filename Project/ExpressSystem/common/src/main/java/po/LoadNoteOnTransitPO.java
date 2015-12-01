/**
 * 中转中心装车单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import vo.LoadNoteOnServiceVO;
import vo.NoteVO;

import java.io.Serializable;
import java.util.ArrayList;

public class LoadNoteOnTransitPO extends NotePO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -136116233905646805L;

	/**
	 * 装车日期
	 */
	private String date;

    /**
     * 本营业厅编号
     */
    private String hallNumber;

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

    public LoadNoteOnTransitPO(String date, String hallNumber, String transpotationNumber,
                               String destination, String carNumber, String guardMan,
                               String supercargoMan, ArrayList<String> barcodes) {
        this.date = date;
        this.hallNumber = hallNumber;
        this.transpotationNumber = transpotationNumber;
        this.Destination = destination;
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

    public String getHallNumber() {
        return hallNumber;
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