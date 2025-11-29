import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

class Connection2
{
	public static void main(String args[]){
		try{
			// Step1: Register the Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Registered Succesfully...!");

			// Step2: Get Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","ishwar2004");
			System.out.println("Connection Succesfull...!");

			// Step3: Create Statment Object
			Statement stmt = con.createStatement();
			System.out.println("Statment Object Created...!");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enetr ID And Name :");
			int id = sc.nextInt();
			String Name = sc.next();

			// Step4: Execute Query 
			//stmt.executeUpdate("create table stud2(ID number(3),Name varchar2(10))");		
			stmt.executeUpdate("insert into stud2 values("+id+",'"+Name+"')");
			System.out.println("Query Executed...!");

			// Step5: close Connection
			con.close();
 	
		}
		catch(SQLException ex){
			System.out.println("Sql Exception....!"+ex);	
		}
	}
}