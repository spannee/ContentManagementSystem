

/************************************************************************************
 * File:        SearchPageAction.java
 * Package:     com.igate.isr.actions
 * Desc:        SearchPage to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subasri		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;





import java.sql.SQLException;




import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
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

import com.igate.isr.bo.SearchPageBO;
import com.igate.isr.bo.SearchResultBO;
import com.igate.isr.dto.CountDTO;
import com.igate.isr.dto.SearchResultDTO;


import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SearchPageUserDefinedException;
import com.igate.isr.exception.SearchResultSqlException;
import com.igate.isr.exception.SearchResultUserDefinedException;

import com.igate.isr.forms.SearchPageForm;
//import com.igate.isr.form.SearchPageForm;
import com.igate.isr.forms.SearchResultForm;





public class SearchPageAction extends DispatchAction {

	 final Logger logger = Logger.getLogger("SearchPageAction.class");
	
	/* Method to load all the existing technology names and their count*/
	public ActionForward doLoadTechnology(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) {
		
		
		
		logger.info("In SearchPageAction doLoadTechnology method");   
		ActionMessages messages = new ActionMessages();//Action Message Object is created to display message
	     List<LabelValueBean> technologydetails = null;
		 CountDTO countDTO=null;
		 SearchPageBO searchPageBO=new SearchPageBO();//SearchPageBO object is created to call the method in SearchPageBO
		 
		 SearchPageForm searchpageform = (SearchPageForm ) form;//SearchPageForm object is created to call the method in SearchPageForm
		
		  try{
			  technologydetails = searchPageBO.getTechnology();//SearchPageBO's getTechnology method is called and return value is assigned to a List called technologydetails
			  searchpageform.setTechnologyList(technologydetails);  //SearchPageForm's setTechnologyList method is called to set technologydetailslist 
			  countDTO = searchPageBO.getCount(); //SearchPageBO's getCount method is called and the return value is assigned to countdto object
	 		  searchpageform.setCountDTO(countDTO);//SearchPageForm's setCountdto method is called to set the countdto
	 		
	 		  if(technologydetails.isEmpty())
	      		 {
	      		
	      			messages.add("msgEmpty", new ActionMessage("MESSAGES_TABLEEMPTY"));// If technologydetails list is empty corresponding error messages is added in action messages
	      			saveMessages(request, messages);
	      			logger.error("In SearchPageAction doLoadTechnology, table empty message is set");
	      		 }
	 		     searchpageform.resetForm();
	 		     logger.info("Returning from SearchPageAction doLoadTechnology,redirecting to Searchpage JSP");
	      		 return mapping.findForward("Searchpage");
			
		}
		catch(SearchPageUserDefinedException se)
		{
			logger.error("In SearchPageAction doLoadTechnology,SearchPageUserDefinedException is caught");
			messages.add("msgConnect", new ActionMessage("MESSAGES_CONNECTION"));//SearchPageUserDefinedException is caught and the corresponding error message is added in action  messages
			saveMessages(request, messages);
			return mapping.findForward("Searchpage");

		} 
		 
				
		
	}
	/* Method to search the solution by entering the corresponding keyword or selecting the technology*/
	public ActionForward searchSolution(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,HttpServletResponse response) throws SQLException, ClassNotFoundException, SearchResultUserDefinedException, SearchResultSqlException, AddProblemSolutionUserDefinedException, NamingException
			{
         String techCode,keyword;
		logger.info("In SearchPageAction, searchSolution method ");
		
		ActionMessages msg = new ActionMessages();
		HttpSession session = request.getSession();
		SearchResultForm searchresultForm=(SearchResultForm)form;
		techCode=searchresultForm.getSearchresultdto().getTechCode();
		keyword=searchresultForm.getSearchresultdto().getKeyword();
		SearchResultBO searchResultBO=new SearchResultBO();
		SearchResultDTO searchResultDTO=new SearchResultDTO();
		ActionMessages messages = new ActionMessages();
		searchResultDTO.setKeyword(keyword);
		searchResultDTO.setTechCode(techCode);
		List<SearchResultDTO> searchList = new ArrayList<SearchResultDTO>();
		//search details by keyword or technology name or both is been loaded in an arraylist
		
		try
		{
		
			searchList = searchResultBO.searchDetails(searchResultDTO);
		}
		
		catch(SearchResultSqlException se)
		{
			logger.error("In SearchPageAction searchSolution,SearchPageUserDefinedException is caught");
			messages.add("msgConnect", new ActionMessage("MESSAGES_CONNECTION"));//SearchPageUserDefinedException is caught and the corresponding error message is added in action  messages
			saveMessages(request, messages);
			
			return mapping.findForward("Searchpage");

		}
		


		if(searchList.isEmpty()){//checking for empty arraylist{
			msg.add("msg", new ActionMessage("errors.norecords"));
			saveMessages(request, msg);
		}
			session.setAttribute("searchdetailsList", searchList);
			 logger.info("Returning from SearchPageAction searchSolution,redirect to SearchResult page");
			 return mapping.findForward("Resultpage");
		}
	
 }
