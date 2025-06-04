// @author aguirres
package control.entidades;
public class DatosLocalizacion {

    private String nombre;
    private String apellido;
    private String lugarDondeAplica;
    private String nombreDondeAplica;
    private String rol;
    private String tipoAplicador;
    private String gradoAnio;
    private String nombreSeccion;
    private String tipo;
    private String turno;
    private int alumnos;

    // Constructor vacío
    public DatosLocalizacion() {}

    // Constructor completo
    public DatosLocalizacion(String nombre, String apellido, String lugarDondeAplica, String nombreDondeAplica,
                             String rol, String tipoAplicador, String gradoAnio, String nombreSeccion,
                             String tipo, String turno, int alumnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarDondeAplica = lugarDondeAplica;
        this.nombreDondeAplica = nombreDondeAplica;
        this.rol = rol;
        this.tipoAplicador = tipoAplicador;
        this.gradoAnio = gradoAnio;
        this.nombreSeccion = nombreSeccion;
        this.tipo = tipo;
        this.turno = turno;
        this.alumnos = alumnos;
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getLugarDondeAplica() { return lugarDondeAplica; }
    public void setLugarDondeAplica(String lugarDondeAplica) { this.lugarDondeAplica = lugarDondeAplica; }

    public String getNombreDondeAplica() { return nombreDondeAplica; }
    public void setNombreDondeAplica(String nombreDondeAplica) { this.nombreDondeAplica = nombreDondeAplica; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getTipoAplicador() { return tipoAplicador; }
    public void setTipoAplicador(String tipoAplicador) { this.tipoAplicador = tipoAplicador; }

    public String getGradoAnio() { return gradoAnio; }
    public void setGradoAnio(String gradoAnio) { this.gradoAnio = gradoAnio; }

    public String getNombreSeccion() { return nombreSeccion; }
    public void setNombreSeccion(String nombreSeccion) { this.nombreSeccion = nombreSeccion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public int getAlumnos() { return alumnos; }
    public void setAlumnos(int alumnos) { this.alumnos = alumnos; }

    // Método toString()
    @Override
    public String toString() {
        return "DatosLocalizacion{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", lugarDondeAplica='" + lugarDondeAplica + '\'' +
                ", nombreDondeAplica='" + nombreDondeAplica + '\'' +
                ", rol='" + rol + '\'' +
                ", tipoAplicador='" + tipoAplicador + '\'' +
                ", gradoAnio='" + gradoAnio + '\'' +
                ", nombreSeccion='" + nombreSeccion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", turno='" + turno + '\'' +
                ", alumnos=" + alumnos +
                '}';
    }
}
