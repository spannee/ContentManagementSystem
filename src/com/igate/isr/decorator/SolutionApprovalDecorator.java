package com.igate.isr.decorator;

import org.displaytag.decorator.TableDecorator;

import com.igate.isr.dto.SolutionApprovalDTO;

public class SolutionApprovalDecorator extends TableDecorator {
	SolutionApprovalDTO solAppDTO = null;

	public String getProblemId() {

		solAppDTO = new SolutionApprovalDTO();
		solAppDTO = (SolutionApprovalDTO) getCurrentRowObject();

		String problemId = "<input type=checkbox name=\"selectedProblemId\" onclick=\"setValue(this);\" value=\""
				+ solAppDTO.getProblemId() + "\" />";

		return problemId;
	}

	public String getSolution() {
		SolutionApprovalDTO solAppDTO = null;

		solAppDTO = new SolutionApprovalDTO();
		solAppDTO = (SolutionApprovalDTO) getCurrentRowObject();

		String solution = "<textarea readonly cols=\"65\" rows=\"6\">"
				+ solAppDTO.getSolution() + "</textarea>";

		return solution;
	}

	public String getProblem() {

		solAppDTO = new SolutionApprovalDTO();
		solAppDTO = (SolutionApprovalDTO) getCurrentRowObject();

		String problem = "<textarea readonly cols=\"40\" rows=\"6\">"
				+ solAppDTO.getProblem() + "</textarea>";

		return problem;
	}
}
