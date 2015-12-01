package util;

import java.io.Serializable;

/**
 * 输入单据等的返回信息
 * 
 * @author kylin
 *
 */
public class ResultMsg implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 888889074956257035L;

	/**
	 * 是否通过该阶段的检查
	 */
	private boolean pass;
	
	/**
	 * 返回的信息
	 */
	private String message;
	
	public ResultMsg(boolean pass, String message) {
		super();
		this.pass = pass;
		this.message = message;
	}

    public ResultMsg(){

    }

    public ResultMsg(boolean pass){
        this.pass = pass;
        this.message = "";
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isPass() {
        return pass;
    }

    public String getMessage() {
        return message;
    }

    public void appendMessage(String newMsg){
        this.message+= newMsg;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
