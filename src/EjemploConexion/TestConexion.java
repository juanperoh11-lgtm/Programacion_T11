package EjemploConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {

	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		
		// try-with-resources: cierra la conexión automáticamente al terminar
		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				Statement stmt = conn.createStatement();) {
			
			
			 {
				// CREATE TABLE IF NOT EXISTS → no falla si ya existe
				//Crear tablas
				stmt.execute(
				"CREATE TABLE IF NOT EXISTS cliente (" +
				" id INT AUTO_INCREMENT PRIMARY KEY, " +
				" nombre VARCHAR(100) NOT NULL, " +
				" edad INT NOT NULL " +
				")");
			}
			System.out.println("✅ Tabla creada correctamente.");

			
		} catch (SQLException e) {
			System.err.println("❌ Error de conexión: " + e.getMessage());
		}

	}
}