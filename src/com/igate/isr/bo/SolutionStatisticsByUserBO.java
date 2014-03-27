/************************************************************************************
 * File:        SolutionStatisticsByUserBO.java
 * Package:     com.igate.isr. bo
 * Desc:         SolutionStatisticsByUser to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subash		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.actions.SolutionStatisticsByUserAction;
import com.igate.isr.dao.SolutionStatisticsByUserDAO;
import com.igate.isr.dto.SolutionStatisticsByUserDTO;
import com.igate.isr.exception.SolutionStatisticsByUserUserDefinedException;

public class SolutionStatisticsByUserBO {
	public static final Logger logger = Logger
			.getLogger(SolutionStatisticsByUserAction.class.getName());
	SolutionStatisticsByUserDAO statsDAO;

	public List<SolutionStatisticsByUserDTO> getSolutionStatisticsByUser()
			throws SolutionStatisticsByUserUserDefinedException {
		logger
				.info("logger object created in BO class before calling DAO to fetch the statistics list");
		List<SolutionStatisticsByUserDTO> statslist = new ArrayList<SolutionStatisticsByUserDTO>();// creating
		// list
		// object//
		statsDAO = new SolutionStatisticsByUserDAO();
		try {
			statslist = statsDAO.getSolutionStatisticsByUser();
		} catch (SQLException e) {
			logger.error("logger object  in BO class raised sql exception");
			throw new SolutionStatisticsByUserUserDefinedException();
		} catch (ClassNotFoundException e) {
			logger
					.error("logger object  in BO class raised classnotfound exception");
			throw new SolutionStatisticsByUserUserDefinedException();
		} catch (NamingException e) {
			logger.error("logger object  in BO class raised NamingException");
			throw new SolutionStatisticsByUserUserDefinedException();
		} catch (NullPointerException ne) {
			logger
					.error("logger object  in BO class raised NullPointerException");
			throw new SolutionStatisticsByUserUserDefinedException();
		}
		
		logger.info("returning the solutionstatistics by user list to SolutionStatisticsByUserAction class");
		return statslist;
	}
}
