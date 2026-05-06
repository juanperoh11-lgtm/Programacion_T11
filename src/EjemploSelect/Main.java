package EjemploSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		String sql = "SELECT * FROM productos ORDER BY id ASC";

		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareCall(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("Stock");

				System.out.printf("%-4d | %-20s | %-8.2f | %-6d%n", id, nombre, precio, stock);
			}

		} catch (SQLException e) {

		}

	}
}