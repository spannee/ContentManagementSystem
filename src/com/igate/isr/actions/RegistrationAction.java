

/************************************************************************************
 * File:        RegisterAction.java
 * Package:     com.igate.isr.actions
 * Desc:         RegisterAction to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan		       7-12-2010       Initial version
 ************************************************************************************/
package com.igate.isr.actions;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;



import com.igate.isr.bo.RegistrationBO;
import com.igate.isr.dto.RegistrationDTO;
import com.igate.isr.exception.ConstraintUserDefinedException;
import com.igate.isr.exception.RegistrationUserDefinedException;
import com.igate.isr.forms.RegistrationForm;

public class RegistrationAction extends DispatchAction {
	
	public static final Logger logger = Logger.getLogger(RegistrationAction.class.getName());
	public ActionForward registerEmployee(ActionMapping mapping,ActionForm form,HttpServletRequest request, HttpServletResponse response)  {
		
		logger.info("In RegistrationAction registerEmployee method" );
		HttpSession session = request.getSession();
		RegistrationDTO registrationdto=new RegistrationDTO();
		RegistrationBO registrationbo=new RegistrationBO();
		ActionMessages messages=new ActionMessages();
		RegistrationForm form1=(RegistrationForm) form;
		boolean register = false;
		
		
					try {
						register = registrationbo.registerEmployee(form1.getRegistrationdto());
						
						if(register){
							
							session.setAttribute("EmpId",form1.getRegistrationdto().getEmpID());
							session.setAttribute("UserName",form1.getRegistrationdto().getFirstName()+" "+form1.getRegistrationdto().getLastName());
							session.setAttribute("isAdmin", "n");
							return mapping.findForward("home");
						    }
						else{
							messages.add("msg", new ActionMessage("errors_msg"));
							saveMessages(request, messages);
							form1.resetForm();
							return mapping.findForward("registration");
						  }
						
					}  catch (RegistrationUserDefinedException e) {
						logger.error("Exception is caught in RegistrationAction registerEmployee method");
						messages.add("msg", new ActionMessage("errors_dbmsg"));
						saveMessages(request, messages);
						return mapping.findForward("registration");
					} catch (ConstraintUserDefinedException e) {
						messages.add("msg", new ActionMessage("errors_invalidmsg"));
						saveMessages(request, messages);
						form1.resetForm();
						return mapping.findForward("registration");
					}
		}
	}


