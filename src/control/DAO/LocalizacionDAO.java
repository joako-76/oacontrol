/**
 *
 * @author aguirres
 */
package control.DAO;

import control.entidades.Localizacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalizacionDAO {
    private Connection conn;

    public LocalizacionDAO(Connection conn) {
        this.conn = conn;
    }

    // 1. Listar todas las localizaciones
    public List<Localizacion> listarTodas() throws SQLException {
        List<Localizacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Localizacion";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Localizacion loc = new Localizacion();
                loc.setCueAnexo(rs.getString("cueAnexo"));
                loc.setNombre(rs.getString("nombre"));
                loc.setSector(rs.getString("sector"));
                loc.setDependencia(rs.getString("dependencia"));
                loc.setModalidadOferta(rs.getString("modalidadOferta"));
                loc.setDireccion(rs.getString("direccion"));
                loc.setLocalidad(rs.getString("localidad"));
                loc.setDepartamento(rs.getString("departamento"));
                loc.setEvalua(rs.getString("evalua"));

                lista.add(loc);
            }
        }

        return lista;
    }

    // 2. Buscar localización por cueAnexo
    public Localizacion buscarPorCueAnexo(String cueAnexo) throws SQLException {
        Localizacion loc = null;
        String sql = "SELECT * FROM Localizacion WHERE cueAnexo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cueAnexo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    loc = new Localizacion();
                    loc.setCueAnexo(rs.getString("cueAnexo"));
                    loc.setNombre(rs.getString("nombre"));
                    loc.setSector(rs.getString("sector"));
                    loc.setDependencia(rs.getString("dependencia"));
                    loc.setModalidadOferta(rs.getString("modalidadOferta"));
                    loc.setDireccion(rs.getString("direccion"));
                    loc.setLocalidad(rs.getString("localidad"));
                    loc.setDepartamento(rs.getString("departamento"));
                    loc.setEvalua(rs.getString("evalua"));
                }
            }
        }

        return loc;
    }
}
