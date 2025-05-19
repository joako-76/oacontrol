
/**
 * @author aguirres
 */
package control.entidades;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private String cuil;
    private String cargo;
    private String cbu;
    private String lugarDondeSeDesempena;
    private String telefono;
    private String correo;
    private String rol;
    private String lugarDondeAplica;

    // Getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCuil() { return cuil; }
    public void setCuil(String cuil) { this.cuil = cuil; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getCbu() { return cbu; }
    public void setCbu(String cbu) { this.cbu = cbu; }

    public String getLugarDondeSeDesempena() { return lugarDondeSeDesempena; }
    public void setLugarDondeSeDesempena(String lugarDondeSeDesempena) { this.lugarDondeSeDesempena = lugarDondeSeDesempena; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getLugarDondeAplica() { return lugarDondeAplica; }
    public void setLugarDondeAplica(String lugarDondeAplica) { this.lugarDondeAplica = lugarDondeAplica; }

    @Override
    public String toString() {
        return apellido + ", " + nombre + " (" + cuil + ") - " + rol;
    }
}
