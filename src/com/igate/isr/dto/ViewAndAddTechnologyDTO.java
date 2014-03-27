package com.igate.isr.dto;


/*
 * Class that contains the Data Transfer Object
 * Contains the getter and setter functions 
 * */
public class ViewAndAddTechnologyDTO {

	private String technologyName;
	private String technologyCode;
	private String dateAdded;
	
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	public String getTechnologyCode() {
		return technologyCode;
	}
	public void setTechnologyCode(String technologyCode) {
		this.technologyCode = technologyCode;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
}
