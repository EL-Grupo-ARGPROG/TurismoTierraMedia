package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TierraMediaConnectionProvider {

	private static String url = "jdbc:sqlite:C:\\Users\\PC\\eclipse-workspace\\TurismoTierraMedia\\DB.db";
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = DriverManager.getConnection(url);
		}
		return connection;
	}
}
