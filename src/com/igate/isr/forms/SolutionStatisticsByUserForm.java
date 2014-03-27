package com.igate.isr.forms;

import org.apache.struts.action.ActionForm;

import com.igate.isr.dto.SolutionStatisticsByUserDTO;

public class SolutionStatisticsByUserForm extends ActionForm {
SolutionStatisticsByUserDTO sdto=new SolutionStatisticsByUserDTO();

public SolutionStatisticsByUserDTO getSdto() {
	return sdto;
}

public void setSdto(SolutionStatisticsByUserDTO sdto) {
	this.sdto = sdto;
}

}
