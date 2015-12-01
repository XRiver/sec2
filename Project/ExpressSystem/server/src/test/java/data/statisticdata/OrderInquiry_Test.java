package data.statisticdata;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import data.statisticdata.MockObject.MockOrderInquiry;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.OrderInquiryDataService;
import po.OrderPO;
import util.enums.GoodsState;

public class OrderInquiry_Test {
	private OrderInquiryData service = new OrderInquiryData();

//	@Test
	public void testfinder() throws RemoteException,
	ElementNotFoundException {
		ArrayList<String> history = new ArrayList<String>();
		history.add("六合营业厅");
		history.add("南京中转中心");
		history.add("鼓楼营业厅");
		//MockOrderInquiry order = new MockOrderInquiry("1234567890","完好",history);
        //assertEquals("1234567890",service.findOrder(order.getBarcode()).getBarcode());
	    //assertEquals("完好",service.findOrder(order.getBarcode()).getStateOfTransport());
	    //assertEquals(true,history.equals(service.findOrder(order.getBarcode()).getHistory()));
	}

	
    @Test
    public void testUpdate() throws ElementNotFoundException, RemoteException, SQLException {
    }


    @Test
    public void testFind() throws ElementNotFoundException, RemoteException, SQLException {
        OrderPO po = service.findOrder("123456789");
        ArrayList<String> strings = po.getHistory();
        for(String s:strings){
            System.out.println(s);
        }
    }
}
