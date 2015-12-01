package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.statisticdataservice.LogInquiryDataService;
import po.LogEntryPO;

public class LogInquiryDataService_Stub implements LogInquiryDataService {

	 
	public ArrayList<LogEntryPO> findLogEntries(String time,
			ArrayList<String> keyword) throws RemoteException {
		System.out.println("success");
		return null;
	}

}
