package businesslogic.statistic;

import businesslogicservice.statisticblservice.LogInquiryBLService;
import connection.RemoteObjectGetter;
import dataservice.statisticdataservice.LogInquiryDataService;
import po.LogEntryPO;
import util.ResultMsg;
import vo.SystemLogVO;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class LogInquiry implements LogInquiryBLService {

    private LogInquiryDataService dataService;

    public LogInquiry() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (LogInquiryDataService)getter.getObjectByName("LogInquiryDataService");
    }

    @Override
    public ResultMsg inputKeywords(SystemLogVO log) {
        ResultMsg formatCheck = log.checkFormat();
        return formatCheck;
    }

    @Override
    public ArrayList<SystemLogVO> getLogInfo(SystemLogVO log) {
        //获取日志查询关键字,可能有多个
        ArrayList<String> keywords = new ArrayList<>();
        if(log.getTime() != null)
            keywords.add(log.getTime());
        if(log.getContent() != null)
            keywords.add(log.getContent());
        //返回的日志查询结果
        ArrayList<SystemLogVO> results = new ArrayList<>();
        try {
            ArrayList<LogEntryPO> pos =  dataService.findLogEntries(log.getTime(),keywords);
            for (LogEntryPO po : pos) {
                SystemLogVO vo = new SystemLogVO(po.getTime(),po.getRecord());
                results.add(vo);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return results;
    }
}