/**
 * @author aguirres
 */
package control.entidades;

public class Seccion {
    private int seccionID;
    private String nombre;
    private String tipo;
    private String turno;
    private Localizacion localizacion; // Aquí seguimos usando Localizacion
    
    //Constructor vacio para que ande mi menu ppl
    public Seccion(){
    }

    // Constructor completo
    public Seccion(int seccionID, String nombre, String tipo, String turno, Localizacion localizacion) {
        this.seccionID = seccionID;
        this.nombre = nombre;
        this.tipo = tipo;
        this.turno = turno;
        this.localizacion = localizacion;
    }

    // Constructor sin ID (para inserciones donde el ID es autogenerado)
    public Seccion(String nombre, String tipo, String turno, Localizacion localizacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.turno = turno;
        this.localizacion = localizacion;
    }

    // Constructor sin Localización (para evitar recursión)
    public Seccion(int seccionID, String nombre, String tipo, String turno) {
        this.seccionID = seccionID;
        this.nombre = nombre;
        this.tipo = tipo;
        this.turno = turno;
    }

    // Getters
    public int getSeccionID() {
        return seccionID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTurno() {
        return turno;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    // Setters
    public void setSeccionID(int seccionID) {
        this.seccionID = seccionID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }
}
