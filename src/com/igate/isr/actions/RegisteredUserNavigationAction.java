


/************************************************************************************
 * File:         RegisteredUserNavigationAction.java
 * Package:     com.igate.isr.actions
 * Desc:        RegistereduserNavigation to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class RegisteredUserNavigationAction extends DispatchAction{
	public static final Logger logger = Logger.getLogger(RegisteredUserNavigationAction.class.getName());
	 public ActionForward home(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In RegisteredUserNavigationAction home method, calling Solution Approval JSP");
		 return mapping.findForward("Home");/*Redirect to HomePage*/
	 }
	 public ActionForward addProblemSolution(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In RegisteredUserNavigationAction addprobelmsolution method, calling AddProblemSolution JSP");
		 return mapping.findForward("AddProblemSolution");/*Redirect to AddProblemSolution Page*/
	 }
	 public ActionForward viewProblemSolution(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In RegisteredUserNavigationAction viewProblemSolution, calling ViewProblemSolution JSP");
		 return mapping.findForward("viewProblemSolution");/*Redirect to ViewProblemSolution Page*/
	 }
	 public ActionForward logout(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In RegisteredUserNavigationActionlogout, calling Welcome JSP");
		 return mapping.findForward("logout");/*Redirect to Welcome Page*/
	 }
}
