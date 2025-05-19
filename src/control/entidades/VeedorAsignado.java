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
}
