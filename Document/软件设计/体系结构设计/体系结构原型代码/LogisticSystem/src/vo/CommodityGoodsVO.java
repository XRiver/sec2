/**
 * 货物库存信息
 * @author wwz
 * @data 2015/10/20
 */
package vo;

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
	private int rownumber;
	
	/**
	 * 架号
	 */
	private int framenumber;
	/**
	 * 位号
	 */
	private int placenumber;
	
	/**
	 * 构造函数
	 * @param barcode
	 * @param areacode
	 * @param destination
	 * @param rownumber
	 * @param framenumber
	 * @param placenumber
	 */
	public CommodityGoodsVO(String barcode,String areacode,String destination,int rownumber,int framenumber,int placenumber){
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

	public int getRownumber() {
		return rownumber;
	}

	public int getFramenumber() {
		return framenumber;
	}

	public int getPlacenumber() {
		return placenumber;
	}

}
