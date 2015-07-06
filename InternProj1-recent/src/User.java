
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class User {

	public static void main(String args[]) {
	      Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test",
	            "postgres", "harib");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");
	         
             int id;
             String fName;
             String lName;
             
             Scanner dd = new Scanner(System.in);
             
             System.out.println("Enter id.");
             id = dd.nextInt();
             System.out.println("Enter First Name.");
             fName = dd.next();
             System.out.println("Enter Last Name.");
             lName = dd.next();
             
             PreparedStatement ps = c.prepareStatement(
            		 "UPDATE user_info set Fname = ?, Lname = ? where ID =?;");
             ps.setString(1,fName);
             ps.setString(2,lName);
             ps.setInt(3,id);
             ps.executeUpdate();
             
             ps.close();
             
//             String query = "INSERT INTO user_info ("
//            		    + " ID,"
//            		    + " Fname,"
//            		    + " Lname ) VALUES ("
//            		    + " ?, ?, ?)";
//             PreparedStatement ps = c.prepareStatement(query);
//             ps.setInt(1, id);
//             ps.setString(2, fName);
//             ps.setString(3, lName);
//             ps.executeUpdate();
//             
//             ps.close();

             
             
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }
	
}
