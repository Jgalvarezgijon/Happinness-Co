package com.happinesssco.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.modelo.Favorito;
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
    public static void crearFavorito(ArrayList<Favorito> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        System.out.println("\n=====Creación de favorito=====\n");
        // Muestra los eventos y el usuario elige uno

        if (usuarios.isEmpty()) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_HAY);
            return;
        }

        if (eventos.isEmpty()) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }
        EventoServicio.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "\nIntroduce el ID del evento: ", "id");
        if (idEventoString == null) {
            System.out.println(Mensajes.ERROR_CAMPO_VACIO);
            return;
        }

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }

        // Muestra los usuarios y el usuario elige uno
        UsuarioServicio.mostrarUsuarios(usuarios);
        String email = Validador.pedirConIntentos(sc, "\nIntroduce el email del usuario: ", "email");
        if (email == null) {
            System.out.println(Mensajes.ERROR_CAMPO_VACIO);
            return;
        }
        if (!usuarios.containsKey(email)) {
            System.out.println(Mensajes.ERROR_USUARIO_NO_EXISTE);
            return;
        }

        // Comprueba si el favorito ya existe
        for (Favorito fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                System.out.println(Mensajes.ERROR_FAVORITO_YA_EXISTE);
                return;
            }
        }

        // Crea el favorito
        Favorito nuevoFavorito = new Favorito(email, idEvento);
        favoritos.add(nuevoFavorito);
        System.out.println("\n=====Favorito creado correctamente=====\n");
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
    public static void eliminarFavorito(ArrayList<Favorito> favoritos,
            HashMap<Integer, Evento> eventos,
            HashMap<String, Usuario> usuarios, Scanner sc) {

        System.out.println("\n=====Eliminación de favorito=====\n");
        // Comprueba que favoritos no esté vacío
        if (favoritos.isEmpty()) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_HAY);
            return;
        }
        mostrarFavoritos(favoritos, eventos);
        // Email del usuario
        String email = Validador.pedirConIntentos(sc, "\nIntroduce el email del usuario: ", "email");
        if (email == null)
            return;
        // ID del evento
        String idEventoStr = Validador.pedirConIntentos(sc, "\nIntroduce el ID del evento: ", "id");
        if (idEventoStr == null)
            return;

        int idEvento = Integer.parseInt(idEventoStr);
        Favorito aEliminar = null;

        // Busca el favorito a eliminar
        for (Favorito fav : favoritos) {
            if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                aEliminar = fav;
                break;
            }
        }
        // Si se encuentra el favorito, se elimina
        if (aEliminar != null) {
            System.out.print("¿Estás seguro de que quieres eliminar el favorito? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                favoritos.remove(aEliminar);
                System.out.println("\n=====Favorito eliminado correctamente=====\n");
            }
        } else {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_EXISTE);
        }
    }

    /**
     * Muestra el ArrayList de favoritos, incluyendo el título del evento.
     * 
     * @param favoritos ArrayList de favoritos
     * @param eventos   HashMap de eventos para obtener los títulos
     */
    public static void mostrarFavoritos(ArrayList<Favorito> favoritos, HashMap<Integer, Evento> eventos) {
        if (favoritos.isEmpty()) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de favoritos=====\n");
        for (Favorito f : favoritos) {
            String titulo = EventoServicio.obtenerTituloEventoPorId(eventos, f.getIdEvento());
            System.out.println("Usuario: " + f.getEmailUsuario() + " | Evento: (" + f.getIdEvento() + ") " + titulo);
        }
    }
}