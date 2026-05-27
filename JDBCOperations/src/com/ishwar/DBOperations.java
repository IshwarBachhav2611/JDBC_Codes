package com.ishwar;
import com.ishwar.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class DBOperations {
	Scanner sc = new Scanner(System.in);
	Connection connection = DBConnection.getConnection();
	PreparedStatement ps;
	String name;
	String email;
	String password;
	int id;
	
	//Insert Data
	public void InsertRecord(){
		
		System.out.println("-Insert Operation");
		System.out.print("Enter Name:");
		name = sc.next();
		System.out.print("Enter email:");
		email = sc.next();
		System.out.print("Enter password:");
		password = sc.next();
		System.out.print("Enter id:");
		id = sc.nextInt();
		
		try {
			PreparedStatement ps = connection.prepareStatement("insert into records values(?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setInt(4, id);
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Inserted...!");
			}else {
				System.out.println("Record not inserted...!");
			}
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	
	
	//Updates Records 
	//name by id
	public void UpdateName() {
		System.out.println("-Update Name:");
		System.out.print("Enter new Name:");
		name = sc.next();
		System.out.print("Enter record id:");
		id = sc.nextInt();
		
		try {
			ps = connection.prepareStatement("update records set name=? where id=?");
			ps.setString(1, name);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Updated...!");
			}else {
				System.out.println("Record not Updated...!");
			}
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	
	//email by id
	public void UpdateEmail() {
		System.out.println("-Update Email");
		System.out.print("Enter new Email:");
		email = sc.next();
		System.out.print("Enter record id:");
		id = sc.nextInt();
		
		try {
			ps = connection.prepareStatement("update records set email=? where id=?");
			ps.setString(1, email);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Updated...!");
			}else {
				System.out.println("Record not Updated...!");
			}
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	//password by id
	public void UpdatePassword() {
		System.out.println("-Update Password");
		System.out.print("Enter new password:");
		password = sc.next();
		System.out.print("Enter record id:");
		id = sc.nextInt();
		
		try {
			ps = connection.prepareStatement("update records set passwors=? where id=?");
			ps.setString(1, email);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Updated...!");
			}else {
				System.out.println("Record not Updated...!");
			}
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	
	
	//Delete Records 
	public void DeleteRecord() {
		System.out.println("-Delete Record ");
		System.out.print("Enter record id:");
		id = sc.nextInt();
		
		try {
			ps = connection.prepareStatement("delete from records where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Record Deleted...!");
			}else {
				System.out.println("Record not Deleted...!");
			}
		}catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}
	
	//fetch record 
	public void getRecord() {
			System.out.println("-Get Record");
			System.out.print("Enter record id:");
			id = sc.nextInt();
		try {	
			ps = connection.prepareStatement("select * from records where id=?");
			ps.setInt(1,id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID :"+rs.getInt("id"));
				System.out.println("Name :"+rs.getString("name"));
				System.out.println("Email :"+rs.getString("email"));
				System.out.println("Password :"+rs.getString("password"));
			}
			
		}catch(Exception e) {
			System.out.println("Exception ;"+e);
		}
	}
}