package data.logisticdata.deliverystrategy;

import data.statisticdata.BusinessDataModificationData;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 15/11/30.
 */
public class PriceStrategy {

    private BusinessDataModificationDataService businessDataModificationData = new BusinessDataModificationData();

    public double getPrice(String city1,String city2,double weight,double volume,
                           DeliverCategory category,double packagePrice) throws ElementNotFoundException, RemoteException, SQLException {
        double price;
        //获取总价
        double distance = businessDataModificationData.getDistance(city1, city2);
        double pricePerKG = distance / 1000 * 23;
        double weightPrice = pricePerKG * weight;
        if (weight / volume< 0.01) {
            double volumeWeight = volume / 5000;
            double volumePrice = pricePerKG * volumeWeight;
            weightPrice = volumePrice > weightPrice ? volumePrice : weightPrice;
        }
        if (category == DeliverCategory.ECNOMIC)
            weightPrice = weightPrice * 18 / 23;
        else if (category == DeliverCategory.EXPRESS)
            weightPrice = weightPrice * 25 / 23;
        price = weightPrice + packagePrice;
        return price;
    }
}
