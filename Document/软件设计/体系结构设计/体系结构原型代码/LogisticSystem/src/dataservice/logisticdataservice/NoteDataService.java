/**
 * 输入单据数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.NotePO;
public interface NoteDataService {
	/**
	 * 在数据库中增加一个po记录
	 */
	public boolean insert(NotePO po) throws RemoteException;
	/**
	 * 在数据库中删除一个po记录
	 */
	public boolean delete(NotePO po) throws RemoteException;
	/**
	 * 在数据库中更新一个po记录
	 */
	public boolean update(NotePO po) throws RemoteException;
	/**
	 * 查找返回相应的NotePO结果
	 */
	public ArrayList<NotePO> find(NotePO po) throws RemoteException;
	
	/**
	 * 返回所有的NotePO
	 */
	public ArrayList<NotePO> findAll() throws RemoteException;

	/**
	 * 初始化持久化数据库
	 */
	public void init() throws RemoteException;
	/**
	 * 结束持久化数据库的使用
	 */
	public void finish() throws RemoteException;
}