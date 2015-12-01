package data.infodata.MockObject;

import java.math.BigDecimal;

import po.BankAccountPO;

public class MockBankAccountManagement extends BankAccountPO{
String name;
public MockBankAccountManagement(String name){
    super();
	this.name=name;
}
public String getName() {
	return name;
}
	
}
