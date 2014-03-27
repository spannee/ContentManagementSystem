package com.igate.isr.exception;

import org.apache.log4j.Logger;

import com.igate.isr.actions.SolutionStatisticsByUserAction;


public class SolutionStatisticsByUserUserDefinedException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger logger = Logger.getLogger(SolutionStatisticsByUserAction.class.getName()); 
		public SolutionStatisticsByUserUserDefinedException()
		{
			super("NO RESULTS FOUND");//In constructor 
			logger.debug("In UserDefinedException Constructor"); 
		}
}
