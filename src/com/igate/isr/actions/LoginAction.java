
/************************************************************************************
 * File:        LoginAction.java
 * Package:     com.igate.isr.actions
 * Desc:        login to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.igate.isr.bo.LoginBO;
import com.igate.isr.dto.LoginDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.LoginUserDefinedException;
import com.igate.isr.forms.LoginForm;

public class LoginAction extends DispatchAction {
	public static final Logger logger = Logger.getLogger(LoginAction.class.getName());
	
	 
	 
	public ActionForward doLogin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws LoginUserDefinedException {
		
		logger.info("In LoginAction doLogin Method");
		HttpSession session = request.getSession();
		LoginDTO logindto = new LoginDTO();
		LoginBO loginbo = new LoginBO();
		ActionMessages messages = new ActionMessages();
		LoginForm form1 = (LoginForm) form;
		String employeeid = form1.getLogindto().getEmpID();
		String passwd = form1.getLogindto().getPassword();
		logindto.setEmpID(employeeid);
		logindto.setPassword(passwd);

		try {
			logindto = loginbo.getLoginDetails(logindto);
			logger.info("return from BO");
		} catch (LoginUserDefinedException e) {
			logger.error("Exception is caught in LoginAction doLogin method");
			messages.add("msg", new ActionMessage("errors_dbmsg"));
			saveMessages(request, messages);
			form1.resetForm();
			return mapping.findForward("loginpage");
		} catch (AddProblemSolutionUserDefinedException e) {
			logger.error("Exception is caught in LoginAction doLogin method");
			messages.add("msg", new ActionMessage("errors_dbmsg"));
			saveMessages(request, messages);
			form1.resetForm();
			return mapping.findForward("loginpage");
		} 

		if (logindto.getAdmin() == null) {
			messages.add("msg", new ActionMessage("errors_loginmsg"));
			saveMessages(request, messages);
			form1.resetForm();
			return mapping.findForward("loginpage");
		}

		else if (logindto.getAdmin().equalsIgnoreCase("y")) {
			session.setAttribute("EmpId", logindto.getEmpID());
			session.setAttribute("UserName", logindto.getUserName());
			session.setAttribute("isAdmin", logindto.getAdmin());
			session.setMaxInactiveInterval(180);
			form1.resetLoginFields();
			return mapping.findForward("approvalpage");
		} else {
			session.setAttribute("EmpId", logindto.getEmpID());

			session.setAttribute("UserName", logindto.getUserName());
			session.setAttribute("isAdmin", logindto.getAdmin());
			session.setMaxInactiveInterval(180);
			form1.resetLoginFields();
			return mapping.findForward("homepage");
		}
		
		
	}
	
	/**
	 * This is the method which logs out the user from the application.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */

	public ActionForward doLogout(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("In LoginAction doLogout method");
		HttpSession session = request.getSession(false);

		session.invalidate();
		logger.info("Returning from LoginAction doLogout method redirect to welcome page");
		return mapping.findForward("welcome");

	}

}
