package control;

import control.persistencia.AplicadorDAO;
import control.persistencia.PersonaDetalleAsignacionDAO;
import control.persistencia.VeedorDAO;
import control.persistencia.DatosLocalizacionDAO;
import control.entidades.AplicadorAsignado;
import control.entidades.PersonaDetalleAsignacion;
import control.entidades.VeedorAsignado;
import control.entidades.DatosLocalizacion;

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
            String url = "jdbc:mariadb://localhost:3306/aprender2025";
            String user = "root";
            String password = "ptamariadb";

            conn = DriverManager.getConnection(url, user, password);
            AplicadorDAO aplicadorDAO = new AplicadorDAO(conn);
            PersonaDetalleAsignacionDAO personaDAO = new PersonaDetalleAsignacionDAO(conn);
            VeedorDAO veedorDAO = new VeedorDAO(conn);
            DatosLocalizacionDAO datosLocalizacionDAO = new DatosLocalizacionDAO(conn);

            int opcion;
            do {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1. Listar aplicadores");
                System.out.println("2. Salir");
                System.out.println("3. Listar personas detalle asignacion");
                System.out.println("4. Buscar persona detalle asignacion por CUIL");
                System.out.println("5. Listar veedores asignados");
                System.out.println("6. Buscar datos por localización (CUE Anexo)");
                System.out.println("7. Buscar persona detalle asignacion por apellido (apellido)");
                System.out.println("8. Buscar persona detalle asignacion por nombre y apellido (por separado)");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer

                switch (opcion) {
                    case 1:
                        List<AplicadorAsignado> lista = aplicadorDAO.obtenerAplicadores();
                        for (AplicadorAsignado a : lista) {
                            mostrarAplicador(a);
                            System.out.println("------------------------------");
                        }
                        break;
                    case 2:
                        System.out.println("Saliendo...");
                        break;
                    case 3:
                        List<PersonaDetalleAsignacion> personas = personaDAO.obtenerTodas();
                        for (PersonaDetalleAsignacion p : personas) {
                            mostrarPersonaDetalleAsignacion(p);
                            System.out.println("------------------------------");
                        }
                        break;
                    case 4:
                        System.out.print("Ingrese CUIL para buscar: ");
                        String cuil = scanner.nextLine();
                        PersonaDetalleAsignacion persona = personaDAO.obtenerPorCUIL(cuil);
                        if (persona != null) {
                            mostrarPersonaDetalleAsignacion(persona);
                        } else {
                            System.out.println("No se encontró persona con CUIL: " + cuil);
                        }
                        break;
                    case 5:
                        List<VeedorAsignado> veedores = veedorDAO.obtenerVeedores();
                        for (VeedorAsignado v : veedores) {
                            mostrarVeedorAsignado(v);
                            System.out.println("------------------------------");
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese el CUE Anexo para buscar: ");
                        String cueAnexo = scanner.nextLine();
                        List<DatosLocalizacion> datos = datosLocalizacionDAO.obtenerPorCue(cueAnexo);
                        if (datos.isEmpty()) {
                            System.out.println("No se encontraron asignaciones para el CUE Anexo: " + cueAnexo);
                        } else {
                            DatosLocalizacion primerDato = datos.get(0);
                            System.out.println("El CUE Anexo " + cueAnexo + " pertenece a la Escuela: " + primerDato.getLugarDondeAplica());
                            System.out.println("Detalles de asignaciones:");
                            for (DatosLocalizacion d : datos) {
                                System.out.println("------------------------------");
                                System.out.println("Nombre: " + d.getNombre());
                                System.out.println("Apellido: " + d.getApellido());
                                System.out.println("Rol: " + d.getRol());
                                System.out.println("Tipo Aplicador: " + d.getTipoAplicador());
                                System.out.println("Grado/Año: " + d.getGradoAnio());
                                System.out.println("Nombre Sección: " + d.getNombreSeccion());
                                System.out.println("Tipo Sección: " + d.getTipo());
                                System.out.println("Turno: " + d.getTurno());
                                System.out.println("Cantidad de Alumnos: " + d.getAlumnos());
                            }
                        }
                        break;
                    case 7:
                        System.out.print("Ingrese el apellido a buscar: ");
                        String apellido = scanner.nextLine();
                        List<PersonaDetalleAsignacion> porApellido = personaDAO.obtenerPorApellido(apellido);
                        if (porApellido.isEmpty()) {
                            System.out.println("No se encontraron personas con el apellido: " + apellido);
                        } else {
                            for (PersonaDetalleAsignacion p : porApellido) {
                                mostrarPersonaDetalleAsignacion(p);
                                System.out.println("------------------------------");
                            }
                        }
                        break;
                    case 8:
                        System.out.print("Ingrese el nombre: ");
                        String nombreBuscar = scanner.nextLine().trim();
                        System.out.print("Ingrese el apellido: ");
                        String apellidoBuscar = scanner.nextLine().trim();

                        List<PersonaDetalleAsignacion> porApellidoNombre = personaDAO.obtenerPorApellidoNombre(nombreBuscar, apellidoBuscar);

                        if (porApellidoNombre.isEmpty()) {
                            System.out.println("No se encontraron personas con nombre '" + nombreBuscar + "' y apellido '" + apellidoBuscar + "'.");
                        } else {
                            for (PersonaDetalleAsignacion p : porApellidoNombre) {
                                mostrarPersonaDetalleAsignacion(p);
                                System.out.println("------------------------------");
                            }
                        }
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }

            } while (opcion != 2);

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

    private static void mostrarAplicador(AplicadorAsignado a) {
        System.out.println("Nombre: " + a.getNombre());
        System.out.println("Apellido: " + a.getApellido());
        System.out.println("CUIL: " + a.getCuil());
        System.out.println("CBU: " + a.getCbu());
        System.out.println("Teléfono: " + a.getTelefono());
        System.out.println("Correo: " + a.getCorreo());
        System.out.println("Remunerado: " + a.getRemunerado());
        System.out.println("Tipo Aplicador: " + a.getTipoAplicador());
        System.out.println("Sección: " + a.getSeccion());
        System.out.println("Turno: " + a.getTurno());
        System.out.println("Tipo Sección: " + a.getTipoSeccion());
        System.out.println("Cue Anexo: " + a.getCueAnexo());
        System.out.println("Nombre Escuela: " + a.getNombreEscuela());
        System.out.println("Dependencia: " + a.getDependencia());
        System.out.println("Sector: " + a.getSector());
        System.out.println("Departamento: " + a.getDepartamento());
    }

    private static void mostrarPersonaDetalleAsignacion(PersonaDetalleAsignacion p) {
        System.out.println("CUIL: " + p.getCuil());
        System.out.println("Nombre: " + p.getNombre());
        System.out.println("Apellido: " + p.getApellido());
        System.out.println("CBU: " + p.getCbu());
        System.out.println("Rol: " + p.getRol());
        System.out.println("Remunerado: " + p.getRemunerado());
        System.out.println("Tipo Aplicador: " + p.getTipoAplicador());
        System.out.println("Lugar Donde Se Desempeña (CUE Anexo): " + p.getLugarDondeSeDesempena());
        System.out.println("Nombre Donde Se Desempeña: " + p.getNombreDondeSeDesempena());
        System.out.println("Lugar Donde Aplica (CUE Anexo): " + p.getLugarDondeAplica());
        System.out.println("Nombre Donde Aplica: " + p.getNombreDondeAplica());
        System.out.println("Contacto: " + p.getContacto());
    }

    private static void mostrarVeedorAsignado(VeedorAsignado v) {
        System.out.println("CUIL: " + v.getCuil());
        System.out.println("Nombre: " + v.getNombre());
        System.out.println("Apellido: " + v.getApellido());
        System.out.println("Cue Anexo: " + v.getCueAnexo());
        System.out.println("Nombre Escuela: " + v.getNombreEscuela());
        System.out.println("Dependencia: " + v.getDependencia());
        System.out.println("Sector: " + v.getSector());
        System.out.println("Departamento: " + v.getDepartamento());
    }
}
