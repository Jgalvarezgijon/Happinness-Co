import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FavoritoAux {

    public static void crearFavorito(ArrayList<Favoritos> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        EventoAux.mostrarEventos(eventos);
        UsuarioAux.mostrarUsuarios(usuarios);

        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println("Error. El evento no existe.");
            return;
        }

        String email = Validador.pedirConIntentos(sc, "Introduce el email del usuario: ", "email");
        if (email == null)
            return;

        if (!usuarios.containsKey(email)) {
            System.out.println("Error. El usuario no existe.");
            return;
        }

        for (Favoritos fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                System.out.println("Error. El favorito ya existe.");
                return;
            }
        }

        Favoritos nuevo = new Favoritos();
        nuevo.setIdEvento(idEvento);
        nuevo.setEmailUsuario(email);
        favoritos.add(nuevo);
        System.out.println("Favorito creado correctamente.");
    }

    public static void eliminarFavorito(ArrayList<Favoritos> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        if (favoritos.isEmpty()) {
            System.out.println("No hay favoritos.");
            return;
        }

        mostrarFavoritos(favoritos);

        String email = Validador.pedirConIntentos(sc, "Introduce el email del usuario: ", "email");
        if (email == null)
            return;

        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);

        Favoritos aEliminar = null;
        for (Favoritos fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                aEliminar = fav;
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("El favorito no existe.");
            return;
        }
        favoritos.remove(aEliminar);
        System.out.println("Favorito eliminado correctamente.");
    }

    public static void mostrarFavoritos(ArrayList<Favoritos> favoritos) {
        if (favoritos.isEmpty()) {
            System.out.println("No hay favoritos.");
            return;
        }
        System.out.println("\n=====Lista de favoritos=====");
        for (Favoritos f : favoritos) {
            System.out.println(f);
        }
    }
}