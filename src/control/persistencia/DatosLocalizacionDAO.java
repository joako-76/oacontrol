//  @author aguirres
package control.persistencia;

import control.entidades.DatosLocalizacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatosLocalizacionDAO {

    private Connection conn;

    // Constructor que recibe la conexión para no abrir una cada vez
    public DatosLocalizacionDAO(Connection conn) {
        this.conn = conn;
    }

    // Método para obtener datos por CUE (se asume que la conexión ya está abierta)
    public List<DatosLocalizacion> obtenerPorCue(String cue) throws SQLException {
        List<DatosLocalizacion> lista = new ArrayList<>();

        String sql = "SELECT nombre, apellido, lugarDondeAplica, nombreDondeAplica, " +
                     "rol, tipoAplicador, gradoAnio, nombreSeccion, tipo, turno, alumnos " +
                     "FROM vista_asignaciones_por_cue WHERE lugarDondeAplica = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cue);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    DatosLocalizacion dl = new DatosLocalizacion();
                    dl.setNombre(rs.getString("nombre"));
                    dl.setApellido(rs.getString("apellido"));
                    dl.setLugarDondeAplica(rs.getString("lugarDondeAplica"));
                    dl.setNombreDondeAplica(rs.getString("nombreDondeAplica"));
                    dl.setRol(rs.getString("rol"));
                    dl.setTipoAplicador(rs.getString("tipoAplicador"));
                    dl.setGradoAnio(rs.getString("gradoAnio"));
                    dl.setNombreSeccion(rs.getString("nombreSeccion"));
                    dl.setTipo(rs.getString("tipo"));
                    dl.setTurno(rs.getString("turno"));
                    dl.setAlumnos(rs.getInt("alumnos"));
                    lista.add(dl);
                }
            }
        }

        return lista;
    }
}
