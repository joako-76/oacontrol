/**
 *
 * @author aguirres
 */
package control.persistencia;

import control.entidades.PersonaDetalleAsignacion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDetalleAsignacionDAO {

    private static final Logger logger = Logger.getLogger(PersonaDetalleAsignacionDAO.class.getName());

    private Connection conexion;

    // Constructor por defecto que obtiene la conexión internamente
    public PersonaDetalleAsignacionDAO() {
        try {
            conexion = ConexionBD.obtenerConexion();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "No se pudo conectar a la base de datos.", e);
            throw new RuntimeException("No se pudo conectar a la base de datos.", e);
        }
    }

    // Nuevo constructor que recibe la conexión por parámetro
    public PersonaDetalleAsignacionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<PersonaDetalleAsignacion> obtenerTodas() {
        List<PersonaDetalleAsignacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_persona_detalle_asignacion";

        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                PersonaDetalleAsignacion p = new PersonaDetalleAsignacion(
                        rs.getString("cuil"),
                        rs.getString("cbu"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("contacto"),
                        rs.getString("lugarDondeSeDesempena"),
                        rs.getString("nombreDondeSeDesempena"),
                        rs.getString("lugarDondeAplica"),
                        rs.getString("nombreDondeAplica"),
                        rs.getString("rol"),
                        rs.getString("tipoAplicador")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todas las personas.", e);
        }

        return lista;
    }

    public PersonaDetalleAsignacion obtenerPorCUIL(String cuil) {
        PersonaDetalleAsignacion persona = null;
        String sql = "SELECT * FROM vista_persona_detalle_asignacion WHERE cuil = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cuil);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    persona = new PersonaDetalleAsignacion(
                            rs.getString("cuil"),
                            rs.getString("cbu"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("contacto"),
                            rs.getString("lugarDondeSeDesempena"),
                            rs.getString("nombreDondeSeDesempena"),
                            rs.getString("lugarDondeAplica"),
                            rs.getString("nombreDondeAplica"),
                            rs.getString("rol"),
                            rs.getString("tipoAplicador")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener persona por CUIL: " + cuil, e);
        }

        return persona;
    }
}
