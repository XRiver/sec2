package vo;

import util.FormatCheck;
import po.LoadNoteOnTransitPO;
import po.NotePO;
import util.ResultMsg;

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
	 * 本中转中心汽运编号(唯一标识)
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

    @Override
    public LoadNoteOnTransitPO toPO() {
        return new LoadNoteOnTransitPO(this.date,this.transpotationNumber,
        this.transpotationNumber,
        this.Destination,
        this.carNumber,
        this.guardMan,
        this.supercargoMan,
        this.barcodes);
    }

    @Override
    public ResultMsg checkFormat() {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[7];
        results[0] = FormatCheck.isCenterLoadNumber(this.transpotationNumber);
        results[1] = FormatCheck.isCity(this.Destination);
        results[2] = FormatCheck.isCarNumber(this.carNumber);
        results[3] = FormatCheck.isChineseName(this.guardMan);
        results[4] = FormatCheck.isChineseName(this.supercargoMan);
        results[5] = FormatCheck.isDate(this.date);
        results[6] = new ResultMsg(true);
        ResultMsg msg;
        for(String barcode:barcodes){
            msg = FormatCheck.isBarcode(barcode);
            if(!msg.isPass()){
                results[6] = msg;
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
}
