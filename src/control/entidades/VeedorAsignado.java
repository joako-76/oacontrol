/**
 *
 * @author aguirres
 */
package control.entidades;

public class VeedorAsignado {
    private String cuil;
    private String nombre;
    private String apellido;
    private String cueAnexo;
    private String nombreEscuela;
    private String dependencia;
    private String sector;
    private String departamento;

    // Constructor vacío
    public VeedorAsignado() {
    }

    // Constructor completo
    public VeedorAsignado(String cuil, String nombre, String apellido,
                          String cueAnexo, String nombreEscuela,
                          String dependencia, String sector, String departamento) {
        this.cuil = cuil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cueAnexo = cueAnexo;
        this.nombreEscuela = nombreEscuela;
        this.dependencia = dependencia;
        this.sector = sector;
        this.departamento = departamento;
    }

    // Getters y Setters
    public String getCuil() { return cuil; }
    public void setCuil(String cuil) { this.cuil = cuil; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getCueAnexo() { return cueAnexo; }
    public void setCueAnexo(String cueAnexo) { this.cueAnexo = cueAnexo; }

    public String getNombreEscuela() { return nombreEscuela; }
    public void setNombreEscuela(String nombreEscuela) { this.nombreEscuela = nombreEscuela; }

    public String getDependencia() { return dependencia; }
    public void setDependencia(String dependencia) { this.dependencia = dependencia; }

    public String getSector() { return sector; }
    public void setSector(String sector) { this.sector = sector; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    // toString
    @Override
    public String toString() {
        return "VeedorAsignado{" +
                "cuil='" + cuil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cueAnexo='" + cueAnexo + '\'' +
                ", nombreEscuela='" + nombreEscuela + '\'' +
                ", dependencia='" + dependencia + '\'' +
                ", sector='" + sector + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
