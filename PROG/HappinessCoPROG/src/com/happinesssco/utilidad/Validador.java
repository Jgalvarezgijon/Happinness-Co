package com.happinesssco.utilidad;

import java.util.Scanner;

public class Validador {

    public static final int MAX_INTENTOS = 3; // Constante validadora de intentos máximos para el Scanner

    /**
     * Valida que el usuario no esté vacío y tenga al menos 8 caracteres
     * 
     * @param usuario String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validacionUsuario(String usuario) {
        if (!Validador.validadorVacio(usuario))
            return false;
        if (usuario.length() < 8) {
            System.out.println(Mensajes.ERROR_LONGITUD);
            return false;
        }
        return true;
    }

    /**
     * Valida que el email no esté vacío y contenga @ y .
     * 
     * @param email String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validacionEmail(String email) {
        if (!Validador.validadorVacio(email))
            return false;
        if (!email.contains("@")) {
            System.out.println(Mensajes.ERROR_USUARIO_EMAIL_ARROBA);
            return false;
        }
        if (!email.contains(".")) {
            System.out.println(Mensajes.ERROR_USUARIO_EMAIL_PUNTO);
            return false;
        }
        return true;
    }

    /**
     * Valida que la contraseña no esté vacía y tenga al menos 8 caracteres y un
     * número
     * 
     * @param password String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validacionPassword(String password) {
        if (!Validador.validadorVacio(password))
            return false;
        if (password.length() < 8) {
            System.out.println(Mensajes.ERROR_LONGITUD);
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            System.out.println(Mensajes.ERROR_USUARIO_PASSWORD_NUMERO);
            return false;
        }
        return true;
    }

    /**
     * Pide un valor al usuario con un mensaje y un tipo de validación
     * 
     * @param sc      Scanner para entrada de datos por teclado
     * @param mensaje Mensaje a mostrar al usuario
     * @param tipo    Tipo de validación a realizar
     * @return Valor validado
     */
    public static String pedirConIntentos(Scanner sc, String mensaje, String tipo) {
        int intentos = 0;
        while (intentos < MAX_INTENTOS) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();

            boolean valido = false;
            switch (tipo) {
                case "usuario":
                    valido = validacionUsuario(entrada);
                    break;
                case "email":
                    valido = validacionEmail(entrada);
                    break;
                case "password":
                    valido = validacionPassword(entrada);
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
            // Si la entrada es válida, se devuelve
            if (valido)
                return entrada;
            intentos++; // Si la entrada no es válida, se incrementa el contador de intentos
        }
        // Si se alcanzan los intentos máximos, se devuelve null
        System.out.println("Error. Se ha alcanzado el número máximo de intentos.");
        return null;
    }

    /**
     * Valida que el String no esté vacío
     * 
     * @param entrada String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validadorVacio(String entrada) {
        if (entrada.isEmpty()) {
            System.out.println(Mensajes.ERROR_CAMPO_VACIO);
            return false;
        }
        return true;
    }

    /**
     * Valida que la fecha no esté vacía y tenga el formato dd/mm/aaaa
     * 
     * @param fecha String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validadorFecha(String fecha) {
        if (!validadorVacio(fecha))
            return false;
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Error. Formato de fecha inválido. Usa dd/mm/aaaa.");
            return false;
        }
        return true;
    }

    /**
     * Valida que el ID no esté vacío y sea un número
     * 
     * @param id String a validar
     * @return true si es válido, false si no lo es
     */
    public static boolean validadorId(String id) {
        if (!id.matches("\\d+")) {
            System.out.println("Error. El ID debe ser un número.");
            return false;
        }
        return true;
    }
}