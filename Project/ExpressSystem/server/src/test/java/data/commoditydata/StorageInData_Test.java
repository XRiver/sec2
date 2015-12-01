package data.commoditydata;
import static junit.framework.TestCase.assertEquals;

import java.rmi.RemoteException;

import data.commoditydata.MockObject.MockStorageInPO;
import org.junit.Test;

public class StorageInData_Test {
	
	static StorageInData sid = new StorageInData();
	
	static MockStorageInPO[] m ;
	
	@Test
	public void StorageInData_Test() throws RemoteException {

		m = new MockStorageInPO[4];
		
//		m[0] = new MockStorageInPO("2015-02-28",null);
//		sid.insert(m[0]);
//
//		m[1] = new MockStorageInPO("2015-05-23",null);
//		sid.insert(m[1]);
//
//		m[2] = new MockStorageInPO("2015-07-11",null);
//		sid.insert(m[2]);
		
		m[3] = new MockStorageInPO("2015-09-04",null);
		//Not inserted
		
	}
	
	@Test
	public void testDelete() throws RemoteException {
		
		//assertEquals(true,sid.delete(m[0]));
		//assertEquals(false,sid.delete(m[3]));
		
	}

	@Test
	public void testFind() throws RemoteException {
		
		//assertEquals(m[2], sid.find(m[2]).get(0));
		//assertEquals(0,sid.find(m[3]).size());
		
	}
}
