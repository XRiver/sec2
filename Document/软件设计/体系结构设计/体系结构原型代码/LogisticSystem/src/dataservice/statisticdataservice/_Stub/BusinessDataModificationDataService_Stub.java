package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.util.PriceType;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import po.DistancePO;

public class BusinessDataModificationDataService_Stub implements BusinessDataModificationDataService{

	

	@Override
	public boolean addCity(String name) throws RemoteException, InterruptWithExistedElementException {
		System.out.println("added city");
		return false;
	}

	@Override
	public ArrayList<String> getAllCities() throws RemoteException {
		System.out.println("returning cities");
		return null;
	}

	@Override
	public void setDistance(DistancePO distancePO) {
		System.out.println("set distance");
	}

	@Override
	public void getDistance(DistancePO distancePO) {		
		System.out.println("got distance");
	}

	@Override
	public boolean setPrice(PriceType name, double newValue)
			throws RemoteException, ElementNotFoundException {
		System.out.println("set price");
		return false;
	}

	@Override
	public double getPrice(PriceType name) throws RemoteException,
			ElementNotFoundException {
		System.out.println("got price");
		return 0;
	}



	

}
