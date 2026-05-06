package Patron_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainSelect {

	public static void main(String[] args) {

		String sql = "SELECT id, nombre, precio, stock FROM productos ORDER BY id ASC";
		try (Connection conn = ConexionDB.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			System.out.printf("%-4s | %-25s | %-8s | %-6s%n", "ID", "NOMBRE", "PRECIO",

					"STOCK");

			//System.out.println("-".repeat(55));
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				int stock = rs.getInt("stock");
				//Formato en el que quermos que salgan los números
				System.out.printf("%-4d | %-25s | %-8.2f | %-6d%n", id, nombre, precio,

						stock);
			}
		} catch (SQLException e) {
			System.err.println("Error al listar: " + e.getMessage());
		}
	}
}