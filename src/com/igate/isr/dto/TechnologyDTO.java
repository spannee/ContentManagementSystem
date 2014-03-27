package com.igate.isr.dto;

import org.apache.log4j.Logger;

public class TechnologyDTO {
	
	String techCode;
	String techName;
	/*Method to get the techcode*/
	public String getTechCode() {
		
		return techCode;
	}
	/*Method to set the techcode*/
	public void setTechCode(String techCode) {
		
		this.techCode = techCode;
	}
	/*Method to get the techname*/
	public String getTechName() {
	
		return techName;
	}
	/*Method to set the techname*/
	public void setTechName(String techName) {
	
		this.techName = techName;
	}

}
