/************************************************************************************
 * File:        LoginDAO.java
 * Package:     com.igate.isr. dao
 * Desc:        login to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Amudhan		       9-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.LoginDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.LoginUserDefinedException;

public class LoginDAO {
	PreparedStatement pstmt = null;
	ResultSet resultset = null;
	Connection connection= null;
	public static final Logger logger = Logger.getLogger(LoginDAO.class.getName());

	public LoginDTO getLoginDetails(LoginDTO logindto)
			throws LoginUserDefinedException, ClassNotFoundException, AddProblemSolutionUserDefinedException, NamingException, SQLException {

		logger.info("In LoginDAO");

		try {

			
			connection =DBConnection.getDbConnection().getConnection();
			logger.info("SQLQuery:SELECT initcap(First_Name|| ||Last_name),Emp_ID,Password,is_Admin FROM User_table WHERE Emp_ID=? And Password=?");
			pstmt = connection
					.prepareStatement("SELECT initcap(First_Name||' '||Last_name),Emp_ID,Password,is_Admin FROM User_table WHERE Emp_ID=? And Password=?");
			pstmt.setString(1, logindto.getEmpID());
			pstmt.setString(2, logindto.getPassword());
			resultset = pstmt.executeQuery();
			while (resultset.next()) {
				logindto.setUserName(resultset.getString(1));
				logindto.setEmpID(resultset.getString(2));
				logindto.setPassword(resultset.getString(3));
				logindto.setAdmin(resultset.getString(4));
			}
			logger.info("Returning logindto to LoginBO Class");
			return logindto;
		}

		 catch(SQLException se){
        	 logger.error("SQLException Login: "+se.getMessage());
        	 throw se;
        	 
         } finally {

			if (connection != null) {
				connection.close();

			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (resultset != null) {
				resultset.close();
			}
       
		}

	}

}
