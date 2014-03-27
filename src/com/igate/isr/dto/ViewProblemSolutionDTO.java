package com.igate.isr.dto;

import org.apache.log4j.Logger;

import com.igate.isr.actions.ViewProblemSolutionAction;

public class ViewProblemSolutionDTO {
	Logger logger = Logger.getLogger(ViewProblemSolutionAction.class.getName());

	String empId;
	String addedDate;
	String problemStatement;
	String solution;
	String status;
	String verifiedDate;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
		logger
				.debug("************************Set method for Employee Id in DTO*********************");
	}

	public String getAddedDate() {
		logger
				.debug("************************Get method for Added date in DTO*********************");
		return addedDate;

	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
		logger
				.debug("************************Set method for Added Date in DTO*********************");
	}

	public String getProblemStatement() {
		logger
				.debug("************************Get method for Problem statement in DTO*********************");
		return problemStatement;
	}

	public void setProblemStatement(String problemStatement) {
		this.problemStatement = problemStatement;
		logger
				.debug("************************Set method for Problem Statement in DTO*********************");
	}

	public String getSolution() {
		logger
				.debug("************************Get method for Solution Id in DTO*********************");
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
		logger
				.debug("************************Set method for Solution Id in DTO*********************");
	}

	public String getStatus() {
		logger
				.debug("************************Get method for Status Id in DTO*********************");
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		logger
				.debug("************************Set method for Status in DTO*********************");
	}

	public String getVerifiedDate() {
		logger
				.debug("************************Get method for Verified Date in DTO*********************");
		return verifiedDate;
	}

	public void setVerifiedDate(String verifiedDate) {
		this.verifiedDate = verifiedDate;
		logger
				.debug("************************Set method for Verified Date in DTO*********************");
	}

}
