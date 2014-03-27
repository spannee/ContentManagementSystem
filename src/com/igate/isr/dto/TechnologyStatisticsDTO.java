package com.igate.isr.dto;

public class TechnologyStatisticsDTO {
String techName;
public String getTechName() {
	return techName;
}
public void setTechName(String techName) {
	this.techName = techName;
}
public int getSubmitted() {
	return submitted;
}
public void setSubmitted(int submitted) {
	this.submitted = submitted;
}

int submitted;
int appr;
public int getAppr() {
	return appr;
}
public void setAppr(int appr) {
	this.appr = appr;
}
public int getRej() {
	return rej;
}
public void setRej(int rej) {
	this.rej = rej;
}

int rej;



}
