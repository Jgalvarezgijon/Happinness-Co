import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static final int MAX_INTENTOS = 3;
    public static int contadorIdEventos = 0;
    public static int contadorIdGalerias = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menú interactivo con bucle while.
        int opcion = 0;
        // =====HashMaps=====
        // Usuarios
        HashMap<String, Usuario> usuarios = new HashMap<>();
        // Eventos
        HashMap<Integer, Evento> eventos = new HashMap<>();
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
            System.out.println("9. Salir.");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {

                case 1:
                    // Añadir usuario
                    agregarUsuario(usuarios, sc);
                    break;
                case 2:
                    // Eliminar usuario
                    eliminarUsuario(usuarios, sc);
                    break;

                case 3:
                    // Añadir evento
                    agregarEvento(eventos, sc);
                    break;
                case 4:
                    // Eliminar evento
                    eliminarEvento(eventos, sc);
                    break;
                case 5:
                    // Añadir Galería
                    agregarGaleria(eventos, sc);
                    break;
                case 6:
                    // Eliminar Galería
                    eliminarGaleria(eventos, sc);
                    break;
                case 7:
                    // Añadir favorito
                    System.out.println();
                    break;
                case 8:
                    // Eliminar favorito
                    System.out.println();
                    break;
                case 9:
                    System.out.println();
                    break;
                default:
                    System.out.println("Error. Opción no válida");
                    break;
            }
        } while (opcion != 9);

    }

    // =====VALIDACIONES=====
    // Validacion de campos vacíos
    public static boolean validadorVacio(String entrada) {
        if (entrada.isEmpty()) {
            System.out.println("Error. Este campo no puede estar vacío");
            return false;
        }
        return true;
    }

    // USUARIO
    // Validacion de usuario
    public static boolean validacionUsuario(String usuario) {
        if (!validadorVacio(usuario))
            return false;
        if (usuario.length() < 8) {
            System.out.println("Error. El usuario debe tener al menos 8 caracteres.");
            return false;
        }
        return true;
    }

    // Validacion de email
    public static boolean validacionEmail(String email) {
        if (!validadorVacio(email))
            return false;
        if (!email.contains("@")) {
            System.out.println("Error. El email debe contener @.");
            return false;
        }
        if (!email.contains(".")) {
            System.out.println("Error. Email inválido.");
            return false;
        }
        return true;
    }

    // Validacion de contraseña
    public static boolean validacionPassword(String password) {
        if (!validadorVacio(password))
            return false;
        if (password.length() < 8) {
            System.out.println("Error. La contraseña debe tener al menos 8 caracteres.");
            return false;
        }
        if (!password.matches(".*\\d.*")) {
            System.out.println("Error. La contraseña debe tener al menos un número.");
            return false;
        }
        return true;
    }

    // EVENTO
    // Validacion de fecha
    public static boolean validadorFecha(String fecha) {
        if (!validadorVacio(fecha)) {
            return false;
        }
        if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Error. Formato de fecha inválido.");
            return false;
        }
        return true;
    }

    // Validador de ID
    public static boolean validadorIdEvento(String idEvento) {
        if (!idEvento.matches("\\d{1,}")) {
            System.out.println("Error. El ID debe ser un número.");
            return false;
        }
        return true;
    }

    // INPUT REUTILIZABLE
    public static String pedirConIntentos(Scanner sc, String mensaje, String tipo) {
        int intentos = 0;
        while (intentos < MAX_INTENTOS) {
            System.out.println(mensaje);
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
                case "generico":
                    valido = validadorVacio(entrada);
                    break;
                case "idEvento":
                    valido = validadorIdEvento(entrada);
                    break;
                default:
                    System.out.println("Error. Tipo de validación no reconocido.");
                    break;
            }
            if (valido) {
                return entrada;
            } else {
                intentos++;
            }
        }
        return null;
    }

    // =====USUARIO=====
    // Añadir usuario
    public static Usuario anadirUsuario(Scanner sc) {

        Usuario usuarioNuevo = new Usuario();
        System.out.println("\n=====Creación de usuario=====");

        String nombre = pedirConIntentos(sc, "\nIntroduce un nombre de usuario: ", "usuario");
        if (nombre == null) {
            return null;
        }
        String email = pedirConIntentos(sc, "\nIntroduce un email: ", "email");
        if (email == null) {
            return null;
        }
        String password = pedirConIntentos(sc, "\nIntroduce una contraseña: ", "password");
        if (password == null) {
            return null;
        }

        usuarioNuevo.setNombre(nombre);
        usuarioNuevo.setEmail(email);
        usuarioNuevo.setPassword(password);
        return usuarioNuevo;
    }

    // Agregar usuario
    public static void agregarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        Usuario usuario = anadirUsuario(sc);
        if (usuario == null) {
            System.out.println("Error. No se ha podido crear el usuario.");
            return;
        }
        if (usuarios.containsKey(usuario.getEmail())) {
            System.out.println("Error. El usuario ya existe.");
            return;
        }
        usuarios.put(usuario.getEmail(), usuario);
        System.out.println("Usuario agregado correctamente.");
    }

    // Eliminar usuario
    public static void eliminarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        System.out.print("Introduce el email del usuario a eliminar: ");
        String email = sc.nextLine();
        if (usuarios.containsKey(email)) {
            Usuario eliminado = usuarios.get(email);
            usuarios.remove(email);
            System.out.println("El usuario " + eliminado.getNombre() + " ha sido eliminado correctamente.");
        } else {
            System.out.println("Error. El usuario no existe.");
        }
    }

    // =====EVENTO=====
    // Añadir evento
    public static Evento anadirEvento(Scanner sc) {
        Evento eventoNuevo = new Evento();
        System.out.println("=====Creación de evento=====");
        // Fecha
        System.out.println("Introduce la fecha del evento: ");
        String fecha = pedirConIntentos(sc, "Introduce la fecha del evento: ", "fecha");
        if (fecha == null) {
            return null;
        }
        eventoNuevo.setFecha(fecha);

        // Título
        String titulo = pedirConIntentos(sc, "Introduce el título del evento: ", "generico");
        if (titulo == null) {
            return null;
        }
        eventoNuevo.setTitulo(titulo);

        // Ubiucacion
        String ubicacion = pedirConIntentos(sc, "Introduce la ubicación del evento: ", "generico");
        if (ubicacion == null) {
            return null;
        }
        eventoNuevo.setUbicacion(ubicacion);

        // Descripción
        String descripcion = pedirConIntentos(sc, "Introduce la descripción del evento: ", "generico");
        if (descripcion == null) {
            return null;
        }
        eventoNuevo.setDescripcion(descripcion);
        // ID de Evento
        contadorIdEventos++;
        eventoNuevo.setId(contadorIdEventos);

        // Creación de galería vacia y adición de la misma al evento
        ArrayList<Galeria> coleccionGalerias = new ArrayList<>();
        eventoNuevo.setColeccionGalerias(coleccionGalerias);

        return eventoNuevo;
    }

    // Agregar evento
    public static void agregarEvento(HashMap<Integer, Evento> eventos, Scanner sc) {
        Evento evento = anadirEvento(sc);
        if (evento == null) {
            System.out.println("Error. No se ha podido crear el evento.");
            return;
        }
        eventos.put(evento.getId(), evento);
        System.out.println("Evento creado correctamente.");
    }

    // Mostrar Eventos
    public static void mostrarEventos(HashMap<Integer, Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos para mostrar.");
            return;
        }
        System.out.println("\n=====Lista de eventos=====");
        for (Evento evento : eventos.values()) {
            System.out.println(evento);
        }
    }

    // Eliminar evento:
    public static void eliminarEvento(HashMap<Integer, Evento> eventos, Scanner sc) {
        System.out.println("Mostrando listado de eventos: ");
        mostrarEventos(eventos);

        String idAEliminar = pedirConIntentos(sc, "Introduce el ID del evento a eliminar: ", "idEvento");
        if (idAEliminar == null) {
            return;
        }
        if (eventos.containsKey(Integer.parseInt(idAEliminar))) {
            Evento eventoAEliminar = eventos.get(Integer.parseInt(idAEliminar));
            eventos.remove(Integer.parseInt(idAEliminar));
            System.out.println("El evento " + eventoAEliminar.getTitulo() + " con ID " + idAEliminar
                    + " ha sido eliminado correctamente.");
        } else {
            System.out.println("Error. El evento no existe.");
        }
    }

    // =====GALERIAS=====
    // Crear galeria
    public static Galeria crearGaleria(Scanner sc, int idEvento) {
        String titulo = pedirConIntentos(sc, "Introduce el título de la galería: ", "generico");
        if (titulo == null) {
            return null;
        }
        Galeria galeria = new Galeria();
        contadorIdGalerias++;
        galeria.setId(contadorIdGalerias);
        galeria.setTitulo(titulo);
        galeria.setIdEvento(idEvento);
        return galeria;
    }

    // Agregar galeria
    public static void agregarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos");
            return;
        }
        mostrarEventos(eventos);
        String idEventoString = pedirConIntentos(sc, "Introduce el ID del evento: ", "idEvento");
        if (idEventoString == null) {
            return;
        }
        int idEvento = Integer.parseInt(idEventoString);

        if (!eventos.containsKey(idEvento)) {
            System.out.println("Error. El evento no existe.");
            return;
        }
        Galeria galeria = crearGaleria(sc, idEvento);
        if (galeria == null) {
            System.out.println("Error. No se ha podido crear la galería.");
            return;
        }
        Evento evento = eventos.get(idEvento);
        evento.getColeccionGalerias().add(galeria);
        System.out.println("Galería creada correctamente.");
    }

    // Mostrar galerías
    public static void mostrarGalerias(Evento evento) {
        if (evento.getColeccionGalerias().isEmpty()) {
            System.out.println("El evento no tiene galerías");
        }
        for (Galeria galeria : evento.getColeccionGalerias()) {
            System.out.println(galeria);
        }
    }

    // Eliminar galería
    public static void eliminarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        mostrarEventos(eventos);
        String idEventoString = pedirConIntentos(sc, "Introduce el ID del evento: ", "idEvento");
        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println("Error. El evento no existe.");
            return;
        }
        Evento evento = eventos.get(idEvento);
        mostrarGalerias(evento);
        String idGaleriaString = pedirConIntentos(sc, "Introduce el ID de la galería: ", "idGaleria");
        int idGaleria = Integer.parseInt(idGaleriaString);
        if (!evento.getColeccionGalerias().contains(idGaleria)) {
            System.out.println("Error. La galería no existe.");
            return;
        }
        evento.getColeccionGalerias().remove(idGaleria);
        System.out.println("Galería eliminada correctamente.");
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
 */
