package businesslogicservice.statisticblservice;

import java.util.ArrayList;

import businesslogic.util.DocType;
import vo.NoteVO;

/**
 * 总经理审批单据的逻辑接口
 * 
 * @author kylin
 *
 */
public interface NoteApprovingBLService {

	/**
	 * 总经理获得所有未审批单据的操作
	 *
	 * @return
	 */
	public ArrayList<NoteVO> getAllDoc();
	
	/**
	 * 根据类型获取单据
	 *
	 * @param type
	 * @return
	 */
	public ArrayList<NoteVO> getDocByType(DocType type);
	
	/**
	 * 通过所有单据的审批
	 */
	public void passAllDoc();

	/**
	 * 通过一个单据的审批
	 *
	 * @param docVO
	 */
	public void passDoc(NoteVO docVO);
	
	/**
	 * 否决一个单据
	 *
	 * @param docVO
	 */
	public void failDoc(NoteVO docVO);
	
	/**
	 * 对否决对单据输入审批意见
	 *
	 * @param advice
	 */
	public void inputAdvice(NoteVO docVO,String advice);
	
}
