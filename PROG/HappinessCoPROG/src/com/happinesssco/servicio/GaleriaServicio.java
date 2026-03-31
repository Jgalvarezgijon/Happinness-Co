package com.happinesssco.servicio;

import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.modelo.Galeria;
import com.happinesssco.utilidad.Mensajes;
import com.happinesssco.utilidad.Validador;

public class GaleriaServicio {

    private static int contadorIdGalerias = 0;

    public static void agregarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        if (eventos.isEmpty()) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }

        EventoServicio.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }

        String titulo = Validador.pedirConIntentos(sc, "Introduce el título de la galería: ", "generico");
        if (titulo == null) {
            System.out.println(Mensajes.ERROR_GALERIA_CREACION);
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
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }

        EventoServicio.mostrarEventos(eventos);
        String idEventoString = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoString == null)
            return;

        int idEvento = Integer.parseInt(idEventoString);
        if (!eventos.containsKey(idEvento)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
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
            System.out.println(Mensajes.ERROR_GALERIA_NO_EXISTE);
            return;
        }
        evento.getColeccionGalerias().remove(aEliminar);
        System.out.println("Galería eliminada correctamente.");
    }

    public static void mostrarGalerias(Evento evento) {
        if (evento.getColeccionGalerias().isEmpty()) {
            System.out.println(Mensajes.ERROR_GALERIA_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de galerías=====");
        for (Galeria g : evento.getColeccionGalerias()) {
            System.out.println(g);
        }
    }
}