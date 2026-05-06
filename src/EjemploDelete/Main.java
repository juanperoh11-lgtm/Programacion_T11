package EjemploDelete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		String sqlDelete = "DELETE FROM productos WHERE stock = ?";
		
		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
			pstmt.setDouble(1, 0);
			//Tanto para upadate como para delete
			pstmt.executeUpdate();
			
			System.out.println("Borrado correctamente");
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
}