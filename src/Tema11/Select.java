package Tema11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

	private static final String URL = "jdbc:mysql://localhost:3306/tienda";
	private final static String USUARIO = "root";
	private static final String PASSWORD = "";

	
	public static void main(String[] args) {
		
		String sql = "SELECT * FROM empresa";
		try(Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery()) {
		
			while(rst.next()) {
				int id = rst.getInt("id");
				String nombre = rst.getString("Nombre");
				String tipo = rst.getString("tipo");
				
				System.out.printf("%-4d | %-20s | %-20s%n", id, nombre,tipo);
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
