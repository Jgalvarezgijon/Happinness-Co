package com.happinesssco.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.modelo.Favoritos;
import com.happinesssco.modelo.Usuario;
import com.happinesssco.utilidad.Mensajes;
import com.happinesssco.utilidad.Validador;

public class FavoritoServicio {
    /**
     * Crea un favorito. Primero muestra los eventos y luego los usuarios
     * existentes. Luego solicita al usuario que introduzca el ID del evento y el
     * email del usuario respectivamente. Misma lógica de validación que en
     * agregarEvento. Además, comprueba si el favorito ya existe.
     * 
     * @param favoritos ArrayList de favoritos
     * @param eventos   HashMap de eventos
     * @param usuarios  HashMap de usuarios
     * @param sc        Scanner para entrada de datos por teclado
     */
    public static void crearFavorito(ArrayList<Favoritos> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        System.out.println("=====Creación de favorito=====");
        // Muestra los eventos y el usuario elige uno
        EventoServicio.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }

        // Muestra los usuarios y el usuario elige uno
        UsuarioServicio.mostrarUsuarios(usuarios);
        String email = Validador.pedirConIntentos(sc, "Introduce el email del usuario: ", "email");
        if (email == null)
            return;

        if (!usuarios.containsKey(email)) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_EXISTE);
            return;
        }

        // Comprueba si el favorito ya existe
        for (Favoritos fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                System.out.println(Mensajes.ERROR_FAVORITO_YA_EXISTE);
                return;
            }
        }

        // Crea el favorito
        Favoritos nuevoFavorito = new Favoritos(email, idEvento);
        favoritos.add(nuevoFavorito);
        System.out.println("Favorito creado correctamente.");
    }

    /**
     * Elimina un favorito. Primero muestra los favoritos existentes. Luego solicita
     * al usuario que introduzca el email del usuario y el ID del evento. Misma
     * lógica de validación que en agregarEvento.
     * 
     * @param favoritos ArrayList de favoritos
     * @param eventos   HashMap de eventos
     * @param usuarios  HashMap de usuarios
     * @param sc        Scanner para entrada de datos por teclado
     */
    public static void eliminarFavorito(ArrayList<Favoritos> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        System.out.println("=====Eliminación de favorito=====");
        // Comprueba que favoritos no esté vacío
        if (favoritos.isEmpty()) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_HAY);
            return;
        }
        // Muestra los favoritos
        mostrarFavoritos(favoritos);
        String email = Validador.pedirConIntentos(sc, "Introduce el email del usuario: ", "email");
        if (email == null)
            return;

        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);

        // Busca el favorito en el ArrayList iterando. Si coincide con el email y el
        // idEvento, lo guarda en la variable aEliminar
        Favoritos aEliminar = null;
        for (Favoritos fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                aEliminar = fav;
                break;
            }
        }

        // Si no se encuentra el favorito, muestra un mensaje de error
        if (aEliminar == null) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_EXISTE);
            return;
        }
        // Elimina el favorito
        favoritos.remove(aEliminar);
        System.out.println("Favorito eliminado correctamente.");
    }

    /**
     * Muestra el ArrayList de favoritos
     * 
     * @param favoritos ArrayList de favoritos
     */
    public static void mostrarFavoritos(ArrayList<Favoritos> favoritos) {
        if (favoritos.isEmpty()) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de favoritos=====");
        for (Favoritos f : favoritos) {
            System.out.println(f);
        }
    }
}