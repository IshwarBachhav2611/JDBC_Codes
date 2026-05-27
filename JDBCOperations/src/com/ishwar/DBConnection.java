package com.ishwar;

import java.sql.DriverManager;
import java.sql.Connection;
public class DBConnection {
	public static String url = "jdbc:mysql://localhost:3306/jdbc_db";
	public static String id = "root";
	public static String password = "ishwar2004";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			//Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create Connection
			connection = DriverManager.getConnection(url,id,password);
			System.out.println("Connection Successfull...!");
			
		}
		catch(Exception e) {
			System.out.println("Connection Failed..!"+e);
		}
		return connection;
	}
}
