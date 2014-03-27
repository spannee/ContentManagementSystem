

/************************************************************************************
 * File:        viewAndAddTechnologyAction.java
 * Package:     com.igate.isr.actions
 * Desc:       viewAndAddTechnologysolution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Santhosh		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.igate.isr.dto.ViewAndAddTechnologyDTO;
import com.igate.isr.exception.AddFailureException;
import com.igate.isr.exception.DBConnectionException;
import com.igate.isr.exception.PrimaryKeyException;
import com.igate.isr.exception.ViewFailureException;
import com.igate.isr.forms.ViewAndAddTechnologyForm;
import com.igate.isr.bo.ViewAndAddTechnologyBO;

public class ViewAndAddTechnologyAction extends DispatchAction{
		
	ViewAndAddTechnologyBO viewAndAddTechnologyBO = new ViewAndAddTechnologyBO();     /*BO object created*/	 	
	public static final Logger logger=Logger.getLogger(ViewAndAddTechnologyAction.class.getName());
	
	/*
	 *  Method to load the existing technologies
	 * */
	public ActionForward doLoadTechnology(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {   
		// TODO Auto-generated method stub
		logger.info("In ViewAndAddTechnologyAction doLoadTechnology method");
		ActionMessages msg=new ActionMessages();
		HttpSession session = request.getSession();
		ViewAndAddTechnologyForm viewAndAddTechnologyForm =(ViewAndAddTechnologyForm)form;     /*Form object created*/	
		try{
			List<ViewAndAddTechnologyDTO> technologyList = new ArrayList<ViewAndAddTechnologyDTO>();    /*ArrayList initialized*/
			technologyList = viewAndAddTechnologyBO.getTechnologyDetails();    /*Method of BO class which returns the ArrayList containing the Technology details called*/
		
			session.setAttribute("technologyList",technologyList);     /*session containing the ArrayList is set*/
		}catch(ViewFailureException vfe){     /*Exception caught which is thrown from BO class in case the ArrayList is empty*/
			logger.error("Exception is caught in ViewAndAddTechnologyAction doLoadTechnology method");
			msg.add("msgViewFailure",new ActionMessage("errors.viewFailure"));
			saveMessages(request,msg);
		}catch(DBConnectionException dce){     /*Exception caught which is thrown from DBConnection class in case there is no Database connection*/
			logger.error("Exception is caught in ViewAndAddTechnologyAction doLoadTechnology method");
			msg.add("msgDBFailure",new ActionMessage("errors.dbConnectionFailure"));
			saveMessages(request,msg);
		}
		logger.info("Returning from ViewAndAddTechnologyAction doLoadTechnology method,redirect to ViewAdndAddTechnology page");
		viewAndAddTechnologyForm.resetForm();
		return mapping.findForward("view");
	}
	
	/* 
	 * Method to add a new Technology
	 * */	
	public ActionForward addTechnology(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub
		
		logger.info("In ViewAndAddTechnologyAction addTechnology method ");
		ActionMessages msg = new ActionMessages();
		ViewAndAddTechnologyDTO viewAndAddTechnologyDTO = new ViewAndAddTechnologyDTO();      /*DTO object created*/
		
		String techName;
		
		boolean status;
		ViewAndAddTechnologyForm viewAndAddTechnologyForm =(ViewAndAddTechnologyForm)form;     /*Form object created*/	
		try{
			
			techName = viewAndAddTechnologyForm.viewAndAddTechnologyDTO.getTechnologyName();
			
			viewAndAddTechnologyDTO.setTechnologyName(techName);			/*Technology Name input is set*/
										
			status = viewAndAddTechnologyBO.addTechnology(viewAndAddTechnologyDTO);     /*Method of BO class which returns a boolean value*/
		
			if(status){
				msg.add("msgSuccess",new ActionMessage("messages.addSuccess"));
				saveMessages(request,msg);
				
			}
		}catch(AddFailureException afe){   /*Exception caught which is thrown from BO class in case the boolean method of BO returns a boolean value*/
			logger.error("Exception is caught in ViewAndAddTechnologyAction addTechnology method");
			msg.add("msgFailure",new ActionMessage("errors.failure"));
			saveMessages(request,msg);
		}catch(DBConnectionException dce){   /*Exception caught which is thrown from DBConnection class in case there is no Database connection*/
			logger.error("Exception is caught in ViewAndAddTechnologyAction addTechnology method");
			msg.add("msgDBFailure",new ActionMessage("errors.dbConnectionFailure"));
			saveMessages(request,msg);
		}catch(PrimaryKeyException afe){  /*Exception caught which is thrown from BO class in case there is a PrimaryKey Constraint*/
			logger.error("Exception is caught in ViewAndAddTechnologyAction addTechnology method");
			msg.add("msgPKFailure",new ActionMessage("errors.pkInsertionFailure"));
			saveMessages(request,msg);
		}
		logger.info("Returning from ViewAndAddTechnologyAction  addTechnology method,redirect to ViewAdndAddTechnology page");
		viewAndAddTechnologyForm.resetForm();
		return mapping.findForward("insert");
	}

}
