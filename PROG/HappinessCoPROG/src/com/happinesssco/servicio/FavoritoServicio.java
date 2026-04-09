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
        EventoServicio.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
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
        String email = Validador.pedirConIntentos(sc, "Introduce el email del usuario: ", "email");
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
        // Muestra los favoritos
        for (int intentos = 0; intentos < Validador.MAX_INTENTOS; intentos++) {
            System.out.print("Introduce el email del usuario: ");
            String email = sc.nextLine();
            if (!Validador.validarEntrada(email, "email"))
                continue;

            System.out.print("Introduce el ID del evento: ");
            String idEventoString = sc.nextLine();
            if (!Validador.validarEntrada(idEventoString, "id"))
                continue;

            int idEvento = Integer.parseInt(idEventoString);

            // Busca el favorito
            Favorito aEliminar = null;
            for (Favorito fav : favoritos) {
                if (fav.getEmailUsuario().equals(email) && fav.getIdEvento() == idEvento) {
                    aEliminar = fav;
                    break;
                }
            }

            if (aEliminar != null) {
                favoritos.remove(aEliminar);
                System.out.println("\n=====Favorito eliminado correctamente=====\n");
                return;
            } else {
                System.out.println(Mensajes.ERROR_FAVORITO_NO_EXISTE);
            }
        }
        System.out.println(Mensajes.ERROR_MAX_INTENTOS);
    }

    /**
     * Muestra el ArrayList de favoritos
     * 
     * @param favoritos ArrayList de favoritos
     */
    public static void mostrarFavoritos(ArrayList<Favorito> favoritos) {
        if (favoritos.isEmpty()) {
            System.out.println(Mensajes.ERROR_FAVORITO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de favoritos=====\n");
        for (Favorito f : favoritos) {
            System.out.println(f);
        }
    }
}