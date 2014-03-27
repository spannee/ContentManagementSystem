
/************************************************************************************
 * File:       TechnologystatisticsBO.java
 * Package:     com.igate.isr. bo
 * Desc:        Technologystatistics to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Supriya		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.actions.TechnologyStatisticsAction;
import com.igate.isr.dao.TechnologyStatisticsDAO;
import com.igate.isr.dto.TechnologyStatisticsDTO;
import com.igate.isr.exception.TechnologyStatisticsUserDefinedException;

public class TechnologyStatisticsBO {
	public static final Logger logger = Logger
			.getLogger(TechnologyStatisticsAction.class.getName());
	TechnologyStatisticsDAO techDAO;

	public List<TechnologyStatisticsDTO> getTechnologyStatistics()
			throws TechnologyStatisticsUserDefinedException {
		logger
				.info("In TechnologyStatisticsBO Action getTechnologyStatistics ");
		techDAO = new TechnologyStatisticsDAO();
		List<TechnologyStatisticsDTO> techlist = new ArrayList<TechnologyStatisticsDTO>();
		try {
			techlist = techDAO.getTechnologyStatistics();
		}
		catch (SQLException e) {
			logger.error("In TechnologyStatisticsBO class raised sql exception");
			throw new TechnologyStatisticsUserDefinedException();
		} catch (ClassNotFoundException e) {
			logger.error("In TechnologyStatisticsBO class raised classnotfound exception");
			throw new TechnologyStatisticsUserDefinedException();
		} catch (NamingException e) {
			logger.error("In TechnologyStatisticsBO class raised naming exception");
			throw new TechnologyStatisticsUserDefinedException();
		} catch (NullPointerException ne) {
			logger.error("In TechnologyStatisticsBO class raised NullPointer exception");
			throw new TechnologyStatisticsUserDefinedException();
		}

	
		logger.debug("From TechnologyStatisticsBO returning the TechnologyStatisticslist to TechnologyStatisticsAction class");
		return techlist;
	}
}
