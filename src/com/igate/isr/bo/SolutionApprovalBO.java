
/************************************************************************************
 * File:        SolutionApprovalBO.java
 * Package:     com.igate.isr. bo
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Rushmitha		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.dao.SolutionApprovalDAO;
import com.igate.isr.dto.SolutionApprovalDTO;
import com.igate.isr.exception.SolutionApprovalUserDefinedExceptions;

public class SolutionApprovalBO {
	List<SolutionApprovalDTO> submittedSolutions;
	SolutionApprovalDAO solAppDAO = new SolutionApprovalDAO();
	boolean update;
	Logger logger = Logger.getLogger(SolutionApprovalBO.class.getName());

	public List<SolutionApprovalDTO> getPendingDetails() throws SolutionApprovalUserDefinedExceptions
			  {
		logger.info("In SolutionApprovalBO--------getPendingDetails()------");
		try {
			submittedSolutions = solAppDAO.getPendingDetails();
		} catch (NamingException e) {
			logger
			.error("In SolutionApprovalBO--------getPendingDetails()--NamingException-------");
	throw new SolutionApprovalUserDefinedExceptions();
			
		} catch (SQLException e) {
			logger
			.error("In SolutionApprovalBO--------getPendingDetails()--SQLException -------");
	throw new SolutionApprovalUserDefinedExceptions();
			
		}
		logger
				.info("In SolutionApprovalBO--------getPendingDetails()---got -------pendingdetails from dao-----");
		return submittedSolutions;
	}

	public boolean updateSolutionStatus(int[] problemId, int status) throws SolutionApprovalUserDefinedExceptions
			 {
		logger.info("In SolutionApprovalBO--------updateStatus------");
		try {
			update = solAppDAO.updateSolutionStatus(problemId, status);
		} catch (SQLException e) {
			logger
			.error("In SolutionApprovalBO--------getPendingDetails()--SQLException -------");
	throw new SolutionApprovalUserDefinedExceptions();
			
		} catch (NamingException e) {
			logger
			.error("In SolutionApprovalBO--------getPendingDetails()--NamingException -------");
	throw new SolutionApprovalUserDefinedExceptions();
		}
		logger
				.info("In SolutionApprovalBO-------- got boolean updateStatus-- from dao----");
		return update;

	}
}
