package com.royal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URLNAME="jdbc:mysql://localhost:3306/testapp";
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String USERNAME="root";
	private static final String PASSWORD="";
	
	public static Connection getDBConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URLNAME, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
