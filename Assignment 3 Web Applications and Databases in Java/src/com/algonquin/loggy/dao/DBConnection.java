package com.algonquin.loggy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
	
    // Database Schema
    // CREATE DATABASE loggy DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
    // CREATE TABLE logs (uuid CHAR(40) NOT NULL PRIMARY KEY, title CHAR(128),
    // content TEXT, createTimestamp Date);	private static final String username = "root";	
	

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    private static final String DB_CONNECTION_PATH = "jdbc:mysql://localhost:3306/loggy";

    public static Connection getConnectionToDatabase() {
        
    	
    	Connection dbConnObj = null;
    	
    	
    	try {
    		
    		
    		Class.forName("com.mysql.jdbc.Driver");
		
    		dbConnObj = DriverManager.getConnection(DB_CONNECTION_PATH, DB_USER, DB_PASSWORD);
			
		
			
			
		}catch(SQLException | ClassNotFoundException e) {

			System.out.println("Error: Unable to connect to database");
			e.printStackTrace();
		}
    	
    	
    	
    	if(dbConnObj != null){
    		
    		System.out.println("MySQL Database Connected!");
    	}
    	

        return dbConnObj;
    }

}
