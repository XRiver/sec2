package util;

/**
 * Created by kylin on 15/11/25.
 */
public class BarcodesAndLocation {

    /**
     * 条形码号
     */
    private String barcode;

    /**
     * 仓库区号
     */
    private int section;

    /**
     * 仓库排号
     */
    private int line;

    /**
     * 仓库架号
     */
    private int row;

    /**
     * 仓库位号
     */
    private int number;

    public BarcodesAndLocation(String barcode, int section, int line, int row, int number) {
        this.barcode = barcode;
        this.section = section;
        this.line = line;
        this.row = row;
        this.number = number;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getSection() {
        return section;
    }

    public int getLine() {
        return line;
    }

    public int getRow() {
        return row;
    }

    public int getNumber() {
        return number;
    }
}
