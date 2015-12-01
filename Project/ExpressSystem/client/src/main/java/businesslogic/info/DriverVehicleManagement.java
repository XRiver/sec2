package businesslogic.info;

import businesslogicservice.infoblservice.DriverVehicleManagementBLService;
import util.ResultMsg;
import vo.DriverVO;
import vo.VehicleVO;

import java.util.ArrayList;

import po.DriverPO;
import po.VehiclePO;
import connection.RemoteObjectGetter;
import dataservice.infodataservice.DriverVehicleManagementDataService;

/**
 * Created by kylin on 15/11/17.
 */
public class DriverVehicleManagement implements DriverVehicleManagementBLService {
	
	DriverVehicleManagementDataService dataService = null;
	
	public DriverVehicleManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (DriverVehicleManagementDataService) getter.getObjectByName("DriverVehicleManagementDataService");
	}
	
    @Override
    public ResultMsg addVehicle(VehicleVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.addVehicle((VehiclePO)vo.toPO());
        	if(!b) return new ResultMsg(false,"添加车辆失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg deleteVehicle(VehicleVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.removeVehicle((VehiclePO)vo.toPO());
        	if(!b) return new ResultMsg(false,"删除车辆失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg modifyVehicle(VehicleVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.modifyVehicle((VehiclePO)vo.toPO());
        	if(!b) return new ResultMsg(false,"删除车辆失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg addDriver(DriverVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.addDriver((DriverPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"添加司机失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg deleteDriver(DriverVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.removeDriver((DriverPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"删除司机信息失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ResultMsg modifyDriver(DriverVO vo) {
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.modifyDriver((DriverPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"修改司机信息失败，请重试");
        } catch (Exception e) {
        	return new ResultMsg(false, e.getMessage());
        }
        
        return new ResultMsg(true);
    }

    @Override
    public ArrayList<VehicleVO> findVehicle(VehicleVO vo) {
    	ArrayList<VehicleVO> result = new ArrayList<>();
    	ArrayList<VehiclePO> get = null;
    	
    	try {
    		if(vo==null){
    			get = dataService.getAllVehicles();
    		}else{
    			get = dataService.inquireVehicle((VehiclePO) vo.toPO());
    		}
    	} catch (Exception e) {
    		System.err.println("获取车辆信息失败：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(VehiclePO po:get) {
    		result.add((VehicleVO) po.toVO());
    	}
    	
    	return result;
    }

    @Override
    public ArrayList<DriverVO> findDriver(DriverVO vo) {
        ArrayList<DriverVO> result = new ArrayList<>();
        ArrayList<DriverPO> get = null;
        
        try {
        	if(vo==null) {
        		get = dataService.getAllDriver();
        	} else {
        		get = dataService.inquireDriver((DriverPO) vo.toPO());
        	}
        } catch (Exception e) {
    		System.err.println("获取司机信息失败：");
    		System.err.println(e.getMessage());
    		return result;
        }
        
        for(DriverPO po:get) {
        	result.add((DriverVO) po.toVO());
        }
        
        return result;
    }
}
