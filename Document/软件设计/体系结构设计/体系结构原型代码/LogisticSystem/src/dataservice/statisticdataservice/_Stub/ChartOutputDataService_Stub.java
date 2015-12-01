package dataservice.statisticdataservice._Stub;
/**
 * @author wwz
 * @data 2015-10-22
 */
import java.rmi.RemoteException;

import dataservice.statisticdataservice.ChartOutputDataService;
import po.ChartPO;

public class ChartOutputDataService_Stub implements ChartOutputDataService{

	@Override
	public ChartPO getChart(ChartPO info) throws RemoteException {
		System.out.println("get chart success");
		return null;
	}
   
}
