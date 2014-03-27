
/************************************************************************************
 * File:        SearchResultDAO.java
 * Package:     com.igate.isr. dao
 * Desc:       SearchResult to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Buddha		       9-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.actions.SearchResultAction;

import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.SearchResultDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SearchResultSqlException;
import com.igate.isr.exception.SearchResultUserDefinedException;

public class SearchResultDAO {
	
	public static final Logger logger=Logger.getLogger(SearchResultAction.class.getName());

	Connection connection = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
  
	public List<SearchResultDTO> searchDetails(SearchResultDTO searchresultDto)
	throws SQLException,ClassNotFoundException,  SearchResultSqlException, AddProblemSolutionUserDefinedException, NamingException {
		
		logger.info("Reached searchDetails in DAO");
		connection = DBConnection.getDbConnection().getConnection();
    
		List<SearchResultDTO> searchdetailslist=new ArrayList<SearchResultDTO>();  
   
		try {
			//values are taken from form and assigned to variables   	
			String keyword=searchresultDto.getKeyword().toLowerCase().trim();
			String techcode=searchresultDto.getTechCode();
			String empty="";
			String select="--Select--";
			//if both keyword and technology name is specified
			if(!(keyword.equals(empty)))
				{    		 
				if(!(techcode.equals(select)))
				{    
    			    logger.info("SQLQuery:SELECT data.Problem_statement,data.Solution, initcap(tech.Technology_Name) FROM Solution_Repository data, Technology_Master_Details tech WHERE data.Technology_Code =  tech.Technology_Code AND data.keyword like %keyword+% AND data.technology_code=+techcode+ AND data.status=Approved");			  
					preparedStatement = connection.prepareStatement("SELECT data.Problem_statement,data.Solution, initcap(tech.Technology_Name) FROM Solution_Repository data, Technology_Master_Details tech WHERE data.Technology_Code =  tech.Technology_Code AND data.keyword like '%"+keyword+"%' AND data.technology_code='"+techcode+"' AND data.status='Approved'");
					resultSet = preparedStatement.executeQuery();
			  
					while (resultSet.next()) {
				 				
						SearchResultDTO searchresultdto = new SearchResultDTO();
						searchresultdto.setProblem(resultSet.getString(1));
						searchresultdto.setSolution(resultSet.getString(2));
						searchresultdto.setTechName(resultSet.getString(3));
						searchdetailslist.add(searchresultdto);//respective search results been loaded in the arraylist from ResultSet
			     
						}
				}
			  } 
			//if only technology name is selected
			if(keyword.equals(empty))
				{	 
				if(!(techcode.equals(select)))   
					{
 				    //logger.info("SELECT data.Problem_statement,data.Solution,initcap( tech.Technology_Name) FROM Solution_Repository data, Technology_Master_Details tech WHERE data.Technology_Code =  tech.Technology_Code AND data.technology_code=+techcode+ AND data.status=Approved);
					preparedStatement= connection.prepareStatement("SELECT data.Problem_statement,data.Solution,initcap( tech.Technology_Name) FROM Solution_Repository data, Technology_Master_Details tech WHERE data.Technology_Code =  tech.Technology_Code AND data.technology_code='"+techcode+"' AND data.status='Approved'");
					resultSet = preparedStatement.executeQuery();
 	   		 
					while (resultSet.next()) {
 		    	 
						SearchResultDTO searchresultdto = new SearchResultDTO();
						searchresultdto.setProblem(resultSet.getString(1));
						searchresultdto.setSolution(resultSet.getString(2));
						searchresultdto.setTechName(resultSet.getString(3));
						searchdetailslist.add(searchresultdto);//respective search results been loaded in the arraylist from ResultSet	
 		         
					}
					}
				}
			//if only keyword is entered
			if(!(keyword.equals(empty)))
			{
				if(techcode.equals(select))
    		 		{ 
    			  	
					preparedStatement = connection.prepareStatement("SELECT data.problem_statement,data.solution,initcap(tech.technology_name) FROM solution_repository data,technology_master_details tech WHERE data.technology_code=tech.technology_code AND data.keyword like '%"+keyword+"%' AND data.status='Approved'");
					resultSet = preparedStatement.executeQuery();
	         
					while (resultSet.next()) {
	        	 
						SearchResultDTO searchresultdto = new SearchResultDTO();
						searchresultdto.setProblem(resultSet.getString(1));
						searchresultdto.setSolution(resultSet.getString(2));
						searchresultdto.setTechName(resultSet.getString(3));
						searchdetailslist.add(searchresultdto);//respective search results been loaded in the arraylist from ResultSet
	        	 
					}
    		 		}
			}  	 
		}
		
		catch(SQLException se){
		   	 logger.error("SQLException Searchresult technology details: "+se.getMessage());
		   	 throw se;
		   	 
		    }
		finally
		{
			
			  //connection is been closed
			if(resultSet!=null){
				resultSet.close();
			}
			if(preparedStatement!=null){
				preparedStatement.close();
			}
			if(connection!=null){
				 connection.close();
			}
					
		}
		logger.info("SearchDetailslist is returned to SearchResultBO class");
		return searchdetailslist;
    	}
	
	

	public List<LabelValueBean> getTechnology() throws SQLException,ClassNotFoundException,SearchResultSqlException, AddProblemSolutionUserDefinedException, NamingException{
		
		logger.info("Reached getTechnology in DAO");
		
		List<LabelValueBean> techdetls = new ArrayList<LabelValueBean>();
		  //DBConnection dbconnection=new DBConnection();
		connection = DBConnection.getDbConnection().getConnection();//connection established
		logger.debug("Reached getTechnology in DAO");
		try
		{
		
		 preparedStatement = connection.prepareStatement("SELECT initcap(technology_name),technology_code FROM technology_master_details ORDER BY technology_name");
		 resultSet = preparedStatement.executeQuery();
		
		 while (resultSet.next()) {
			
			LabelValueBean labelValueBean = new LabelValueBean();
			labelValueBean.setValue(resultSet.getString("technology_code"));
			labelValueBean.setLabel(resultSet.getString(1));
			techdetls.add(labelValueBean);//respective search results been loaded in the arraylist from ResultSet
			
		 }

	    }
		catch(SQLException se){
		   	 logger.error("SQLException Searchresult technology details: "+se.getMessage());
		   	 throw se;
		   	 
		    }
		finally
		{
			  //jdbc objects been closed
			if(resultSet!=null){
				resultSet.close();
			}
			if(preparedStatement!=null){
				preparedStatement.close();
			}
			if(connection!=null){
				 connection.close();
			}
	
		}
		logger.info("TechnologyDetailslist is returned to SearchResultBO class");
		return techdetls;
	}
}
