package dataservice.statisticdataservice._Driver;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.sql.SQLException;

import dataservice.statisticdataservice.BusinessDataModificationDataService;
import dataservice.statisticdataservice._Stub.BusinessDataModificationDataService_Stub;
import po.DistancePO;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BusinessDataModificationDataService_Driver {
	private DistancePO distancePO;
	
	public BusinessDataModificationDataService_Driver() {
	distancePO = new DistancePO("上海","南京",1000000.0);
	}

    public void drive(BusinessDataModificationDataService businessDataService) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException, SQLException {
        businessDataService.addCity("");
		businessDataService.setDistance(distancePO);
		businessDataService.setPrice(null, 0);
		businessDataService.getAllCities();
        businessDataService.getDistance("nanjing", "beijing");
        if(businessDataService.addCity(""))
			System.out.println("success");
		else
			System.out.println("fail");
		if(businessDataService.setPrice(null, 0))
			System.out.println("success");
		else
			System.out.println("fail");
	}

    public static void main(String[] args) throws RemoteException, InterruptWithExistedElementException, ElementNotFoundException, SQLException {
        BusinessDataModificationDataService_Stub stub = new BusinessDataModificationDataService_Stub();
		BusinessDataModificationDataService_Driver driver = new BusinessDataModificationDataService_Driver();
		driver.drive(stub);
	}

}
