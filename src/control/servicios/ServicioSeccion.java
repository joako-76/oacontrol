/**
 * @author aguirres
 */

package control.servicios;

import control.entidades.Seccion;
import control.entidades.Localizacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioSeccion {

    private Connection conexion;

    public ServicioSeccion(Connection conexion) {
        this.conexion = conexion;
    }

    // Listar todas las secciones
    public List<Seccion> listarTodas() throws SQLException {
        List<Seccion> lista = new ArrayList<>();
        String sql = "SELECT s.seccionID, s.nombre, s.tipo, s.turno, s.cueAnexo, l.nombre as nombreLocalizacion FROM Seccion s LEFT JOIN Localizacion l ON s.cueAnexo = l.cueAnexo";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Localizacion loc = new Localizacion();
                loc.setCueAnexo(rs.getString("cueAnexo"));
                loc.setNombre(rs.getString("nombreLocalizacion"));

                Seccion sec = new Seccion(
                        rs.getInt("seccionID"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getString("turno"),
                        loc
                );
                lista.add(sec);
            }
        }
        return lista;
    }

    // Buscar sección por ID
    public Seccion buscarPorID(int seccionID) throws SQLException {
        String sql = "SELECT s.seccionID, s.nombre, s.tipo, s.turno, s.cueAnexo, l.nombre as nombreLocalizacion FROM Seccion s LEFT JOIN Localizacion l ON s.cueAnexo = l.cueAnexo WHERE s.seccionID = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, seccionID);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Localizacion loc = new Localizacion();
                    loc.setCueAnexo(rs.getString("cueAnexo"));
                    loc.setNombre(rs.getString("nombreLocalizacion"));

                    return new Seccion(
                            rs.getInt("seccionID"),
                            rs.getString("nombre"),
                            rs.getString("tipo"),
                            rs.getString("turno"),
                            loc
                    );
                }
            }
        }
        return null;
    }

    // Insertar nueva sección
    public boolean insertar(Seccion sec) throws SQLException {
        String sql = "INSERT INTO Seccion (nombre, tipo, turno, cueAnexo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, sec.getNombre());
            ps.setString(2, sec.getTipo());
            ps.setString(3, sec.getTurno());
            ps.setString(4, sec.getLocalizacion().getCueAnexo());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    // Actualizar sección
    public boolean actualizar(Seccion sec) throws SQLException {
        String sql = "UPDATE Seccion SET nombre=?, tipo=?, turno=?, cueAnexo=? WHERE seccionID=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, sec.getNombre());
            ps.setString(2, sec.getTipo());
            ps.setString(3, sec.getTurno());
            ps.setString(4, sec.getLocalizacion().getCueAnexo());
            ps.setInt(5, sec.getSeccionID());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    // Eliminar sección
    public boolean eliminar(int seccionID) throws SQLException {
        String sql = "DELETE FROM Seccion WHERE seccionID = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, seccionID);
            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
}
