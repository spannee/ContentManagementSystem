package com.igate.isr.forms;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.igate.isr.actions.ViewProblemSolutionAction;
import com.igate.isr.dto.ViewProblemSolutionDTO;

public class ViewProblemSolutionForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ViewProblemSolutionDTO viewProbSolDTO = new ViewProblemSolutionDTO();
	Logger logger = Logger.getLogger(ViewProblemSolutionAction.class.getName());

	public ViewProblemSolutionDTO getViewdto() {
		logger
				.debug("*******************In form get DTO***************************");
		return viewProbSolDTO;
	}

	public void setViewdto(ViewProblemSolutionDTO viewProbSolDTO) {
		logger
				.debug("*********************In from set DTO************************");
		this.viewProbSolDTO = viewProbSolDTO;
	}

}
