package util;

import util.enums.GoodsState;

public class BarcodeAndState {

	private String barcode;
	
	private GoodsState state;

	public String getBarcode() {
		return barcode;
	}

	public GoodsState getState() {
		return state;
	}

	public BarcodeAndState(String barcode, GoodsState state) {
		super();
		this.barcode = barcode;
		this.state = state;
	}
	
}
