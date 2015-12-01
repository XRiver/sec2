/**
 * 入库单信息VO类
 * @author wwz
 * @data 2015/10/17
 */
package vo;

import java.util.ArrayList;
import java.util.Iterator;

import po.CommodityGoodsPO;
import po.StorageInPO;
import util.FormatCheck;
import util.ResultMsg;

public class StorageInVO {
	
    /**
     * 日期
     */
	private String date;
	
	/**
	 * 货物信息，包括条形码及其位置信息
	 */
	private ArrayList<CommodityGoodsVO> GoodsInStorageInfo;
	
	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageInVO(String date,ArrayList<CommodityGoodsVO> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<CommodityGoodsVO> getGoodsInStorageInfo() {
		return GoodsInStorageInfo;
	}
	
	public ResultMsg checkFormat(){
		
		ResultMsg msg = FormatCheck.isDate(date);
		if(!msg.isPass()) return msg;
		
		Iterator<CommodityGoodsVO> it = GoodsInStorageInfo.iterator();
		while(it.hasNext()) {
			msg = it.next().checkFormat();
			if(!msg.isPass()) return msg;
		}
		
		return new ResultMsg(true);
	}
	
	public Object toPO(){
		
		ArrayList<CommodityGoodsPO> list = new ArrayList<>();
		Iterator<CommodityGoodsVO> it = GoodsInStorageInfo.iterator();
		
		while(it.hasNext()) {
			list.add((CommodityGoodsPO) it.next().toPO());
		}
		
		StorageInPO po = new StorageInPO(date, list);
		return po;
	}
	
}
