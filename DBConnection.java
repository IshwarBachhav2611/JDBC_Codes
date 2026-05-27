package com.ishwar.demoproject;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class DBConnection {
	public static void main(String[] args)throws Exception {
		
		//take date from User
		String name = "jayesh";
		String email = "Jayesh@gmail.com";
		String password = "1234";
		String city = "Chennai";
		
		//Load & Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Registretion Successfull..!");
		
		//Create Connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db","root","ishwar2004");
		System.out.println("Connection Successfull..!");
		
		//Create Statement(insert values)
		
		//insert values manually
		//PreparedStatement ps= con.prepareStatement("insert into register values('shubham', 'shubham@gmail.com', '1234', 'shahada')");
		
		//insert values using variables;
		//PreparedStatement ps= con.prepareStatement("insert into register values('"+name+"', '"+email+"', '"+password+"', '"+city+"')");
		
		//insert values using Positional Parameters(best way)
		PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?)");
		ps.setString(1, name);
		ps.setString(2, email);
		ps.setString(3, password);
		ps.setString(4, city);
		
		//Execute SQL Statement
		int i = ps.executeUpdate();
		if(i>0) {
			System.out.println("Values Inserted...!");		
		}else {
			System.out.println("Values Not Inserted...!");		
		}
		
		con.close();		
	}
}
