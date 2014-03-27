
/************************************************************************************
 * File:        viewProblamsolutionAction.java
 * Package:     com.igate.isr.actions
 * Desc:        viewProblamsolution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Chaitanya		       7-12-2010       Initial version
 ************************************************************************************/



package com.igate.isr.actions;


import java.util.ArrayList;
import java.util.List;


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

import com.igate.isr.bo.ViewProblemSolutionBO;
import com.igate.isr.dto.ViewProblemSolutionDTO;

import com.igate.isr.exception.ViewProblemSolutionUserDefinedException;

public class ViewProblemSolutionAction extends DispatchAction {
	String EmpId;
	ViewProblemSolutionBO viewProbSolBO;
	List<ViewProblemSolutionDTO> probSolList;
	ActionMessages messages = new ActionMessages();/*Creating object for Action message*/
	public static final Logger logger = Logger
			.getLogger(ViewProblemSolutionAction.class.getName());

	public ActionForward viewProblemSolution(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)
			 {
        logger.info(" In ViewProblemSolutionAction viewProblemSolution method ");
		HttpSession session = request.getSession();
		viewProbSolBO = new ViewProblemSolutionBO();/*Creating object for BO*/
		probSolList = new ArrayList<ViewProblemSolutionDTO>();

		if (!session.isNew()) {

			try {
				EmpId = (String) session.getAttribute("EmpId");
				probSolList = viewProbSolBO.viewProblemSolutionDetails(EmpId);
				session.setAttribute("viewdetails", probSolList);
				
				int arraysize = probSolList.size();
				if (arraysize == 0) {
					messages.add("messagesresult", new ActionMessage("messages.msg"));
					saveMessages(request, messages);
					
				}
			} catch (ViewProblemSolutionUserDefinedException e) {
				messages.add("messageserror", new ActionMessage("messages.server"));
				 logger.error("Exception is caught in  ViewProblemSolutionAction viewProblemSolution method ");
				saveMessages(request, messages);
			}

		}
		 logger.info(" Returning from ViewProblemSolutionAction viewProblemSolution method,redirect to viewPreobelmsolution page ");
		return mapping.findForward("viewDetails");
	}
}