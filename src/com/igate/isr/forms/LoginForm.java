package com.igate.isr.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.igate.isr.dto.LoginDTO;


@SuppressWarnings({ "deprecation", "serial" })
public class LoginForm extends ActionForm {
	public LoginDTO logindto = new LoginDTO();

	public LoginDTO getLogindto() {
		return logindto;
	}

	public void setLogindto(LoginDTO logindto) {
		this.logindto = logindto;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (logindto.getEmpID().equals("") && logindto.getPassword().equals("")) {
			errors.add("errors", new ActionError("errors.NoEmpIdPassword"));
			resetForm();
		}
		else if (logindto.getEmpID().equals("")) {
			errors.add("errors", new ActionError("errors.NoEmpId"));
			resetForm();
		} 
		else if (logindto.getPassword().equals("")) {
			errors.add("errors", new ActionError("errors.NoPassword"));
			resetForm();
		} 
		else if (logindto.getEmpID().length()<6 || logindto.getEmpID().length()>6) {
			errors.add("errors", new ActionError("errors.invalidEmpId"));
			resetForm();
		} 
		else if (logindto.getPassword().length() < 8
				|| logindto.getPassword().length() > 25) {
			errors.add("errors", new ActionError("errors.invalidPassword"));
			resetForm();
		}

		else if ((logindto.getEmpID().matches("\\d{6}"))==false) {
			errors.add("errors", new ActionError("errors.invalidempid"));
			resetForm();
		} 
		else if ((logindto.getPassword().matches("^[a-zA-Z0-9]+$"))==false) {
			errors.add("errors", new ActionError("errors.invalidpassword"));
			resetForm();
		}

		return errors;

	}
	public void resetForm(){
		
		logindto.setPassword("");
	}
	public void resetLoginFields(){
		logindto.setEmpID("");
		logindto.setPassword("");
	}

}
