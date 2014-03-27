package com.igate.isr.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.igate.isr.actions.ViewAndAddTechnologyAction;
import com.igate.isr.dto.ViewAndAddTechnologyDTO;

@SuppressWarnings("deprecation")
public class ViewAndAddTechnologyForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger logger=Logger.getLogger(ViewAndAddTechnologyAction.class.getName());    /*Logger object created*/
	
	public ViewAndAddTechnologyDTO viewAndAddTechnologyDTO = new ViewAndAddTechnologyDTO();

	public ViewAndAddTechnologyDTO getViewAndAddTechnologydto() {
		return viewAndAddTechnologyDTO;
	}

	public void setViewAndAddTechnologydto(	ViewAndAddTechnologyDTO viewAndAddTechnologydto) {
		this.viewAndAddTechnologyDTO = viewAndAddTechnologydto;
	}

	
	public ActionErrors validate(ActionMapping mapping,
				HttpServletRequest request)  {
		// TODO Auto-generated method stub
		
		ActionErrors errors = new ActionErrors();    
			
		try{
			String techName = this.getViewAndAddTechnologydto().getTechnologyName();
			int techNameLength = techName.length();
			
			if(techName == ""){       /*To check whether the input is null*/
				errors.add("errors",new ActionError("errors.NullTechnologyName"));
			}else if(!techName.matches("^[a-zA-Z ]{1,30}$")){     /*To check whether the input contains only alphabets and to check whether the input does not contain more than 30 characters*/
				errors.add("errors",new ActionError("errors.InvalidTechnologyName"));
			}else if(techName.charAt(0) == ' '){     /*To check whether the input contains spaces in the beginning of the input*/	
				errors.add("errors",new ActionError("errors.InvalidTechnologyName"));
			}else if(techName.charAt(techNameLength-1) == ' '){     /*To check whether the input contains spaces in the end of the input*/	
				errors.add("errors",new ActionError("errors.InvalidTechnologyName"));
			}
			
		}catch (NullPointerException e) {
			logger.info("NullPointerException caught");
		}
		return errors;
	}
	
	public void resetForm(){
		viewAndAddTechnologyDTO.setTechnologyName("");
	}
}
