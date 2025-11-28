import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException; 
import java.sql.Connection;
import java.sql.Statement;

class Connection1
{
	public static void main(String args[])
	{
			try{
				// Step1 : Register the driver
				Driver d = new oracle.jdbc.driver.OracleDriver();
				DriverManager.registerDriver(d);
				System.out.println("Driver Registered Succesfully...!");

				// Step2 : Get Connection
				Connection con = DriverManager.getConnection("jsbc:oracle:thin:@localhost:1521","system","ishwar2004");
				System.out.println("Connection SuccessFull...!");

				// Step3 : Create Statement Object
				Statement stmt = con.createStatement();
				System.out.println("Statement Object Created...!");

				// Step4 : Execute the Query
				//stmt.executeUpdate("create table stud(id number(3),name varchar2(10))");
				//stmt.executeUpdate("insert into stud values(1,'ishwar')");
				stmt.executeUpdate("insert into stud values(2,'shubham')");		
				System.out.println("Query Excuted...!");
				
				// Step5 : Close Connection
				con.close();
				System.out.println("Connection Closed...!");
			}
			catch(SQLException ex)
			{
				System.out.println("Error in Database Connection....!");
			}
	}
}