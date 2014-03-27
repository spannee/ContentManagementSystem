/************************************************************************************
 * File:        AddProblemSolutionBO.java
 * Package:     com.igate.isr.bo
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Jawahar		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.dao.AddProblemSolutionDAO;
import com.igate.isr.dto.ProblemSolutionDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.SolutionStatisticsByUserUserDefinedException;

public class AddProblemSolutionBO {
	public static final Logger logger = Logger
			.getLogger(AddProblemSolutionBO.class.getName());

	/*
	 * Logger object is created for AddProblemSolutionBO class
	 */

	public List<LabelValueBean> getTechnology()
			throws AddProblemSolutionUserDefinedException
			

	{
		logger.info("Inside AddProblemSolutionBO class,getTechnology method");
	
		List<LabelValueBean> technologyList = new ArrayList<LabelValueBean>(); 
		
		AddProblemSolutionDAO addProblemSolutionDao = new AddProblemSolutionDAO(); 
		
		try {
			technologyList = addProblemSolutionDao.getTechnology();
		} catch (NullPointerException e) {
			logger.error("In AddProblemSolutionBO class  raised NullPointerException");
			throw new AddProblemSolutionUserDefinedException();
		} catch (SQLException e) {
			logger.error("In AddProblemSolutionBO class  raised SQLException");
			throw new AddProblemSolutionUserDefinedException();
		}
		catch (NamingException e) {
			logger.error("In AddProblemSolutionBO class  raised NamingException");
			throw new AddProblemSolutionUserDefinedException();
		} catch (ClassNotFoundException e) {
			logger.error("In AddProblemSolutionBO class  raised ClassNotFoundException");
			throw new AddProblemSolutionUserDefinedException();
		} 
		
		if (technologyList.isEmpty())/* Checking if technologyList is empty */
		{
			
			throw new AddProblemSolutionUserDefinedException();
		}
		logger.info("From AddProblemSolutionBO,technologyList is returned to doLoadTechnology method of AddProblemSolutionAction Class");
		return technologyList;
	}
	

	public boolean addProblemSolution(ProblemSolutionDTO problemSolutionDto)
			throws AddProblemSolutionUserDefinedException
			
	/*
	 * addProblemSolution(ProblemSolutionDTO problemSolutionDto) method of
	 * AddProblemSolutionBO class passes the AddProblemSolutionForm elements to
	 * the AddProblemSolutionDAO class
	 */
	{
		logger.info("Inside AddProblemSolutionBO class,addProblemSolution method");
		
		AddProblemSolutionDAO addProblemSolutionDao = new AddProblemSolutionDAO(); 
	
		boolean status;
		try {
			status = addProblemSolutionDao
					.addProblemSolution(problemSolutionDto);
		} catch (NullPointerException e) {
			logger.error("In AddProblemSolutionBO class  raised NullPointerException");
			throw new AddProblemSolutionUserDefinedException();
		} catch (SQLException e) {
			logger.error("In AddProblemSolutionBO class  raised SQLException");
			throw new AddProblemSolutionUserDefinedException();
		}
		catch (NamingException e) {
			logger.error("In AddProblemSolutionBO class  raised NamingException");
			throw new AddProblemSolutionUserDefinedException();
		} catch (ClassNotFoundException e) {
			logger.error("In AddProblemSolutionBO class  raised ClassNotFoundException");
			throw new AddProblemSolutionUserDefinedException();
		} 
		
		logger.info("From AddProblemSolutionBO, status is returned to doAddProblemSolution method of AddProblemSolutionAction Class");
		return status;/* status is returned to AddProblemSolutionAction class */
	}
}
