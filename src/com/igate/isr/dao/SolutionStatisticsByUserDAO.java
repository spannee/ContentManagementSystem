/************************************************************************************
 * File:        SolutionStatisticsByUserDAO.java
 * Package:     com.igate.isr. dao
 * Desc:         SolutionStatisticsByUser to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Subash		       9-12-2010       Initial version
 ************************************************************************************/

package com.igate.isr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

import com.igate.isr.actions.SolutionStatisticsByUserAction;
import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.SolutionStatisticsByUserDTO;

public class SolutionStatisticsByUserDAO {
	// creating logger,PreparedStatement,DBConnection object

	public static final Logger logger = Logger
			.getLogger(SolutionStatisticsByUserAction.class.getName());

	public List<SolutionStatisticsByUserDTO> getSolutionStatisticsByUser()
			throws SQLException, ClassNotFoundException, NamingException {
		PreparedStatement prestatObject = null;
		ResultSet resultsetObj = null;
		Connection con = null;

		logger
				.info("logger object created in DAO class before calling DBConnection class to get the connection");
		List<SolutionStatisticsByUserDTO> statsList = new ArrayList<SolutionStatisticsByUserDTO>();

		try { // Calling the DBConnection class to get the connection object//
			
			con = DBConnection.getDbConnection().getConnection();
			
			SolutionStatisticsByUserDTO ststsDTO = null;
			
			logger
					.info("SELECT se1.emp_id,initcap(se2.first_name || se2.last_name) name,se2.project_name, count(distinct sub) Submitted, count(distinct appr) Approved , count(distinct rej) Rejected FROM (SELECT emp_id, sub,  appr,rej FROM (SELECT DISTINCT a.emp_id, a.problem_id sub, b.problem_id appr, c.problem_id rej FROM solution_repository a,(SELECT emp_id, problem_id FROM solution_repository WHERE status='Approved') b,(SELECT emp_id, problem_id FROM solution_repository WHERE status='Rejected') c WHERE a.emp_id = b.emp_id(+) and a.emp_id=c.emp_id(+) )) se1,user_table se2 WHERE se1.emp_id=se2.emp_id GROUP BY se1.emp_id,se2.first_name,se2.last_name,se2.project_name");
			prestatObject = con
					.prepareStatement("SELECT se1.emp_id,initcap(se2.first_name ||' '|| se2.last_name) name,initcap(se2.project_name), count(distinct sub) Submitted, count(distinct appr) Approved , count(distinct rej) Rejected FROM (SELECT emp_id, sub,  appr,rej FROM (SELECT DISTINCT a.emp_id, a.problem_id sub, b.problem_id appr, c.problem_id rej FROM solution_repository a,(SELECT emp_id, problem_id FROM solution_repository WHERE status='Approved') b,(SELECT emp_id, problem_id FROM solution_repository WHERE status='Rejected') c WHERE a.emp_id = b.emp_id(+) and a.emp_id=c.emp_id(+) )) se1,user_table se2 WHERE se1.emp_id=se2.emp_id GROUP BY se1.emp_id,se2.first_name,se2.last_name,se2.project_name");
			resultsetObj = prestatObject.executeQuery();
			
			while (resultsetObj.next()) {
				
				ststsDTO = new SolutionStatisticsByUserDTO();
				String semp = String.valueOf(resultsetObj.getInt(1));
				ststsDTO.setEmpid(semp);
				
				ststsDTO.setEname(resultsetObj.getString(2));
				
				ststsDTO.setProjName(resultsetObj.getString(3));
				
				ststsDTO.setSubmit(resultsetObj.getInt(4));
				
				ststsDTO.setApprove(resultsetObj.getInt(5));
				
				ststsDTO.setRejecte(resultsetObj.getInt(6));
				
				statsList.add(ststsDTO);
				
			}

			

		}
		catch(SQLException se){
		   	 logger.error("SQLException Statistics by User : "+se.getMessage());
		   	 throw se;
		   	 
		    }

		finally {

			
			if (con != null) {
				con.close();
				
			}
			if (prestatObject != null) {
				prestatObject.close();
				
			}
			if (resultsetObj != null) {
				resultsetObj.close();
				
			}

			
		}
		logger.info("DAO class returning the  list to BO");
		
		return statsList;
	}
}
