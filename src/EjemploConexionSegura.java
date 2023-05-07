import utilidades.Consola;

import javax.net.ssl.*;
import java.io.*;

public class EjemploConexionSegura {

    public static void arrancar() throws IOException {
        Consola.saltoDeLinea();
        Consola.salidaNormal("EJEMPLO DE CONEXION SEGURA");
        Consola.salidaNormal("==========================");
        Consola.saltoDeLinea();

        System.setProperty("javax.net.ssl.trustStore", "truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        // Crear un SSLSocket y conectarse al servidor en el puerto 12345
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 12345);
        //Una vez que hayas completado estos pasos, actualiza el código del cliente para utilizar el nuevo almacén de claves truststore.jks como almacén de claves de confianza, tal como se explicó en la respuesta anterior.


        // Enviar un mensaje al servidor
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        out.println("Hola servidor");

        // Leer la respuesta del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        String line = in.readLine();
        Consola.salidaNormal("Respuesta recibida del servidor: " + line);
        Consola.saltoDeLinea();
        // Cerrar los recursos
        out.close();
        in.close();
        sslSocket.close();
    }
}
