/************************************************************************************
 * File:        AddProblemSolutionDAO.java
 * Package:     com.igate.isr.dao
 * Desc:        Add problem solution to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Jawahar		       9-12-2010       Initial version
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
import org.apache.struts.util.LabelValueBean;

import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.ProblemSolutionDTO;
import com.igate.isr.dto.TechnologyDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;

public class AddProblemSolutionDAO {
	public static final Logger logger = Logger
			.getLogger(AddProblemSolutionDAO.class.getName());

	/*
	 * Logger object is created for AddProblemSolutionDAO class
	 */

	public List<LabelValueBean> getTechnology()
			throws AddProblemSolutionUserDefinedException,
			NullPointerException, ClassNotFoundException
			/*
			 * getTechnology() method of AddProblemSolutionDAO class retrieves
			 * the technologylist from database
			 */, NamingException, SQLException

	{
		logger.info("Inside AddProblemSolutionDAO class,getTechnology method");
		
		List<LabelValueBean> technologyList = new ArrayList<LabelValueBean>();
		TechnologyDTO techdto = null;
		
		Connection con = null;
		ResultSet technologySet = null;
		PreparedStatement loadTechPS = null;
		try {
			
			con = DBConnection.getDbConnection().getConnection();
			
			String sqlQuery = null;
			logger.info("SQLQuery:SELECT technology_code,initcap(technology_name) FROM TECHNOLOGY_MASTER_DETAILS ORDER BY technology_name ASC");
			sqlQuery = "SELECT technology_code,initcap(technology_name) FROM TECHNOLOGY_MASTER_DETAILS ORDER BY technology_name ASC";
			
			loadTechPS = con.prepareStatement(sqlQuery);
			technologySet = loadTechPS.executeQuery();/* Query is executed */
			
			LabelValueBean labelValue;
			while (technologySet.next()) {
				
				labelValue = new LabelValueBean();
				techdto = new TechnologyDTO();
				techdto.setTechCode(technologySet.getString("technology_code"));
				techdto.setTechName(technologySet.getString(2));
				labelValue.setValue(techdto.getTechCode());
				labelValue.setLabel(techdto.getTechName());

				technologyList.add(labelValue);
				
			}
		}
         catch(SQLException se){
        	 logger.error("SQLException ADDproblemSolution: "+se.getMessage());
        	 throw se;
        	 
         }
		finally {
			if (technologySet != null) {
				technologySet.close();
			}
			if (loadTechPS != null) {

				loadTechPS.close();
			}

			if (con != null) {

				con.close();/* Connection is closed */
			}
		}

		logger
				.info("technologyList is returned to getTechnology method of AddProblemSolutionBO class");
		return technologyList;/* TechnologyList is returned */
	}

	public boolean addProblemSolution(ProblemSolutionDTO problemSolutionDto)
			throws AddProblemSolutionUserDefinedException,
			NullPointerException, ClassNotFoundException, NamingException,
			SQLException
	/*
	 * addProblemSolution(ProblemSolutionDTO problemSolutionDto) method of
	 * AddProblemSolutionDAO class inserts the AddProblemSolutionForm elements
	 * to the database
	 */
	{
		logger.info("Inside AddProblemSolutionDAO class,addProblemSolution method");
		
		Connection con = null;
		PreparedStatement addProbPS = null;
		String sqlQuery = null;
		int insertStatus = 0;
		boolean status = false;
		try {
			
			con = DBConnection.getDbConnection().getConnection();
			logger.info("SQLQuery:INSERT INTO SOLUTION_REPOSITORY(problem_id,problem_statement,solution,emp_id,technology_code,keyword,status,added_date) VALUES(prob_id.NEXTVAL,?,?,?,?,?,Submitted,sysdate");
			sqlQuery = "INSERT INTO SOLUTION_REPOSITORY(problem_id,problem_statement,solution,emp_id,technology_code,keyword,status,added_date) VALUES(prob_id.NEXTVAL,?,?,?,?,?,'Submitted',sysdate)";
			addProbPS = con.prepareStatement(sqlQuery);
		
			addProbPS.setString(1, problemSolutionDto.getProblem());
			
			addProbPS.setString(2, problemSolutionDto.getSolution());
			
			addProbPS.setInt(3, Integer.valueOf(problemSolutionDto.getEmpID()));
			
			addProbPS.setString(4, problemSolutionDto.getTechCode());
			String keyword=problemSolutionDto.getKeyword().toLowerCase();
			addProbPS.setString(5,keyword);
			
			insertStatus = addProbPS.executeUpdate();/* Query is executed */
			
			con.commit();

			if (insertStatus > 0) {
				
				status = true;
			} else {
				
				status = false;
			}
		}
		 catch(SQLException se){
			 con.rollback();
        	 logger.error("SQLException ADDproblemSolution: "+se.getMessage());
        	 throw se;
        	
         }
		finally {

			if (addProbPS != null) {

				addProbPS.close();
			}

			if (con != null) {
                 
				con.close();/* Connection is closed */
			}

		}
		logger.debug("status is returned to addProblemSolution method of AddProblemSolutionBO class");
		return status;/* status is returned back to AddProblemSolutionBO class */
	}
}
