
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class User {

	public static void main(String args[]) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test",
	            "harita", "harib");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "INSERT INTO Users (ID,Fname, Lname) "
	               + "VALUES (2, 'Harita', 'Kannan');";
	         stmt.executeUpdate(sql);

	         sql = "INSERT INTO Users(ID,Fname,Lname) "
	               + "VALUES (4, 'Emma', 'Zhang' );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }
	
}
