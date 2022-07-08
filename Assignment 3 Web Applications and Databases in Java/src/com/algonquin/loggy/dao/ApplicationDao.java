package com.algonquin.loggy.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.algonquin.loggy.beans.TextLog;
import com.algonquin.loggy.services.ApplicationService;

public class ApplicationDao implements ApplicationService {

    public ApplicationDao() {

    	
    	
    }
    
    public List<TextLog> getTextLogListFromDatabase() throws SQLException{

    	Connection dbConnection = DBConnection.getConnectionToDatabase();
    	List<TextLog> textLogArrayList = new ArrayList<TextLog>();
    	TextLog txtLog = null;
    	
    	
    	PreparedStatement sqlQueryStatement = dbConnection.prepareStatement("SELECT * FROM loggy.logs ORDER BY Timestamp DESC");
    	ResultSet resultSetFromQuery = sqlQueryStatement.executeQuery();
    	    	    	
    	
    	while(resultSetFromQuery.next()){
    		
    		txtLog = new TextLog();
    		    		
    		//resultSetFromQuery.getSTring() is selecting the column ID to pull from the Database Table
    		txtLog.setId(resultSetFromQuery.getString("UUID"));
    		txtLog.setTitle(resultSetFromQuery.getString("Title"));
    		txtLog.setContent(resultSetFromQuery.getString("Content"));
    		txtLog.setTimestamp(resultSetFromQuery.getTimestamp("Timestamp"));
    		textLogArrayList.add(txtLog);
    		
    	}
    	System.out.println("getLogFrom Database");
    	dbConnection.close();
    	return textLogArrayList;
    	
    }
    
    
   public int addTextLogToDatabase(TextLog txtLog) throws SQLException {
	   
	   Connection dbConnection = DBConnection.getConnectionToDatabase();
	   String insertSqlQuery = "INSERT INTO logs VALUES(?,?,?,?)";
	   PreparedStatement sqlStatment = dbConnection.prepareStatement(insertSqlQuery);
	   
	   sqlStatment.setString(1, txtLog.getId().toString());
	   sqlStatment.setString(2, txtLog.getTitle());
	   sqlStatment.setString(3, txtLog.getContent());
	   
	   Date utilDate = txtLog.getTimestamp(); //get
	   Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());  
	   sqlStatment.setTimestamp(4,  sqlTimestamp); //If this messes with things just store it as a string.
	   
	   
	   System.out.println("adding Log via query pattern: " + insertSqlQuery);
	   
	   
	   int rowsAffected = sqlStatment.executeUpdate();
	   
	   dbConnection.close(); 
	   
	   return rowsAffected;   
   }
   
   
   
   
   // SQL format for DELETE FROM Customers WHERE ID='value';
   
   public int deleteTextLogFromDatabase(String logId) throws SQLException {
	   
	   Connection dbConnection = DBConnection.getConnectionToDatabase();
	   System.out.println("DeleteTextLog Connected");
	   String deleteSqlQuery = "DELETE FROM logs WHERE UUID='" + logId + "'";
	   System.out.println("DeleteTextLog query string = " + deleteSqlQuery);
	   
	   
	   PreparedStatement sqlStatment = dbConnection.prepareStatement(deleteSqlQuery);
	   
	   System.out.println("Deleteing Log matching this query= " + deleteSqlQuery);
	   
	   int rowsAffected = sqlStatment.executeUpdate();
	   dbConnection.close();	   
	   return rowsAffected;   
	   
   }
   
   public TextLog getSpeicifcTextLogFromDatabase(String logId) throws SQLException {
	   
	  TextLog textLog = new TextLog();
	   
	  Connection dbConnection = DBConnection.getConnectionToDatabase();
	  System.out.println("Get Specfic Log Connected");
	  
	  String selectLogSqlQuery = "SELECT * "
	  					       + "FROM loggy.logs "
	  					       + "WHERE UUID='" + logId +"'";
	  
	  System.out.println("Get Specfic Log query string = " + selectLogSqlQuery);
	  
	  PreparedStatement sqlQueryStatement = dbConnection.prepareStatement(selectLogSqlQuery);
	  ResultSet resultSetFromQuery = sqlQueryStatement.executeQuery();
	  
	  while(resultSetFromQuery.next()){
	  
		  textLog.setId(resultSetFromQuery.getString("UUID"));
		  textLog.setTitle(resultSetFromQuery.getString("Title"));
		  textLog.setContent(resultSetFromQuery.getString("Content"));
		  textLog.setTimestamp(resultSetFromQuery.getTimestamp("Timestamp"));
		   
	  	  System.out.println(textLog.getId());
	  	  System.out.println(textLog.getTitle());
	  	  System.out.println(textLog.getContent());
		   
	  	  System.out.println("Log to edit matching this query = " + selectLogSqlQuery);
  	  
	  }
	   
	  dbConnection.close();	   
	  return textLog;   
	   
   }
   
  public int updateTextLogInDatabase(String logId, String title, String content) throws SQLException{
	
	  Connection dbConnection = DBConnection.getConnectionToDatabase();
	  
	  String updateSqlQuery = "UPDATE loggy.logs "
	  						+ "SET Title='" + title + "', Content='" + content + "'" 
			  				+ "WHERE UUID='" + logId + "'";
	  
	  
	  PreparedStatement sqlStatment = dbConnection.prepareStatement(updateSqlQuery);
	  
  	  System.out.println("updateTextLogInDatabase query = " + updateSqlQuery);
	   
  	  System.out.println("Log to edit matching this query = " + logId);
	  
	  int rowsAffected = sqlStatment.executeUpdate();
	   
	  dbConnection.close(); 
	   
	  return rowsAffected; 
	   
   }
  
  /* SYNTAX FOR UPDATE

		UPDATE table_name
		SET column1 = value1, column2 = value2, ...
		WHERE condition;
 
   */
    

}
