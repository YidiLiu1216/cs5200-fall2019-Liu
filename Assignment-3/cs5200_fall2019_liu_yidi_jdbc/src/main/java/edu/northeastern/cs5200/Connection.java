package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection { 
	 
private static final String DRIVER = "com.mysql.jdbc.Driver";
private static final String URL = "jdbc:mysql://cs5200-fall2019-liu.cqp8vapklpzg.us-east-1.rds.amazonaws.com:3306/cs5200_fall2019_liu_hw3";
private static final String USER = "flyingcat";
private static final String PASSWORD = "miao19960612liu";
private static java.sql.Connection dbConnection = null; 
 
public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName(DRIVER); 
 
if (dbConnection == null) { 
	dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
	return dbConnection; 
	} 
else { return dbConnection; } } 

 public static void closeConnection() { 
	 try {   
		 if (dbConnection != null) {
			 dbConnection.close(); 
			 dbConnection = null; }
		 } catch (SQLException e) {
			 // TODO Auto-generated catch block   
			 e.printStackTrace();   
		 }
	 }
 }
 
