/************************************************************************************
 * File:        SearchPageDAO.java
 * Package:     com.igate.isr. dao
 * Desc:        SearchPage to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subasri		       9-12-2010       Initial version
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

import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.CountDTO;
import com.igate.isr.exception.SearchPageUserDefinedException;

public class SearchPageDAO {
	final Logger logger = Logger.getLogger(" SearchPageDAO.class");
	Connection connection=null;
	
	/*Method to get the technology names*/
public List<LabelValueBean> getTechnology() throws SQLException, ClassNotFoundException, NamingException, NullPointerException, SearchPageUserDefinedException{
	
	logger.info("In SearchPageDAO getTechnology method");
	List<LabelValueBean> techdetails = new ArrayList<LabelValueBean>();//techdetails list is created to add the technology names in the list
	ResultSet techDetailsResultSet=null;
	PreparedStatement techDetailsPstmt = null;
		
	try{
			
			
			DBConnection dbconnection=new DBConnection();//DBConnection object is created to call the getConnection method
			connection=dbconnection.getConnection();//DBCOnnection's getConnection method is called to establish a connection
			
			String sqlQuery = null;
			logger.info("Select initcap(technology_name),technology_code from technology_master_details order by technology_name asc");
	        sqlQuery = "Select initcap(technology_name),technology_code from technology_master_details order by technology_name asc";
	        techDetailsPstmt = connection.prepareStatement(sqlQuery);//SQL Query for getting technology names is prepared
	        techDetailsResultSet = techDetailsPstmt.executeQuery();//SQL Query is executed and assigned to result set
	        while (techDetailsResultSet.next()) {
	        	        	 
	        	    LabelValueBean labelvaluebean = new LabelValueBean(); //LabelValueBean object is created and it is used to pass the techcode when the user selects the technames
	           	    labelvaluebean.setValue((techDetailsResultSet.getString("technology_code")));
	        	    labelvaluebean.setLabel(techDetailsResultSet.getString(1));
					techdetails.add(labelvaluebean);//LabelValueBean object is added to the techdetails list
				
	         	}
	       
	         
		}
		catch(SQLException se){
	   	 logger.error("SQLException SearchPage technology details: "+se.getMessage());
	   	 throw se;
	   	 
	    }
		finally{
			
			 if(connection!=null){
			    connection.close();
			   }
			 if(techDetailsResultSet!=null){   
			    techDetailsResultSet.close();
			   }
			 if(techDetailsPstmt!=null){   
		         techDetailsPstmt.close();
			   }
		}
		logger.info("Technology details are returned to SearchBO class getTechnology method");
		return techdetails;
		
}


/* Method to get the count of technology names and the count of solutions*/
public CountDTO getCount() throws  ClassNotFoundException, NullPointerException, NamingException, SQLException, SearchPageUserDefinedException {
	// TODO Auto-generated method stub
	logger.info("In SearchPageDAO getCount method");
	CountDTO countDTO=new CountDTO();//CountDTO Object is created to call the setter methods
	PreparedStatement techCountPstmt = null;
	PreparedStatement solCountPstmt = null;
	ResultSet solCountResultSet =null;
	ResultSet techCountResultSet =null;
	
	try
	{
		
		DBConnection dbconnection=new DBConnection();
		connection=dbconnection.getConnection();//DBConnection object is created to call the getConnection method
		String sqlQuery = null;
		String sqlQuery1 = null;
		logger.info("Select count(technology_name) from technology_master_details");
		sqlQuery = "Select count(technology_name) from technology_master_details";
		
		logger.info("Select count(solution) from solution_repository where status='Approved'");
	    sqlQuery1 = "Select count(solution) from solution_repository where status='Approved'";
	    techCountPstmt =connection.prepareStatement(sqlQuery);//SQL Query for getting the count of technology names is prepared
	 	techCountResultSet = techCountPstmt.executeQuery();//SQL Query for getting the count of technology names is executed and assigned to result set
	   	solCountPstmt=connection.prepareStatement(sqlQuery1);//SQL Query for getting the count of solutions is prepared
        solCountResultSet = solCountPstmt.executeQuery();//SQL Query for getting the count of solutions is executed and assigned to result set
	   
	    while (solCountResultSet.next()) 
        {
        	countDTO.setSolutionCount(solCountResultSet.getInt(1));//Countdto's setSolutionCount method is called to set the solution count
        }
       
      while (techCountResultSet.next()) 
	       {
	         countDTO.setTechCount(techCountResultSet.getInt(1));//Countdto's setTechCount method is called to set the tech count
		         
	        }
	        
	     connection.commit();
	}
	catch(SQLException se){
	   	 logger.error("SQLException  SearchPage getCount: "+se.getMessage());
	   	 throw se;
	   	 
	    }
	
	finally{
		
		if(connection!=null) {	
		   connection.close();
		  }
		if(solCountResultSet!=null){	
		   solCountResultSet.close();
		  }
		if(solCountPstmt!=null){
	       solCountPstmt.close();
		  }
		if(techCountResultSet!=null){		
		
		  techCountResultSet.close();
		}
		
		if(techCountPstmt!=null){	
	    	techCountPstmt.close();
		}
		
	}
	logger.info("CountDTO is returned to SearchBO class getCount method");
	return countDTO;
}
}
	
