package com.happinesssco.servicio;

import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Usuario;
import com.happinesssco.utilidad.Validador;
import com.happinesssco.utilidad.Mensajes;

public class UsuarioServicio {

    /**
     * Agrega un usuario al HashMap de usuarios. Primero pide al usuario que
     * introduzca
     * un nombre de usuario, un email y una contraseña. Luego comprueba que el email
     * no existe. Si no existe, crea el usuario y lo añade al HashMap.
     * 
     * @param usuarios HashMap de usuarios
     * @param sc       Scanner para entrada de datos por teclado
     */
    public static void agregarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        System.out.println("\n=====Creación de usuario=====\n");

        // Pide el nombre de usuario
        String nombre = Validador.pedirConIntentos(sc, "Introduce un nombre de usuario: ", "usuario");
        if (nombre == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        // Pide el email
        String email = Validador.pedirConIntentos(sc, "Introduce un email: ", "email");
        if (email == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        // Pide la contraseña
        String password = Validador.pedirConIntentos(sc, "Introduce una contraseña: ", "password");
        if (password == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        // Comprueba si el email ya existe
        if (usuarios.containsKey(email)) {
            System.out.println(Mensajes.ERROR_USUARIO_YA_EXISTE);
            return;
        }

        // Objeto Usuario creado con los atributos solicitados.
        Usuario nuevo = new Usuario(nombre, email, password);

        // Se agrega el usuario al HashMap.
        usuarios.put(email, nuevo);
        System.out.println("\n=====Usuario creado correctamente=====\n");
    }

    /**
     * Elimina un usuario del HashMap de usuarios. Primero muestra los usuarios
     * existentes. Luego solicita al usuario que introduzca el email del usuario a
     * eliminar. Misma lógica de validación que en agregarUsuario.
     * 
     * @param usuarios HashMap de usuarios
     * @param sc       Scanner para entrada de datos por teclado
     */
    public static void eliminarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {

        System.out.println("\n=====Eliminación de usuario=====");
        // Muestra los usuarios
        mostrarUsuarios(usuarios);
        for (int intentos = 0; intentos < Validador.MAX_INTENTOS; intentos++) {
            System.out.print("\nIntroduce el email del usuario a eliminar: ");
            String emailAEliminar = sc.nextLine();

            // 1. Validamos formato primero
            if (Validador.validarEntrada(emailAEliminar, "generico")) {
                // 2. Validamos existencia después
                if (usuarios.containsKey(emailAEliminar)) {
                    usuarios.remove(emailAEliminar);
                    System.out.println("\n=====Usuario eliminado correctamente=====\n");
                    return;
                } else {
                    System.out.println(Mensajes.ERROR_USUARIO_NO_EXISTE);
                }
            }
        }
        System.out.println(Mensajes.ERROR_MAX_INTENTOS);
    }

    /**
     * Muestra el HashMap de usuarios
     * 
     * @param usuarios HashMap de usuarios
     */
    public static void mostrarUsuarios(HashMap<String, Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de usuarios=====\n");
        for (Usuario u : usuarios.values()) {
            System.out.println(u);
        }
    }
}