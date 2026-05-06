package EjemploFicheroSql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainFicheroSql {
	private static final String URL = "jdbc:mysql://localhost:3306/?allowMultiQueries=true";
	
	private static final String USUARIO = "root";

	private static final String PASSWORD = ""; // vacía en XAMPP local

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		String todo = "";

		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			     Statement stm = conn.createStatement()) {
			    
			    // Dividimos el script en sentencias individuales
			    String[] consultas = sb.toString().split(";");
			    
			    for (String consulta : consultas) {
			        if (!consulta.trim().isEmpty()) {
			            stm.execute(consulta.trim());
			        }
			    }
			    System.out.println("¡Script ejecutado con éxito!");

			} catch (SQLException ex) {
			    System.out.println("Error SQL: " + ex.getMessage());
			}
	}
}