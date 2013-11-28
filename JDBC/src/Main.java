import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {

		// This is to be CMD main interface required in the problem statement
		// All of the "Try to"s are necessary

		// Steps :
		// --------
		// 1- Try to check for existence of the JDBC driver
		// 2- Try to obtain and register the JDBC driver to the DriverManager
		// the previous two steps can be merged into one
		// 3- Try to obtain the connection from the DriverManager
		// 4- Try to obtain a statement instance
		// 5- Try to direct all SQL statements to the statement instance
		
		// 1,2: load the JDBC driver (it registers itself automatically :D)
		// ------------------------------------------------------------------
		try {
			Class.forName("JDBCDriver"); // our DBMS Driver :D
		} catch(ClassNotFoundException e) {
		    System.err.println("Error loading driver: " + e);
		}
		
		// 3: obtain connection:
		// ----------------------
		try {
			DriverManager.getConnection("jdbc:dana:localhost:foe", "cutepuppy", "69696969");
		} catch (SQLException e) {
			System.err.println("Error creating connection: " + e);
		}
		
	}
}
