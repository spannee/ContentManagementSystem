
/************************************************************************************
 * File:        SearchPageBO.java
 * Package:     com.igate.isr. bo
 * Desc:        SearchPage to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subasri		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;



import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.dao.SearchPageDAO;
import com.igate.isr.dto.CountDTO;


import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SearchPageUserDefinedException;



public class SearchPageBO {
	final Logger logger = Logger.getLogger(" SearchPageBO.class");
	SearchPageDAO searchPageDAO=new SearchPageDAO();//SearchPageDAO object is created to call the methods in searchpagedao
		
	/* Method to get the technology that are returned from SearchPageDAO*/
	public List<LabelValueBean> getTechnology() throws  SearchPageUserDefinedException{
		logger.info("In SearchPageBO getTechnologyList method  "); 
		List<LabelValueBean> techdetails;
		try{
		
		 
		techdetails=searchPageDAO.getTechnology();//SearchPageDAO  getTechnology method is called and the return value is assigned to techdetails list
				
		}
		
		catch(NullPointerException ne){
			logger.error("In SearchPageBO class  raised NullPointerException");
			throw new SearchPageUserDefinedException();
		}
		catch(SQLException se){
			logger.error("In SearchPageBO class  raised SQLException");
			throw new SearchPageUserDefinedException();
		}
		catch(NamingException ne){
			logger.error("In SearchPageBO class  raised NamingException");
			throw new SearchPageUserDefinedException();
		}
		catch (ClassNotFoundException e) {
			logger.error("In SearchPageBO class  raised NamingException");
			throw new SearchPageUserDefinedException();
		}
		logger.info("From SearchPageBO, technologydetails is returned to doLoadTechnology method of SeacrhPageAction Class");
	    return techdetails;
	   
	}
	
	/* Method to count the technology and the solution  */
	public CountDTO getCount()  throws  SearchPageUserDefinedException{
		CountDTO countDTO=new CountDTO();
		logger.info("In SearchPageBO getCount method  ");
		try{
		
		//CountDTO object is created to get the return value of SearchPageDAO's getCount method
	    countDTO=searchPageDAO.getCount();//SearchPageDAO's getCount method is called and return value is assigned to countdto
	  
		
		}
		catch(NullPointerException ne){
			logger.error("In SearchPageBO class  raised NullPointerException");
			throw new SearchPageUserDefinedException();
		}
		catch(SQLException se){
			logger.error("In SearchPageBO class  raised SQLException");
			throw new SearchPageUserDefinedException();
		}
		catch(NamingException ne){
			logger.error("In SearchPageBO class  raised NamingException");
			throw new SearchPageUserDefinedException();
		}
		catch (ClassNotFoundException e) {
			logger.error("In SearchPageBO class  raised NamingException");
			throw new SearchPageUserDefinedException();
		} 
		logger.info("From SearchPageBO getCount method,countdto is returned to doLoadTechnology method of SeacrhPageAction Class");
	  return countDTO;
	}

}
