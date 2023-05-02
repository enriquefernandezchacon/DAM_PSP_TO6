import utilidades.Consola;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;

public class EjemploDSA {

    public static void arrancar() throws Exception {
        Consola.saltoDeLinea();
        Consola.salidaNormal("EJEMPLO DE FIRMA DIGITAL DSA");
        Consola.salidaNormal("============================");
        Consola.saltoDeLinea();
        // Crear objeto KeyPairGenerator con algoritmo DSA
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");

        // Generar par de claves pública y privada
        KeyPair pair = kpg.generateKeyPair();

        // Obtener claves pública y privada del par generado
        DSAPublicKey publicKey = (DSAPublicKey) pair.getPublic();
        DSAPrivateKey privateKey = (DSAPrivateKey) pair.getPrivate();

        // Cifrar y descifrar un mensaje utilizando las claves generadas
        String mensajeOriginal = "Este es un mensaje de prueba.";
        Consola.salidaNormal("Mensaje original: " + mensajeOriginal);

        byte[] firma = firmarMensaje(mensajeOriginal, privateKey);
        Consola.salidaNormal("Firma digital generada: " + bytesToHex(firma));

        boolean verificado = verificarFirma(mensajeOriginal, firma, publicKey);
        Consola.salidaNormal("Firma digital verificada: " + verificado);
        Consola.saltoDeLinea();
    }

    //Método para firmar un mensaje utilizando una clave privada
    private static byte[] firmarMensaje(String mensaje, DSAPrivateKey privateKey) throws Exception {
        Signature firma = Signature.getInstance("SHA256withDSA");
        firma.initSign(privateKey);
        firma.update(mensaje.getBytes());
        return firma.sign();
    }

    // Método para verificar la firma de un mensaje utilizando una clave pública
    private static boolean verificarFirma(String mensaje, byte[] firma, DSAPublicKey publicKey) throws Exception {
        Signature verificacion = Signature.getInstance("SHA256withDSA");
        verificacion.initVerify(publicKey);
        verificacion.update(mensaje.getBytes());
        return verificacion.verify(firma);
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
