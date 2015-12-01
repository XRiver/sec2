package businesslogic.commodity;

import util.FormatCheck;
import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import util.ResultMsg;
import vo.InventoryVO;

import java.util.ArrayList;

import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.InventoryDataService;

/**
 * Created by kylin on 15/11/17.
 * 
 * 问题：InventoryDataService没有提供输入第一次盘点时间的接口
 */
public class StorageInquiryAll implements StorageInquiryAllBLService {
	
	InventoryDataService dataService = null;
	
	/*
	 * 应该作为盘点起始时间的字符串，由inputFirst获得
	 */
	String lastTime = null;
	
	public StorageInquiryAll() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (InventoryDataService) getter.getObjectByName("InventoryDataService");
	}
	
    @Override
    public ResultMsg inputFirst(String firstTime) {
    	//TODO 要先修改数据层接口！
    	
        ResultMsg msg = FormatCheck.isDate(firstTime);
        
        if(!msg.isPass()) {
        	return msg;
        }
        
        lastTime = firstTime;
        
        return new ResultMsg(true);
        
    }

    @Override
    public ArrayList<InventoryVO> request() {
    	
    	//TODO 要修改数据层接口：增加一个传入用户账户信息的参数
    	
        return null;
    }
}
