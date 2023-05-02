import utilidades.Consola;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EjemploConexionSegura {

    public static void arrancar() throws IOException {
        Consola.saltoDeLinea();
        Consola.salidaNormal("EJEMPLO DE CONEXION SEGURA");
        Consola.salidaNormal("==========================");
        Consola.saltoDeLinea();

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        // Crear un SSLSocket y conectarse al servidor en el puerto 12345
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 12345);

        // Enviar un mensaje al servidor
        PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
        out.println("Hola servidor");

        // Leer la respuesta del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        String line = in.readLine();
        System.out.println("Respuesta recibida del servidor: " + line);

        // Cerrar los recursos
        out.close();
        in.close();
        sslSocket.close();
    }
}
