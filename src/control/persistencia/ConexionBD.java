/**
 *
 * @author aguirres
 */
package control.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mariadb://localhost:3306/aprender2025"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "ptamariadb";

    // Método para obtener conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver"); // Cargar driver MariaDB
            return DriverManager.getConnection(URL, USER, PASSWORD); // Establecer conexión
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de MariaDB no encontrado.", e);
        }
    }

    // Método auxiliar para cerrar conexión
    public static void cerrarConexion(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando conexión: " + e.getMessage());
            }
        }
    }
}
