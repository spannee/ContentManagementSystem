package com.igate.isr.exception;

/*Exception in case there are no technologies available*/
public class ViewFailureException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewFailureException(){
		super("No Data Found");
	}
}
