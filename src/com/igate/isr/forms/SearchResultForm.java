package com.igate.isr.forms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.actions.SearchResultAction;
import com.igate.isr.dto.CountDTO;
import com.igate.isr.dto.SearchResultDTO;

@SuppressWarnings("deprecation")
public class SearchResultForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final Logger logger=Logger.getLogger(SearchResultAction.class.getName());
	private SearchResultDTO searchresultdto = new SearchResultDTO();
	public CountDTO countdto=new CountDTO();//CountDTO object is created to get and set the countdto
	public List<LabelValueBean> technologyList=new ArrayList<LabelValueBean>();//TechnologyDetails list is created to get and set the technologydetailslist
public List<LabelValueBean> technoDetailsList=new ArrayList<LabelValueBean>();//TechnologyDetails list is created to get and set the technologydetailslist
	
	/*Method to set the technology list*/
	
	public void setTechnoDetailsList(List<LabelValueBean> techlist)
	{
		technoDetailsList=techlist;
	}
	/*Method to get the technology list*/
	public List<LabelValueBean> getTechnoDetailsList()
	{
		return technoDetailsList;
	}
	private List<SearchResultDTO> searchdetailslist = new ArrayList<SearchResultDTO>();
	
	public SearchResultDTO getSearchresultdto() {
		return searchresultdto;
	}
	public void setSearchresultdto(SearchResultDTO searchresultdto) {
		this.searchresultdto = searchresultdto;
	}
	public List<SearchResultDTO> getSearchdetailslist() {
		return searchdetailslist;
	}
	public void setSearchdetailslist(List<SearchResultDTO> searchdetailslist) {
		this.searchdetailslist = searchdetailslist;
	}
	/*Method to set the technology list*/
	
	public void setTechnologyList(List<LabelValueBean> techlist)
	{
		technologyList=techlist;
	}
	/*Method to get the technology list*/
	public List<LabelValueBean>getTechnologyList()
	{
		return technologyList;
	}
	/*Method to set the countdto*/
	public void setCountdto(CountDTO countdto) {
		logger.info("In SearchPageForm setCdto method");
		this.countdto = countdto;
	}
	/*Method to get the countdto*/
	public CountDTO getCountdto() {
		logger.info("In SearchPageForm getCdto method");
		return countdto;
	}
	
	/*Method to validate the keyword and the technology names*/
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		try {
		    logger.info("In SearchPageForm validate method");
			ActionErrors errors = new ActionErrors();//ActionError object is created to add the errors
			
			Pattern keywordPattern = Pattern.compile("^[A-za-z ]{1,20}$");//Keyword is validated using regular expression
			
			Matcher keywordMatcher =keywordPattern.matcher(searchresultdto.getKeyword());
			
       			 if((searchresultdto.getKeyword()=="") && (searchresultdto.getTechCode().equals("--Select--")))
				  {
					 errors.add("errors", new ActionError("errors.Empty"));
				  }
				
       			 else if((searchresultdto.getTechCode().equals("--Select--")))
       					{
       			              if (!keywordMatcher.find()) {
						          errors.add("errors", new ActionError("errors.InvalidKeyword"));
				
			                     }

       					}

			return errors;
		}
		catch (NullPointerException e) {
			 
			
			
		}
		return null;
	}
	
	
	
}
