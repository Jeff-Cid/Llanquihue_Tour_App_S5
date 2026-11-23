package cl.LlanquihueTour.util;

public class Validador {

    public static void validarTextoNoVacio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("el campo " + nombreCampo + " está vacío.");
        }
    }

    public static int convertirAEntero(String valor, String nombreCampo) {
        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "el campo " + nombreCampo + " debe ser un número... se ingreso '" + valor.trim() + "'.");
        }
    }

    public static void validarCorreo(String correo) {
        if (correo == null || !correo.contains("@") || !correo.contains(".")) {
            throw new IllegalArgumentException("el correo '" + correo + "' no es válido.");
        }
    }
}