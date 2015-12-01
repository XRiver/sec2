package vo;

import util.FormatCheck;
import po.DeliveryNotePO;
import util.ResultMsg;
import util.enums.DeliverCategory;

/**
 * 寄件单VO
 * 
 * @author kylin
 *
 */
public class DeliveryNoteVO extends NoteVO {

    /**
     * 客户(寄件人)姓名
     */
    private String senderName;

    /**
     * 客户(寄件人)地址
     */
    private String senderAddress;

    /**
     * 客户(寄件人)电话（手机）号码
     */
    private String senderTeleNumber;

    /**
     * 收件人姓名
     */
    private String receiverName;

    /**
     * 收件人地址
     */
    private String receiverAddress;

    /**
     * 收件人电话（手机）号码
     */
    private String receiverTeleNumber;

    /**
     * 货物内件品名
     */
    private String name;

    /**
     * 寄件件数
     */
    private int goodsNumber;

    /**
     * 货物实际重量
     */
    private double weight;

    /**
     * 货物体积
     */
    private double volume;

    /**
     * 快递种类
     */
    private DeliverCategory category;

    /**
     * 包装费用
     */
    private double packPrice;

    /**
     * 货物条形码(唯一标示符)
     */
    private String barCode;

    public DeliveryNoteVO(String senderName, String senderAddress, String senderTeleNumber,
                          String receiverName, String receiverAddress, String receiverTeleNumber,
                          String name, int goodsNumber, double weight, double volume,
                          DeliverCategory category, double packPrice, String barCode) {
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.senderTeleNumber = senderTeleNumber;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverTeleNumber = receiverTeleNumber;
        this.name = name;
        this.goodsNumber = goodsNumber;
        this.weight = weight;
        this.volume = volume;
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

    public String getSenderTeleNumber() {
        return senderTeleNumber;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getReceiverTeleNumber() {
        return receiverTeleNumber;
    }

    public String getName() {
        return name;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }

    public DeliverCategory getCategory() {
        return category;
    }

    public double getPackPrice() {
        return packPrice;
    }

    public String getBarCode() {
        return barCode;
    }

    public DeliveryNotePO toPO(){
        return new DeliveryNotePO(this.senderName, this.senderAddress, this.senderTeleNumber, this.receiverName,
        this.receiverAddress, this.receiverTeleNumber, this.name, this.goodsNumber, this.weight,
        this.volume, this.category, this.packPrice, this.barCode);
    }

    public ResultMsg checkFormat(){
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[13];
        results[0] = FormatCheck.isChineseName(this.senderName);
        results[1] = FormatCheck.isCity(this.senderAddress);
        results[2] = FormatCheck.isPhoneNumber(this.senderTeleNumber);
        results[3] = FormatCheck.isChineseName(this.receiverName);
        results[4] = FormatCheck.isCity(this.receiverAddress);
        results[5] = FormatCheck.isPhoneNumber(this.receiverTeleNumber);
        results[6] = new ResultMsg(true);
        results[8] = new ResultMsg(goodsNumber>0);
        results[9] = new ResultMsg(weight>0);
        results[10] = new ResultMsg(volume>0);
        results[11] = new ResultMsg(packPrice>0);
        results[12] = FormatCheck.isBarcode(this.barCode);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass())
                return results[i];
        }
        return result;
    }
}
