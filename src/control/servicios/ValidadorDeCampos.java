/**
 * @author aguirres
 */

package control.servicios;

public class ValidadorDeCampos {

    public static void validarNoNulo(String nombreCampo, Object valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' no puede ser nulo.");
        }
    }

    public static void validarLongitud(String nombreCampo, String valor, int longitudMaxima) {
        validarNoNulo(nombreCampo, valor);
        if (valor.length() > longitudMaxima) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' no puede tener más de "
                                               + longitudMaxima + " caracteres. Valor recibido: '" + valor + "'");
        }
    }

    public static void validarExacto(String nombreCampo, String valor, int longitudExacta) {
        validarNoNulo(nombreCampo, valor);
        if (!valor.matches("\\d{" + longitudExacta + "}")) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' debe tener exactamente "
                                               + longitudExacta + " dígitos numéricos. Valor recibido: '" + valor + "'");
        }
    }

    public static void validarEmail(String nombreCampo, String email) {
        validarNoNulo(nombreCampo, email);
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' no tiene un formato de correo válido.");
        }
    }

    public static void validarRangoNumerico(String nombreCampo, int valor, int limiteInferior, int limiteSuperior) {
        if (valor < limiteInferior || valor > limiteSuperior) {
            throw new IllegalArgumentException("El campo '" + nombreCampo + "' debe estar entre " 
                                               + limiteInferior + " y " + limiteSuperior + ". Valor recibido: " + valor);
        }
    }

    public static void validarCuil(String nombreCampo, String cuil) {
        validarExacto(nombreCampo, cuil, 11);
    }

    public static void validarTelefono(String nombreCampo, String telefono) {
        validarExacto(nombreCampo, telefono, 10);
    }

    public static void validarCbu(String nombreCampo, String cbu) {
        validarExacto(nombreCampo, cbu, 22);
    }
}
