
/************************************************************************************
 * File:        AdminNavigationAction.java
 * Package:     com.igate.isr.actions
 * Desc:         AdminNavigation to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subash		       7-12-2010       Initial version
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

public class AdminNavigationAction extends DispatchAction {
	public static final Logger logger = Logger.getLogger(SolutionStatisticsByUserAction.class.getName());
	 public ActionForward solutionApproval(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In  AdminNavigationAction solutionApproval,redirect to Solution Approval JSP");
		 return mapping.findForward("solutionApproval");
	 }
	 public ActionForward technology(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In AdminNavigationAction technology,redirect to  View And Add Technology JSP");
		 return mapping.findForward("viewAndAddTechnology");
	 }
	 public ActionForward viewAndAddTechnologyStatistics(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In AdminNavigationAction viewAndAddTechnologyStatistics,redirect to Solution Approval JSP");
		 return mapping.findForward("technologyStatistics");
	 }
	 public ActionForward solutionStatisticsByUser(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In AdminNavigationAction solutionStatisticsByUser,redirect to Solution Statistics By User JSP");
		 return mapping.findForward("userStatistics");
	 }
	 public ActionForward logout(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.debug("In AdminNavigationAction logout,redirect to Welcome JSP");
		 return mapping.findForward("logout");
	 }
}
