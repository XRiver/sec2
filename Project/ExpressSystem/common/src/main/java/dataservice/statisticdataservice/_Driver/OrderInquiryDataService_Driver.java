package dataservice.statisticdataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.sql.SQLException;

import dataservice.statisticdataservice.OrderInquiryDataService;
import dataservice.statisticdataservice._Stub.OrderInquiryDataService_Stub;
import dataservice.exception.ElementNotFoundException;

public class OrderInquiryDataService_Driver {
	public void drive(OrderInquiryDataService OIDataService) throws RemoteException, ElementNotFoundException, SQLException {
		OIDataService.findOrder("123567890");
	}
   
	public static void main(String[] args) throws RemoteException, ElementNotFoundException, SQLException {
		OrderInquiryDataService_Stub stub = new OrderInquiryDataService_Stub();
		OrderInquiryDataService_Driver driver = new OrderInquiryDataService_Driver();
		driver.drive(stub);
	}
	
	

}
