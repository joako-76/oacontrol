/**
 *
 * @author aguirres
 */
package control.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AplicadorDAO {

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
            e.printStackTrace();
        }

        return lista;
    }
}
