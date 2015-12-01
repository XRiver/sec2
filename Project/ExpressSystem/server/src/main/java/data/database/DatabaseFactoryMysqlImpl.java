package data.database;


import data.commoditydata.InventoryData;
import data.commoditydata.StorageInData;
import data.commoditydata.StorageOutData;
import data.financedata.CreditNoteInputData;
import data.financedata.PaymentInputData;
import data.financedata.SettlementManagementData;
import data.infodata.BankAccountManagementData;
import data.infodata.DriverVehicleManagementData;
import data.infodata.StaffOrganizationManagementData;
import data.infodata.SystemUserManagementData;
import data.logisticdata.*;
import data.statisticdata.*;
import data.statisticdata.inte.LogInsertDataService;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.commoditydataservice.StorageOutDataService;
import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.financedataservice.PaymentInputDataService;
import dataservice.financedataservice.SettlementManagementDataService;
import dataservice.infodataservice.BankAccountManagementDataService;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.logisticdataservice.*;
import dataservice.statisticdataservice.*;

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/22.
 */
public class DatabaseFactoryMysqlImpl implements DatabaseFactory{

    /**
     * 数据实现的提供工厂,单件模式
     * volatile确保实例被初始化的时候,多个线程正确处理实例变量
     *
     */
    private volatile static DatabaseFactoryMysqlImpl dataBaseFactoryMysql;

    private DatabaseFactoryMysqlImpl() throws RemoteException {
        inventoryDataService = new InventoryData();
        storageInDataService = new StorageInData();
        storageOutDataService = new StorageOutData();

        creditNoteInputDataService = new CreditNoteInputData();
        paymentInputDataService = new PaymentInputData();
        settlementManagementDataService = new SettlementManagementData();

        bankAccountManagementDataService = new BankAccountManagementData();
        driverVehicleManagementDataService = new DriverVehicleManagementData();
        systemUserManagementDataService = new SystemUserManagementData();
        staffOrganizationManagementDataService = new StaffOrganizationManagementData();

        arrivalNoteOnServiceDataService = new ArrivalNoteOnServiceData();
        arrivalNoteOnTransitDataService = new ArrivalNoteOnTransitData();

        loadNoteOnServiceDataService = new LoadNoteOnServiceData();
        loadNoteOnTransitDataService = new LoadNoteOnTransitData();
        receivingNoteInputDataService = new ReceivingNoteInputData();
        transitNoteInputDataService = new TransitNoteInputData();

        baseDataBuildingDataService = new BaseDataBuildingData();
        businessDataModificationDataService = new BusinessDataModificationData();
        chartOutputDataService = new ChartOutputData();
        logInquiryDataService = new LogInquiryData();

        orderInquiryDataService = new OrderInquiryData();

        logInsertDataService = new LogInsertData();
        deliveryNoteInputDataService = new DeliveryNoteInputData(orderInquiryDataService,
                businessDataModificationDataService);
        noteApprovingDataService = new NoteApprovingData(arrivalNoteOnServiceDataService,
                arrivalNoteOnTransitDataService,deliveryNoteInputDataService,
                loadNoteOnServiceDataService,loadNoteOnTransitDataService,
                receivingNoteInputDataService,transitNoteInputDataService);
    }

    public static DatabaseFactoryMysqlImpl getInstance() throws RemoteException {
        if(dataBaseFactoryMysql == null){
            //如果实例没有被创建,进行同步,只有第一次同步加锁
            synchronized (DatabaseFactoryMysqlImpl.class){
                if(dataBaseFactoryMysql == null)
                    dataBaseFactoryMysql = new DatabaseFactoryMysqlImpl();
            }
        }
        return dataBaseFactoryMysql;
    }

    /**
     * 所有的数据实现服务,皆为单件
     */
    //commodity
    private InventoryDataService inventoryDataService;
    private StorageInDataService storageInDataService;
    private StorageOutDataService storageOutDataService;

    //finance
    private CreditNoteInputDataService creditNoteInputDataService;
    private PaymentInputDataService paymentInputDataService;
    private SettlementManagementDataService settlementManagementDataService;

    //info
    private BankAccountManagementDataService bankAccountManagementDataService;
    private DriverVehicleManagementDataService driverVehicleManagementDataService;
    private StaffOrganizationManagementDataService staffOrganizationManagementDataService;
    private SystemUserManagementDataService systemUserManagementDataService;

    //logistic
    private ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService;
    private ArrivalNoteOnTransitDataService arrivalNoteOnTransitDataService;
    private DeliveryNoteInputDataService deliveryNoteInputDataService;
    private LoadNoteOnServiceDataService loadNoteOnServiceDataService;
    private LoadNoteOnTransitDataService loadNoteOnTransitDataService;
    private ReceivingNoteInputDataService receivingNoteInputDataService;
    private TransitNoteInputDataService transitNoteInputDataService;

    //statistic
    private BaseDataBuildingDataService baseDataBuildingDataService;
    private BusinessDataModificationDataService businessDataModificationDataService;
    private ChartOutputDataService chartOutputDataService;
    private LogInquiryDataService logInquiryDataService;
    private NoteApprovingDataService noteApprovingDataService;
    private OrderInquiryDataService orderInquiryDataService;
    private LogInsertDataService logInsertDataService;

    @Override
    public InventoryDataService getInventoryDataService() {
        return inventoryDataService;
    }

    @Override
    public StorageInDataService getStorageInDataService() {
        return storageInDataService;
    }
    @Override
    public StorageOutDataService getStorageOutDataService() {
        return storageOutDataService;
    }

    @Override
    public CreditNoteInputDataService getCreditNoteInputDataService() {
        return creditNoteInputDataService;
    }

    @Override
    public PaymentInputDataService getPaymentInputDataService() {
        return paymentInputDataService;
    }

    @Override
    public SettlementManagementDataService getSettlementManagementDataService() {
        return settlementManagementDataService;
    }

    @Override
    public BankAccountManagementDataService getBankAccountManagementDataService() {
        return bankAccountManagementDataService;
    }

    @Override
    public DriverVehicleManagementDataService getDriverVehicleManagementDataService() {
        return driverVehicleManagementDataService;
    }

    @Override
    public StaffOrganizationManagementDataService getStaffOrganizationManagementDataService() {
        return staffOrganizationManagementDataService;
    }

    @Override
    public SystemUserManagementDataService getSystemUserManagementDataService() {
        return systemUserManagementDataService;
    }

    @Override
    public ArrivalNoteOnServiceDataService getArrivalNoteOnServiceDataService() {
        return arrivalNoteOnServiceDataService;
    }

    @Override
    public ArrivalNoteOnTransitDataService getArrivalNoteOnTransitDataService() {
        return arrivalNoteOnTransitDataService;
    }

    @Override
    public DeliveryNoteInputDataService getDeliveryNoteInputDataService() {
        return deliveryNoteInputDataService;
    }

    @Override
    public LoadNoteOnServiceDataService getLoadNoteOnServiceDataService() {
        return loadNoteOnServiceDataService;
    }

    @Override
    public LoadNoteOnTransitDataService getLoadNoteOnTransitDataService() {
        return loadNoteOnTransitDataService;
    }

    @Override
    public ReceivingNoteInputDataService getReceivingNoteInputDataService() {
        return receivingNoteInputDataService;
    }

    @Override
    public TransitNoteInputDataService getTransitNoteInputDataService() {
        return transitNoteInputDataService;
    }

    @Override
    public BaseDataBuildingDataService getBaseDataBuildingDataService() {
        return baseDataBuildingDataService;
    }

    @Override
    public BusinessDataModificationDataService getBusinessDataModificationDataService() {
        return businessDataModificationDataService;
    }

    @Override
    public ChartOutputDataService getChartOutputDataService() {
        return chartOutputDataService;
    }

    @Override
    public LogInquiryDataService getLogInquiryDataService() {
        return logInquiryDataService;
    }

    @Override
    public NoteApprovingDataService getNoteApprovingDataService() {
        return noteApprovingDataService;
    }

    @Override
    public OrderInquiryDataService getOrderInquiryDataService() {
        return orderInquiryDataService;
    }

    @Override
    public LogInsertDataService getLogInsertDataService() {
        return null;
    }

}
