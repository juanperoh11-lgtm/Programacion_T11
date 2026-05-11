package EjemploDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Asegúrate de que este nombre sea el correcto
import Patron_Dao.ConexionDB;

public class ProductoDAO {

	public List<Producto> listarTodos() throws SQLException {
		List<Producto> productos = new ArrayList<>();
		String sql = "SELECT id, nombre, precio, stock FROM productos ORDER BY id ASC";

		// Corregido: ConexionDB (antes decía ConexionBD)
		try (Connection conn = ConexionDB.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				productos.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"),
						rs.getInt("stock")));
			}
		}
		return productos;
	}

	public int insertar(Producto producto) throws SQLException {
		String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, producto.getNombre());
			ps.setDouble(2, producto.getPrecio());
			ps.setInt(3, producto.getStock());
			return ps.executeUpdate();
		}
	}

	public int actualizarPrecio(String nombre, double nuevoPrecio) throws SQLException {
		String sql = "UPDATE productos SET precio = ? WHERE nombre = ?";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setDouble(1, nuevoPrecio);
			ps.setString(2, nombre);
			return ps.executeUpdate();
		}
	}

	public int eliminarPorNombre(String nombre) throws SQLException {
		String sql = "DELETE FROM productos WHERE nombre = ?";
		try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, nombre);
			return ps.executeUpdate();
		}
	}
}