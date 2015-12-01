package vo;

import java.io.File;
import java.text.Format;

import po.VehiclePO;
import util.FormatCheck;
import util.ResultMsg;

public class VehicleVO {
	
	/**
	 * 车辆代号
	 */
	private String vehiclecode;
	
	/**
	 * 所属机构编号
	 */
	private String organization;
	
	/**
	 * 首次服役时间
	 */
	private String serviceTimeLimit;
	
	private File picture;
	
	/**
	 * 
	 * @param vehiclecode 车辆代号
	 * @param organization 所属机构编号
	 * @param serviceTimeLimit 首次服役时间
	 */
	public VehicleVO(String vehiclecode,String organization,String serviceTimeLimit,File picture){
		this.vehiclecode = vehiclecode;
		this.organization = organization;
		this.serviceTimeLimit =serviceTimeLimit;
		this.picture = picture;
	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public String getOrganization() {
		return organization;
	}

	public String getServiceTimeLimit() {
		return serviceTimeLimit;
	}
	
	public File getPicture(){
		return picture;
	}
	
	public Object toPO(){
		VehiclePO po = new VehiclePO(vehiclecode, organization, picture, serviceTimeLimit);
		
		return po;
	}
	
	public ResultMsg checkFormat(){
		ResultMsg[] msgs = new ResultMsg[3];
		
		msgs[0] = FormatCheck.isCarNumber(vehiclecode);
		msgs[1] = FormatCheck.isDate(serviceTimeLimit);
		msgs[2] = FormatCheck.isOrganizationNumber(organization);
		
		for(ResultMsg m:msgs) {
			if(!m.isPass()) return m;
		}
		
		return new ResultMsg(true);
	}
}
