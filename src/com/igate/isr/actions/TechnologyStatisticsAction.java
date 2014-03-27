

/************************************************************************************
 * File:       TechnologystatisticsAction.java
 * Package:     com.igate.isr.actions
 * Desc:        Technologystatistics to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Supriya		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.igate.isr.bo.TechnologyStatisticsBO;
import com.igate.isr.dto.TechnologyStatisticsDTO;
import com.igate.isr.exception.TechnologyStatisticsUserDefinedException;

public class TechnologyStatisticsAction extends DispatchAction {

	TechnologyStatisticsDTO techdto = new TechnologyStatisticsDTO();
	public static final Logger logger = Logger
			.getLogger(TechnologyStatisticsAction.class.getName());

	public ActionForward doLoadTechnologyStatistics(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			 {
		logger.info("In TechnologyStatisticsAction doLoadTechnologyStatistics method");
		HttpSession session = request.getSession(false);
	    TechnologyStatisticsBO techbo = new TechnologyStatisticsBO();

		ActionMessages msg = new ActionMessages();
		List<TechnologyStatisticsDTO> techlist = new ArrayList<TechnologyStatisticsDTO>();
		try {
		
			techlist = techbo.getTechnologyStatistics();
			
			if (techlist.isEmpty()) {
			
				
				msg.add("msgresult", new ActionMessage("NO_DATA"));
			}
		}

		catch (TechnologyStatisticsUserDefinedException sue) {
			logger
			.error(" Exception is caught in TechnologyStatisticsAction doLoadTechnologyStatistics ");
			msg.add("msgfailure", new ActionMessage("EXP_MSG"));
			saveMessages(request, msg);

		}
	
		session.setAttribute("Stats", techlist);
		saveMessages(request, msg);
		logger.info("Returning to StatisticsByTechnology JSP page ");
		return actionMapping.findForward("StatisticsByTechnology");
	}
}
