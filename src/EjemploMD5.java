import utilidades.Consola;
import utilidades.Entrada;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EjemploMD5 {

    public static void arrancar() throws NoSuchAlgorithmException {
        Consola.saltoDeLinea();
        Consola.salidaNormal("EJEMPLO DE CODIFICACION MD5");
        Consola.salidaNormal("===========================");
        Consola.salidaNormalSinSalto("Introduzca un texto a codificar en formato MD5: ");
        String mensaje = Entrada.cadena();
        // Crear objeto MessageDigest con algoritmo MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Actualizar el objeto MessageDigest con el mensaje a codificar
        md.update(mensaje.getBytes());

        // Codificar el mensaje y obtener el valor de hash resultante
        byte[] digest = md.digest();

        // Mostrar información sobre la codificación MD5
        Consola.salidaNormal("El mensaje original es: " + mensaje);
        Consola.salidaNormal("La codificación MD5 del mensaje es: " + bytesToHex(digest));
        Consola.salidaNormal("El valor de hash resultante tiene una longitud de " + digest.length + " bytes.");
        Consola.saltoDeLinea();
    }

    // Método para convertir un array de bytes en una cadena hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
