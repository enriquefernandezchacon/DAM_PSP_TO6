import utilidades.Consola;
import utilidades.Entrada;

public class Main {
    public static void main(String[] args) {
        Consola.salidaNormal("BIENVENIDO AL PROGRAMA DE EJEMPLO DE CRIPTOGRAFIA Y SEGURIDAD");
        Consola.salidaNormal("=============================================================");
        Consola.saltoDeLinea();
        do {
            mostarMenu();
            int opcion = elegirOpcion();
            try {
                gestionarOpcion(opcion);
            } catch (Exception e) {
                Consola.salidaError("Error: " + e.getMessage());
            }
        } while (true);
    }

    public  static void mostarMenu(){
        Consola.salidaNormal("1. Ejemplo MD5");
        Consola.salidaNormal("2. Ejemplo DSA");
        Consola.salidaNormal("3. Ejemplo Encriptacion");
        Consola.salidaNormal("4. Conexion a servidor cifrada");
        Consola.salidaNormal("0. Salir");
        Consola.saltoDeLinea();
    }

    public static int elegirOpcion() {
        Consola.salidaNormalSinSalto("Introduzca una opcion: ");
        return Entrada.entero();
    }

    public static void gestionarOpcion(int opcion) throws Exception {
        switch (opcion) {
            case 1 -> EjemploMD5.arrancar();
            case 2 -> EjemploDSA.arrancar();
            case 3 -> EjemploEncriptacion.arrancar();
            case 4 -> EjemploConexionSegura.arrancar();
            case 0 -> {
                Consola.salidaNormal("Saliendo...");
                System.exit(0);
            }
            default -> Consola.salidaError("Opcion no valida");
        }
    }


}
