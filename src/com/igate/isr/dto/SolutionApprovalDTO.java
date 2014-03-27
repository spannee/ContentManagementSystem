package com.igate.isr.dto;

public class SolutionApprovalDTO {
private String empId;
private String empName;
private String problemId;
private String solution;
private String status;
private String problem;
private String technologyName;
public String getEmpId() {
	return empId;
}
public void setEmpId(String empId) {
	this.empId = empId;
}
public String getTechnologyName() {
	return technologyName;
}
public void setTechnologyName(String technologyName) {
	this.technologyName = technologyName;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getProblemId() {
	return problemId;
}
public void setProblemId(String problemId) {
	this.problemId = problemId;
}
public String getSolution() {
	return solution;
}
public void setSolution(String solution) {
	this.solution = solution;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getProblem() {
	return problem;
}
public void setProblem(String problem) {
	this.problem = problem;
}


}
