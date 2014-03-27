/************************************************************************************
 * File:        ViewProblemSolutionDAO.java
 * Package:     com.igate.isr.bo
 * Desc:        Adding a new set of problem-solution to iSolutionRepository
 * Version:     1.0
 * Restrictions: Can be accessed only by a particular company personnel(whose employeeIDs are already registered)
 * Modifications:
 * Author:          		Date:          Change Description:
 *  Boni Krishna Chaitanya    09-12-2010       Final Version
  
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

import com.igate.isr.actions.ViewProblemSolutionAction;
import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.ViewProblemSolutionDTO;
import com.igate.isr.exception.AddProblemSolutionUserDefinedException;
import com.igate.isr.exception.ViewProblemSolutionUserDefinedException;



public class ViewProblemSolutionDAO {
     Connection con=null;
     ResultSet resultSet;
 	PreparedStatement psmt;
   
    List<ViewProblemSolutionDTO> probSolList=new ArrayList<ViewProblemSolutionDTO>();
	 ViewProblemSolutionDTO  viewProbSolDTO;
	 Logger logger = Logger.getLogger(ViewProblemSolutionAction.class.getName());
	public List<ViewProblemSolutionDTO> viewProblemSolutionDetails(String EmpId) throws SQLException, ClassNotFoundException, NamingException 
	{
		
		try{
			 con=DBConnection.getDbConnection().getConnection();
			 psmt = con.prepareStatement("SELECT to_char(added_date),problem_statement,solution,status,to_char(verified_date) FROM solution_repository WHERE emp_id="+EmpId+"ORDER BY added_date desc");
			 logger.info("**************************Prepared Statement***********************");
			 resultSet = psmt.executeQuery();
			 logger.info("*************************Got the data into Result set******************");
			
		while(resultSet.next())
		{
			 viewProbSolDTO=new ViewProblemSolutionDTO();
			 viewProbSolDTO.setAddedDate(resultSet.getString(1));
			 viewProbSolDTO.setEmpId(EmpId);
			 viewProbSolDTO.setProblemStatement(resultSet.getString(2));
			 viewProbSolDTO.setSolution(resultSet.getString(3));
			 viewProbSolDTO.setStatus(resultSet.getString(4));
			 String verifiedStatus=resultSet.getString(5);
			 if(verifiedStatus!=null)
			 {
				 viewProbSolDTO.setVerifiedDate(verifiedStatus);
				
			 }
			 else
			 {
				 verifiedStatus="Not yet verified";
				 viewProbSolDTO.setVerifiedDate(verifiedStatus);
			 }
			
			 
			 
			 probSolList.add( viewProbSolDTO);
		}
		}
		catch(SQLException se){
			logger.error("SQLException view problem solution : "+se.getMessage());
			
			throw se;
		}
		
		finally{
			
				if(con!=null){
					con.close();
				}
				if(resultSet!=null){
					
					resultSet.close();
				}
				if(	psmt!=null){
				psmt.close();
				}
				
			
		}
	      return  probSolList;
		
	}
}
