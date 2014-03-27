/************************************************************************************
 * File:        RegistrationBO.java
 * Package:     com.igate.isr. bo
 * Desc:         RegistrationBO to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan		       8-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.bo;

import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.dao.RegistrationDAO;
import com.igate.isr.dto.RegistrationDTO;
import com.igate.isr.exception.ConstraintUserDefinedException;
import com.igate.isr.exception.RegistrationUserDefinedException;

public class RegistrationBO {
	
	public static final Logger logger = Logger.getLogger(RegistrationBO.class.getName());
	
	public boolean registerEmployee(RegistrationDTO registrationdto) throws  RegistrationUserDefinedException, ConstraintUserDefinedException{
		
		logger.info("In RegistrationBO registerEmployee method");
		
		RegistrationDAO registrationdao=new RegistrationDAO();
		
		boolean register;
		try {
			register = registrationdao.registerEmployee(registrationdto);
		} catch (SQLException e) {
			logger.error("In RegistrationBO class  raised SQLException");
		throw new ConstraintUserDefinedException();
		} catch (NamingException e) {
			logger.error("In RegistrationBO class  raised NamingException");
			throw new 	RegistrationUserDefinedException();
		}
		logger.info("From RegistrationBO,register status is returned to LoginActionClass ");
		return register;
		
		
		
		
		
		
	}

}
