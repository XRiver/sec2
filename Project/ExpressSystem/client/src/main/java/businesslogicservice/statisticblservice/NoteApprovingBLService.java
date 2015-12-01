package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import vo.*;

/**
 * 总经理审批单据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface NoteApprovingBLService {
    
    ArrayList<ArrivalNoteOnServiceVO> getArrivalNoteOnServiceVO();

    ArrayList<DeliverNoteOnServiceVO> getDeliverNoteOnServiceVO();

    ArrayList<ArrivalNoteOnTransitVO> getArrivalNoteOnTransitVO();

    ArrayList<DeliveryNoteVO> getDeliveryNoteVO();

    ArrayList<LoadNoteOnServiceVO> getLoadNoteOnServiceVO();

    ArrayList<LoadNoteOnTransitVO> getLoadNoteOnTransitVO();

    ArrayList<ReceivingNoteVO> getReceivingNoteVO();

    ArrayList<TransitNoteOnTransitVO> getTransitNoteVO();
	
	/**
	 * 通过所有单据的审批
	 */
    void passAllDoc();

	/**
	 * 通过一个单据的审批
	 *
	 * @param docVO
	 */
    void passDoc(NoteVO docVO);
	
	/**
	 * 对否决对单据输入审批意见
	 *
	 * @param advice
	 */
    void inputAdvice(NoteVO docVO,String advice);

    ArrayList<NoteVO> getAllDoc();

}
