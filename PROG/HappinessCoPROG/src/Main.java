import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // =====Listas instanciadas=====
        // Usuarios
        HashMap<String, Usuario> usuarios = new HashMap<>();
        // Eventos
        HashMap<Integer, Evento> eventos = new HashMap<>();
        // Favoritos
        ArrayList<Favoritos> favoritos = new ArrayList<>();
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
                System.out.println("Error. Debes introducir un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    // Añadir usuario
                    UsuarioAux.agregarUsuario(usuarios, sc);
                    break;
                case 2:
                    // Eliminar usuario
                    UsuarioAux.eliminarUsuario(usuarios, sc);
                    break;
                case 3:
                    // Añadir evento
                    EventoAux.agregarEvento(eventos, sc);
                    break;
                case 4:
                    // Eliminar evento
                    EventoAux.eliminarEvento(eventos, sc);
                    break;
                case 5:
                    // Añadir Galería
                    GaleriaAux.agregarGaleria(eventos, sc);
                    break;
                case 6:
                    // Eliminar Galería
                    GaleriaAux.eliminarGaleria(eventos, sc);
                    break;
                case 7:
                    // Añadir favorito
                    FavoritoAux.crearFavorito(favoritos, eventos, usuarios, sc);
                    break;
                case 8:
                    // Eliminar favorito
                    FavoritoAux.eliminarFavorito(favoritos, eventos, usuarios, sc);
                    break;
                case 9:
                    // Información en pantalla
                    mostrarMenuInfo(usuarios, eventos, favoritos, sc);
                    break;
                case 10:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Error. Opción no válida");
                    break;
            }
        } while (opcion != 10);

        sc.close();
    }

    // Submenú de información
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
            // Manejo de excepciones
            try {
                opcionSubMenu = Integer.parseInt(inputSubMenu);
            } catch (NumberFormatException e) {
                System.out.println("Error. Debes introducir un número.");
                continue;
            }

            switch (opcionSubMenu) {
                case 1:
                    UsuarioAux.mostrarUsuarios(usuarios);
                    break;
                case 2:
                    EventoAux.mostrarEventos(eventos);
                    break;
                case 3:
                    FavoritoAux.mostrarFavoritos(favoritos);
                    break;
                case 4:
                    System.out.println("Saliendo del submenú...");
                    break;
                default:
                    System.out.println("Error. Opción no válida.");
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
 */