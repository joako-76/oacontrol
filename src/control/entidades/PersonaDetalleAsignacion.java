/**
 *
 * @author aguirres
 */
package control.entidades;

public class PersonaDetalleAsignacion extends Persona {

    private String rolAsignado;
    private String tipoAplicador;
    private String seccion;
    private String turno;
    private String tipo;
    private String cueAnexo;
    private String nombreEscuela;
    private String departamento;
    private String sector;
    private String dependencia;

    public PersonaDetalleAsignacion(String cuil, String nombre, String apellido,
                                    String rolDeclarado, String rolAsignado,
                                    String tipoAplicador, String seccion, String turno,
                                    String tipo, String cueAnexo, String nombreEscuela,
                                    String departamento, String sector, String dependencia) {

        setCuil(cuil);
        setNombre(nombre);
        setApellido(apellido);
        setRol(rolDeclarado); // Este es el rol declarado

        this.rolAsignado = rolAsignado;
        this.tipoAplicador = tipoAplicador;
        this.seccion = seccion;
        this.turno = turno;
        this.tipo = tipo;
        this.cueAnexo = cueAnexo;
        this.nombreEscuela = nombreEscuela;
        this.departamento = departamento;
        this.sector = sector;
        this.dependencia = dependencia;
    }

    // Getters y setters adicionales

    public String getRolAsignado() {
        return rolAsignado;
    }

    public void setRolAsignado(String rolAsignado) {
        this.rolAsignado = rolAsignado;
    }

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }
}

