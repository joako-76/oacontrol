/**
 *
 * @author aguirres
 */
package control.DAO;

import control.entidades.Localizacion;
import control.entidades.Seccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocalizacionDAO {
    private Connection conn;

    public LocalizacionDAO(Connection conn) {
        this.conn = conn;
    }

    /**
    // INSERTAR
    public void insertar(Localizacion loc) throws SQLException {
        String sql = "INSERT INTO Localizacion (cueAnexo, nombre, sector, dependencia, modalidadOferta, direccion, localidad, departamento, evalua) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loc.getCueAnexo());
            ps.setString(2, loc.getNombre());
            ps.setString(3, loc.getSector());
            ps.setString(4, loc.getDependencia());
            ps.setString(5, loc.getModalidadOferta());
            ps.setString(6, loc.getDireccion());
            ps.setString(7, loc.getLocalidad());
            ps.setString(8, loc.getDepartamento());
            ps.setString(9, loc.getEvalua());

            ps.executeUpdate();
        }
    }

    // ACTUALIZAR
    public void actualizar(Localizacion loc) throws SQLException {
        String sql = "UPDATE Localizacion SET nombre = ?, sector = ?, dependencia = ?, modalidadOferta = ?, direccion = ?, localidad = ?, departamento = ?, evalua = ? " +
                     "WHERE cueAnexo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loc.getNombre());
            ps.setString(2, loc.getSector());
            ps.setString(3, loc.getDependencia());
            ps.setString(4, loc.getModalidadOferta());
            ps.setString(5, loc.getDireccion());
            ps.setString(6, loc.getLocalidad());
            ps.setString(7, loc.getDepartamento());
            ps.setString(8, loc.getEvalua());
            ps.setString(9, loc.getCueAnexo());

            ps.executeUpdate();
        }
    }

    // ELIMINAR
    public void eliminar(String cueAnexo) throws SQLException {
        String sql = "DELETE FROM Localizacion WHERE cueAnexo = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cueAnexo);
            ps.executeUpdate();
        }
    }

 */
    
    // BUSCAR POR CUE ANEXO
    public Localizacion buscarPorCueAnexo(String cueAnexo) throws SQLException {
        String sql = "SELECT * FROM Localizacion WHERE cueAnexo = ?";
        Localizacion loc = null;

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

                    // Asociar secciones
                    loc.setSecciones(listarSeccionesPorCue(cueAnexo));
                }
            }
        }

        return loc;
    }

    // LISTAR TODAS LAS LOCALIZACIONES
    public List<Localizacion> listarTodas() throws SQLException {
        List<Localizacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Localizacion";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

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

                // Asociar secciones
                loc.setSecciones(listarSeccionesPorCue(loc.getCueAnexo()));

                lista.add(loc);
            }
        }

        return lista;
    }

    // MÉTODO PRIVADO: Listar Secciones asociadas a una Localización
    private List<Seccion> listarSeccionesPorCue(String cueAnexo) throws SQLException {
        List<Seccion> secciones = new ArrayList<>();
        String sql = "SELECT * FROM Seccion WHERE cueAnexoID = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cueAnexo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Seccion sec = new Seccion();
                    sec.setSeccionID(rs.getInt("seccionID"));
                    sec.setNombre(rs.getString("nombre"));
                    sec.setTipo(rs.getString("tipo"));
                    sec.setTurno(rs.getString("turno"));
                    // No seteamos la Localización para evitar ciclos

                    secciones.add(sec);
                }
            }
        }

        return secciones;
    }
}
