/************************************************************************************
 * File:       TechnologystatisticsDAO.java
 * Package:     com.igate.isr. dao
 * Desc:        Technologystatistics to iSolutionsRepository
 * Version:     1.0
 * Restrictions:
 * Modifications:
 * Author:          		Date:          Change Description:
 * Supriya		       9-12-2010       Initial version
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
import com.igate.isr.actions.TechnologyStatisticsAction;
import com.igate.isr.db.DBConnection;
import com.igate.isr.dto.TechnologyStatisticsDTO;

public class TechnologyStatisticsDAO {
	public static final Logger logger = Logger
			.getLogger(TechnologyStatisticsAction.class.getName());
	DBConnection dbcon;

	public List<TechnologyStatisticsDTO> getTechnologyStatistics()
			throws SQLException, ClassNotFoundException, NamingException {
		PreparedStatement psobject = null;
		Connection con = null;
		ResultSet rsobject = null;
		dbcon = new DBConnection();
		TechnologyStatisticsDTO techDTO;
		logger
				.info("logger object created in DAO class before calling DBConnection class to get the connection");

		List<TechnologyStatisticsDTO> techlist = new ArrayList<TechnologyStatisticsDTO>();
		try { // Calling the DBConnection class to get the connection object//
			
			con = DBConnection.getDbConnection().getConnection();
		    logger
					.info("SQLQuery:SELECT se2.technology_name, count(distinct sub) Submitted, count(distinct appr) Approved,count(distinct rej) Rejected FROM(SELECT technology_code, sub, appr,rej FROM(SELECT DISTINCT a.technology_code, a.problem_id sub, b. problem_id appr, c. problem_id rej FROM solution_repository a,(SELECT technology_code, problem_id FROM solution_repository where status=Approved) b,(SELECT technology_code, problem_id FROM solution_repository where status=Rejected) c WHERE a.technology_code = b.technology_code(+) and a.technology_code=c.technology_code(+))) se1,technology_master_details se2 WHERE se1.technology_code=se2.technology_code GROUP BY se2.technology_name");

			psobject = con
					.prepareStatement("SELECT initcap(se2.technology_name), count(distinct sub) Submitted, count(distinct appr) Approved,count(distinct rej) Rejected FROM(SELECT technology_code, sub, appr,rej FROM(SELECT DISTINCT a.technology_code, a.problem_id sub, b. problem_id appr, c. problem_id rej FROM solution_repository a,(SELECT technology_code, problem_id FROM solution_repository where status='Approved') b,(SELECT technology_code, problem_id FROM solution_repository where status='Rejected') c WHERE a.technology_code = b.technology_code(+) and a.technology_code=c.technology_code(+))) se1,technology_master_details se2 WHERE se1.technology_code=se2.technology_code GROUP BY se2.technology_name");
			rsobject = psobject.executeQuery();
			
			while (rsobject.next()) {
				
				techDTO = new TechnologyStatisticsDTO();
				techDTO.setTechName(rsobject.getString(1));
				
				techDTO.setSubmitted(rsobject.getInt(2));
				
				techDTO.setAppr(rsobject.getInt(3));
				
				techDTO.setRej(rsobject.getInt(4));
				
				techlist.add(techDTO);
				
			}
          
		}
		catch(SQLException se){
		   	 logger.error("SQLException TechnologyStatistics: "+se.getMessage());
		   	 throw se;
		   	 
		    }
		finally {

			
			if (con != null) {
				con.close();

				
			}
			if (psobject != null) {
				psobject.close();

			
			}
			if (rsobject != null) {
				rsobject.close();

			}
			

		}
		logger.debug("DAO class returning the  list to BO");
		return techlist;
	}

}
