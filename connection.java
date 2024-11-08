package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	private static final String URL = "jdbc:mysql://localhost:3306/Banking";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "12345";
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Database connected successfully");
		} catch (SQLException e) {
			System.err.println("Connection failed!");
			e.printStackTrace();
		} 
		return c;
	}
	public static void main(String args[]) {
		getConnection();
	}
}


