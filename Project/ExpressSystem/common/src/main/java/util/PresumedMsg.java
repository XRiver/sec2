package util;

/**
 * Created by kylin on 15/11/19.
 */
public class PresumedMsg {

    /**
     * 根据出发地到达地而自动生成的运费
     */
    double price;

    /**
     * 预计到达日期
     */
    String date;

    public PresumedMsg(double price, String date) {
        this.price = price;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }
}
