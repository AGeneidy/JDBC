import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;
import DBMS.*;

public class JDBCDriver implements Driver {
	
	private String username = "cutepuppy";
	private String password = "69696969";
	
	// static initializer :v
	static {
		// register the driver:
		try {
			DriverManager.registerDriver(new JDBCDriver());
		} catch (SQLException e1) {
			// cannot register :(
		}
    }
	
	// resolve the url:
	private String urlToDataBase(String url) {
		String[] tokens = url.split(":");
		
		// url format:
		// jdbc:dbms:costa:localhost::<dbname>
		
		if (tokens.length != 6)
			return null;
		
		if (!tokens[0].equals("jdbc"))
			return null;
		
		if (!tokens[1].equals("dbms"))
			return null;
		
		if (!tokens[2].equals("costa")) // sub-protocol (implemented
			return null;
		
		if (!tokens[3].equals("localhost"))
			return null;
		
		if (!tokens[4].equals(""))
			return null;
		
		return tokens[5]; // database name
	}
	
	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return urlToDataBase(url) != null;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		String dbName = urlToDataBase(url);
		String iUsername = info.getProperty("user");
		String iPassword = info.getProperty("password");
		// valid URL?
		if (dbName == null)
			return null;
		// check user name and password:
		if (iUsername == null || iPassword == null ||
		    iUsername != username || iPassword != password)
			throw new java.sql.SQLClientInfoException();
		// connect to the database:
		DBMS dbms = new StdDBMS();
		try {
			dbms.setUsedDB(dbName);
		} catch (Exception e) {
			throw new SQLException("Database not found!");
		}
		// create new connection
		return new JDBCConnection();
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info)
			throws SQLException {
		return null;
	}

	// ------------------------------------------------------\\
	// /////////--------- UNUSED METHODS ----------\\\\\\\\\\\\
	// ------------------------------------------------------\\

	@Override
	public int getMajorVersion() {
		return 0;
	}

	@Override
	public int getMinorVersion() {
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public boolean jdbcCompliant() {
		return false;
	}

}
