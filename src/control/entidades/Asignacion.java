/**
 *
 * @author aguirres
 */
package control.entidades;

import java.time.LocalDate;

public class Asignacion {

    private int asignacionID;
    private String cuil;
    private Integer seccionID; // Puede ser null
    private LocalDate fechaAsignacion;
    private String rol; // Podríamos hacer enum, pero dejamos String para simplificar
    private String tipoAplicador; // Puede ser null

    // Constructor vacío
    public Asignacion() {
    }

    // Constructor completo
    public Asignacion(int asignacionID, String cuil, Integer seccionID, LocalDate fechaAsignacion, String rol, String tipoAplicador) {
        this.asignacionID = asignacionID;
        this.cuil = cuil;
        this.seccionID = seccionID;
        this.fechaAsignacion = fechaAsignacion;
        this.rol = rol;
        this.tipoAplicador = tipoAplicador;
    }

    // Getters y Setters
    public int getAsignacionID() {
        return asignacionID;
    }

    public void setAsignacionID(int asignacionID) {
        this.asignacionID = asignacionID;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Integer getSeccionID() {
        return seccionID;
    }

    public void setSeccionID(Integer seccionID) {
        this.seccionID = seccionID;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
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
}

