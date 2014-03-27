/************************************************************************************
 * File:        viewAndAddTechnologyDAO.java
 * Package:     com.igate.isr. dao
 * Desc:       viewAndAddTechnologysolution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Santhosh		       9-12-2010       Initial version
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

import com.igate.isr.actions.ViewAndAddTechnologyAction;
import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.ViewAndAddTechnologyDTO;

public class ViewAndAddTechnologyDAO {
	
	public static final Logger logger=Logger.getLogger(ViewAndAddTechnologyAction.class.getName());
	String query1;
	String query2;
	
	/*
	 * Method to load the existing technologies
	 * */
	
	public List<ViewAndAddTechnologyDTO> getTechnologyDetails() throws ClassNotFoundException, SQLException, NullPointerException, NamingException {
		
		logger.info("Reached doLoadTechnology in ViewAndAddTechnologyDAO");
		Connection connection =DBConnection.getDbConnection().getConnection();   /*Connection object created*/
		logger.info("SQLQuery:SELECT technology_name,technology_code,to_char(date_added) FROM technology_master_details ORDER BY technology_name");
		query1 = "SELECT technology_name,technology_code,to_char(date_added) FROM technology_master_details ORDER BY technology_name";

		List<ViewAndAddTechnologyDTO> technologyList = new ArrayList<ViewAndAddTechnologyDTO>(); /*ArrayList initialized*/
		ResultSet technologySet = null;
		PreparedStatement loadTechnologyPS = null;
		
		try{
			loadTechnologyPS = connection.prepareStatement(query1);    /*Object created for PreparedStatement*/
			
			technologySet = loadTechnologyPS.executeQuery();   /*SQL query for loading the existing technologies executed*/
			ViewAndAddTechnologyDTO viewAndAddTechnologyDTO;    /*DTO Object created*/
			while(technologySet.next()){
				viewAndAddTechnologyDTO = new ViewAndAddTechnologyDTO();
				viewAndAddTechnologyDTO.setTechnologyName(technologySet.getString(1));
				viewAndAddTechnologyDTO.setTechnologyCode(technologySet.getString("technology_code"));
				viewAndAddTechnologyDTO.setDateAdded(technologySet.getString(3));
				technologyList.add(viewAndAddTechnologyDTO);				
			}
		}
		catch(SQLException se){
		   	 logger.error("SQLException viewAndAddTechnology technology details: "+se.getMessage());
		   	 throw se;
		   	 
		    }
		finally{
			 	if(connection != null){
					connection.close();  /*Database connection closed*/
					logger.debug("Connection Closed");
			 	}
			 	if(technologySet != null){
			 		technologySet.close(); /*ResultSet closed*/
			 		logger.debug("ResultSet Closed");
			 	}
			 	if(loadTechnologyPS != null){
			 		loadTechnologyPS.close();   /*PreparedStatement closed*/
			 		logger.debug("PreparedStatement Closed");
			 	}
		}
		return technologyList;
	}
	
	/*
	 * Method to add a new Technology
	 * */
	public boolean addTechnology(ViewAndAddTechnologyDTO viewAndAddTechnologyDTO) throws ClassNotFoundException, SQLException, NullPointerException, NamingException{
		
		logger.info("Reached addTechnology in DAO"); 
		Connection connection = com.igate.isr.db.DBConnection.getDbConnection().getConnection();   /*Connection object created*/
		logger.info("SQLQuery:INSERT INTO technology_master_details values(initcap(?),tech_code.NEXTVAL,sysdate)");
		query2 = "INSERT INTO technology_master_details values(initcap(?),tech_code.NEXTVAL,sysdate)";
		int check = 0;
		boolean status;
		PreparedStatement insertTechnologyPS = null;
		
		try{
			insertTechnologyPS = connection.prepareStatement(query2);    /*Object created for PreparedStatement*/
			logger.info("Connection Established And Now In DAO Again");
			insertTechnologyPS.setString(1, viewAndAddTechnologyDTO.getTechnologyName());
			check = insertTechnologyPS.executeUpdate();			/*SQL query for loading the existing technologies executed*/			
			connection.commit();
		}catch(SQLException se){
			logger.error("SQLException add technology: "+se.getMessage());
			connection.rollback(); 
			throw se;
		}finally{
		
			if(connection != null){
				
				connection.close();  /*Database connection closed*/
				logger.debug("Connection Closed");
		 	}
			if(insertTechnologyPS != null){
				insertTechnologyPS.close();   /*PreparedStatement closed*/
		 		logger.debug("PreparedStatement Closed");
		 	}
		}
		if(check > 0){
			status = true;
		}else{
			status = false;
		}
		return status; 

	}
}