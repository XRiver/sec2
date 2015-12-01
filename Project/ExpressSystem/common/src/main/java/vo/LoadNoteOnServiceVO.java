package vo;

import util.FormatCheck;
import po.LoadNoteOnServicePO;
import po.NotePO;
import util.ResultMsg;

import java.util.ArrayList;

/**
 * 营业厅装车单VO
 * 
 * @author kylin
 *
 */
public class LoadNoteOnServiceVO extends NoteVO {

	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 本营业厅编号
	 */
	private String hallNumber;

	/**
	 * 汽运编号(唯一标识)
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

    public LoadNoteOnServiceVO(String date, String hallNumber, String transpotationNumber, String destination,
                               String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes) {
        super();
        this.date = date;
        this.hallNumber = hallNumber;
        this.transpotationNumber = transpotationNumber;
        this.Destination = destination;
        this.carNumber = carNumber;
        this.guardMan = guardMan;
        this.supercargoMan = supercargoMan;
        this.barcodes = barcodes;
    }

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[8];
        results[0] = FormatCheck.isDate(this.date);
        results[1] = FormatCheck.isServiceHallNumber(this.hallNumber);
        results[2] = FormatCheck.isServiceHallLoadNumber(this.transpotationNumber);
        results[3] = FormatCheck.isCity(this.Destination);
        results[4] = FormatCheck.isCarNumber(this.carNumber);
        results[5] = FormatCheck.isChineseName(this.guardMan);
        results[6] = FormatCheck.isChineseName(this.supercargoMan);
        results[7] = new ResultMsg(true);
        ResultMsg msg;
        for(String barcode:barcodes){
            msg = FormatCheck.isBarcode(barcode);
            if(!msg.isPass()){
                results[7] = msg;
                break;
            }
        }
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass()){
                return results[i];
            }
        }
        return result;
    }

    @Override
    public LoadNoteOnServicePO toPO() {
        return new LoadNoteOnServicePO(this.date, this.hallNumber, this.transpotationNumber,
        this.Destination, this.carNumber, this.guardMan, this.supercargoMan, this.barcodes);
    }
}
