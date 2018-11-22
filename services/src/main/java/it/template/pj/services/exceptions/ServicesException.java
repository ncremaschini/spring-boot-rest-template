package it.template.pj.services.exceptions;

/**
 * @author nicola.cremaschini
 * 17 nov 2017
 */
public class ServicesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4791833287317137148L;

	public ServicesException(){ 
		super();
	}
	
	public ServicesException(String message){ 
		super(message); 
	}
	
	public ServicesException(String message, Throwable cause){ 
		super(message, cause); 
	}
	
	public ServicesException(Throwable cause) { 
		super(cause);
	}
	
}
