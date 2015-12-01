/**
 * 货物库存信息
 * @author wwz
 * @data 2015/10/20
 */
package vo;

import po.CommodityGoodsPO;
import util.FormatCheck;
import util.ResultMsg;

public class CommodityGoodsVO {
	
	/**
	 * 条形码
	 */
	private String barcode;
	
	/**
	 * 区号
	 */
	private String areacode;
	
	/**
	 * 目的地
	 */
	private String destination;
	
	/**
	 * 排号
	 */
	private String rownumber;
	
	/**
	 * 架号
	 */
	private String framenumber;
	/**
	 * 位号
	 */
	private String placenumber;
	
	/**
	 * 构造函数
	 * @param barcode
	 * @param areacode
	 * @param destination
	 * @param rownumber
	 * @param framenumber
	 * @param placenumber
	 */
	public CommodityGoodsVO(String barcode,String areacode,String destination,String rownumber,String framenumber,String placenumber){
		this.barcode = barcode;
		this.destination = destination;
		this.areacode = areacode;
		this.rownumber = rownumber;
		this.framenumber = framenumber;
		this.placenumber= placenumber;
	}

	public String getBarcode() {
		return barcode;
	}

	public String getAreacode() {
		return areacode;
	}

	public String getDestination() {
		return destination;
	}

	public String getRownumber() {
		return rownumber;
	}

	public String getFramenumber() {
		return framenumber;
	}

	public String getPlacenumber() {
		return placenumber;
	}
	
	public ResultMsg checkFormat() {
		
		ResultMsg[] msgs = new ResultMsg[6];

		msgs[0] = FormatCheck.isBarcode(barcode);
		msgs[1] = FormatCheck.isOrganizationName(destination);
		msgs[2] = FormatCheck.isAreaCode(areacode);
		msgs[3] = FormatCheck.isStorageDistrictNumber(framenumber);
		msgs[4] = FormatCheck.isStorageDistrictNumber(placenumber);
		msgs[5] = FormatCheck.isStorageDistrictNumber(rownumber);
		
		for(int i=0;i<msgs.length;i++) {
			if(!msgs[i].isPass()) {
				return msgs[i];
			}
		}
		
		return new ResultMsg(true);
		
	}

	public Object toPO() {
		return new CommodityGoodsPO(barcode, areacode, destination, rownumber, framenumber, placenumber);
	}
}
