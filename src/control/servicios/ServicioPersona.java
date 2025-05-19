package control.servicios;

import control.entidades.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicioPersona {

    private Connection conexion;

    public ServicioPersona(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Persona> listarTodas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM Persona";

        try (PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Persona p = new Persona();
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCuil(rs.getString("cuil"));
                p.setCargo(rs.getString("cargo"));
                p.setCbu(rs.getString("cbu"));
                p.setLugarDondeSeDesempena(rs.getString("lugarDondeSeDesempena"));
                p.setTelefono(rs.getString("telefono"));
                p.setCorreo(rs.getString("correo"));
                p.setRol(rs.getString("rol"));
                p.setLugarDondeAplica(rs.getString("lugarDondeAplica"));
                personas.add(p);
            }
        }
        return personas;
    }

    public Persona buscarPorCuil(String cuil) throws SQLException {
        String sql = "SELECT * FROM Persona WHERE cuil = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cuil);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Persona p = new Persona();
                    p.setNombre(rs.getString("nombre"));
                    p.setApellido(rs.getString("apellido"));
                    p.setCuil(rs.getString("cuil"));
                    p.setCargo(rs.getString("cargo"));
                    p.setCbu(rs.getString("cbu"));
                    p.setLugarDondeSeDesempena(rs.getString("lugarDondeSeDesempena"));
                    p.setTelefono(rs.getString("telefono"));
                    p.setCorreo(rs.getString("correo"));
                    p.setRol(rs.getString("rol"));
                    p.setLugarDondeAplica(rs.getString("lugarDondeAplica"));
                    return p;
                }
            }
        }
        return null;
    }

    public boolean insertar(Persona persona) throws SQLException {
        String sql = "INSERT INTO Persona (nombre, apellido, cuil, cargo, cbu, lugarDondeSeDesempena, telefono, correo, rol, lugarDondeAplica) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCuil());
            ps.setString(4, persona.getCargo());
            ps.setString(5, persona.getCbu());
            ps.setString(6, persona.getLugarDondeSeDesempena());
            ps.setString(7, persona.getTelefono());
            ps.setString(8, persona.getCorreo());
            ps.setString(9, persona.getRol());
            ps.setString(10, persona.getLugarDondeAplica());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    public boolean actualizar(Persona persona) throws SQLException {
        String sql = "UPDATE Persona SET nombre=?, apellido=?, cargo=?, cbu=?, lugarDondeSeDesempena=?, telefono=?, correo=?, rol=?, lugarDondeAplica=? WHERE cuil=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getCargo());
            ps.setString(4, persona.getCbu());
            ps.setString(5, persona.getLugarDondeSeDesempena());
            ps.setString(6, persona.getTelefono());
            ps.setString(7, persona.getCorreo());
            ps.setString(8, persona.getRol());
            ps.setString(9, persona.getLugarDondeAplica());
            ps.setString(10, persona.getCuil());

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }

    public boolean eliminar(String cuil) throws SQLException {
        String sql = "DELETE FROM Persona WHERE cuil = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, cuil);
            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
}
