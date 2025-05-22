/**
 *
 * @author aguirres
 */
package control.persistencia;

import control.entidades.VeedorAsignado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeedorDAO {

    private static final Logger logger = Logger.getLogger(VeedorDAO.class.getName());
    private Connection conn;

    public VeedorDAO(Connection conn) {
        this.conn = conn;
    }

    public List<VeedorAsignado> obtenerVeedores() {
        List<VeedorAsignado> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_veedor_escuela"; 

        try (PreparedStatement stmt = conn.prepareStatement(sql);
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
            logger.log(Level.SEVERE, "Error al obtener veedores desde la base de datos", e);
        }

        return lista;
    }
}

