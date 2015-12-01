package dataservice.exception;

import java.io.Serializable;

/**
* @author River
*/
public class ElementNotFoundException extends Exception implements Serializable{

	public String message = null;

	public ElementNotFoundException(String string) {
		message = string;
	}

	public ElementNotFoundException() {
	}

	private static final long serialVersionUID = -4080377879461286908L;

	
}
