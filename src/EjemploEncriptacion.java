import utilidades.*;
import java.awt.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class EjemploEncriptacion {

    private static final String key = "password12345678";
    private static final File inputFile = new File("input.txt");
    private static final File encryptedFile = new File("encrypted.txt");
    private static final File decryptedFile = new File("decrypted.txt");
    public static void arrancar() {
        Consola.saltoDeLinea();
        Consola.salidaNormal("EJEMPLO DE ENCRIPTACION DE UN FICHERO");
        Consola.salidaNormal("=====================================");
        Consola.saltoDeLinea();
        try {
            Consola.salidaNormal("Introduzca el texto a cifrar y descifrar:");
            escribirDocumento(Entrada.cadena());
            encrypt();
            Thread.sleep(2000);
            decrypt();
        } catch (Exception ex) {
            System.out.println("Error cifrando/descifrando el archivo: " + ex.getMessage());
        }
        Consola.saltoDeLinea();
    }

    private static void doCrypto(int cipherMode, File inputFile, File outputFile) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(EjemploEncriptacion.key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(cipherMode, secretKey);
        FileInputStream inputStream = new FileInputStream(inputFile);
        byte[] inputBytes = new byte[(int) inputFile.length()];
        inputStream.read(inputBytes);
        byte[] outputBytes = cipher.doFinal(inputBytes);
        FileOutputStream outputStream = new FileOutputStream(outputFile);
        outputStream.write(outputBytes);
        inputStream.close();
        outputStream.close();
    }

    private static void encrypt() throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, EjemploEncriptacion.inputFile, EjemploEncriptacion.encryptedFile);
        abrirDocuento(encryptedFile);
    }

    private static void decrypt() throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, EjemploEncriptacion.encryptedFile, EjemploEncriptacion.decryptedFile);
        abrirDocuento(decryptedFile);
    }

    private static void abrirDocuento(File file) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
    }

    private static void escribirDocumento(String texto) throws IOException {
        FileWriter fw = new FileWriter(inputFile);
        fw.write(texto);
        fw.close();
    }
}
