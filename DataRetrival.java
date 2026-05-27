import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class DataRetrival {
    public static void main(String[] args) throws Exception{
        //Register Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Get Connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "ishwar2004");

        //create Statement
        PreparedStatement ps = con.prepareStatement("select * from records");
        ResultSet rs = ps.executeQuery();

        
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            System.out.println("ID :"+id);
            System.out.println("Name :"+name);
            System.out.println("Email :"+email);
            System.out.println("Password :"+password);
        }

    }
}
