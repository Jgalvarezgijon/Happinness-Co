package com.happinesssco.servicio;

import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Usuario;
import com.happinesssco.utilidad.Validador;
import com.happinesssco.utilidad.Mensajes;

public class UsuarioServicio {

    // =====VALIDACIONES=====
    public static boolean validacionUsuario(String usuario) {
        if (!Validador.validadorVacio(usuario))
            return false;
        if (usuario.length() < 8) {
            System.out.println(Mensajes.ERROR_LONGITUD);
            return false;
        }
        return true;
    }

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

    // =====OPERACIONES=====
    public static void agregarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        System.out.println("\n=====Creación de usuario=====");

        String nombre = Validador.pedirConIntentos(sc, "Introduce un nombre de usuario: ", "usuario");
        if (nombre == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        String email = Validador.pedirConIntentos(sc, "Introduce un email: ", "email");
        if (email == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        String password = Validador.pedirConIntentos(sc, "Introduce una contraseña: ", "password");
        if (password == null) {
            System.out.println(Mensajes.ERROR_USUARIO_CREACION);
            return;
        }

        if (usuarios.containsKey(email)) {
            System.out.println(Mensajes.ERROR_USUARIO_YA_EXISTE);
            return;
        }

        Usuario nuevo = new Usuario();
        nuevo.setNombre(nombre);
        nuevo.setEmail(email);
        nuevo.setPassword(password);
        usuarios.put(email, nuevo);
        System.out.println("Usuario creado correctamente.");
    }

    public static void eliminarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        System.out.print("Introduce el email del usuario a eliminar: ");
        String email = sc.nextLine();
        if (!usuarios.containsKey(email)) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_EXISTE);
            return;
        }
        usuarios.remove(email);
        System.out.println("Usuario eliminado correctamente.");
    }

    public static void mostrarUsuarios(HashMap<String, Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de usuarios=====");
        for (Usuario u : usuarios.values()) {
            System.out.println(u);
        }
    }
}