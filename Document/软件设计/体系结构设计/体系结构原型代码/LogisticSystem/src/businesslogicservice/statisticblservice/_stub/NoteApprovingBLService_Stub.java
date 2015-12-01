package businesslogicservice.statisticblservice._stub;

import java.util.ArrayList;

import businesslogic.util.DocType;
import businesslogicservice.statisticblservice.NoteApprovingBLService;
import vo.NoteVO;

public class NoteApprovingBLService_Stub implements NoteApprovingBLService {

	public ArrayList<NoteVO> getAllDoc(){
		System.out.println("returning all docs");
		return new ArrayList<>();
	};
	

	public ArrayList<NoteVO> getDocByType(DocType type){
		System.out.println("returning docs with:" + type);
		return new ArrayList<>();
	};
	

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
