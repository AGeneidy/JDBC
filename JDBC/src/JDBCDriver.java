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
		// jdbc:dana:localhost:<dbname>
		
		if (!(tokens.length == 3 || tokens.length == 4))
			return null;
		
		if (!tokens[0].equals("jdbc"))
			return null;
		
		if (!tokens[1].equals("dana"))
			return null;
		
		if (!tokens[2].equals("localhost"))
			return null;
		
		return tokens.length == 4 ? tokens[3] : ""; // database name
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
		// instantiate DBMS:
		DBMS dbms = new StdDBMS();
		// connect to database:
		if (!dbName.equals("")) {
			try {
				dbms.setUsedDB(dbName);
			} catch (Exception e) {
				throw new SQLException("Database not found!");
			}
		}
		// create new connection
		return new JDBCConnection(dbms);
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
