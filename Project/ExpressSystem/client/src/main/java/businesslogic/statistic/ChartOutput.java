package businesslogic.statistic;

import businesslogicservice.statisticblservice.ChartOutputBLService;
import connection.RemoteObjectGetter;
import dataservice.statisticdataservice.ChartOutputDataService;
import org.apache.poi.hssf.usermodel.*;
import po.ChartPO;
import po.chart.BusinessStateChartPO;
import po.chart.CostAndProfitChartPO;
import util.FormatCheck;
import util.ResultMsg;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kylin on 15/11/17.
 */
public class ChartOutput implements ChartOutputBLService {

    private ChartOutputDataService dataService;

    private ChartVO inputChartVO;

    private BusinessStateChartVO businessStateVO;
    private BusinessStateChartPO businessStatePO;

    private CostAndProfitChartVO costAndProfitVO;
    private CostAndProfitChartPO costAndProfitPO;

    public ChartOutput() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (ChartOutputDataService)getter.getObjectByName("ChartOutputDataService");
    }

    @Override
    public ResultMsg enquiryChart(ChartType chartType, String time1, String time2) {
        ResultMsg result = new ResultMsg(true);
        ResultMsg results[] = new ResultMsg[2];
        results[0] = FormatCheck.isDate(time1);
        results[1] = FormatCheck.isDate(time2);
        for(int i = 0; i<results.length; i++){
            if(!results[i].isPass())
                return results[i];
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDay = dateFormat.parse(time1);
            Date endDay = dateFormat.parse(time2);
            if(startDay.before(endDay))
                return new ResultMsg(false,"起点日期不能在终点日期之后!");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(result.isPass()){
            this.getChartVO(chartType,time1,time2);
        }
        return result;
    }

    @Override
    public ChartVO getChartVO(ChartType chartType, String time1, String time2) {
        try {
            if (chartType == ChartType.BUSINESS_STAT_CHART){
                businessStatePO = dataService.getBusinessStateChart(new BusinessStateChartPO(time1,time2));
                businessStateVO = new BusinessStateChartVO(
                        time1,time2,businessStatePO.getProfix(),businessStatePO.getGrowthRate());
                return businessStateVO;
            }
            else{
                costAndProfitPO = dataService.getCostAndProfitChart(new CostAndProfitChartPO(time1,time2));
                costAndProfitVO = new CostAndProfitChartVO(
                        time1,time2,costAndProfitPO.getCost(),costAndProfitPO.getProfit());
                return costAndProfitVO;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultMsg exportChart(ChartVO chartVO, String path) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(chartVO.getType().toString());
        // 第三步，在sheet中添加表头第0行
        HSSFRow row = sheet.createRow(0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 创建一个居中格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 第五步，创建单元格，并设置值
        if(chartVO.getType() == ChartType.BUSINESS_STAT_CHART){
            BusinessStateChartVO vo = (BusinessStateChartVO)chartVO;
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("日期");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("收益");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("增涨比");
            cell.setCellStyle(style);
            for(int i = 0;i<vo.getEveryday().size();i++){
                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(vo.getEveryday().get(i));
                row.createCell(1).setCellValue(vo.getProfix().get(i));
                row.createCell(2).setCellValue(vo.getGrowthRate().get(i));
            }
        }else{
            CostAndProfitChartVO vo = (CostAndProfitChartVO)chartVO;
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("日期");
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("成本");
            cell.setCellStyle(style);
            cell = row.createCell(2);
            cell.setCellValue("收益");
            cell.setCellStyle(style);
            for(int i = 0;i<vo.getEveryday().size();i++){
                row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(vo.getEveryday().get(i));
                row.createCell(1).setCellValue(vo.getCost().get(i));
                row.createCell(2).setCellValue(vo.getProfit().get(i));
            }
        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream(path+"test3.xls");
            wb.write(fout);
            fout.close();
            return new ResultMsg(true,"已导出EXCEL表格!");
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResultMsg(false,"无法导出EXCEL表格!");
        }

    }

    public static void main(String[] args) {
        ArrayList<Double> cost = new ArrayList<Double>(5){
            {add(0.1); add(0.2);add(0.3);add(0.4);add(0.5);}};
        ArrayList<Double> profit = new ArrayList<Double>(5){
            {add(6.1); add(6.2);add(6.3);add(6.4);add(6.5);}};
        CostAndProfitChartVO  vo = new CostAndProfitChartVO("2015-11-1","2015-11-5",cost,profit);
        ArrayList<String> days = new ArrayList<String>(5){
            {add("2015-11-1"); add("2015-11-2");add("2015-11-3");add("2015-11-4");add("2015-11-5");}};
        vo.setEveryday(days);
        ChartOutput chartOutput = new ChartOutput();
        chartOutput.exportChart(vo,"/Users/kylin/Documents/");
    }
}
