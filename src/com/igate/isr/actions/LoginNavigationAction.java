


/************************************************************************************
 * File:        LoginNavigationAction.java
 * Package:     com.igate.isr.actions
 * Desc:        loginNavigation to iSolutionsRepository
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

public class LoginNavigationAction extends DispatchAction {
	public static final Logger logger = Logger.getLogger(LoginAction.class.getName());
	public ActionForward doSignUp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, Exception {
        logger.info("In LoginNavigationAction,doSignUp method calling registration JSP");
		return mapping.findForward("signup");

	}

	public ActionForward doBacktoWelcome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException,
			Exception {
		  logger.info("In LoginNavigationAction,doBacktoWelcome method calling Welcome JSP");
		return mapping.findForward("back");

	}

}
