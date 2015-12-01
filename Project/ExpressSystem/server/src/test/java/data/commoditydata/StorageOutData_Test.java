package data.commoditydata;

import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import data.commoditydata.MockObject.MockStorageOutPO;
import org.junit.Test;

public class StorageOutData_Test {

	static StorageOutData sod = new StorageOutData();
	
	static MockStorageOutPO[] m;
	
	public StorageOutData_Test() throws RemoteException {
		m = new MockStorageOutPO[4];
		
		m[0] = new MockStorageOutPO(null, "2015-02-28","北京市朝阳区10086号邮箱", "空运", "025000201510120000003", true);
//		sod.insert(m[0]);
		
		m[1] = new MockStorageOutPO(null, "2015-05-23","南京市仙林区仙林大道163号", "铁路", "025000201510120000004", true);
//		sod.insert(m[1]);
		
		m[2] = new MockStorageOutPO(null, "2015-07-11","南京市鼓楼区南京大学教务处", "汽运", "025000201510120000005", true);
//		sod.insert(m[2]);
		
		m[3] = new MockStorageOutPO(null, "2015-09-04","南京市仙林区仙林大道163号", "铁运", "025000201510120000006", true);
		//Not inserted.
	}
	
	@Test
	public void testDelete() throws RemoteException {
		//assertEquals(true,sod.delete(m[1]));
		//assertEquals(false,sod.delete(m[3]));
	}
	
	@Test
	public void testFind() throws RemoteException{
		//assertEquals(m[2], sod.find(m[2]).get(0));
		//assertEquals(0,sod.find(m[3]).size());
	}
}
