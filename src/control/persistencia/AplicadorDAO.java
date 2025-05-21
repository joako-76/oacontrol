/**
 *
 * @author aguirres
 */
package control.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.entidades.AplicadorAsignado;

public class AplicadorDAO {

    private static final Logger LOGGER = Logger.getLogger(AplicadorDAO.class.getName());

    public List<AplicadorAsignado> obtenerAplicadores() {
        List<AplicadorAsignado> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_aplicador_seccion";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AplicadorAsignado a = new AplicadorAsignado();
                a.setCuil(rs.getString("cuil"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setTipoAplicador(rs.getString("tipoAplicador"));
                a.setSeccion(rs.getString("seccion"));
                a.setTurno(rs.getString("turno"));
                a.setTipoSeccion(rs.getString("tipo"));
                a.setCueAnexo(rs.getString("cueAnexo"));
                a.setNombreEscuela(rs.getString("nombreEscuela"));
                a.setDependencia(rs.getString("dependencia"));
                a.setSector(rs.getString("sector"));
                a.setDepartamento(rs.getString("departamento"));
                lista.add(a);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener aplicadores desde la vista.", e);
        }

        return lista;
    }
}
