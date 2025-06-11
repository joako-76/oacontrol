/**
 *
 * @author aguirres
 */
package control.entidades;
import control.enums.remuneradoEnum;

public class AplicadorAsignado extends Persona {

    private String tipoAplicador;
    private String seccion;
    private String turno;
    private String tipo;
    private String cueAnexo;
    private String nombreEscuela;
    private String dependencia;
    private String sector;
    private String departamento;

    private String cbu;
    private String telefono;
    private String correo;
    private remuneradoEnum remunerado;

    // Constructor vacío
    public AplicadorAsignado() {
    }

    // Constructor completo (desde vista)
    public AplicadorAsignado(String cuil, String nombre, String apellido,
                              String cbu, String telefono, String correo, remuneradoEnum remunerado,
                              String tipoAplicador, String seccion, String turno, String tipo,
                              String cueAnexo, String nombreEscuela, String dependencia,
                              String sector, String departamento) {

        // Atributos heredados
        setCuil(cuil);
        setNombre(nombre);
        setApellido(apellido);

        // Nuevos campos de la vista
        this.cbu = cbu;
        this.telefono = telefono;
        this.correo = correo;
        this.remunerado = remunerado;

        this.tipoAplicador = tipoAplicador;
        this.seccion = seccion;
        this.turno = turno;
        this.tipo = tipo;
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
        return tipo;
    }

    public void setTipoSeccion(String tipoSeccion) {
        this.tipo = tipoSeccion;
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
    public String getCbu() {
        return cbu;
    }
@Override
    public void setCbu(String cbu) {
        this.cbu = cbu;
    }
@Override
    public String getTelefono() {
        return telefono;
    }
@Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
@Override
    public String getCorreo() {
        return correo;
    }
@Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public remuneradoEnum getRemunerado() {
        return remunerado;
    }

    public void setRemunerado(remuneradoEnum remunerado) {
        this.remunerado = remunerado;
    }

@Override
public String toString() {
    return super.toString()
           + " | CUIL: " + getCuil()
           + " | Nombre: " + getNombre() + " " + getApellido()
           + " | CBU: " + cbu
           + " | Teléfono: " + telefono
           + " | Correo: " + correo
           + " | Remunerado: " + remunerado  // acá esperás 'SI', 'NO' o 'REVISAR'
           + " | Tipo Aplicador: " + tipoAplicador
           + " | Sección: " + seccion
           + " | Turno: " + turno
           + " | Tipo Sección: " + tipo
           + " | Cue Anexo: " + cueAnexo
           + " | Nombre Escuela: " + nombreEscuela
           + " | Dependencia: " + dependencia
           + " | Sector: " + sector
           + " | Departamento: " + departamento;
}

}

