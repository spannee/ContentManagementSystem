
/************************************************************************************
 * File:        SolutionStatisticsByUserAction.java
 * Package:     com.igate.isr.actions
 * Desc:         SolutionStatisticsByUser to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subash		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;


import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import com.igate.isr.bo.SolutionStatisticsByUserBO;
import com.igate.isr.dto.SolutionStatisticsByUserDTO;
import com.igate.isr.exception.SolutionStatisticsByUserUserDefinedException;

public class SolutionStatisticsByUserAction extends DispatchAction {

	public static final Logger logger = Logger
			.getLogger(SolutionStatisticsByUserAction.class.getName());

	public ActionForward doLoadSolutionStatisticsByUser(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)  {

		HttpSession session = request.getSession(false);

		logger.info("In SolutionStatisticsByUserAction doLoadSolutionStatisticsByUser ");
		
		SolutionStatisticsByUserBO ststsBO = new SolutionStatisticsByUserBO();// creating
		// BO
		// object//
		ActionMessages msg = new ActionMessages();// creating action message
		// object//
		List<SolutionStatisticsByUserDTO> statslist = new ArrayList<SolutionStatisticsByUserDTO>();// creating
		// list
		// object//

		try {
		

			statslist = ststsBO.getSolutionStatisticsByUser();

			
			if (statslist.isEmpty()) {
				
				msg.add("msgresult", new ActionMessage("NO_DATA"));
			}
		}

		catch (SolutionStatisticsByUserUserDefinedException e) {
			logger
					.error(" Exception is caught in SolutionStatisticsByUserAction doLoadSolutionStatisticsByUser ");
			msg.add("msgfailure", new ActionMessage("EXP_MSG"));
			saveMessages(request, msg);
			
			
		}

		
		session.setAttribute("Stats", statslist);
		saveMessages(request, msg);
		logger.info("Returning to SolutionStatisticsByUser JSP page ");
		return mapping.findForward("SolutionStatisticsByUser");
	}
}
