/**
 *
 * @author aguirres
 */
package control.entidades;

import control.enums.remuneradoEnum;

public class PersonaDetalleAsignacion extends Persona {

    private String cbu;
    private String contacto;
    private String lugarDondeSeDesempena;
    private String nombreDondeSeDesempena;
    private String lugarDondeAplica;
    private String nombreDondeAplica;
    private String rol;
    private String tipoAplicador;
    private remuneradoEnum remunerado;
    
     public PersonaDetalleAsignacion(){
     }

    public PersonaDetalleAsignacion(
            String cuil,
            String cbu,
            String nombre,
            String apellido,
            String contacto,
            remuneradoEnum remunerado,
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
        this.remunerado = remunerado;
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
@Override
    public String getLugarDondeSeDesempena() {
        return lugarDondeSeDesempena;
    }
@Override
    public void setLugarDondeSeDesempena(String lugarDondeSeDesempena) {
        this.lugarDondeSeDesempena = lugarDondeSeDesempena;
    }

    public String getNombreDondeSeDesempena() {
        return nombreDondeSeDesempena;
    }

    public void setNombreDondeSeDesempena(String nombreDondeSeDesempena) {
        this.nombreDondeSeDesempena = nombreDondeSeDesempena;
    }
@Override
    public String getLugarDondeAplica() {
        return lugarDondeAplica;
    }
@Override
    public void setLugarDondeAplica(String lugarDondeAplica) {
        this.lugarDondeAplica = lugarDondeAplica;
    }

    public String getNombreDondeAplica() {
        return nombreDondeAplica;
    }

    public void setNombreDondeAplica(String nombreDondeAplica) {
        this.nombreDondeAplica = nombreDondeAplica;
    }
@Override
    public String getRol() {
        return rol;
    }
@Override
    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoAplicador() {
        return tipoAplicador;
    }

    public void setTipoAplicador(String tipoAplicador) {
        this.tipoAplicador = tipoAplicador;
    }

    public remuneradoEnum getRemunerado() {
        return remunerado;
    }

    public void setRemunerado(remuneradoEnum remunerado) {
        this.remunerado = remunerado;
    }

    @Override
    public String toString() {
        return "PersonaDetalleAsignacion{" +
                "cuil='" + getCuil() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", cbu='" + cbu + '\'' +
                ", contacto='" + contacto + '\'' +
                ", remunerado='" + remunerado + '\'' +
                ", lugarDondeSeDesempena='" + lugarDondeSeDesempena + '\'' +
                ", nombreDondeSeDesempena='" + nombreDondeSeDesempena + '\'' +
                ", lugarDondeAplica='" + lugarDondeAplica + '\'' +
                ", nombreDondeAplica='" + nombreDondeAplica + '\'' +
                ", rol='" + rol + '\'' +
                ", tipoAplicador='" + tipoAplicador + '\'' +
                '}';
    }
}
