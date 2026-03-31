import java.util.HashMap;
import java.util.Scanner;

public class UsuarioAux {

    // =====VALIDACIONES=====
    public static boolean validacionUsuario(String usuario) {
        if (!validadorVacio(usuario))
            return false;
        if (usuario.length() < 8) {
            System.out.println("Error. El usuario debe tener al menos 8 caracteres.");
            return false;
        }
        return true;
    }

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

    // =====OPERACIONES=====
    public static void agregarUsuario(HashMap<String, Usuario> usuarios, Scanner sc) {
        System.out.println("\n=====Creación de usuario=====");

        String nombre = Validador.pedirConIntentos(sc, "Introduce un nombre de usuario: ", "usuario");
        if (nombre == null) {
            System.out.println("Error. No se ha podido crear el usuario.");
            return;
        }

        String email = Validador.pedirConIntentos(sc, "Introduce un email: ", "email");
        if (email == null) {
            System.out.println("Error. No se ha podido crear el usuario.");
            return;
        }

        String password = Validador.pedirConIntentos(sc, "Introduce una contraseña: ", "password");
        if (password == null) {
            System.out.println("Error. No se ha podido crear el usuario.");
            return;
        }

        if (usuarios.containsKey(email)) {
            System.out.println("El usuario ya existe.");
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
            System.out.println("El usuario no existe.");
            return;
        }
        usuarios.remove(email);
        System.out.println("Usuario eliminado correctamente.");
    }

    public static void mostrarUsuarios(HashMap<String, Usuario> usuarios) {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios para mostrar.");
            return;
        }
        System.out.println("\n=====Lista de usuarios=====");
        for (Usuario u : usuarios.values()) {
            System.out.println(u);
        }
    }

    // =====VALIDADORES PROPIOS=====
    private static boolean validadorVacio(String entrada) {
        if (entrada.isEmpty()) {
            System.out.println("Error. Este campo no puede estar vacío.");
            return false;
        }
        return true;
    }
}