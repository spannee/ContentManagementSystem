/************************************************************************************
 * File:        SearchResultBO.java
 * Package:     com.igate.isr. bo
 * Desc:       SearchResult to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Buddha		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.actions.SearchResultAction;
import com.igate.isr.dao.SearchResultDAO;
import com.igate.isr.dto.SearchResultDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SearchPageUserDefinedException;
import com.igate.isr.exception.SearchResultSqlException;
import com.igate.isr.exception.SearchResultUserDefinedException;

public class SearchResultBO {
	
	public static final Logger logger=Logger.getLogger(SearchResultAction.class.getName());
	SearchResultDAO searchresultDao = new SearchResultDAO();

	public List<SearchResultDTO> searchDetails(SearchResultDTO searchresultDto) throws  SearchResultSqlException, AddProblemSolutionUserDefinedException  {
		
		logger.info(" In SearchResultBO searchDetails method ");
		 List<SearchResultDTO> searchDetailsList=new ArrayList();
		try{
			 
  	     searchDetailsList = searchresultDao.searchDetails(searchresultDto);
		}
		catch(NullPointerException ne){
			logger.error("logger object  in SearchResultBO class  raised NullPointerException");
			throw new SearchResultSqlException();
		}
		catch(SQLException se){
			logger.error("logger object  in SearchResultBO class  raised SQLException");
			throw new SearchResultSqlException();
		}
		catch(NamingException ne){
			logger.error("logger object  in SearchResultBO class  raised NamingException");
			throw new SearchResultSqlException();
		} 
		catch (ClassNotFoundException e) {
			logger.error("logger object  in SearchResultBO class  raised ClassNotFoundException");
			throw new SearchResultSqlException();
		}
		logger.info("From SearchReultBO,searchdetails list is returned to SeacrhResultAction Class");
		return searchDetailsList;
	}

	public List<LabelValueBean> getTechnology() throws  SearchResultSqlException, AddProblemSolutionUserDefinedException{
		
		logger.info("In SearchResultBO, getTechnologyDetails ");
		List<LabelValueBean> techdetails=new ArrayList<LabelValueBean>();
		try{
			techdetails=searchresultDao.getTechnology();
		if(techdetails.isEmpty()){
			throw new SearchResultSqlException();
		}
	}
		
		catch(NullPointerException ne){
			logger.error("logger object  in SearchResultBO class  raised NullPointerException");
			throw new SearchResultSqlException();
		} catch (SQLException e) {
			logger.error("logger object  in SearchResultBO class  raised NullPointerException");
			throw new SearchResultSqlException();
		} catch (ClassNotFoundException e) {
			logger.error("logger object  in SearchResultBO class  raised NullPointerException");
			throw new SearchResultSqlException();
		} catch (NamingException e) {
			logger.error("logger object  in SearchResultBO class  raised NullPointerException");
			throw new SearchResultSqlException();
		}
		logger.info("From SearchReultBO,technologydetails list is returned to SeacrhResultAction Class");
		return techdetails;
	}
}
