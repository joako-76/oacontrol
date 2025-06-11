/**
 *
 * @author aguirres
 */
package control.persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import control.entidades.AplicadorAsignado;
import control.enums.remuneradoEnum;

public class AplicadorDAO {

    private static final Logger LOGGER = Logger.getLogger(AplicadorDAO.class.getName());
    private final Connection conn;

    // Constructor con conexión
    public AplicadorDAO(Connection conn) {
        this.conn = conn;
    }

    public List<AplicadorAsignado> obtenerAplicadores() {
        List<AplicadorAsignado> lista = new ArrayList<>();
        String sql = "SELECT * FROM vista_aplicador_seccion";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                AplicadorAsignado a = new AplicadorAsignado();

                // Atributos heredados de Persona (si no están en superclase, igual usamos aquí)
                a.setCuil(rs.getString("cuil"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));

                // Nuevos campos agregados en vista
                a.setCbu(rs.getString("cbu"));
                a.setTelefono(rs.getString("telefono"));
                a.setCorreo(rs.getString("correo"));
                
                // Aquí estamos usando el enum remuneradoEnum
                String remuneradoStr = rs.getString("remunerado");
                if (remuneradoStr != null) {
                    try {
                        a.setRemunerado(remuneradoEnum.valueOf(remuneradoStr));
                    } catch (IllegalArgumentException e) {
                        // Si no coincide con un valor del enum, se pone REVISAR
                        a.setRemunerado(remuneradoEnum.REVISAR);
                    }
                }

                // Datos propios de AplicadorAsignado
                a.setTipoAplicador(rs.getString("tipoAplicador"));
                a.setSeccion(rs.getString("seccion"));
                a.setTurno(rs.getString("turno"));
                a.setTipoSeccion(rs.getString("tipo"));
                a.setCueAnexo(rs.getString("cueAnexo"));
                a.setNombreEscuela(rs.getString("nombreEscuela"));
                a.setDependencia(rs.getString("dependencia"));
                a.setSector(rs.getString("sector"));
                a.setDepartamento(rs.getString("departamento"));

                lista.add(a);
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener aplicadores desde la vista.", e);
        }

        return lista;
    }
}
