/**
 * 
 * @author wwz
 * @date 2015/10/17
 */
package businesslogicservice.infoblservice;

import java.util.ArrayList;

import vo.DriverVO;
import vo.VehicleInfoVO;
import businesslogic.util.ResultMsg;
public interface DriverVehicleManagementBLService {
	
	/**
	 * 新增车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg addVehicle(VehicleInfoVO vo);
	
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg deleteVehicle(VehicleInfoVO vo);
	
	/**
	 * 修改车辆信息
	 * @param vo
	 * @return
	 */
	public ResultMsg modifyVehicle(VehicleInfoVO vo);
	
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
	 * @param keyword
	 * @return
	 */
	public ArrayList<VehicleInfoVO> findVehicle(VehicleInfoVO vo);
	
	/**
	 * 关键字查询司机信息
	 * @param keyword
	 * @return
	 */
	public ArrayList<DriverVO> findDriver(DriverVO vo);
	
}
