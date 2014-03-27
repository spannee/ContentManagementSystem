
/************************************************************************************
 * File:        viewAndAddTechnologyBO.java
 * Package:     com.igate.isr. bo
 * Desc:       viewAndAddTechnologysolution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Santhosh		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.actions.ViewAndAddTechnologyAction;
import com.igate.isr.dao.ViewAndAddTechnologyDAO;
import com.igate.isr.dto.ViewAndAddTechnologyDTO;
import com.igate.isr.exception.AddFailureException;
import com.igate.isr.exception.DBConnectionException;
import com.igate.isr.exception.PrimaryKeyException;
import com.igate.isr.exception.ViewFailureException;

public class ViewAndAddTechnologyBO {

	public static final Logger logger=Logger.getLogger(ViewAndAddTechnologyAction.class.getName());  /*Logger object created*/
	ViewAndAddTechnologyDAO viewAndAddTechnologyDAO = new ViewAndAddTechnologyDAO();   /*DAO object created*/
	
	/*
	 * Method to load the existing technologies
	 * */
	public List<ViewAndAddTechnologyDTO> getTechnologyDetails() throws  ViewFailureException, DBConnectionException{
		logger.info("Reached getTechnologyDetails in ViewAndAddTechnologyBO");	
		List<ViewAndAddTechnologyDTO> technologyList = new ArrayList<ViewAndAddTechnologyDTO>();      /*ArrayList initialized*/
		
		try{
		
		technologyList = viewAndAddTechnologyDAO.getTechnologyDetails();       /*Method of DAO class which returns the ArrayList containing the Technology details called*/
		
		}catch(NullPointerException npe){      /*Exception caught and thrown in case the database connection is lost*/
			logger.error("In ViewAndAddTechnologyBOclass raised nullpointer exception");
			throw new DBConnectionException();
		}catch(SQLException sql){              /*Exception caught and thrown in case the database connection is lost*/
			logger.error("In ViewAndAddTechnologyBOclass raised SQL exception");
			throw new DBConnectionException();
		}catch(NamingException ne){
			logger.error("In ViewAndAddTechnologyBOclass raised Naming exception");
			throw new DBConnectionException();
		 } catch (ClassNotFoundException e) {
			 logger.error("In ViewAndAddTechnologyBOclass raised ClassNotFound exception");
			 throw new DBConnectionException();
		}
		
		if(technologyList.isEmpty()){
			throw new ViewFailureException();	/*Exception thrown in case the ArrayList is empty*/
		}else{
			return technologyList;
		}
	}
	
	/*
	 * Method to add a new Technology
	 * */
	public boolean addTechnology(ViewAndAddTechnologyDTO viewAndAddTechnologyDTO) throws AddFailureException, DBConnectionException, PrimaryKeyException{
		
		logger.info("Reached addTechnology in ViewAndAddTechnologyBO");
		boolean status=false;
		String invalidData;
		
		try{
		status = viewAndAddTechnologyDAO.addTechnology(viewAndAddTechnologyDTO);    /*Method of DAO class which returns a boolean value*/		
		
		}catch(NullPointerException npe){      /*Exception caught and thrown in case the database connection is lost*/
			logger.error("In ViewAndAddTechnologyBOclass raised nullpointer exception");
			throw new DBConnectionException();
		}catch(SQLException sql){              /*Exception caught and thrown in case the database connection is lost*/
			logger.error("In ViewAndAddTechnologyBOclass raised SQL exception");
			invalidData = sql.getMessage();
			if(invalidData.contains("ORA-00001")){
				throw new PrimaryKeyException(); 
			}
		}catch(NamingException ne){
			logger.error("In ViewAndAddTechnologyBOclass raised Naming exception");
			throw new DBConnectionException();
		 } catch (ClassNotFoundException e) {
			 logger.error("In ViewAndAddTechnologyBOclass raised ClassNotFound exception");
			 throw new DBConnectionException();
		}
		
		if(status == false){
			throw new AddFailureException();   /*Exception thrown in case the boolean method of DAO returns a boolean value*/
		}else{
			return status;
		}
	}
}


