/**
 * @author aguirres
 */

package control.entidades;

import java.util.List;

public class Localizacion {
    private String cueAnexo;
    private String nombre;
    private String sector;
    private String dependencia;
    private String modalidadOferta;
    private String direccion;
    private String localidad;
    private String departamento;
    private String evalua;
    private List<Seccion> secciones; // Lista de secciones

    // Constructor con parámetros
    public Localizacion(String cueAnexo, String nombre, String sector, String dependencia, String modalidadOferta,
                        String direccion, String localidad, String departamento, String evalua) {
        this.cueAnexo = cueAnexo;
        this.nombre = nombre;
        this.sector = sector;
        this.dependencia = dependencia;
        this.modalidadOferta = modalidadOferta;
        this.direccion = direccion;
        this.localidad = localidad;
        this.departamento = departamento;
        this.evalua = evalua;
    }

    // Constructor vacío para casos sin parámetros
    public Localizacion() {
        // Constructor vacío
    }

    // Getters y Setters
    public String getCueAnexo() {
        return cueAnexo;
    }

    public void setCueAnexo(String cueAnexo) {
        this.cueAnexo = cueAnexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getModalidadOferta() {
        return modalidadOferta;
    }

    public void setModalidadOferta(String modalidadOferta) {
        this.modalidadOferta = modalidadOferta;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEvalua() {
        return evalua;
    }

    public void setEvalua(String evalua) {
        this.evalua = evalua;
    }

    public List<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(List<Seccion> secciones) {
        this.secciones = secciones;
    }
}
