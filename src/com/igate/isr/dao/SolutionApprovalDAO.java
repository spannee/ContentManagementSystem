/************************************************************************************
 * File:        SolutionApprovalDAO.java
 * Package:     com.igate.isr. dao
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Rushmitha		       9-12-2010       Initial version
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

import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.SolutionApprovalDTO;


public class SolutionApprovalDAO {

	SolutionApprovalDTO solAppDTO;
	List<SolutionApprovalDTO> submittedSolutions = new ArrayList<SolutionApprovalDTO>();

	Connection con = null;
	String query;
	int update;
	ResultSet resultSet;
	int count = 0;
	PreparedStatement psmt;
	Logger logger = Logger.getLogger(SolutionApprovalDAO.class.getName());

	public List<SolutionApprovalDTO> getPendingDetails()
			throws  NamingException, SQLException {
		logger.info("In SolutionApprovalDAO--------getPendingDetails()------");
		try {
			con = DBConnection.getDbConnection().getConnection();
			logger.info("SQLQuery:SELECT initcap(first_name),initcap(solution_repository.emp_id),initcap(technology_name),problem_statement,solution,problem_id FROM user_table,technology_master_details,solution_repository WHERE user_table.emp_id=solution_repository.emp_id AND solution_repository.technology_code=technology_master_details.technology_code AND status=Submitted ORDER BY added_date DESC");
			psmt = con
					.prepareStatement("SELECT initcap(first_name),initcap(solution_repository.emp_id),initcap(technology_name),problem_statement,solution,problem_id FROM user_table,technology_master_details,solution_repository WHERE user_table.emp_id=solution_repository.emp_id AND solution_repository.technology_code=technology_master_details.technology_code AND status='Submitted' ORDER BY added_date DESC");
			
			resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				
				solAppDTO = new SolutionApprovalDTO();
				solAppDTO.setEmpName(resultSet.getString(1));
				String empId = String.valueOf(resultSet.getInt(2));
				solAppDTO.setEmpId(empId);
				solAppDTO.setTechnologyName(resultSet.getString(3));
				solAppDTO.setProblem(resultSet.getString(4));
				solAppDTO.setSolution(resultSet.getString(5));
				String problemId = String.valueOf(resultSet.getInt(6));
				solAppDTO.setProblemId(problemId);
			
				submittedSolutions.add(solAppDTO);

				count++;

			}

		} 
		catch(SQLException se){
		   	 logger.error("SQLException SolutionApproval get Pending details: "+se.getMessage());
		   	 throw se;
		   	 
		    }
		finally {
		
		
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (con != null) {
					
					con.commit();
					con.close();
				}
				if(psmt!=null){
					psmt.close();
			} 

		}
		return submittedSolutions;

	}

	public boolean updateSolutionStatus(int[] problemId, int status) throws SQLException, NamingException
			  {
		logger.info("In SolutionApprovalDAO--------updateStatus------");
		try {

			con = DBConnection.getDbConnection().getConnection();
			
			if (status == 1) {
				query = "'Approved'";

			} else if (status == 0) {
				query = "'Rejected'";

			}
			logger.info("SQLQuery:Update  solution_repository SET Status =+ query+ ,verified_date=sysdate WHERE problem_id=+ count");
			for (int count : problemId) {
				psmt = con
						.prepareStatement("Update  solution_repository SET Status ="
								+ query
								+ ",verified_date=sysdate WHERE problem_id="
								+ count);
				update = psmt.executeUpdate();
				con.commit();
				
			}
		}
		catch(SQLException se){
		   	 logger.error("SQLException SolutionApproval update: "+se.getMessage());
		   	con.rollback();
		   	 throw se;
		   	 
		    }
		finally {
			
				if (resultSet != null) {
					resultSet.close();
				}
				if (con != null) {
					con.close();
				}
				if(psmt!=null){
					psmt.close();
			} 
			}

		

		if (update == 1) {
			logger
					.info("In SolutionApprovalDAO--------updateStatus------query executed failed ----");
			return false;

		}

		else {
			logger
					.info("In SolutionApprovalDAO--------updateStatus------query executed successfully ----");
			return true;
		}

	}
}
