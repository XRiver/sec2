package data.logisticdata.deliverystrategy;

import data.statisticdata.BusinessDataModificationData;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;
import util.enums.DeliverCategory;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kylin on 15/11/30.
 */
public class TimePresumeStrategy {

    private BusinessDataModificationDataService businessDataModificationData = new BusinessDataModificationData();

    public String getPresumedTime(String city1,String city2, DeliverCategory category) throws ElementNotFoundException, RemoteException, SQLException {
        double distance = businessDataModificationData.getDistance(city1,city2);
        // new Date()为获取当前系统时间
        Date startDay = new Date();

        //业务核心逻辑
        double time = distance/300 * 60 * 60 * 1000;
        if (category == DeliverCategory.EXPRESS)
            time = time/2;
        else if (category == DeliverCategory.ECNOMIC)
            time = time*1.5;

        long longTime = (long) time;
        Date arrivalDay = new Date((startDay.getTime()+longTime));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDay = dateFormat.format(arrivalDay);
        return strDay;
    }
}
