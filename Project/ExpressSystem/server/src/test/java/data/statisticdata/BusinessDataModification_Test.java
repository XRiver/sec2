package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.statisticdataservice.BusinessDataModificationDataService;
import org.junit.Test;

import po.DistancePO;
import util.enums.PriceType;
import data.statisticdata.MockObject.MockDistance;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BusinessDataModification_Test {
	
	private BusinessDataModificationDataService service = new BusinessDataModificationData();


//    @Test
    public void testAddCity() throws RemoteException, ElementNotFoundException, SQLException, InterruptWithExistedElementException {
        service.addCity("香港");
    }

//    @Test
    public void testGetAllCity() throws RemoteException, SQLException {
	     ArrayList<String> city = new ArrayList<String>();
            city = service.getAllCities();
            for (String str:city) {
                System.out.println(str);
            }
        }

    //    @Test
    public void testSetandGetPrice() throws RemoteException, ElementNotFoundException, SQLException {
//		service.setPrice(PriceType.Bag, 1.0);
        System.out.println(service.getPrice(PriceType.PricePerKg));
        System.out.println(service.getPrice(PriceType.Bag));
        System.out.println(service.getPrice(PriceType.PaperBox));
        System.out.println(service.getPrice(PriceType.WoodenBox));
    }

    @Test
    public void testSetDistance() throws RemoteException, ElementNotFoundException, SQLException {
        service.setDistance(new DistancePO("北京","香港",333));
    }

//    @Test
    public void testGetDistance() throws RemoteException, ElementNotFoundException, SQLException {
        double distance = service.getDistance("上海","123");
        System.out.println(distance);
    }

}
