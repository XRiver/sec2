/**
 * 输入寄件单
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

public class DeliveryNoteInputPO implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3326557217189374031L;

/**
 * 客户姓名
 */
private String senderName;

/**
 * 客户地址
 */
private String senderAddress;

/**
 * 客户单位地址
 */
private String senderWorkPlace;

/**
 * 客户电话（手机）号码
 */
private String senderTeleNumber;

/**
 * 寄件件数
 */
private String number;

/**
 * 货物实际重量
 */
private double weight;

/**
 * 货物体积
 */
private double volume;

/**
 * 货物内件品名
 */
private String name;

/**
 * 快递种类
 */
private String category;

/**
 * 包装费用
 */
private double packPrice;

/**
 * 货物条形码
 */
private String barCode;

public DeliveryNoteInputPO(String senderName, String senderAddress, String senderWorkPlace, String senderTeleNumber,
		String number, double weight, double volume, String name, String category, double packPrice,
		String barCode) {
	super();
	this.senderName = senderName;
	this.senderAddress = senderAddress;
	this.senderWorkPlace = senderWorkPlace;
	this.senderTeleNumber = senderTeleNumber;
	this.number = number;
	this.weight = weight;
	this.volume = volume;
	this.name = name;
	this.category = category;
	this.packPrice = packPrice;
	this.barCode = barCode;
}

public String getSenderName() {
	return senderName;
}

public String getSenderAddress() {
	return senderAddress;
}

public String getSenderWorkPlace() {
	return senderWorkPlace;
}

public String getSenderTeleNumber() {
	return senderTeleNumber;
}

public String getNumber() {
	return number;
}

public double getWeight() {
	return weight;
}

public double getVolume() {
	return volume;
}

public String getName() {
	return name;
}

public String getCategory() {
	return category;
}

public double getPackPrice() {
	return packPrice;
}

public String getBarCode() {
	return barCode;
}

public void setSenderName(String senderName) {
	this.senderName = senderName;
}

public void setSenderAddress(String senderAddress) {
	this.senderAddress = senderAddress;
}

public void setSenderWorkPlace(String senderWorkPlace) {
	this.senderWorkPlace = senderWorkPlace;
}

public void setSenderTeleNumber(String senderTeleNumber) {
	this.senderTeleNumber = senderTeleNumber;
}

public void setNumber(String number) {
	this.number = number;
}

public void setWeight(double weight) {
	this.weight = weight;
}

public void setVolume(double volume) {
	this.volume = volume;
}

public void setName(String name) {
	this.name = name;
}

public void setCategory(String category) {
	this.category = category;
}

public void setPackPrice(double packPrice) {
	this.packPrice = packPrice;
}

public void setBarCode(String barCode) {
	this.barCode = barCode;
}

}