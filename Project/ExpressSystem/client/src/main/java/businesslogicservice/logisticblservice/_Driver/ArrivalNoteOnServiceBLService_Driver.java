package businesslogicservice.logisticblservice._Driver;

import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import util.ResultMsg;
import vo.ArrivalNoteOnServiceVO;
import vo.DeliverNoteOnServiceVO;

/**
 * Created by kylin on 15/11/10.
 */
public class ArrivalNoteOnServiceBLService_Driver {

    public void driver(ArrivalNoteOnServiceBLService service){
        ResultMsg result = service.inputHallArrivalDoc(new ArrivalNoteOnServiceVO
                ("2015-10-22",true,"02500020151009","nanjing",null));
        if(result.isPass()==true)
            System.out.println("输入的中转中心到达单格式正确");
        else
            System.out.println("输入的中转中心到达单格式不正确");
        result = service.submitHallArrivalDoc(new ArrivalNoteOnServiceVO
                ("2015-10-22",true,"02500020151009","nanjing",null));
        if(result.isPass()==true)
            System.out.println("输入的中转中心到达单格式正确");
        else
            System.out.println("输入的中转中心到达单格式不正确");
        result = service.inputHallDeliverDoc(new DeliverNoteOnServiceVO(null,"2015-10-22",null,"tom"));
        if(result.isPass()==true)
            System.out.println("输入的中转中心到达单格式正确");
        else
            System.out.println("输入的中转中心到达单格式不正确");
        result = service.submitHallDeliverDoc(new DeliverNoteOnServiceVO(null,"2015-10-22",null,"tom"));
        if(result.isPass()==true)
            System.out.println("输入的中转中心到达单格式正确");
        else
            System.out.println("输入的中转中心到达单格式不正确");
    }

    public static void main(String[] args) {

    }
}
