package EjemploFicheroSql;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class EjecutarScript {

	private static final String URL = "jdbc:mysql://localhost:3306/nombre_tu_base_datos"; // Asegúrate de poner el
																							// nombre de la BD
	private static final String USUARIO = "root";
	private static final String PASSWORD = ""; // Vacía en XAMPP local

	public static void main(String[] args) {

		String rutaScript = "fich.sql"; // El archivo que quieres leer

		try {
			// 1. Leemos el contenido del archivo SQL a un String
			String sqlScript = Files.readString(Paths.get(rutaScript));

			// 2. Establecemos conexión con el Driver Manager
			try (Connection conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
					Statement stmt = conn.createStatement()) {

				// 3. Dividimos el script por el punto y coma (;) para obtener sentencias
				// individuales
				String[] sentencias = sqlScript.split(";");

				for (String sql : sentencias) {
					// Limpiamos espacios en blanco y saltos de línea
					String sqlLimpio = sql.trim();

					// Solo ejecutamos si la cadena no está vacía (evita errores con el último ;)
					if (!sqlLimpio.isEmpty()) {
						stmt.execute(sqlLimpio);
						System.out.println("Ejecutado con éxito: "
								+ sqlLimpio.substring(0, Math.min(sqlLimpio.length(), 30)) + "...");
					}
				}
				System.out.println("--- Script ejecutado por completo ---");
			}

		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
			e.printStackTrace();
		}
	}
}