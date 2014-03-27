package com.igate.isr.exception;

import org.apache.log4j.Logger;

import com.igate.isr.actions.ViewProblemSolutionAction;



public class ViewProblemSolutionUserDefinedException extends Exception{
	Logger logger;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ViewProblemSolutionUserDefinedException(){
		super("Super:Server busy try again later");
		 logger = Logger.getLogger(ViewProblemSolutionAction.class.getName());
		 logger.debug("**************************In exception************************");
		
	}

}
