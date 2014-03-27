package com.igate.isr.dto;

public class SolutionStatisticsByUserDTO {
	String ename;
	String empid;
    String projName;
    int submit;
	int approve;
	int rejecte;

	public String getProjName() {
		return projName;
	}

	public void setProjName(String projName) {
		this.projName = projName;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public int getSubmit() {
		return submit;
	}

	public void setSubmit(int submit) {
		this.submit = submit;
	}

	public int getApprove() {
		return approve;
	}

	public void setApprove(int approve) {
		this.approve = approve;
	}

	public int getRejecte() {
		return rejecte;
	}

	public void setRejecte(int rejecte) {
		this.rejecte = rejecte;
	}

}
