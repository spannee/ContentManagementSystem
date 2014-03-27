package com.igate.isr.forms;

/*
 * Contains the getters and setters for the AddProblemSolutionForm objects
 */
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.dto.ProblemSolutionDTO;
import com.igate.isr.dto.TechnologyDTO;

@SuppressWarnings("deprecation")
public class AddProblemSolutionForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TechnologyDTO technologyDto = new TechnologyDTO();

	public ProblemSolutionDTO problemSolutionDto = new ProblemSolutionDTO();

	public List<LabelValueBean> getTechnologyList() {
		return technologyList;
	}

	public void setTechnologyList(List<LabelValueBean> technologyList) {
		this.technologyList = technologyList;
	}

	public List<LabelValueBean> technologyList = new ArrayList<LabelValueBean>();

	public TechnologyDTO getTechnologyDto() {
		return technologyDto;
	}

	public void setTechnologyDto(TechnologyDTO technologyDto) {
		this.technologyDto = technologyDto;
	}

	public ProblemSolutionDTO getProblemSolutionDto() {
		return problemSolutionDto;
	}

	public void setProblemSolutionDto(ProblemSolutionDTO problemSolutionDto) {
		this.problemSolutionDto = problemSolutionDto;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		try {
			ActionErrors errors = new ActionErrors();

			Pattern keywordPattern = Pattern.compile("^[A-Za-z- ]{1,20}$");

			Matcher keywordMatcher = keywordPattern.matcher(problemSolutionDto
					.getKeyword());

			if (problemSolutionDto.getTechCode().equals("--Select--")) {
				errors.add("errors",
						new ActionError("errors.InvalidTechnology"));
				return errors;
			}
			if (problemSolutionDto.getProblem() == ""
					|| problemSolutionDto.getProblem().length() > 500) {
				errors.add("errors", new ActionError("errors.InvalidProblem"));
				return errors;
			}
			if (problemSolutionDto.getSolution() == ""
					|| problemSolutionDto.getSolution().length() > 500) {
				errors.add("errors", new ActionError("errors.InvalidSolution"));
				return errors;
			}
			if (problemSolutionDto.getKeyword() == ""
					|| problemSolutionDto.getKeyword().length() > 20) {
				errors.add("errors", new ActionError("errors.InvalidKeyword"));
				return errors;
			}
			if (!keywordMatcher.find()) {
				errors.add("errors", new ActionError("errors.InvalidKeyword"));
				return errors;

			}

		} catch (NullPointerException e) {

		}
		return null;
	}

	public void resetForm() {
		problemSolutionDto.setKeyword(null);
		problemSolutionDto.setSolution(null);
		problemSolutionDto.setProblem(null);
		problemSolutionDto.setTechCode(null);
	}
}
