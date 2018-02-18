package DB;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQLController {
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/cdio";
	public static final String USER = "root";
	public static final String PASSWORD = "";
		
	public MySQLController() throws ClassNotFoundException {
		Class.forName(DRIVER_CLASS);
	}
	
	private Connection startConnection() throws SQLException {
		
		Connection connection = null;
		connection = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
		
		return connection;
	}
	
	public Connection getConnection() throws SQLException {
		return startConnection();
	}
	
}
