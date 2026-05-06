package EjemploInsertar_Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	// Necesario para cualquier clase
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, "Usb");
			pstmt.setDouble(2, 10.50);
			pstmt.setInt(3, 20);

			int filasAfectadas = pstmt.executeUpdate();

			if (filasAfectadas > 0) {
				System.out.println("✅ Producto insertado correctamente.");
			}

		} catch (SQLException e) {
			System.err.println("❌ Error de SQL: " + e.getMessage());
			e.printStackTrace();
		}
	}
}