/**
 *
 * @author aguirres
 */
package control.DAO;

import control.entidades.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private Connection conexion;

    public PersonaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public List<Persona> listarTodas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM Persona";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Persona persona = new Persona();
                persona.setCuil(rs.getString("cuil"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setRol(rs.getString("rol"));
                persona.setCargo(rs.getString("cargo"));
                persona.setLugarDondeAplica(rs.getString("lugar_donde_aplica"));
                persona.setTelefono(rs.getString("telefono"));
                personas.add(persona);
            }
        }
        return personas;
    }

    public Persona buscarPorCuil(String cuil) throws SQLException {
        Persona persona = null;
        String sql = "SELECT * FROM Persona WHERE cuil = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cuil);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    persona = new Persona();
                    persona.setCuil(rs.getString("cuil"));
                    persona.setNombre(rs.getString("nombre"));
                    persona.setApellido(rs.getString("apellido"));
                    persona.setRol(rs.getString("rol"));
                    persona.setCargo(rs.getString("cargo"));
                    persona.setLugarDondeAplica(rs.getString("lugar_donde_aplica"));
                    persona.setTelefono(rs.getString("telefono"));
                }
            }
        }
        return persona;
    }

    // Puedes agregar métodos adicionales según tus necesidades
}
