package util;

import util.ResultMsg;

import java.util.regex.Pattern;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck {

    /**
     * 检查输入是否是合法的城市名称
     *
     * @param str
     * @return
     */
    public static ResultMsg isCity(String str) {
        String trueExpression = "^[\\u4e00-\\u9fa5]+$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"地点名称格式错误,应为合法汉字");
    }

    /**
     * 1检查输入是否是合法的订单条形码(10位0～9的数字)
     *
     * @param str
     * @return
     */
    public static ResultMsg isBarcode(String str) {
        String trueExpression = "\\d{10}$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"条形码格式错误,应为10位0～9的数字");
    }

    /**
     * 2检查输入是否是合法的日期,日期格式为“xxxx－xx－xx”,x是数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isDate(String str) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"日期格式错误,应为“xxxx－xx－xx”,x是数字");
    }

    /**
     * 3检查输入是否是合法的库存查看时间点
     * 库存查看时间点格式为“xxxx－xx－xx xx：xx”，如“2015-09-26 10:30”
     *
     * @param str
     * @return
     */
    public static ResultMsg isInventoryTime(String str) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"日期格式错误,应为“xxxx－xx－xx xx：xx”,x是数字");
    }

    /**
     * 4检查输入是否是合法的人员姓名,至少是两个合法汉字
     *
     * @param str
     * @return
     */
    public static ResultMsg isChineseName(String str) {
        String trueExpression = "^[\\u4e00-\\u9fa5]+$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"姓名格式错误,应为合法汉字");
    }

    /**
     * 5检查输入是否是合法的手机号码,11位数字(最前端可以加国家区号)
     *
     * @param str
     * @return
     */
    public static ResultMsg isPhoneNumber(String str) {
        String trueExpression = "(\\+\\d+)?1\\d{10}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"手机号码格式错误,应为11位数字(最前端可以是+号再加国家区号)");
    }

    /**
     * 6检查输入是否是合法的固定电话号码
     * 电话格式为“xxxx－xxxxxxxx”，即四位区号＋8位座机号，如“0250-66778899”。
     *
     * @param str
     * @return
     */
    public static ResultMsg isFixedPhoneNumber(String str) {
        String trueExpression = "\\d{4}-\\d{8}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"固定电话号码格式错误,应为四位区号＋8位座机号");
    }

    /**
     * 7检查输入是否是合法的营业厅编号
     * 营业厅编号格式为“025城市编码+1营业厅+000鼓楼营业厅”
     *
     * @param str
     * @return
     */
    public static ResultMsg isServiceHallNumber(String str) {
        String trueExpression = "\\d{3}1\\d{3}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅编号格式错误,应为7位数字:3位城市编码+1代表营业厅+3位营业厅编码");
    }

    /**
     * 7检查输入是否是合法的中转中心
     * 营业厅编号格式为“025城市编码+0中转中心+000鼓楼营业厅”
     *
     * @param str
     * @return
     */
    public static ResultMsg isTransitCenterNumber(String str) {
        String trueExpression = "\\d{3}0\\d{3}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"中转中心编号格式错误,应为7位数字:3位城市编码+0代表中转中心+3位营业厅编码");
    }
    
    /**
     * 7检查输入是否是合法的营业厅汽运编号
     * 营业厅汽运编号格式为“营业厅编号+20150921日期+00000编码五位数字”。
     *
     * @param str
     * @return
     */
    public static ResultMsg isServiceHallLoadNumber(String str) {
        String trueExpression = "\\d{3}1\\d{16}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅汽运编号格式错误,应为营业厅编号+8位日期+00000五位编码");
    }
    /**
     * 9检查输入是否是合法的车辆代号
     * 车辆代号格式为“城市编号（电话号码区号南京025）＋营业厅编号（000三位）＋000三位数字”
     *
     * @param str
     * @return
     */
    public static ResultMsg isCarNumber(String str) {
        String trueExpression = "\\d{9,10}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"车辆代号格式错误,应为城市编号(电话号码区号)＋三位营业厅编号＋三位数字");
    }

    /**
     * 10检查输入是否是合法的司机编号
     * 司机编号格式为“城市编号（电话号码区号南京025）＋营业厅编号（000 三位数字）＋000三位数字”
     *
     * @param str
     * @return
     */
    public static ResultMsg isDriverNumber(String str) {
        String trueExpression = "\\d{9,10}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"司机编号格式错误,应为城市编号(电话号码区号)＋三位营业厅编号＋三位数字");
    }

    /**
     * 11检查输入是否是合法的身份证号
     * 身份证号为18位0～9的数字，允许最后一位是‘x’
     *
     * @param str
     * @return
     */
    public static ResultMsg isIDNumber(String str) {
        String trueExpression = "\\d{17}(\\d|x|X)";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"身份证号格式错误,身份证号为18位0～9的数字，允许最后一位是‘x’");
    }

    /**
     * 12检查输入是否是合法的中转中心编号
     * 中转中心编号格式为“025城市编码+0代表中转中心+00鼓楼中转中心”
     *
     * @param str
     * @return
     */
    public static ResultMsg isCenterNumber(String str) {
        String trueExpression = "\\d{3}0\\d{2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"中转中心编号格式错误,3位城市编码+1代表营业厅+3位中转中心编码");
    }

    /**
     * 13检查输入是否是合法的中转中心汽运编号
     * 中转中心汽运编号“中转中心编号(6位)＋日期＋7位0～9的数字”，日期为形如“20151012”
     *
     * @param str
     * @return
     */
    public static ResultMsg isCenterLoadNumber(String str) {
        String trueExpression = "\\d{3}0\\d{2}\\d{15}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"中转中心汽运编号格式错误,应为中转中心编号(6位)＋日期＋7位0～9的数字");
    }

    /**
     * 14检查输入是否是合法的中转单编号
     * 中转单编号格式为“中转中心编号(6位)＋日期＋7位0～9的数字”
     *
     * @param str
     * @return
     */
    public static ResultMsg isTransitNoteNumber(String str) {
        String trueExpression = "\\d{3}0\\d{15}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"中转单编号格式错误,应为中转中心编号(6位)＋日期＋7位0～9的数字");
    }

    /**
     * 15检查输入是否是合法的基础账目数据
     * 基础账目数据必须位大于0的数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isBaseData(String str) {
        String trueExpression = "\\+?[1-9]+\\d*\\.?\\d*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"常量数值格式错误，应为正数");
    }

    /**
     * 17检查输入是否是合法的款项金额
     * 所有款项金额必须为正的数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isMoney(String str) {
        String trueExpression = "\\+?[1-9]+\\d*\\.?\\d*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"常量数值格式错误，应为正数");
    }

    /**
     * 18检查输入是否是合法的系统日志查询日期
     * 系统日志查询关键字位日期，格式位“xxxx-xx-xx”，如“2015-01-07”X代指0～9的数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isLogInquiryTime(String str) {
        if(str == null)
            return new ResultMsg(true);
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"系统日志查询日期格式错误,应为应为“xxxx－xx－xx”,x是数字");
    }

    /**
     * 检查输入是否为合法的工资数目，必须为正整数
     *
     * @param str
     * @return
     */
    public static ResultMsg isSalary(String str){
        String trueExpression = "\\+?[1-9]+\\d*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"工资格式错误，应为正整数");
    }

    /**
     * 检查输入的常量数值是否为正数
     *
     * @param str
     * @return
     */
    public static ResultMsg isConstants(String str) {
        String trueExpression = "\\+?[1-9]+\\d*\\.?\\d{0,}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"常量数值格式错误，应为正数");
    }

    /**
     * 检查银行账号格式，应为10位数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isBankAccount(String str) {
        String trueExpression = "\\d{10}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"银行账号格式错误，应为10位数字");
    }

    /**
     * 检查账号密码格式，必须为6~10位数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isPassword(String str) {
        String trueExpression = "\\d{6,10}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"账号密码号格式错误，应为6~10位数字");
    }

    /**
     * 检查货物数目格式，必须为正数
     *
     * @param str
     * @return
     */
    public static ResultMsg isQuantity(String str) {
        String trueExpression = "\\+?[1-9]+\\d*\\.?\\d{0,}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"货物数目格式错误，应为正数");
    }

    /**
     * 检查车辆使用年份格式是否正确，应为正整数
     *
     * @param str
     * @return
     */
    public static ResultMsg isYearsUsed(String str) {
        String trueExpression = "\\+?[1-9]+\\d*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"工资格式错误，应为正整数");
    }

    /**
     * 检查是否为车牌号：一个汉字+字母+空格+5位数字或大写字母混合
     * （把省份缩写全写出来挺麻烦的，就当汉字都行）
     *
     * @param str
     * @return
     */
    public static ResultMsg isPlateNumber(String str) {
        String trueExpression = "[\\u4e00-\\u9fa5][A-Z]\\s[0-9A-Z]{5}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"车牌号格式错误，应为省份缩写+字母+空格+5位数字或大写字母混合");
    }

    /**
     * 检查性别输入是否符合格式：只可为“男”或“女”
     *
     * @param str
     * @return
     */
    public static ResultMsg isGender(String str) {
        String trueExpression = "男|女";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"性别只可填“男”或“女”");
    }
    /**
     * 检查驾驶证期限格式是否符合日期格式：xxxx-xx-xx（x为数字）
     *
     * @param str
     * @return
     */
    public static ResultMsg isLicenseExpirationData(String str) {
        String trueExpression = "\\d{4}-\\d{2}-\\d{2}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"驾驶证期限必须符合日期格式：xxxx-xx-xx（x为数字）");
    }

    /**
     * 检查机构名是否为汉字
     *
     * @param str
     * @return
     */
    public static ResultMsg isOrganizationName(String str) {
        String trueExpression = "^[\\u4e00-\\u9fa5]+$";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"机构名格式错误,应为汉字");
    }



    /**
     * 检查营业厅内职位名称是否规范：只有“快递员”、“营业厅业务员”、“司机”
     *
     * @param str
     * @return
     */
    public static ResultMsg isServiceHallVocation(String str) {
        String trueExpression = "(快递员)|(营业厅业务员)|(司机)";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅人员职位格式错误,只有“快递员”、“营业厅业务员”、“司机”");
    }


    /**
     * 检查中转中心内人员职位名称是否规范：只有“库存管理人员”、“中转中心业务员”
     *(库存管理人员)|(中转中心业务员)|(快递员)|(营业厅业务员)|(司机)
     * @param str
     * @return
     */
    public static ResultMsg isTransitCenterVocation(String str) {
        String trueExpression = "(库存管理人员)|(中转中心业务员)";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅人员职位格式错误,只有“库存管理人员”、“中转中心业务员”");
    }

    /**
     * 检查多种数量是否为正整数
     *
     * @param str
     * @return
     */
    public static ResultMsg isProperNumber(String str) {
        String trueExpression = "\\+?[1-9]+\\d*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"数目必须为正整数");
    }

    /**
     * 检查库存排号、架号、位号格式是否正确：必须为四位数字
     *
     * @param str
     * @return
     */
    public static ResultMsg isStorageDistrictNumber(String str) {
        String trueExpression = "\\d{4}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"库存排号、架号、位号必须为四位数字");
    }


    /**
     * 检查营业厅名称格式：应为地名+“营业厅”
     *
     * @param str
     * @return
     */
    public static ResultMsg isServiceHall(String str) {
        String trueExpression = "[\\u4e00-\\u9fa5]+营业厅";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅名称格式错误,应为地名+“营业厅”");
    }


    /**
     * 检查中转中心名称格式：应为地名+“中转中心”
     *
     * @param str
     * @return
     */
    public static ResultMsg isTransitCenter(String str) {
        String trueExpression = "[\\u4e00-\\u9fa5]+中转中心";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"营业厅名称格式错误,应为地名+“中转中心”");
    }


    /**
     * 检查系统日志查询关键字：必须为汉字
     *
     * @param str
     * @return
     */
    public static ResultMsg isLogKeyWord(String str) {
        if(str == null)
            return new ResultMsg(true);
        String trueExpression = "[\\u4e00-\\u9fa5]*";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"查询关键字格式有误，必须为汉字");
    }


    public static ResultMsg isReceiveTime(String time) {
        String trueExpression = "\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}";
        return Pattern.matches(trueExpression,time)? new ResultMsg(true) :
                new ResultMsg(false,"收件时间格式错误,应为“xxxx－xx－xx xx：xx”,x是数字");
    }

    public static ResultMsg isFlightNumber(String flightNumber) {
        String trueExpression = "";
        return Pattern.matches(trueExpression,flightNumber)? new ResultMsg(true) :
                new ResultMsg(false,"航班号格式错误,应为");
    }

    public static ResultMsg isUserAccount(String account) {
        String trueExpression = "\\d{6,}";
        return Pattern.matches(trueExpression,account)? new ResultMsg(true) :
                new ResultMsg(false,"用户账号格式错误,应为不少于六位数字");
    }

    public static ResultMsg isAreaCode(String areacode) {
        String trueExpression = "";
        return Pattern.matches(trueExpression,areacode)? new ResultMsg(true) :
                new ResultMsg(false,"地名格式错误,应为");
    }

	public static ResultMsg isVocation(String vocation) {
		String trueExpression = "(库存管理人员)|(中转中心业务员)|(快递员)|(营业厅业务员)|(司机)|(财务人员)|(经理)";
        return Pattern.matches(trueExpression,vocation)? new ResultMsg(true) :
                new ResultMsg(false,"职位只可为：库存管理人员,中转中心业务员,快递员,营业厅业务员,司机,财务人员,经理等");
	}

	public static ResultMsg isOrganizationNumber(String str) {
		String trueExpression = "\\d{3}[01]\\d{3}";
        return Pattern.matches(trueExpression,str)? new ResultMsg(true) :
                new ResultMsg(false,"机构编号格式错误,应为7位数字:3位城市编码+0或1+3位编码");
	}
}
