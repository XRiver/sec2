package po;

import java.io.File;
import java.io.Serializable;

public class VehiclePO implements Serializable {

	private static final long serialVersionUID = -843114324702086467L;

	public VehiclePO(String carNumber, String hallNumber,File picture,
			String firstUseTime) {
		super();
		this.carNumber = carNumber;
		this.hallNumber = hallNumber;
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
	String hallNumber = null;
	
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

	public String getHallNumber() {
		return hallNumber;
	}

	public File getPicture() {
		return picture;
	}

	public String getFirstUseTime() {
		return firstUseTime;
	}
	
}
