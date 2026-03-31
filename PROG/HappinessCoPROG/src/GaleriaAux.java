import java.util.HashMap;
import java.util.Scanner;

public class GaleriaAux {

    private static int contadorIdGalerias = 0;

    public static void agregarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos.");
            return;
        }

        EventoAux.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println("Error. El evento no existe.");
            return;
        }

        String titulo = Validador.pedirConIntentos(sc, "Introduce el título de la galería: ", "generico");
        if (titulo == null) {
            System.out.println("Error. No se ha podido crear la galería.");
            return;
        }

        contadorIdGalerias++;
        Galeria nueva = new Galeria();
        nueva.setId(contadorIdGalerias);
        nueva.setTitulo(titulo);
        nueva.setIdEvento(idEvento);

        eventos.get(idEvento).getColeccionGalerias().add(nueva);
        System.out.println("Galería creada correctamente.");
    }

    public static void eliminarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos.");
            return;
        }

        EventoAux.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println("Error. El evento no existe.");
            return;
        }

        Evento evento = eventos.get(idEvento);
        mostrarGalerias(evento);

        String idGaleriaString = Validador.pedirConIntentos(sc, "Introduce el ID de la galería: ", "id");
        if (idGaleriaString == null)
            return;

        int idGaleria = Integer.parseInt(idGaleriaString);
        Galeria aEliminar = null;
        for (Galeria g : evento.getColeccionGalerias()) {
            if (g.getId() == idGaleria) {
                aEliminar = g;
                break;
            }
        }

        if (aEliminar == null) {
            System.out.println("La galería no existe.");
            return;
        }
        evento.getColeccionGalerias().remove(aEliminar);
        System.out.println("Galería eliminada correctamente.");
    }

    public static void mostrarGalerias(Evento evento) {
        if (evento.getColeccionGalerias().isEmpty()) {
            System.out.println("Este evento no tiene galerías.");
            return;
        }
        System.out.println("\n=====Lista de galerías=====");
        for (Galeria g : evento.getColeccionGalerias()) {
            System.out.println(g);
        }
    }
}