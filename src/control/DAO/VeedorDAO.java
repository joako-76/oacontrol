/**
 *
 * @author aguirres
 */
package control.DAO;

import control.persistencia.ConexionBD;
import control.entidades.VeedorAsignado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeedorDAO {

    public List<VeedorAsignado> obtenerVeedores() {
        List<VeedorAsignado> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_veedor_escuela"; // Debemos crear esta vista en la BD

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                VeedorAsignado v = new VeedorAsignado();
                v.setCuil(rs.getString("cuil"));
                v.setNombre(rs.getString("nombre"));
                v.setApellido(rs.getString("apellido"));
                v.setCueAnexo(rs.getString("cueAnexo"));
                v.setNombreEscuela(rs.getString("nombreEscuela"));
                v.setDependencia(rs.getString("dependencia"));
                v.setSector(rs.getString("sector"));
                v.setDepartamento(rs.getString("departamento"));
                lista.add(v);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}

