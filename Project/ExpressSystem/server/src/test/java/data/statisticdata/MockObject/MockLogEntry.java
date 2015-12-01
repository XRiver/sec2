package data.statisticdata.MockObject;

import po.LogEntryPO;

public class MockLogEntry extends LogEntryPO{
	

	 
	private static final long serialVersionUID = 1L;
	
	private String time;
	private String record;
	
	public MockLogEntry(String time, String record) {
		super(time, record);
		
	}

    public String getTime(){
    	return time;
    }
    
    public String getRecord(){
    	return record;
    }
}
