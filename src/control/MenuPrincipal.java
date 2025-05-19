/**
 *
 * @author aguirres
 */

package control;

import control.entidades.Localizacion;
import control.entidades.Persona;
import control.entidades.Seccion;
import control.persistencia.ConexionBD;
import control.servicios.ServicioLocalizacion;
import control.servicios.ServicioPersona;
import control.servicios.ServicioSeccion;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    public static void main(String[] args) {
        try (Connection conexion = ConexionBD.obtenerConexion()) {
            ServicioPersona servicioPersona = new ServicioPersona(conexion);
            ServicioLocalizacion servicioLocalizacion = new ServicioLocalizacion(conexion);
            ServicioSeccion servicioSeccion = new ServicioSeccion(conexion);

            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Listar Localizaciones");
                System.out.println("2. Listar Coordinadores");
                System.out.println("3. Listar Veedores");
                System.out.println("4. Buscar Veedor por CUE Anexo");
                System.out.println("5. Listar Aplicadores por CUE Anexo");
                System.out.println("6. Verificar Secciones de una Localización");
                System.out.println("7. Editar Secciones de una Localización");
                System.out.println("8. Buscar una Persona por CUIL");
                System.out.println("9. Listar Aplicadores Titulares y Foráneos por CUE Anexo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        List<Localizacion> localizaciones = servicioLocalizacion.listarTodas();
                        for (Localizacion loc : localizaciones) {
                            System.out.println(loc.getCueAnexo() + " - " + loc.getNombre());
                        }
                        break;

                    case 2:
                        for (Persona p : servicioPersona.listarTodas()) {
                            if ("coordinador".equalsIgnoreCase(p.getRol())) {
                                System.out.println(p.getNombre() + " " + p.getApellido());
                            }
                        }
                        break;

                    case 3:
                        for (Persona p : servicioPersona.listarTodas()) {
                            if ("veedor".equalsIgnoreCase(p.getRol())) {
                                System.out.println(p.getNombre() + " " + p.getApellido());
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese CUE Anexo: ");
                        String cueVeedor = scanner.nextLine();
                        Persona veedor = servicioPersona.buscarPorCuil(cueVeedor);
                        if (veedor != null) {
                            System.out.println("Veedor: " + veedor.getNombre() + " " + veedor.getApellido());
                        } else {
                            System.out.println("No se encontró Veedor para ese CUE.");
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese CUE Anexo: ");
                        String cueAplicadores = scanner.nextLine();
                        List<Persona> aplicadores = servicioPersona.buscarPorCuil(cueAplicadores);
                        if (!aplicadores.isEmpty()) {
                            for (Persona a : aplicadores) {
                                System.out.println("Aplicador: " + a.getNombre() + " " + a.getApellido());
                            }
                        } else {
                            System.out.println("No se encontraron Aplicadores para ese CUE.");
                        }
                        break;

                    case 6:
                        System.out.print("Ingrese CUE Anexo: ");
                        String cueSeccion = scanner.nextLine();
                        List<Seccion> secciones = servicioSeccion.obtenerSeccionesPorLocalizacion(cueSeccion);
                        if (secciones.isEmpty()) {
                            System.out.println("La Localización no tiene Secciones cargadas.");
                        } else {
                            for (Seccion s : secciones) {
                                System.out.println("Sección: " + s.getNombre() + " - Tipo: " + s.getTipo() + " - Turno: " + s.getTurno());
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Ingrese CUE Anexo de la Localización: ");
                        String cueEditar = scanner.nextLine();
                        List<Seccion> seccionesExistentes = servicioSeccion.obtenerSeccionesPorLocalizacion(cueEditar);

                        if (seccionesExistentes.isEmpty()) {
                            System.out.println("No hay Secciones registradas para esta Localización.");
                        } else {
                            System.out.println("Secciones actuales:");
                            for (Seccion s : seccionesExistentes) {
                                System.out.println("ID: " + s.getSeccionID() + " - " + s.getNombre() + " (" + s.getTipo() + ", " + s.getTurno() + ")");
                            }
                        }

                        System.out.print("¿Desea agregar (A) o eliminar (E) una Sección?: ");
                        String eleccion = scanner.nextLine().trim().toUpperCase();

                        if (eleccion.equals("A")) {
                            System.out.print("Nombre de la nueva Sección: ");
                            String nombreNueva = scanner.nextLine();
                            System.out.print("Tipo: ");
                            String tipoNueva = scanner.nextLine();
                            System.out.print("Turno: ");
                            String turnoNueva = scanner.nextLine();

                            Seccion nueva = new Seccion();
                            nueva.setNombre(nombreNueva);
                            nueva.setTipo(tipoNueva);
                            nueva.setTurno(turnoNueva);

                            Localizacion loc = new Localizacion();
                            loc.setCueAnexo(cueEditar);
                            nueva.setLocalizacion(loc);

                            boolean agregado = servicioSeccion.agregarSeccion(nueva);
                            System.out.println(agregado ? "Sección agregada correctamente." : "Error al agregar Sección.");

                        } else if (eleccion.equals("E")) {
                            System.out.print("Ingrese el ID de la Sección a eliminar: ");
                            int idEliminar = Integer.parseInt(scanner.nextLine());
                            boolean eliminado = servicioSeccion.eliminarSeccion(idEliminar);
                            System.out.println(eliminado ? "Sección eliminada." : "No se pudo eliminar la Sección.");
                        } else {
                            System.out.println("Opción no válida.");
                        }

                        break;

                    case 8:
                        System.out.print("Ingrese CUIL: ");
                        String cuilBuscar = scanner.nextLine();
                        Persona personaEncontrada = servicioPersona.buscarPorCuil(cuilBuscar);
                        if (personaEncontrada != null) {
                            System.out.println("Persona: " + personaEncontrada.getNombre() + " " + personaEncontrada.getApellido());
                            System.out.println("Rol: " + personaEncontrada.getRol());
                            System.out.println("Cargo: " + personaEncontrada.getCargo());
                            System.out.println("Lugar donde aplica: " + personaEncontrada.getLugarDondeAplica());
                            System.out.println("Teléfono: " + personaEncontrada.getTelefono());
                        } else {
                            System.out.println("No se encontró persona con ese CUIL.");
                        }
                        break;

                    case 9:
                        System.out.print("Ingrese CUE Anexo: ");
                        String cueAplicadoresTitFor = scanner.nextLine();
                        List<Persona> aplicadoresTitulares = servicioPersona.buscarAplicadoresPorCue(cueAplicadoresTitFor);
                        List<Persona> aplicadoresForaneos = servicioPersona.buscarAplicadoresPorCue(cueAplicadoresTitFor);

                        System.out.println("Aplicadores Titulares:");
                        if (!aplicadoresTitulares.isEmpty()) {
                            for (Persona p : aplicadoresTitulares) {
                                System.out.println(p.getNombre() + " " + p.getApellido());
                            }
                        } else {
                            System.out.println("No hay aplicadores titulares.");
                        }

                        System.out.println("Aplicadores Foráneos:");
                        if (!aplicadoresForaneos.isEmpty()) {
                            for (Persona p : aplicadoresForaneos) {
                                System.out.println(p.getNombre() + " " + p.getApellido());
                            }
                        } else {
                            System.out.println("No hay aplicadores foráneos.");
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } while (opcion != 0);

            scanner.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
