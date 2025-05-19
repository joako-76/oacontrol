/**
 *
 * @author aguirres
 */
package control.servicios;

import control.entidades.Localizacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioLocalizacion {

    private Connection conexion;

    public ServicioLocalizacion(Connection conexion) {
        this.conexion = conexion;
    }

    // Listar todas las localizaciones
    public List<Localizacion> listarTodas() throws SQLException {
        List<Localizacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Localizacion";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Localizacion loc = new Localizacion(
                        rs.getString("cueAnexo"),
                        rs.getString("nombre"),
                        rs.getString("sector"),
                        rs.getString("dependencia"),
                        rs.getString("modalidadOferta"),
                        rs.getString("direccion"),
                        rs.getString("localidad"),
                        rs.getString("departamento"),
                        rs.getString("evalua")
                );
                lista.add(loc);
            }
        }
        return lista;
    }

    // Buscar localizacion por cueAnexo
    public Localizacion buscarPorCueAnexo(String cueAnexo) throws SQLException {
        String sql = "SELECT * FROM Localizacion WHERE cueAnexo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cueAnexo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Localizacion(
                            rs.getString("cueAnexo"),
                            rs.getString("nombre"),
                            rs.getString("sector"),
                            rs.getString("dependencia"),
                            rs.getString("modalidadOferta"),
                            rs.getString("direccion"),
                            rs.getString("localidad"),
                            rs.getString("departamento"),
                            rs.getString("evalua")
                    );
                }
            }
        }
        return null;
    }

    // Método para insertar una nueva Localizacion
    public boolean insertar(Localizacion loc) throws SQLException {
        String sql = "INSERT INTO Localizacion (cueAnexo, nombre, sector, dependencia, modalidadOferta, direccion, localidad, departamento, evalua) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, loc.getCueAnexo());
            ps.setString(2, loc.getNombre());
            ps.setString(3, loc.getSector());
            ps.setString(4, loc.getDependencia());
            ps.setString(5, loc.getModalidadOferta());
            ps.setString(6, loc.getDireccion());
            ps.setString(7, loc.getLocalidad());
            ps.setString(8, loc.getDepartamento());
            ps.setString(9, loc.getEvalua());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    // Método para actualizar una Localizacion
    public boolean actualizar(Localizacion loc) throws SQLException {
        String sql = "UPDATE Localizacion SET nombre=?, sector=?, dependencia=?, modalidadOferta=?, direccion=?, localidad=?, departamento=?, evalua=? WHERE cueAnexo=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, loc.getNombre());
            ps.setString(2, loc.getSector());
            ps.setString(3, loc.getDependencia());
            ps.setString(4, loc.getModalidadOferta());
            ps.setString(5, loc.getDireccion());
            ps.setString(6, loc.getLocalidad());
            ps.setString(7, loc.getDepartamento());
            ps.setString(8, loc.getEvalua());
            ps.setString(9, loc.getCueAnexo());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    // Método para eliminar una Localizacion
    public boolean eliminar(String cueAnexo) throws SQLException {
        String sql = "DELETE FROM Localizacion WHERE cueAnexo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cueAnexo);
            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
}

