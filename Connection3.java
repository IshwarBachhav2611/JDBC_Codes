import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

class Connection3
{
	public static void main(String args[]){
		try{
			//step1: Register Driver
			Driver d = new oracle.jdbc.driver.OracleDriver();
			DriverManager.registerDriver(d);
			System.out.println("Driver Registeres...!");

			//step2: Get Connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","ishwar2004");
			System.out.println("Connection Successfull...!");

			//step3: Create Prepared Statment
			System.out.println("Prepared Statment Created...!");
			PreparedStatement pstmt = con.prepareStatement("Create table Stud3(id number(3),name varchar2(10))");
			pstmt.executeUpdate();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Id and Name");
			int id = sc.nextInt();
			String name = sc.next();

			//step4: Pass values
			pstmt = con.prepareStatement("insert Into Stud3 values(?,?)");
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.executeUpdate();
			System.out.println("Value Passed...!");

			//step5: close Connection
			con.close();
			System.out.println("Connection closed...!");
			
			
		}
		catch(SQLException ex){
			System.out.println("Sql Exception....!"+ex);	
		}
	}
}