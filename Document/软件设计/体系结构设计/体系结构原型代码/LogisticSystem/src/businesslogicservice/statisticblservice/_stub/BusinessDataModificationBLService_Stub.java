package businesslogicservice.statisticblservice._stub;

import businesslogic.util.PriceType;
import businesslogic.util.ResultMsg;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;


public class BusinessDataModificationBLService_Stub implements BusinessDataModificationBLService {

    @Override
	public ResultMsg inputCityDistance(String city1,String city2,double distance){
		System.out.println("inputed distance");
		return new ResultMsg(true,"Success!");
	};

    @Override
	public void submitChange(){
		System.out.println("submitted changes");
	};

	@Override
	public ResultMsg inputPrice(PriceType type, double price) {
        System.out.println("inputPrice succeed");
		return new ResultMsg(true,"Success!");
	}
}
