/**
 *
 * @author aguirres
 */
package control.entidades;

public class PersonaDetalleAsignacion extends Persona {

    private String cbu;
    private String contacto;
    private String lugarDondeSeDesempena;
    private String nombreDondeSeDesempena;
    private String lugarDondeAplica;
    private String nombreDondeAplica;
    private String rol;
    private String tipoAplicador;

    public PersonaDetalleAsignacion(
            String cuil,
            String cbu,
            String nombre,
            String apellido,
            String contacto,
            String lugarDondeSeDesempena,
            String nombreDondeSeDesempena,
            String lugarDondeAplica,
            String nombreDondeAplica,
            String rol,
            String tipoAplicador
    ) {
        setCuil(cuil);
        setNombre(nombre);
        setApellido(apellido);

        this.cbu = cbu;
        this.contacto = contacto;
        this.lugarDondeSeDesempena = lugarDondeSeDesempena;
        this.nombreDondeSeDesempena = nombreDondeSeDesempena;
        this.lugarDondeAplica = lugarDondeAplica;
        this.nombreDondeAplica = nombreDondeAplica;
        this.rol = rol;
        this.tipoAplicador = tipoAplicador;
    }

    // Getters y Setters

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getLugarDondeSeDesempena() {
        return lugarDondeSeDesempena;
    }

    public void setLugarDondeSeDesempena(String lugarDondeSeDesempena) {
        this.lugarDondeSeDesempena = lugarDondeSeDesempena;
    }

    public String getNombreDondeSeDesempena() {
        return nombreDondeSeDesempena;
    }

    public void setNombreDondeSeDesempena(String nombreDondeSeDesempena) {
        this.nombreDondeSeDesempena = nombreDondeSeDesempena;
    }

    public String getLugarDondeAplica() {
        return lugarDondeAplica;
    }

    public void setLugarDondeAplica(String lugarDondeAplica) {
        this.lugarDondeAplica = lugarDondeAplica;
    }

    public String getNombreDondeAplica() {
        return nombreDondeAplica;
    }

    public void setNombreDondeAplica(String nombreDondeAplica) {
        this.nombreDondeAplica = nombreDondeAplica;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoAplicador() {
        return tipoAplicador;
    }

    public void setTipoAplicador(String tipoAplicador) {
        this.tipoAplicador = tipoAplicador;
    }

    @Override
    public String toString() {
        return "PersonaDetalleAsignacion{" +
                "cuil='" + getCuil() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", cbu='" + cbu + '\'' +
                ", contacto='" + contacto + '\'' +
                ", lugarDondeSeDesempena='" + lugarDondeSeDesempena + '\'' +
                ", nombreDondeSeDesempena='" + nombreDondeSeDesempena + '\'' +
                ", lugarDondeAplica='" + lugarDondeAplica + '\'' +
                ", nombreDondeAplica='" + nombreDondeAplica + '\'' +
                ", rol='" + rol + '\'' +
                ", tipoAplicador='" + tipoAplicador + '\'' +
                '}';
    }
}

