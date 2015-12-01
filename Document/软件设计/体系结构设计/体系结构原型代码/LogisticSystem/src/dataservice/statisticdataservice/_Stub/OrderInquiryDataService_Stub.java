package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015/10/22
 *
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import dataservice.exception.ElementNotFoundException;

public class OrderInquiryDataService_Stub implements OrderInquiryDataService {

	@Override
	public OrderPO findOrder(String barcode) throws RemoteException,
			ElementNotFoundException {
		System.out.println("find order success");
		return null;
	}

}
