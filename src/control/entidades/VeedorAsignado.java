/**
 *
 * @author aguirres
 */
package control.entidades;

public class VeedorAsignado {

    private String cuil;
    private String nombre;
    private String apellido;
    private String cbu;
    private String esDe;
    private String nombreLocalizacionTrabajo;
    private String contacto;
    private String correo;
    private String cueAnexo;
    private String nombreLocalizacionAplicada;
    private String dependencia;
    private String sector;

    // Constructor vacío
    public VeedorAsignado() {
    }

    // Constructor con todos los campos
    public VeedorAsignado(String cuil, String nombre, String apellido, String cbu, String esDe,
                          String nombreLocalizacionTrabajo, String contacto, String correo,
                          String cueAnexo, String nombreLocalizacionAplicada, String dependencia, String sector) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cbu = cbu;
        this.esDe = esDe;
        this.nombreLocalizacionTrabajo = nombreLocalizacionTrabajo;
        this.contacto = contacto;
        this.correo = correo;
        this.cueAnexo = cueAnexo;
        this.nombreLocalizacionAplicada = nombreLocalizacionAplicada;
        this.dependencia = dependencia;
        this.sector = sector;
    }

    // Getters y Setters
    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getEsDe() {
        return esDe;
    }

    public void setEsDe(String esDe) {
        this.esDe = esDe;
    }

    public String getNombreLocalizacionTrabajo() {
        return nombreLocalizacionTrabajo;
    }

    public void setNombreLocalizacionTrabajo(String nombreLocalizacionTrabajo) {
        this.nombreLocalizacionTrabajo = nombreLocalizacionTrabajo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCueAnexo() {
        return cueAnexo;
    }

    public void setCueAnexo(String cueAnexo) {
        this.cueAnexo = cueAnexo;
    }

    public String getNombreLocalizacionAplicada() {
        return nombreLocalizacionAplicada;
    }

    public void setNombreLocalizacionAplicada(String nombreLocalizacionAplicada) {
        this.nombreLocalizacionAplicada = nombreLocalizacionAplicada;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    // Método toString para testeo
    @Override
    public String toString() {
        return "VeedorAsignado{" +
                "cuil='" + cuil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cbu='" + cbu + '\'' +
                ", esDe='" + esDe + '\'' +
                ", nombreLocalizacionTrabajo='" + nombreLocalizacionTrabajo + '\'' +
                ", contacto='" + contacto + '\'' +
                ", correo='" + correo + '\'' +
                ", cueAnexo='" + cueAnexo + '\'' +
                ", nombreLocalizacionAplicada='" + nombreLocalizacionAplicada + '\'' +
                ", dependencia='" + dependencia + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
