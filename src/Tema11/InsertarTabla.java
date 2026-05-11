package Tema11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarTabla {

	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private final static String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				Statement stmt = conn.createStatement();) {

			{
				stmt.execute("Create table empresa (" + " id INT AUTO_INCREMENT PRIMARY KEY, "
						+ " nombre VARCHAR(100) NOT NULL, " + " tipo VARCHAR(100) NOT NULL " + ")");
			}
			System.out.println("Tabla creada");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}