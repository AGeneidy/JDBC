import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class JDBCDriver implements Driver {

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		return false;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		return null;
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
