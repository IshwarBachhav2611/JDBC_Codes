import java.sql.SQLException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
class Connection4{
	public static void main(String args[]){
		
		try{
			//Step1: Register the Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver registerd Sucessfully...!");

			//Step2: Create Connection Object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","ishwar2004");
			System.out.println("Connection Sucessfull...!");

			//Step3: create statment object
			//Statement stmt = con.createStatement();
			System.out.println("Statment Object Created Successfully...!");
			PreparedStatement pstmt = con.prepareStatement("Create table Stud4(id number(3),Name varchar2(10))");
			//pstmt.executeUpdate();

			//Get input from user
			Scanner sc = new Scanner(System.in);
			System.out.println("Want to Add items (1 for yes)/(2 for no): ");
			int condition = sc.nextInt();
			while(condition == 1){
				System.out.println("Enter ID and Name :-");
				int id = sc.nextInt();
				String name = sc.next();
				condition = sc.nextInt();
				
				//Step4: Execute Query
				pstmt = con.prepareStatement("insert into stud4 values(?,?)");
				pstmt.setInt(1,id);
				pstmt.setString(2,name);
				pstmt.executeUpdate();
				System.out.println("Value Saved Successfully...!");
			}

			//Get values ResultSet
			PreparedStatement pstmt2 = con.prepareStatement("select * from stud4");
			ResultSet rs = pstmt2.executeQuery();
			System.out.println("\nData Retrived from Table....!");
			while(rs.next()){
				System.out.println("Id : "+rs.getInt(1)+" Name : "+rs.getString(2));
			}

			//Step5: close Connection
			con.close();
			System.out.println("Connection Close...!");
		}

		catch(SQLException ex){
			System.out.println("SQL Exception...!"+ex);
		}

	}
}
