/**
 * 入库单信息PO类
 * @author WQY
 * @data 2015/10/17
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;

public class StorageInPO implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 3860679131224751298L;

	/**
     * 日期
     */
	private String date;
	
	/**
	 * 货物信息，包括条形码及其位置信息
	 */
	private ArrayList<CommodityGoodsPO> GoodsInStorageInfo;
	
	/**
	 * 构造方法
	 * @param date
	 * @param GoodsInStorageInfo
	 */
	public StorageInPO(String date,ArrayList<CommodityGoodsPO> GoodsInStorageInfo){
		this.date = date;
		this.GoodsInStorageInfo = GoodsInStorageInfo;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<CommodityGoodsPO> getGoodsInStorageInfo() {
		return GoodsInStorageInfo;
	}


    
}







