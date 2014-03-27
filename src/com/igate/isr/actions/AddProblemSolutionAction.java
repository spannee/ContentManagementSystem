/************************************************************************************
 * File:        AddProblemSolutionAction.java
 * Package:     com.igate.isr.actions
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Jawahar		       7-12-2010       Initial version
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
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.bo.AddProblemSolutionBO;
import com.igate.isr.dto.ProblemSolutionDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.forms.AddProblemSolutionForm;

public class AddProblemSolutionAction extends DispatchAction {

	public static final Logger logger = Logger
			.getLogger(AddProblemSolutionAction.class.getName());

	/*
	 * Logger object is created for AddProblemSolutionAction class
	 */

	public ActionForward doLoadTechnology(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)  
	/*
	 * doLoadTechnology method gets the technologyList from AddProblemSolutionBO
	 * class and sets them in AddProblemSolutionForm Object
	 */
	{
		
		logger.info("Inside AddProblemSolutionAction class,doLoadTechnology method");
		
		ActionMessages msg = new ActionMessages();
		AddProblemSolutionBO addProblemSolutionBo = new AddProblemSolutionBO();
		AddProblemSolutionForm tech = (AddProblemSolutionForm) form;
		List<LabelValueBean> technologyList = new ArrayList<LabelValueBean>();
		try {
			
			technologyList = addProblemSolutionBo.getTechnology();
			
			tech.setTechnologyList(technologyList);
			if (technologyList.isEmpty())/* Checking if technologyList is empty */
			{
				
				msg.add("emptyTechList", new ActionMessage(
						"messages.emptyTechnologyList"));

			}
		} catch (AddProblemSolutionUserDefinedException e) {
			
			logger.error("Execption is caught in AddProblemSolutionAction class,doLoadTechnology method");
			msg.add("connectionError", new ActionMessage("messages.dbConnection"));
			saveMessages(request, msg);
			
			return mapping.findForward("loadAddProblemSolution");
		}

		saveMessages(request, msg);
		logger.info("Returning from doLoadTechnology AddProblemSolutionAction,redirect to AddProblemSolutionLoader Page");
		return mapping.findForward("loadAddProblemSolution");
	}

	public ActionForward doAddProblemSolution(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ClassNotFoundException
	/*
	 * doAddProblemSolution method sets the AddProblemSolutionForm Object in a
	 * ProblemSolutionDTO object and passes to AddProblemSolutionBO class and
	 */
	{

		HttpSession session = request.getSession();
		logger
				.info("Inside AddProblemSolutionAction class,doAddProblemSolution method");
		
		ActionMessages msg = new ActionMessages();
		
		AddProblemSolutionBO addProblemSolutionBo = new AddProblemSolutionBO();
		
		AddProblemSolutionForm addProbSolForm = (AddProblemSolutionForm) form;
		
		/* Getting the Form objects from AddProblemSolution page */
		String techcode = addProbSolForm.getProblemSolutionDto().getTechCode();
		String problem = addProbSolForm.getProblemSolutionDto().getProblem();
		String solution = addProbSolForm.getProblemSolutionDto().getSolution();
		String keyword = addProbSolForm.getProblemSolutionDto().getKeyword();
		
		ProblemSolutionDTO problemSolutionDto = new ProblemSolutionDTO();
		
		String empId = (String) session.getAttribute("EmpId");
		/* Setting the values in the ProblemSolutionDTO object */
		problemSolutionDto.setEmpID(empId);
		problemSolutionDto.setTechCode(techcode);
		problemSolutionDto.setProblem(problem);
		problemSolutionDto.setSolution(solution);
		problemSolutionDto.setKeyword(keyword);
		boolean status;
		try {

			status = addProblemSolutionBo
					.addProblemSolution(problemSolutionDto);
			if (status == false)/* Checking the status of insert statement */
			{
				
				msg.add("submitFailure", new ActionMessage(
						"messages.addProbSolFailure"));
				saveMessages(request, msg);
				return mapping.findForward("loadAddProblemSolution");
			}
			if (status == true) {
				
				msg.add("submitSuccess", new ActionMessage(
						"messages.addProbSolSuccess"));
				saveMessages(request, msg);
				addProbSolForm.resetForm();
				return mapping.findForward("addProblemSolution");
			}
		} catch (AddProblemSolutionUserDefinedException e) {

			
			logger.error("Exception is caught in AddProblemSolutionAction class,doAddProblemSolution method");
			msg.add("databaseError", new ActionMessage("messages.dbError"));

			saveMessages(request, msg);
			
			return mapping.findForward("loadAddProblemSolution");
		} 
		saveMessages(request, msg);
		logger.info("Returning from doAddProblemSolution AddProblemSolutionAction,redirect to AddProblemSolution Page");
		return mapping.findForward("addProblemSolution");
	}
}
