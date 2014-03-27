
/************************************************************************************
 * File:        CustomRequestProcessor.java
 * Package:     com.igate.isr.actions
 * Desc:        CustomRequestProcessor to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Jawahar		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;



import java.io.IOException;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.RequestProcessor;


public class CustomRequestProcessor extends RequestProcessor
{
	
	private static final Logger logger = Logger.getLogger(CustomRequestProcessor.class.getName());
	protected boolean processPreprocess(HttpServletRequest request,	HttpServletResponse response) 
	{
	  logger.info("In CustomRequestProcessor processPreprocess method");	
		HttpSession session = request.getSession(false);
		if (request.getServletPath().equals("/displaysearch.do")) 
		{
			
		    if(null==request.getParameter("mode")||request.getParameter("mode").trim().length()==0) 
			   {
				try
				{
					
					response.sendRedirect(request.getContextPath()+"/web/jsp/MainPage.jsp");
					return false;
				}
				catch(IOException ie)
				{
					StringBuffer errorMessage = new StringBuffer();
					Date currentDate = new Date();
					errorMessage.append("******IO Exception : RequestProcessor method ");
					errorMessage.append(currentDate.toString());
					errorMessage.append(ie.getMessage());
					logger.error(errorMessage.toString());
				}
			}
		   
		}
		
		else if(request.getServletPath().contains("/searchSolution.do") || request.getServletPath().contains("/result.do"))
		{
			if(request.getParameter("mode")==null)
			{
				try
				{
					response.sendRedirect(request.getContextPath()+"/web/jsp/MainPage.jsp");
					return false;
				}
				catch(IOException e)
				{
					
				}
			}
						
		}
		else if(request.getServletPath().contains("/LoginNavigation.do"))
		{
			if(request.getParameter("mode").equals("doBacktoWelcome"))
				try
				{
					response.sendRedirect(request.getContextPath()+"/web/jsp/MainPage.jsp");
					return false;
				}
				catch(IOException e)
				{
					
				}
			
						
		}
		

	else if(request.getServletPath().contains("/AdminNavigation.do")||request.getServletPath().contains("/isr.do")){
		
		if(null==session ||null==request.getParameter("mode")|| session.getAttribute("EmpId")==null || session.getAttribute("UserName")==null||session.getAttribute("isAdmin").equals("n"))
		{
			try {
			
				response.sendRedirect(request.getContextPath()+"/web/jsp/Login.jsp");
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.error("Exception is caught in  CustomRequestProcessor processPreprocess method");
				e.printStackTrace();
			} 
			
		}	
	}

	else if(request.getServletPath().contains("/registeredUserNavigation.do")){
		
		if(null==session ||null==request.getParameter("mode")|| session.getAttribute("EmpId")==null || session.getAttribute("UserName")==null || session.getAttribute("isAdmin").equals("y"))
		{
			try {
			
				response.sendRedirect(request.getContextPath()+"/web/jsp/Login.jsp");
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}	
	}
		
		
	else if(request.getServletPath().endsWith(".do"))
	{
		if(request.getParameter("mode")==null)
			{
			try
			{
				response.sendRedirect(request.getContextPath()+"/web/jsp/MainPage.jsp");
				return false;
			}
			catch(IOException e)
			{
				
			}
			}
	}
	
		logger.info("Returning from CustomRequestProcessor processPreprocess method");	
	return super.processPreprocess(request, response);	
	
	}}

	