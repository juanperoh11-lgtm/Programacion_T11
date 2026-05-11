package EjemploDao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class main {

	private static final Scanner sc = new Scanner(System.in);
	private static final ProductoDAO dao = new ProductoDAO();

	public static void main(String[] args) {

		int opcion;
		do {
			mostrarMenu();
			opcion = leerEntero("Elige una opción: ");
			try {
				switch (opcion) {
				case 1:
					listarProductos();
					break;

				case 2:
					insertarProducto();
					break;

				case 3:
					actualizarPrecio();
					break;

				case 4:
					eliminarProducto();
					break;

				case 5:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
					break;
				}
			} catch (SQLException e) {
				System.err.println("Error de base de datos: " + e.getMessage());
			}
		} while (opcion != 5);
	}

	private static void mostrarMenu() {
		System.out.println("\n=== GESTIÓN DE PRODUCTOS ===");
		System.out.println("1. Listar productos");
		System.out.println("2. Añadir producto");
		System.out.println("3. Actualizar precio");
		System.out.println("4. Eliminar producto");
		System.out.println("5. Salir");
	}

	private static void listarProductos() throws SQLException {
		List<Producto> productos = dao.listarTodos();
		// Cabecera sugerida para mayor claridad
		System.out.printf("%-4s | %-25s | %-8s | %-6s%n", "ID", "NOMBRE", "PRECIO", "STOCK");
		System.out.println("-".repeat(55));
		for (Producto p : productos)
			System.out.println(p);
	}

	private static void insertarProducto() throws SQLException {
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		double precio = leerDouble("Precio: ");
		int stock = leerEntero("Stock: ");
		// Se usa el DAO para la persistencia
		System.out.println("Filas insertadas: " + dao.insertar(new Producto(nombre, precio, stock)));
	}

	private static void actualizarPrecio() throws SQLException {
		System.out.print("Nombre del producto a actualizar: ");
		String nombre = sc.nextLine();
		double nuevoPrecio = leerDouble("Nuevo precio: ");
		int filas = dao.actualizarPrecio(nombre, nuevoPrecio);
		System.out.println("Filas actualizadas: " + filas);
	}

	private static void eliminarProducto() throws SQLException {
		System.out.print("Nombre del producto a eliminar: ");
		String nombre = sc.nextLine();
		int filas = dao.eliminarPorNombre(nombre);
		System.out.println("Filas eliminadas: " + filas);
	}

	// Metodos de validación para evitar que el programa se cierre por errores
	// [cite: 291, 292, 294]
	private static int leerEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número entero válido.");
			}
		}
	}

	private static double leerDouble(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Double.parseDouble(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Introduce un número decimal válido.");
			}
		}
	}
}
