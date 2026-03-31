package com.happinesssco.utilidad;

import java.util.Scanner;

import com.happinesssco.servicio.UsuarioServicio;

public class Validador {

    public static final int MAX_INTENTOS = 3;

    public static String pedirConIntentos(Scanner sc, String mensaje, String tipo) {
        int intentos = 0;
        while (intentos < MAX_INTENTOS) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            boolean valido = false;
            switch (tipo) {
                case "usuario":
                    valido = UsuarioServicio.validacionUsuario(entrada);
                    break;
                case "email":
                    valido = UsuarioServicio.validacionEmail(entrada);
                    break;
                case "password":
                    valido = UsuarioServicio.validacionPassword(entrada);
                    break;
                case "fecha":
                    valido = validadorFecha(entrada);
                    break;
                case "id":
                    valido = validadorId(entrada);
                    break;
                default:
                    valido = validadorVacio(entrada);
                    break;
            }
            if (valido)
                return entrada;
            intentos++;
        }
        System.out.println("Número máximo de intentos alcanzado.");
        return null;
    }

    public static boolean validadorVacio(String entrada) {
        if (entrada.isEmpty()) {
            System.out.println("Error. Este campo no puede estar vacío.");
            return false;
        }
        return true;
    }

    public static boolean validadorFecha(String fecha) {
        if (!validadorVacio(fecha))
            return false;
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Error. Formato de fecha inválido. Usa dd/mm/aaaa.");
            return false;
        }
        return true;
    }

    public static boolean validadorId(String id) {
        if (!id.matches("\\d+")) {
            System.out.println("Error. El ID debe ser un número.");
            return false;
        }
        return true;
    }
}