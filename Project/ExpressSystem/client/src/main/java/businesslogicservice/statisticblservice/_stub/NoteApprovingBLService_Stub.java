package businesslogicservice.statisticblservice._stub;

import java.util.ArrayList;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import util.enums.DocType;
import vo.*;

public class NoteApprovingBLService_Stub implements NoteApprovingBLService {

	public ArrayList<NoteVO> getAllDoc(){
		System.out.println("returning all docs");
		return new ArrayList<NoteVO>();
	};
	

	public ArrayList<NoteVO> getDocByType(DocType type){
		System.out.println("returning docs with:" + type);
		return new ArrayList<NoteVO>();
	};


    @Override
    public ArrayList<ArrivalNoteOnServiceVO> getArrivalNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServiceVO> getDeliverNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnTransitVO> getArrivalNoteOnTransitVO() {
        return null;
    }

    @Override
    public ArrayList<DeliveryNoteVO> getDeliveryNoteVO() {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnServiceVO> getLoadNoteOnServiceVO() {
        return null;
    }

    @Override
    public ArrayList<LoadNoteOnTransitVO> getLoadNoteOnTransitVO() {
        return null;
    }

    @Override
    public ArrayList<ReceivingNoteVO> getReceivingNoteVO() {
        return null;
    }

    @Override
    public ArrayList<TransitNoteOnTransitVO> getTransitNoteVO() {
        return null;
    }

    public void passAllDoc(){
		System.out.println("passing docs");
	};


	public void passDoc(NoteVO docVO){
		System.out.println("passing docs");
	};
	
	
	public void failDoc(NoteVO docVO){
		System.out.println("setting fail docs");
	};
	

	public void inputAdvice(NoteVO docVO,String advice){
		System.out.println("setting advice");
	};
	
}
