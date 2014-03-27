package com.igate.isr.forms;
import org.apache.struts.action.ActionForm;

import com.igate.isr.dto.TechnologyStatisticsDTO;

public class TechnologyStatisticsForm extends ActionForm {
	TechnologyStatisticsDTO sdto=new TechnologyStatisticsDTO();

public TechnologyStatisticsDTO getTdto() {
	return sdto;
}

public void setTdto(TechnologyStatisticsDTO tdto) {
	this.sdto = sdto;
}

}




