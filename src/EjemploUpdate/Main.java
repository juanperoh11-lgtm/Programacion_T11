package EjemploUpdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		String sqlUpdate = "UPDATE productos SET precio = ? WHERE nombre = ?";
		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
			
			pstmt.setDouble(1, 19.99);
			pstmt.setString(2, "Usb");
			
			pstmt.executeUpdate();
			System.out.println("Producto Actualizado");
			
		} catch (SQLException e) {
			
		}
	}

}
