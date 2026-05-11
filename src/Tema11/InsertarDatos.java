package Tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {

	private final static String URL = "jdbc:mysql://localhost:3306/tienda";
	private final static String USUARIO = "root";
	private final static String PASSWORD = "";
	
	public static void main(String[] args) {
		String sql = "INSERT INTO empresa (id, nombre, tipo) VALUES (?, ?, ?)";
		
		try(Connection conn  = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setInt(1, 2);
			stmt.setString(2, "Abogada Spain");
			stmt.setString(3, "Juridico");
			
			int filasAfectadas = stmt.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("✅ Producto insertado correctamente.");
			}

		} catch (SQLException e) {
			System.err.println("❌ Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}
	}
}