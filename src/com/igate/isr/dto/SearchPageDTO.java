package com.igate.isr.dto;



public class SearchPageDTO {
	
 
 String keyword;
 String problem;
 String solution;
 String techName;
 String techCode;
 /*Method to get the keyword*/
public String getKeyword() {
	
	return keyword;
}
 /*Method to set the keyword*/
public void setKeyword(String keyword) {
	
	this.keyword = keyword;
}
/*Method to get the problem*/
public String getProblem() {
	
	return problem;
}
/*Method to set the problem*/
public void setProblem(String problem) {
	
	this.problem = problem;
}
/*Method to get the solution*/
public String getSolution() {
	
	return solution;
}
/*Method to set the solution*/
public void setSolution(String solution) {
	
	this.solution = solution;
}
/*Method to get the techname*/
public String getTechName() {
	
	return techName;
}
/*Method to set the techname*/
public void setTechName(String techName) {
	
	this.techName = techName;
}
/*Method to get the techcode*/
public String getTechCode() {
	
	return techCode;
}
/*Method to set the techcode*/
public void setTechCode(String techCode) {
	
	this.techCode = techCode;
}
}
