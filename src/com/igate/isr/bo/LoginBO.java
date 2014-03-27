/************************************************************************************
 * File:        LoginBO.java
 * Package:     com.igate.isr. bo
 * Desc:        login to iSolutionsRepository
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

import com.igate.isr.dao.LoginDAO;
import com.igate.isr.dto.LoginDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.LoginUserDefinedException;

public class LoginBO {
public static final Logger logger = Logger.getLogger(LoginBO.class.getName());
	public LoginDTO getLoginDetails(LoginDTO logindto)
			throws LoginUserDefinedException, AddProblemSolutionUserDefinedException {
		
		logger.info("In LoginBO getLoginDetails method");
		LoginDAO logindao = new LoginDAO();
		LoginDTO logindtoinbo = new LoginDTO();
	
		try {
			logindtoinbo = logindao.getLoginDetails(logindto);
		} catch (ClassNotFoundException e) {
			logger.error("In LoginBO class  raised ClassNotFoundException");
			throw new LoginUserDefinedException();
			
		} catch (NamingException e) {
			logger.error("In LoginBO class  raised NamingException");
			throw new LoginUserDefinedException();
		} catch (SQLException e) {
			logger.error("In LoginBO class  raised NamingException");
			throw new LoginUserDefinedException();
		}
		logger.info("From LoginBO,logindto object is returned to LoginActionClass ");

		return logindtoinbo;

	}

}
