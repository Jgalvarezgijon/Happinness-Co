package com.happinesssco.principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.servicio.EventoServicio;
import com.happinesssco.servicio.FavoritoServicio;
import com.happinesssco.servicio.GaleriaServicio;
import com.happinesssco.servicio.UsuarioServicio;
import com.happinesssco.modelo.Evento;
import com.happinesssco.modelo.Favoritos;
import com.happinesssco.modelo.Usuario;
import com.happinesssco.utilidad.Mensajes;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =====Listas instanciadas=====
        HashMap<String, Usuario> usuarios = new HashMap<>(); // Usuarios
        HashMap<Integer, Evento> eventos = new HashMap<>(); // Eventos
        ArrayList<Favoritos> favoritos = new ArrayList<>(); // Favoritos

        int opcion = 0;

        do {
            System.out.println("\n=====MENÚ PRINCIPAL=====");
            System.out.println("1. Añadir usuario.");
            System.out.println("2. Eliminar usuario.");
            System.out.println("3. Añadir evento.");
            System.out.println("4. Eliminar evento.");
            System.out.println("5. Añadir galería.");
            System.out.println("6. Eliminar galería.");
            System.out.println("7. Añadir favorito.");
            System.out.println("8. Eliminar favorito.");
            System.out.println("9. Mostrar información.");
            System.out.println("10. Salir.");
            System.out.print("Elige una opción: ");

            String input = sc.nextLine();
            // Manejo de excepciones
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(Mensajes.ERROR_MENU_INPUT);
                continue;
            }

            switch (opcion) {
                case 1:
                    // Añadir usuario
                    UsuarioServicio.agregarUsuario(usuarios, sc);
                    break;
                case 2:
                    // Eliminar usuario
                    UsuarioServicio.eliminarUsuario(usuarios, sc);
                    break;
                case 3:
                    // Añadir evento
                    EventoServicio.agregarEvento(eventos, sc);
                    break;
                case 4:
                    // Eliminar evento
                    EventoServicio.eliminarEvento(eventos, sc);
                    break;
                case 5:
                    // Añadir Galería
                    GaleriaServicio.agregarGaleria(eventos, sc);
                    break;
                case 6:
                    // Eliminar Galería
                    GaleriaServicio.eliminarGaleria(eventos, sc);
                    break;
                case 7:
                    // Añadir favorito
                    FavoritoServicio.crearFavorito(favoritos, eventos, usuarios, sc);
                    break;
                case 8:
                    // Eliminar favorito
                    FavoritoServicio.eliminarFavorito(favoritos, eventos, usuarios, sc);
                    break;
                case 9:
                    // Información en pantalla
                    mostrarMenuInfo(usuarios, eventos, favoritos, sc);
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println(Mensajes.ERROR_MENU_OPCION);
                    break;
            }
        } while (opcion != 10);

        sc.close();
    }

    /**
     * Muestra un submenú dentro del menú principal para mostrar la información de
     * Usuarios, Eventos, y favoritos.
     * 
     * @param usuarios  HashMap de usuarios.
     * @param eventos   HashMap de eventos.
     * @param favoritos ArrayList de favoritos.
     * @param sc        Scanner para entrada de datos por teclado.
     */
    private static void mostrarMenuInfo(HashMap<String, Usuario> usuarios,
            HashMap<Integer, Evento> eventos,
            ArrayList<Favoritos> favoritos,
            Scanner sc) {

        int opcionSubMenu = 0;

        do {
            System.out.println("\n=====INFORMACIÓN EN PANTALLA=====");
            System.out.println("1. Mostrar usuarios.");
            System.out.println("2. Mostrar eventos.");
            System.out.println("3. Mostrar favoritos.");
            System.out.println("4. Salir.");
            System.out.print("Elige una opción: ");

            String inputSubMenu = sc.nextLine();
            // Manejo de excepciones de entrada de datos
            try {
                opcionSubMenu = Integer.parseInt(inputSubMenu);
            } catch (NumberFormatException e) {
                System.out.println(Mensajes.ERROR_MENU_INPUT);
                continue;
            }

            switch (opcionSubMenu) {
                case 1:
                    UsuarioServicio.mostrarUsuarios(usuarios);
                    break;
                case 2:
                    EventoServicio.mostrarEventos(eventos);
                    break;
                case 3:
                    FavoritoServicio.mostrarFavoritos(favoritos);
                    break;
                case 4:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println(Mensajes.ERROR_MENU_OPCION);
                    break;
            }
        } while (opcionSubMenu != 4);
    }
}

// Creación de clases con atributos privados, getter, setter toString y
// constructores.
// Estructura mínima de clases con atributos
// Estructura de menú interactivo con bucle while.
/*
 * Metodos:
 * crearusuario
 * validacion usuario
 * validacion email
 * validacion password.
 * contador de intentos fallidos. En cada apartado de validación, de manera
 * general.
 * problemas con bucles while y contadores. (Revisar)
 * un bucle while para cada apartado de validación en crearUsuario.
 * REFACTORIZACIón: métodos validar entradas (para cada uno), métodos para PEDIR
 * cada apartado
 * Otro método para crear el usuario.
 * Añadido el HashMap para almacenar los usuarios. con validación de existencia
 * Métodos para crear eventos. Necesario validadores globales. Cambios
 * generales.
 * Método reutilizable para validar entradas vacías (Se repite mucho).
 * Modular y reutilizable.
 * Los campos del constructor de eventos no necesitan mucha validación.
 * Metodo validador de 3 intentos con switch para cada situación. Se introduce
 * el menasaje como parámetro y devuelve la entrada. Método reutilizable para
 * refactorizar.
 * Refactorizar el código en pedir$Metodo, elimino los metodos de pedir
 * nombnre,string, etc.
 * If de error en un método propio.
 * borro metodo intentoFallido, ya que el metodo pedirConIntentos devuelve null
 * si hay error.
 * AÑADIR A LOS Métodos de creacion el manejo de NULL.
 * Nuevo metodo para AGREGAR usuario al HashMap Para que tome como parámetro
 * asdemás
 * el HashMap de usuarios.
 * Nuevo método para ELIMINAR usuario del HashMap.
 * Creacion de agregar evento.
 * Diferenciasr entre agregar (al hashmap) y crear/añadir (el objeto)
 * validarEntrada
 *
 * Mejorar los toString
 * EN mostrar usuarios no mostrar las contraseñas
 * agregar usuario + crear usuario, etc.
 * Si no hay usuarios no deberia mostrarse opciones de eliminar favvoritos ni
 * galerias.
 * Agregar otro submenu: MOstrar info de eventos, usuarios, etc.
 *
 * InputMissmatch Exception con las opciones del menú. Cambiar a try catch con
 * un String como input --> Integer.parseInt();
 * Crear clases de servicio para cada objeto. Mayor limpieza en el código
 * Paso los contadores globales a privados.
 * manejo de errores en el submenú
 * creo clase validador a parte
 * Limpio el main
 * Pedir repaso a la IA
 * Organiación en distintos paquetes + arreglar los imports.
 * Posibles mejoras:
 * Validación de fecha,
 * validación de email az@az.az
 * Contraseñas más robustas (con Mayúsculas)
 * Validador vacío repetido en dos clases. Borrado en usuarioServicio.
 * HACER JAVADOC
 * Movidos validadores de usuario a la clase Validador.
 * 
 */