package com.igate.isr.forms;



import javax.servlet.http.HttpServletRequest;



import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.igate.isr.dto.RegistrationDTO;

@SuppressWarnings("serial")
public class RegistrationForm extends ActionForm{
	RegistrationDTO registrationdto=new RegistrationDTO();

	public RegistrationDTO getRegistrationdto() {
		return registrationdto;
	}

	public void setRegistrationdto(RegistrationDTO registrationdto) {
		this.registrationdto = registrationdto;
	}
	
	
	@SuppressWarnings("deprecation")
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (registrationdto.getFirstName().equals("") && registrationdto.getLastName().equals("") && registrationdto.getPassword().equals("")
				&& registrationdto.getEmpID().equals("") && registrationdto.getProjectName().equals("") && registrationdto.getEmailid().equals("")
				&& registrationdto.getConfirmPassword().equals("")) {
			errors.add("errors", new ActionError("errors.NoFields"));
		}
		
		else if(registrationdto.getFirstName().equals("")){
			errors.add("errors", new ActionError("errors.nofirstname"));
		}
		
		else if(registrationdto.getLastName().equals("")){
			errors.add("errors", new ActionError("errors.nolastname"));
		}
		
		else if(registrationdto.getEmpID().equals("")){
			errors.add("errors", new ActionError("errors.noempid"));
		}
		
		
		else if(registrationdto.getEmailid().equals("")){
			errors.add("errors", new ActionError("errors.noemailid"));
		}
		
        else if(registrationdto.getPassword().equals("")){
        	errors.add("errors", new ActionError("errors.nopassword"));
        }
		
        else if(registrationdto.getConfirmPassword().equals("")){
        	errors.add("errors", new ActionError("errors.noconfirmpassword"));
        }
        else if(registrationdto.getProjectName().equals("")){
        	errors.add("errors", new ActionError("errors.noprojectname"));
		}
		
		
		else if(registrationdto.getFirstName().length()>25){
			
			errors.add("errors", new ActionError("errors.firstname"));
			
		}
		else if(registrationdto.getLastName().length()>25){
			errors.add("errors", new ActionError("errors.lastname"));
			
		}
		else if(registrationdto.getEmpID().length()<6 || registrationdto.getEmpID().length()>6){
			errors.add("errors", new ActionError("errors.empid"));
		}
		else if(registrationdto.getPassword().length()<8 || registrationdto.getPassword().length()>25){
			errors.add("errors", new ActionError("errors.password"));
		}
		
		
		else if((registrationdto.getFirstName().matches("^^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$"))==false){
			errors.add("errors", new ActionError("errors.invalidfirstname"));
		}
		else if((registrationdto.getLastName().matches("^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$"))==false){
			errors.add("errors", new ActionError("errors.invalidlastname"));
		}
		else if((registrationdto.getEmpID().matches("\\d{6}"))==false){
			errors.add("errors", new ActionError("errors.invalidempid"));
		}
else if((registrationdto.getPassword().matches("^[a-zA-Z0-9]+$"))==false){
			
			errors.add("errors", new ActionError("errors.invalidpassword"));
		}
		
		
		else if((registrationdto.getProjectName().matches("^[A-Za-z]+([A-Za-z '.]*)[A-Za-z]+$"))==false){
			errors.add("errors", new ActionError("errors.invalidprojectname"));
		}
		else if((registrationdto.getEmailid().matches("^([a-zA-Z0-9_.-]+)@([A-Za-z0-9]+).([a-z0-9]+)*(.[a-z]{2,3})$"))==false)
		{
			errors.add("errors", new ActionError("errors.invalidemailid"));
	}
		else if((registrationdto.getPassword().equals(registrationdto.getConfirmPassword()))==false){
			
			errors.add("errors", new ActionError("errors.invalidconfirmpassword"));
		}

		

		return errors;

	}	
	
	public void resetForm(){
		registrationdto.setPassword("");
		registrationdto.setConfirmPassword("");
	}

}
