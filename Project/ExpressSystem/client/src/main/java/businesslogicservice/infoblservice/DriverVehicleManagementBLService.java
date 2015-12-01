/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.DriverVO;
import vo.VehicleVO;
public interface DriverVehicleManagementBLService {
	
	/**
	 * 新增车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addVehicle(VehicleVO vo);
	
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg deleteVehicle(VehicleVO vo);
	
	/**
	 * 修改车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg modifyVehicle(VehicleVO vo);
	
	/**
	 * 新增司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addDriver(DriverVO vo);
	
	/**
	 * 删除司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg deleteDriver(DriverVO vo);
	
	/**
	 * 修改司机信息
	 * @param vo
	 * @return
	 */
	public ResultMsg modifyDriver(DriverVO vo);
	
	/**
	 * 关键字查询车辆信息
	 * @param vo 包含车辆信息关键词，若为null，则返回所有车辆信息
	 * @return
	 */
	public ArrayList<VehicleVO> findVehicle(VehicleVO vo);
	
	/**
	 * 关键字查询司机信息
	 * @param vo 包含司机信息关键词，若为null，则返回所有司机信息
	 * @return
	 */
	public ArrayList<DriverVO> findDriver(DriverVO vo);
	
}
