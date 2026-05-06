package Patron_Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";
	
	public ConexionDB() {
		
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USUARIO, PASSWORD);
		}
}
