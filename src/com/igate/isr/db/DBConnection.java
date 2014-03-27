package com.igate.isr.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.igate.isr.actions.SolutionStatisticsByUserAction;

public class DBConnection {
	DataSource  dsobject;
	static DBConnection dbConnection;
	public static final Logger logger = Logger.getLogger(SolutionStatisticsByUserAction.class.getName());
	public DBConnection()throws  NamingException
	{
		
			Context initContext = new InitialContext();
			Context envCtx = (Context)initContext.lookup("java:/comp/env");
			// Look up our data source
			logger.info("Look up our data source in DBConnection Connection pool"); 
			dsobject = (DataSource) envCtx.lookup("jdbc/TestDB");
			logger.info("Executed once: DBConnection Connection pool");
		
	}
	public static DBConnection getDbConnection() throws  NamingException
	{
		if(dbConnection==null)
			{
			dbConnection=new DBConnection();
			}
		
		return dbConnection;
	}
	public Connection getConnection() throws SQLException 
	{
		logger.debug("Executed more than once:DBConnection Connection pool");
		Connection con = null;
		if(dsobject!=null)
			{
			
				
				
				
						con=dsobject.getConnection();
					
				
			
			}
		logger.debug("returning the connection object from getConnection method");
		return con;
	}
}
