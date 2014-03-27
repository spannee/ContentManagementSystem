package com.igate.isr.forms;

import java.util.ArrayList;


import java.util.List;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;



import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.dto.CountDTO;
import com.igate.isr.dto.SearchPageDTO;


@SuppressWarnings("deprecation")
public class SearchPageForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	public SearchPageDTO searchPageDTO=new SearchPageDTO();//SearchPageDTO object is created to get and set the searchpagedto
	public CountDTO countDTO=new CountDTO();//CountDTO object is created to get and set the countdto
	public List<LabelValueBean> technologyList=new ArrayList<LabelValueBean>();//TechnologyDetails list is created to get and set the technologydetailslist
	
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
	/*Method to set the searchpagedto*/
	public void setSearchPageDTO(SearchPageDTO searchpagedto)
	{
		
		this.searchPageDTO = searchpagedto;
	}
	/*Method to get the searchpagedto*/
	public SearchPageDTO getSearchPageDTO()
	{
		
		return searchPageDTO;
	}
	/*Method to set the countdto*/
	public void setCountDTO(CountDTO countdto) {
		
		this.countDTO = countdto;
	}
	/*Method to get the countdto*/
	public CountDTO getCountDTO() {
	
		return countDTO;
	}
	/*Method to validate the keyword and the technology names*/
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		   try{
			ActionErrors errors = new ActionErrors();//ActionError object is created to add the errors
			
			Pattern keywordPattern = Pattern.compile("^[A-za-z ]{1,20}$");//Keyword is validated using regular expression
			
			Matcher keywordMatcher =keywordPattern.matcher(searchPageDTO.getKeyword());
			
       			 if((searchPageDTO.getKeyword()=="") && (searchPageDTO.getTechCode().equals("--Select--")))
				  {
					 errors.add("errors", new ActionError("ERRORS_EMPTY"));
				  }
				
       			 else if((searchPageDTO.getTechCode().equals("--Select--")))
       					{
       			 
       				            if(searchPageDTO.getKeyword().length()>20)
       				            {
       				             errors.add("errors", new ActionError("ERRORS_MAXKEYWORD"));
       				            }
       				 
       				           else if (!keywordMatcher.find()) {
						          errors.add("errors", new ActionError("ERRORS_INVALIDKEYWORD"));
				
			                     }
       				         return errors;
       					}
		   }
		   catch (NullPointerException e) {
			   return null;
			}
		return null;

			
		
		
		
	}
	public void resetForm(){
		searchPageDTO.setKeyword(null);
		searchPageDTO.setTechCode(null);
		searchPageDTO.setTechName(null);
	}
	 
	
	}

