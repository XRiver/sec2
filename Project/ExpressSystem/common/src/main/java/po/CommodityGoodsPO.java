/**
 * 货物库存信息
 * @author WQY
 * @data 2015/10/27
 */
package po;

import java.io.Serializable;

import vo.CommodityGoodsVO;

public class CommodityGoodsPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5422402328899845439L;

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
	public CommodityGoodsPO(String barcode,String areacode,String destination,String rownumber,String framenumber,String placenumber){
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

	public Object toVO() {
		CommodityGoodsVO vo = new CommodityGoodsVO(barcode, areacode, destination, rownumber, framenumber, placenumber);
		return vo;
	}

}

