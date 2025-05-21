/**
 * @author aguirres
 */
package control.persistencia;

import control.entidades.Asignacion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para manejar operaciones CRUD sobre la entidad Asignacion.
 */
public class AsignacionDAO {

    private Connection conexion;

    public AsignacionDAO() {
        try {
            conexion = ConexionBD.obtenerConexion();
        } catch (SQLException e) {
            e.printStackTrace();
            // Si la conexión falla, se puede lanzar una excepción en tiempo de ejecución
            throw new RuntimeException("No se pudo conectar a la base de datos.", e);
        }
    }

    // Insertar asignación
    public boolean insertar(Asignacion asignacion) {
        String sql = "INSERT INTO Asignacion (cuil, seccionID, fechaAsignacion, rol, tipoAplicador) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, asignacion.getCuil());
            ps.setObject(2, asignacion.getSeccionID(), Types.INTEGER);
            ps.setObject(3, asignacion.getFechaAsignacion() != null ? Date.valueOf(asignacion.getFechaAsignacion()) : null, Types.DATE);
            ps.setString(4, asignacion.getRol());
            ps.setObject(5, asignacion.getTipoAplicador(), Types.VARCHAR);

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Obtener asignación por ID
    public Asignacion obtenerPorId(int id) {
        String sql = "SELECT * FROM Asignacion WHERE asignacionID = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapearAsignacion(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Obtener todas las asignaciones
    public List<Asignacion> obtenerTodas() {
        List<Asignacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Asignacion";
        try (Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapearAsignacion(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar asignación
    public boolean actualizar(Asignacion asignacion) {
        String sql = "UPDATE Asignacion SET cuil = ?, seccionID = ?, fechaAsignacion = ?, rol = ?, tipoAplicador = ? WHERE asignacionID = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, asignacion.getCuil());
            ps.setObject(2, asignacion.getSeccionID(), Types.INTEGER);
            ps.setObject(3, asignacion.getFechaAsignacion() != null ? Date.valueOf(asignacion.getFechaAsignacion()) : null, Types.DATE);
            ps.setString(4, asignacion.getRol());
            ps.setObject(5, asignacion.getTipoAplicador(), Types.VARCHAR);
            ps.setInt(6, asignacion.getAsignacionID());

            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar asignación
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Asignacion WHERE asignacionID = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mapear ResultSet a objeto Asignacion
    private Asignacion mapearAsignacion(ResultSet rs) throws SQLException {
        int asignacionID = rs.getInt("asignacionID");
        String cuil = rs.getString("cuil");

        int seccionID = rs.getInt("seccionID");
        if (rs.wasNull()) seccionID = -1;

        Date fecha = rs.getDate("fechaAsignacion");
        LocalDate fechaAsignacion = (fecha != null) ? fecha.toLocalDate() : null;

        String rol = rs.getString("rol");
        String tipoAplicador = rs.getString("tipoAplicador");

        return new Asignacion(
                asignacionID,
                cuil,
                (seccionID == -1) ? null : seccionID,
                fechaAsignacion,
                rol,
                tipoAplicador
        );
    }
}
