import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
class Connection5 {
    public static void main(String args[]){
        try{
            // step1 : Register Driver
            Driver d = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(d);
            System.out.println("Driver Registered...!");

            //step2 : Get Connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "system", "ishwar2004");
            System.out.println("Connection Successfull...!");

            //step3 : Create Statment Object
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            //stmt.executeUpdate("Create table stud5(id number(5),name varchar(10))");
            System.out.println("Object Created...!");
            
            //step4 : Execute Query            
            ResultSet rs = stmt.executeQuery("select * from stud5");
            System.out.println("Student Table :");
            System.out.println("Id\tName");
            while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
			}

            rs.first();
            System.out.println("First row :"+rs.getInt(1)+"  "+rs.getString(2));

            rs.last();
            System.out.println("Last row :"+rs.getInt(1)+"  "+rs.getString(2));

            rs.absolute(2);
            System.out.println("selected row :"+rs.getInt(1)+"  "+rs.getString(2));


            //Step5 : Close Connection
            con.close();

        }
        catch(SQLException e){
            System.out.println("SQL Exception :"+e);
        }
    }
}
