package Tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "";

	public static void main(String[] args) {

		String sql = "UPDATE empresa SET id = ? where nombre = ?";
		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, 0);
			pstmt.setString(2, "Abogada Spain");

			pstmt.executeUpdate();
			System.out.println("Empresa actualizada");
		} catch (SQLException e) {

		}

	}

}
