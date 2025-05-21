/**
 *
 * @author aguirres
 */
package control.entidades;

public class AplicadorAsignado extends Persona {

    private String tipoAplicador;
    private String seccion;
    private String turno;
    private String tipoSeccion;
    private String cueAnexo;
    private String nombreEscuela;
    private String dependencia;
    private String sector;
    private String departamento;

    // Constructor vacío
    public AplicadorAsignado() {
    }

    // Constructor completo
    public AplicadorAsignado(String nombre, String apellido, String cuil, String cargo, String cbu,
                             String lugarDondeSeDesempena, String telefono, String correo, String rol,
                             String lugarDondeAplica,
                             String tipoAplicador, String seccion, String turno, String tipoSeccion,
                             String cueAnexo, String nombreEscuela, String dependencia,
                             String sector, String departamento) {

        // Atributos heredados
        setNombre(nombre);
        setApellido(apellido);
        setCuil(cuil);
        setCargo(cargo);
        setCbu(cbu);
        setLugarDondeSeDesempena(lugarDondeSeDesempena);
        setTelefono(telefono);
        setCorreo(correo);
        setRol(rol);
        setLugarDondeAplica(lugarDondeAplica);

        // Atributos propios
        this.tipoAplicador = tipoAplicador;
        this.seccion = seccion;
        this.turno = turno;
        this.tipoSeccion = tipoSeccion;
        this.cueAnexo = cueAnexo;
        this.nombreEscuela = nombreEscuela;
        this.dependencia = dependencia;
        this.sector = sector;
        this.departamento = departamento;
    }

    // Getters y Setters
    public String getTipoAplicador() {
        return tipoAplicador;
    }

    public void setTipoAplicador(String tipoAplicador) {
        this.tipoAplicador = tipoAplicador;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTipoSeccion() {
        return tipoSeccion;
    }

    public void setTipoSeccion(String tipoSeccion) {
        this.tipoSeccion = tipoSeccion;
    }

    public String getCueAnexo() {
        return cueAnexo;
    }

    public void setCueAnexo(String cueAnexo) {
        this.cueAnexo = cueAnexo;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " - Aplicador: " + tipoAplicador
               + ", Sección: " + seccion + ", Turno: " + turno
               + ", Escuela: " + nombreEscuela + ", CUE-Anexo: " + cueAnexo;
    }
}

