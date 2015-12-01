package data.statisticdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.statisticdata.MockObject.MockLogEntry;
import dataservice.statisticdataservice.LogInquiryDataService;

public class LogInquiry_Test {

    private LogInquiryDataService service = new LogInquiryData();

    @Test
	public void testfind() throws RemoteException{
		MockLogEntry logEntry1 = new MockLogEntry("2015-11-11","中转中心业务员王小二录入南京中转中心装车单");
		MockLogEntry logEntry2 = new MockLogEntry("2015-11-11","中转中心业务员王小三录入南京中转中心装车单");
		MockLogEntry logEntry3 = new MockLogEntry("2015-11-11","中转中心业务员王小四南京中转中心到达单");
		ArrayList<String> keyword = new ArrayList<String>();
		keyword.add("中转中心装车单");
		ArrayList<MockLogEntry> log1 = new ArrayList<MockLogEntry>();
		log1.add(logEntry1);
		log1.add(logEntry2);
		log1.add(logEntry3);
		ArrayList<MockLogEntry> log2 = new ArrayList<MockLogEntry>();
		log2.add(logEntry1);
		log2.add(logEntry2);
		//assertEquals(true,log1.equals(service.findLogEntries("2015-11-11", null)));
		//assertEquals(true,log2.equals(service.findLogEntries(null, keyword)));
		//assertEquals(true,log1.equals(service.findLogEntries("2015-11-11", keyword)));
	}



}
