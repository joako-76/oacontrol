/**
 *
 * @author aguirres
 */

package control;

import control.persistencia.LocalizacionDAO;
import control.persistencia.PersonaDAO;
import control.entidades.Localizacion;
import control.entidades.Persona;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            // Configuración de la conexión a la base de datos
            String url = "jdbc:mariadb://localhost:3306/aprender2025";
            String user = "root"; // Reemplaza con tu usuario
            String password = "ptamariadb"; // Reemplaza con tu contraseña

            conn = DriverManager.getConnection(url, user, password);
            LocalizacionDAO localizacionDAO = new LocalizacionDAO(conn);
            PersonaDAO personaDAO = new PersonaDAO(conn);

            int opcion;
            do {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Buscar Localización por cueAnexo");
                System.out.println("2. Listar todas las Localizaciones");
                System.out.println("3. Buscar Persona por CUIL");
                System.out.println("4. Listar todas las Personas");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el cueAnexo: ");
                        String cueAnexo = scanner.nextLine();
                        Localizacion loc = localizacionDAO.buscarPorCueAnexo(cueAnexo);
                        if (loc != null) {
                            mostrarLocalizacion(loc);
                        } else {
                            System.out.println("No se encontró una Localización con ese cueAnexo.");
                        }
                        break;
                    case 2:
                        List<Localizacion> listaLoc = localizacionDAO.listarTodas();
                        for (Localizacion l : listaLoc) {
                            mostrarLocalizacion(l);
                            System.out.println("------------------------------");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el CUIL: ");
                        String cuil = scanner.nextLine();
                        Persona persona = personaDAO.buscarPorCuil(cuil);
                        if (persona != null) {
                            mostrarPersona(persona);
                        } else {
                            System.out.println("No se encontró una Persona con ese CUIL.");
                        }
                        break;
                    case 4:
                        List<Persona> listaPersonas = personaDAO.listarTodas();
                        for (Persona p : listaPersonas) {
                            mostrarPersona(p);
                            System.out.println("------------------------------");
                        }
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } while (opcion != 5);

        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
            }
            scanner.close();
        }
    }

    private static void mostrarLocalizacion(Localizacion loc) {
        System.out.println("cueAnexo: " + loc.getCueAnexo());
        System.out.println("Nombre: " + loc.getNombre());
        System.out.println("Sector: " + loc.getSector());
        System.out.println("Dependencia: " + loc.getDependencia());
        System.out.println("Modalidad Oferta: " + loc.getModalidadOferta());
        System.out.println("Dirección: " + loc.getDireccion());
        System.out.println("Localidad: " + loc.getLocalidad());
        System.out.println("Departamento: " + loc.getDepartamento());
        System.out.println("Evalúa: " + loc.getEvalua());
    }

    private static void mostrarPersona(Persona persona) {
        System.out.println("CUIL: " + persona.getCuil());
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Apellido: " + persona.getApellido());
        System.out.println("Cargo: " + persona.getCargo());
        System.out.println("CBU: " + persona.getCbu());
        System.out.println("Lugar donde se desempeña: " + persona.getLugarDondeSeDesempena());
        System.out.println("Teléfono: " + persona.getTelefono());
        System.out.println("Correo: " + persona.getCorreo());
        System.out.println("Rol: " + persona.getRol());
        System.out.println("Lugar donde aplica: " + persona.getLugarDondeAplica());
    }
}
