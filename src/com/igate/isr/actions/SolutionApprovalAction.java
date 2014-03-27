
/************************************************************************************
 * File:        SolutionApprovalAction.java
 * Package:     com.igate.isr.actions
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Rushmitha		       7-12-2010       Initial version
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
import com.igate.isr.bo.SolutionApprovalBO;
import com.igate.isr.dto.SolutionApprovalDTO;
import com.igate.isr.exception.SolutionApprovalUserDefinedExceptions;
import com.igate.isr.forms.SolutionApprovalForm;

public class SolutionApprovalAction extends DispatchAction {
	List<SolutionApprovalDTO> submittedSolutions;
	SolutionApprovalBO solAppBO;
	boolean update;
	int[] problemId;
    int statusFinal;
	int incount;
	String[] checkProblemId;
	ActionMessages messages;
	String statusTemp;
	public static final Logger logger = Logger.getLogger(SolutionApprovalAction.class.getName());
	public ActionForward doLoadSolutionApproval(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		submittedSolutions = new ArrayList<SolutionApprovalDTO>();
		
		logger.info("In SolutionApprovalAction-----doLoadSolutionApproval---------");
		HttpSession session = request.getSession();
		messages = new ActionMessages();
		try {
			solAppBO = new SolutionApprovalBO();

			submittedSolutions = solAppBO.getPendingDetails();
			session.setAttribute("submittedSolutions", submittedSolutions);
			int rows = submittedSolutions.size();
			if (rows == 0) {
			
				messages.add("messagesResult", new ActionMessage(
						"messages.results"));
				saveMessages(request, messages);
				return mapping.findForward("SolutionApproval");
			}
		
				
		} catch (SolutionApprovalUserDefinedExceptions e) {
			logger
					.error("In SolutionApprovalAction------------doLoadSolutionApproval---------Exception-----------");
			messages.add("messagesError", new ActionMessage("messages.error"));
			saveMessages(request, messages);
			return mapping.findForward("SolutionApproval");
		}
		logger.info("Returning from  SolutionApprovalAction doLoadSolutionApproval method,redirect to SolutionApproval page");
		return mapping.findForward("SolutionApproval");

	}

	public ActionForward updateSolutionStatus(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		logger.info("In SolutionApprovalAction-----updateStatus---------");
		messages = new ActionMessages();
		problemId = new int[100];
		SolutionApprovalForm SolutionApprovalform = (SolutionApprovalForm) form;
		String[] checkedProblemId = SolutionApprovalform.getSelectedProblemId();
		if (checkedProblemId.length == 0) {
			messages.add("messages", new ActionMessage("messages.atleastone"));
		}
		
		incount = 0;
		statusTemp = (String) request.getParameter("check");
		statusFinal = Integer.parseInt(statusTemp);
		for (String problemIdCount : checkedProblemId) {
			
			problemId[incount] = Integer.parseInt(problemIdCount);

			incount++;
		}

		
		try {
			update = solAppBO.updateSolutionStatus(problemId, statusFinal);
		} catch (SolutionApprovalUserDefinedExceptions e) {
		
			messages.add("messagesError", new ActionMessage("messages.error"));
			saveMessages(request, messages);
			return mapping.findForward("SolutionApproval");
		}
		catch(NullPointerException e)
		{
			messages.add("messagesError", new ActionMessage("messages.error"));
			saveMessages(request, messages);
		}
		if (update == true) {
			
			if (statusFinal == 1) {
				messages.add("messagesSuccess", new ActionMessage(
						"messages.approve"));

			} else {
				messages.add("messagesSuccess", new ActionMessage(
						"messages.reject"));

			}
			saveMessages(request, messages);
		} else {
			
			messages.add("messagesError", new ActionMessage("messages.fail"));
			saveMessages(request, messages);
		}
		logger.info("Retruning from SolutionApprovalAction-----updateStatus---------");
		return mapping.findForward("success");
	}
}