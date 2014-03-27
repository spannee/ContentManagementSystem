/************************************************************************************
 * File:        viewProblamsolutionBO.java
 * Package:     com.igate.isr. bo
 * Desc:        viewProblamsolution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Chaitanya		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.dao.ViewProblemSolutionDAO;
import com.igate.isr.dto.ViewProblemSolutionDTO;
import com.igate.isr.exception.ViewProblemSolutionUserDefinedException;

public class ViewProblemSolutionBO {
	List<ViewProblemSolutionDTO> probSolList;
	
	ViewProblemSolutionDAO viewProbSolDAO;
	public static final Logger logger = Logger
	.getLogger(ViewProblemSolutionBO.class.getName());
	public List<ViewProblemSolutionDTO> viewProblemSolutionDetails(String EmpId)
			throws ViewProblemSolutionUserDefinedException
		
			{
		logger.info("In ViewProblemSolutionBO,viewProblemSolutionDetails method");
		probSolList = new ArrayList<ViewProblemSolutionDTO>();
	
		viewProbSolDAO = new ViewProblemSolutionDAO();
		
		try {
			probSolList = viewProbSolDAO.viewProblemSolutionDetails(EmpId);
		} catch (SQLException e) {
			logger.error("In ViewProblemSolutionBO  raised SQL exception");
			throw new ViewProblemSolutionUserDefinedException();
		} catch (ClassNotFoundException e) {
			logger.error("In ViewProblemSolutionBO  raised classnot found exception");
			throw new ViewProblemSolutionUserDefinedException();
		} catch (NamingException e) {
			logger.error("In ViewProblemSolutionBO  raised naming exception");
			throw new ViewProblemSolutionUserDefinedException();
		}

		logger
				.info("**********************In BO employee Id being passed to DAO to fetch list of data***********");
		return probSolList;
	}

}