package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/elden_ring_weapons";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123Buttz!";
	private static Connection connection;
	private static DBConnection instance;
	
	
	@SuppressWarnings("static-access")
	private DBConnection(Connection connection) {
		this.connection = connection;
	}

	
	public static Connection getConnection() {
		if (instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return DBConnection.connection;
	}
}
