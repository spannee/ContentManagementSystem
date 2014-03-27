

/************************************************************************************
 * File:        SearchResultAction.java
 * Package:     com.igate.isr.actions
 * Desc:       SearchResult to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Buddha		       7-12-2010       Initial version
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


import com.igate.isr.bo.SearchResultBO;
import com.igate.isr.dto.SearchResultDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SearchResultSqlException;
import com.igate.isr.exception.SearchResultUserDefinedException;
import com.igate.isr.forms.SearchResultForm;
	
public class SearchResultAction extends DispatchAction{
	   
	public static final Logger logger=Logger.getLogger(SearchResultAction.class.getName());
	
public ActionForward doLoadTechnology(ActionMapping mapping, ActionForm form,  HttpServletRequest request, HttpServletResponse response)  {
		
	    logger.info("In SearchResultAction, doLoadTechnology method ");
	    //session is been set
		List<LabelValueBean> technodetls = null;
		ActionMessages messages = new ActionMessages();
		SearchResultForm searchresultForm=(SearchResultForm)form;
		
		SearchResultBO searchresultBo=new SearchResultBO();
		//technology names been loaded into the technodelts arraylist
		try{
			technodetls = searchresultBo.getTechnology();
			searchresultForm.setTechnoDetailsList(technodetls);
	
		  if(technodetls.isEmpty())
    		 {
    			
    			messages.add("msg", new ActionMessage("MESSAGES_TABLEEMPTY"));// If technologydetails list is empty corresponding error messages is added in action messages
    			saveMessages(request, messages);
    			logger.error("In SearchResultAction doLoadTechnology, table empty message is set");
    		 }
								
	
		  logger.info("Returning from SearchResultAction doLoadTechnology,redirect to ResultPage JSP");				 		 
		return mapping.findForward("Resultpage");
        }
		catch(SearchResultSqlException se)//connection loss error is caught
		{
			
			messages.add("msg", new ActionMessage("MESSAGES_CONNECTION"));
			saveMessages(request, messages);
			logger.error("In SearchResultAction doLoadTechnology, exception is caught");
			return mapping.findForward("Resultpage");

		} catch (AddProblemSolutionUserDefinedException e) {
			messages.add("msg", new ActionMessage("MESSAGES_CONNECTION"));
			saveMessages(request, messages);
			logger.error("In SearchResultAction doLoadTechnology, exception is caught");
			return mapping.findForward("Resultpage");
		}
 
	
	}
	
	public ActionForward doLoadSearchDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception, ClassNotFoundException, SearchResultUserDefinedException, SearchResultSqlException {
		
		logger.info("In SearchResultAction doLoadSearchDetails method ");
		ActionMessages msg = new ActionMessages();
		HttpSession session = request.getSession();
		SearchResultForm searchresultForm=(SearchResultForm)form;
		List<SearchResultDTO> searchList = new ArrayList<SearchResultDTO>();
		try{
		String techcode=searchresultForm.getSearchresultdto().getTechCode();
		String keyword=searchresultForm.getSearchresultdto().getKeyword();
		SearchResultBO searchresultBo=new SearchResultBO();
		SearchResultDTO searchresultDto=new SearchResultDTO();
		
		searchresultDto.setKeyword(keyword);
		searchresultDto.setTechCode(techcode);
		
		//search details by keyword or technology name or both is been loaded in an arraylist
		searchList = searchresultBo.searchDetails(searchresultDto);
		
				
		if(searchList.isEmpty())//checking for empty arraylist
		{
			msg.add("msg", new ActionMessage("errors.norecords"));
			saveMessages(request, msg);
		}
		}
		
		catch(SearchResultSqlException se)//connection loss error is caught
		{
			
			msg.add("msg", new ActionMessage("MESSAGES_CONNECTION"));
			saveMessages(request, msg);
			logger.error("In SearchResultAction doLoadSearchDetails, exception is caught");
			return mapping.findForward("Resultpage");

		}
		
		
		session.setAttribute("searchdetailsList", searchList);
		  logger.info("Returning from SearchResultAction doLoadSearchDetails,redirect to ResultPage JSP");	
		    return mapping.findForward("Resultpage");
		
	
 }
}