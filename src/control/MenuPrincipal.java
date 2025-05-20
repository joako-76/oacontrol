/**
 *
 * @author aguirres
 */

package control;

import control.DAO.PersonaDAO;
//import control.DAO.LocalizacionDAO;
//import control.DAO.SeccionDAO;
import control.entidades.Persona;
import control.entidades.Localizacion;
import control.entidades.Seccion;
import control.persistencia.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            LocalizacionDAO localizacionDAO = new LocalizacionDAO(conexion);
            SeccionDAO seccionDAO = new SeccionDAO(conexion);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Listar todas las personas");
                System.out.println("2. Buscar persona por CUIL");
                System.out.println("3. Listar todas las localizaciones");
                System.out.println("4. Buscar localización por CUE Anexo");
                System.out.println("5. Listar todas las secciones");
                System.out.println("6. Buscar secciones por CUE Anexo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        List<Persona> personas = personaDAO.listarTodas();
                        for (Persona p : personas) {
                            System.out.println(p);
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese el CUIL de la persona: ");
                        String cuil = scanner.nextLine();
                        Persona persona = personaDAO.buscarPorCuil(cuil);
                        if (persona != null) {
                            System.out.println(persona);
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                        break;
                    case 3:
                        List<Localizacion> localizaciones = localizacionDAO.listarTodas();
                        for (Localizacion l : localizaciones) {
                            System.out.println(l);
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese el CUE Anexo de la localización: ");
                        String cueAnexo = scanner.nextLine();
                        Localizacion localizacion = localizacionDAO.buscarPorCueAnexo(cueAnexo);
                        if (localizacion != null) {
                            System.out.println(localizacion);
                        } else {
                            System.out.println("Localización no encontrada.");
                        }
                        break;
                    case 5:
                        List<Seccion> secciones = seccionDAO.listarTodas();
                        for (Seccion s : secciones) {
                            System.out.println(s);
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese el CUE Anexo para buscar secciones: ");
                        String cueAnexoSeccion = scanner.nextLine();
                        List<Seccion> seccionesPorCue = seccionDAO.obtenerSeccionesPorLocalizacion(cueAnexoSeccion);
                        if (!seccionesPorCue.isEmpty()) {
                            for (Seccion s : seccionesPorCue) {
                                System.out.println(s);
                            }
                        } else {
                            System.out.println("No se encontraron secciones para ese CUE Anexo.");
                        }
                        break;
                    case 0:
                        System.out.println("Saliendo del programa.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
