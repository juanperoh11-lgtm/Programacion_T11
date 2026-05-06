package Patron_Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Selecto_Con_Filtro {

	public static void main(String[] args) {
		String nombreBuscado = "Ratón Inalámbrico";
		String sql = "SELECT id, nombre, precio, stock FROM productos WHERE nombre = ?";
		
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, nombreBuscado);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					System.out.println("ID: " + rs.getInt("id"));
					System.out.println("Nombre: " + rs.getString("nombre"));
					System.out.println("Precio: " + rs.getDouble("precio"));
					System.out.println("Stock: " + rs.getInt("stock"));
				} else {
					System.out.println("No existe ningún producto con ese nombre.");
				}
			}
		} catch (SQLException e) {
			System.err.println("Error al buscar: " + e.getMessage());
		}
	}
}
