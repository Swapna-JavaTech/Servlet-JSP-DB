package com.hexaware.servletjspdb.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection conn = null;
	public DBConnection() {
		
	}
	
	public static Connection getDBConnection() {
		
		//Register the Driver
		try {
			Class.forName("org.h2.Driver");
		
		//Establish DB Connection
		conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
