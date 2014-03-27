
/************************************************************************************
 * File:       GuestuserNavigationAction.java
 * Package:     com.igate.isr.actions
 * Desc:        GuestuserNavigation  to iSolutionsRepository
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

public class GuestUserNavigationAction  extends DispatchAction {
	public static final Logger logger = Logger.getLogger(GuestUserNavigationAction.class.getName());
	 public ActionForward signin(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In GuestUserNavigationAction  signin method, calling Login JSP");
		 return mapping.findForward("login");
	 }
	 public ActionForward signup(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		 logger.info("In GuestUserNavigationAction  signup method,calling Registration JSP");
		 return mapping.findForward("registration");
	 }
}
