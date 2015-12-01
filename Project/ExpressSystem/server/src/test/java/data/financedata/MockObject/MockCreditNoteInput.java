package data.financedata.MockObject;

import java.math.BigDecimal;

import po.CreditNotePO;

public class MockCreditNoteInput extends CreditNotePO{
	String nameOfDeliveryMan;
	public MockCreditNoteInput(String nameOfDeliveryMan) {
		super();
        this.nameOfDeliveryMan=nameOfDeliveryMan;
	}

}
