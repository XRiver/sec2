package po;

import java.io.File;
import java.io.Serializable;

import vo.VehicleVO;

public class VehiclePO implements Serializable {

	private static final long serialVersionUID = -843114324702086467L;

	public VehiclePO(String carNumber, String institutionNumber, File picture,
                     String firstUseTime) {
		super();
		this.carNumber = carNumber;
		this.institutionNumber = institutionNumber;
		this.picture = picture;
		this.firstUseTime = firstUseTime;
	}
	
	/**
	 * 车辆编号
	 */
	String carNumber = null;
	
	/**
	 * 所属营业厅或中转中心编号
	 */
	String institutionNumber = null;
	
	/**
	 * 车辆照片
	 */
	File picture = null;
	
	/**
	 * 车辆首次服役时间
	 */
	String firstUseTime = null;

	public String getCarNumber() {
		return carNumber;
	}

	public String getInstitutionNumber() {
		return institutionNumber;
	}

	public File getPicture() {
		return picture;
	}

	public String getFirstUseTime() {
		return firstUseTime;
	}

	public Object toVO() {
		VehicleVO vo = new VehicleVO(carNumber, institutionNumber, firstUseTime, picture);
		return vo;
	}
	
}
