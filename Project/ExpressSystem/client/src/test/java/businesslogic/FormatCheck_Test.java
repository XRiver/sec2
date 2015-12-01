package businesslogic;

import util.FormatCheck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck_Test {

//    @Test
    public void testBarcode(){
        assertEquals(true, FormatCheck.isBarcode("0123456789"));
        assertEquals(true, FormatCheck.isBarcode("0123412589"));
        assertEquals(false, FormatCheck.isBarcode("012a456789"));
        assertEquals(false, FormatCheck.isBarcode(""));
        assertEquals(false, FormatCheck.isBarcode("asdsadfasd"));
        assertEquals(false, FormatCheck.isBarcode("啊啊是打算等我"));
    }

//    @Test
    public void testDate(){
        assertEquals(true, FormatCheck.isDate("2018-1-24"));
        assertEquals(true, FormatCheck.isDate("2015-12-24"));
        assertEquals(true, FormatCheck.isDate("1996-6-1"));
        assertEquals(false, FormatCheck.isDate("2015 12 05"));
        assertEquals(false, FormatCheck.isDate("20151205"));
        assertEquals(false, FormatCheck.isDate("1996-0712"));
        assertEquals(false, FormatCheck.isDate("960612"));
        assertEquals(false, FormatCheck.isDate("2014 9 3"));
    }

//    @Test
    public void testInventoryTime(){
        assertEquals(true, FormatCheck.isInventoryTime("2015-09-26 10:30"));
        assertEquals(true, FormatCheck.isInventoryTime("2015-9-26 10:30"));
        assertEquals(true, FormatCheck.isInventoryTime("2015-10-1 10:30"));
        assertEquals(false, FormatCheck.isInventoryTime("2015-10-01-10:30"));
        assertEquals(false, FormatCheck.isInventoryTime("2015 10 01 10:30"));
        assertEquals(false, FormatCheck.isInventoryTime("2015-10-01  10:30"));
        assertEquals(false, FormatCheck.isInventoryTime("2015-10-01 10 30"));
        assertEquals(false, FormatCheck.isInventoryTime("20151001 10:30"));
    }

//    @Test
    public void testChineseName(){
        assertEquals(true, FormatCheck.isChineseName("王二狗"));
        assertEquals(true, FormatCheck.isChineseName("拉啊空间十啊实打实"));
        assertEquals(true, FormatCheck.isChineseName("端木雪莹"));
        assertEquals(false, FormatCheck.isChineseName("王二狗x"));
        assertEquals(false, FormatCheck.isChineseName("王二 狗"));
        assertEquals(false, FormatCheck.isChineseName(" 王二狗"));
        assertEquals(false, FormatCheck.isChineseName("王x二狗"));
        assertEquals(false, FormatCheck.isChineseName("asdw王sad"));
    }

//    @Test
    public void testPhoneNumber(){
        assertEquals(true, FormatCheck.isPhoneNumber("18795853010"));
        assertEquals(true, FormatCheck.isPhoneNumber("+8611233451234"));
        assertEquals(true, FormatCheck.isPhoneNumber("19958530110"));
        assertEquals(false, FormatCheck.isPhoneNumber("28795853010"));
        assertEquals(false, FormatCheck.isPhoneNumber("387958 3010"));
        assertEquals(false, FormatCheck.isPhoneNumber(" 18795 853010"));
        assertEquals(false, FormatCheck.isPhoneNumber("1879-5853010"));
        assertEquals(false, FormatCheck.isPhoneNumber("+18795853010"));
    }

//    @Test
    public void testFixedPhoneNumber(){
        assertEquals(true, FormatCheck.isFixedPhoneNumber("0250-66778899"));
        assertEquals(true, FormatCheck.isFixedPhoneNumber("0516-89578899"));
        assertEquals(false, FormatCheck.isFixedPhoneNumber("025066778899"));
        assertEquals(false, FormatCheck.isFixedPhoneNumber("0250 66778899"));
        assertEquals(false, FormatCheck.isFixedPhoneNumber("+0250-66778899"));
        assertEquals(false, FormatCheck.isFixedPhoneNumber("+0250"));
    }

//    @Test
    public void testServiceHallNumber(){
        assertEquals(true, FormatCheck.isServiceHallNumber("0251000"));
        assertEquals(true, FormatCheck.isServiceHallNumber("0251001"));
        assertEquals(false, FormatCheck.isServiceHallNumber("02510002"));
        assertEquals(false, FormatCheck.isServiceHallNumber(" "));
        assertEquals(false, FormatCheck.isServiceHallNumber(" 0251000"));
        assertEquals(false, FormatCheck.isServiceHallNumber("+025100 0"));
    }

//    @Test
    public void testCarNumber(){
        assertEquals(true, FormatCheck.isCarNumber("025001002"));
        assertEquals(true, FormatCheck.isCarNumber("025222002"));
        assertEquals(false, FormatCheck.isCarNumber(" 02510002"));
        assertEquals(false, FormatCheck.isCarNumber("025222002 "));
        assertEquals(false, FormatCheck.isCarNumber(" 0251000"));
        assertEquals(false, FormatCheck.isCarNumber(" 025100 0"));
    }

//    @Test
    public void testDriverNumber(){
        assertEquals(true, FormatCheck.isDriverNumber("025001002"));
        assertEquals(true, FormatCheck.isDriverNumber("025222002"));
        assertEquals(false, FormatCheck.isDriverNumber(" 02510002"));
        assertEquals(false, FormatCheck.isDriverNumber("025222002 "));
        assertEquals(false, FormatCheck.isDriverNumber(" 0251000"));
        assertEquals(false, FormatCheck.isDriverNumber(" 025100 0"));
    }

//    @Test
    public void testIDNumber(){
        assertEquals(true, FormatCheck.isIDNumber("320322199606120043"));
        assertEquals(true, FormatCheck.isIDNumber("32032219960612004x"));
        assertEquals(false, FormatCheck.isIDNumber(" 320322199606120043"));
        assertEquals(false, FormatCheck.isIDNumber("320322199606120043 "));
        assertEquals(false, FormatCheck.isIDNumber("3203221996061200x3"));
        assertEquals(false, FormatCheck.isIDNumber("0320322199606120043"));
    }

//    @Test
    public void testCenterNumber(){
        assertEquals(true, FormatCheck.isCenterNumber("025001"));
        assertEquals(true, FormatCheck.isCenterNumber("025006"));
        assertEquals(false, FormatCheck.isCenterNumber(" 025001"));
        assertEquals(false, FormatCheck.isCenterNumber("025001 "));
        assertEquals(false, FormatCheck.isCenterNumber("025x001"));
        assertEquals(false, FormatCheck.isCenterNumber("01225001"));
    }
    
    @Test
    public void testIsBaseData(){
        assertEquals(true, FormatCheck.isBaseData("213").isPass());
        assertEquals(true, FormatCheck.isBaseData("213.2131").isPass());
        assertEquals(false, FormatCheck.isBaseData("-025001").isPass());
        assertEquals(false, FormatCheck.isBaseData("123.123.1").isPass());
        assertEquals(false, FormatCheck.isBaseData("-123.213").isPass());
        assertEquals(false, FormatCheck.isBaseData("00.123").isPass());
    }
    
}
