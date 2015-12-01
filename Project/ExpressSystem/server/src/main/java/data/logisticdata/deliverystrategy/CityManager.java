package data.logisticdata.deliverystrategy;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/30.
 */
public class CityManager {

    public String findCity(ArrayList<String> citys, String senderAddress) {
        for (String regex : citys) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(senderAddress);
            if (matcher.find())
                return regex;
        }
        return null;
    }
}
