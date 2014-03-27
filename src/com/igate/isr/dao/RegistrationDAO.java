/************************************************************************************
 * File:        RegisterDAO.java
 * Package:     com.igate.isr. dao
 * Desc:         RegisterDAO to iSolutionsRepository
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
import com.igate.isr.dto.RegistrationDTO;
import com.igate.isr.exception.ConstraintUserDefinedException;
import com.igate.isr.exception.RegistrationUserDefinedException;

public class RegistrationDAO {
	Connection connection;
	ResultSet resultset;
	PreparedStatement pstmt;
	public static final Logger logger = Logger.getLogger(RegistrationDAO.class
			.getName());

	public boolean registerEmployee(RegistrationDTO registrationdto)
			throws RegistrationUserDefinedException,
			ConstraintUserDefinedException, SQLException, NamingException {
       logger.info("In RegistrationDAO registerEmployee method ");
		connection = DBConnection.getDbConnection().getConnection();
		logger.info("In Registration DAO");
		try {
			logger.info("SQLQuery:SELECT emp_id FROM employee_master_details where emp_id=?");
			pstmt = connection
					.prepareStatement("SELECT emp_id FROM employee_master_details where emp_id=?");
			pstmt.setString(1, registrationdto.getEmpID());
			resultset = pstmt.executeQuery();
			if (resultset.next()) {

				pstmt = connection
						.prepareStatement("INSERT into User_table values(?,?,?,?,?,?,'n')");
				pstmt.setString(1, registrationdto.getFirstName());
				pstmt.setString(2, registrationdto.getLastName());
				pstmt.setString(3, registrationdto.getEmpID());
				pstmt.setString(4, registrationdto.getEmailid());
				pstmt.setString(5, registrationdto.getProjectName());
				pstmt.setString(6, registrationdto.getPassword());
				int insertrows = pstmt.executeUpdate();
                  connection.commit();
						if (insertrows > 0) {
		
							return true;
						} else {
							return false;
						}

			} 
			else
			{

				return false;
			}
        
		} 
		catch (SQLException e) {
			connection.rollback();
			logger.error("in SQL exception registration DAO" + e.getMessage());
			if (e.getMessage().contains("ORA-00001") || connection == null) {
				throw e;}
		}
		
		 finally {

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
		 logger.info("Returning the register status to RegistrationBO class");
		return false;

	}
}
