package com.igate.isr.forms;

import org.apache.struts.action.ActionForm;

import com.igate.isr.dto.SolutionApprovalDTO;

public class SolutionApprovalForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SolutionApprovalDTO solAppDTO;
	String[] selectedProblemId;

	public String[] getSelectedProblemId() {
		return selectedProblemId;
	}

	public void setSelectedProblemId(String[] selectedProblemId) {
		this.selectedProblemId = selectedProblemId;
	}

	public SolutionApprovalDTO getApdto() {
		return solAppDTO;
	}

	public void setApdto(SolutionApprovalDTO solAppDTO) {
		this.solAppDTO = solAppDTO;
	}

}
