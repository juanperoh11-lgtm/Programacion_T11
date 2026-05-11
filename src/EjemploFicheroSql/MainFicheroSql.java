package EjemploFicheroSql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainFicheroSql {
	private static final String URL = "jdbc:mysql://localhost:3306/?allowMultiQueries=true";

	private static final String USUARIO = "root";

	private static final String PASSWORD = ""; // vacía en XAMPP local

	public static void main(String[] args) {

		String sqlScript;

		try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
				Statement stm = conn.createStatement()) {

			sqlScript = Files.readString(Paths.get("inventario.sql"));

			String[] sentencia = sqlScript.toString().split(";");
			for (String s : sentencia)
				stm.execute(s.trim());

			System.out.println("¡Script ejecutado con éxito!");

		} catch (SQLException | IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}