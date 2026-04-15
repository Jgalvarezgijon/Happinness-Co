package com.happinesssco.servicio;

import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.modelo.Galeria;
import com.happinesssco.utilidad.Mensajes;
import com.happinesssco.utilidad.Validador;

public class GaleriaServicio {

    private static int contadorIdGalerias = 0;

    /**
     * Agrega una galería a un evento. Primero muestra los eventos existentes y
     * solicita al usuario que introduzca el ID del evento. Luego solicita al
     * usuario que introduzca el título de la galería.
     * 
     * @param eventos HashMap de eventos
     * @param sc      Scanner para entrada de datos por teclado
     */
    public static void agregarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        System.out.println("\n=====Creación de galería=====\n");
        // Comprueba que eventos no esté vacío (No hay galerias si no hay eventos)
        if (eventos.isEmpty()) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }

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

        // Solicita el título de la galería
        String titulo = Validador.pedirConIntentos(sc, "Introduce el título de la galería: ", "generico");
        if (titulo == null) {
            System.out.println(Mensajes.ERROR_GALERIA_CREACION);
            return;
        }

        // Crea la galería con el constructor
        contadorIdGalerias++;
        Galeria nuevaGaleria = new Galeria(contadorIdGalerias, titulo, idEvento);

        eventos.get(idEvento).getColeccionGalerias().add(nuevaGaleria);
        System.out.println("\n=====Galería creada correctamente=====\n");
    }

    /**
     * Elimina una galería de un evento. Primero muestra los eventos existentes y
     * solicita al usuario que introduzca el ID del evento. Luego solicita al
     * usuario que introduzca el ID de la galería. Misma lógica de validación que en
     * agregarEvento.
     * 
     * @param eventos HashMap de eventos
     * @param sc      Scanner para entrada de datos por teclado
     */
    public static void eliminarGaleria(HashMap<Integer, Evento> eventos, Scanner sc) {
        System.out.println("\n=====Eliminación de galería===== \n");
        // Comprueba que eventos no esté vacío (No hay galerias si no hay eventos)
        if (eventos.isEmpty()) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }

        String idEventoStr = Validador.pedirConIntentos(sc, "Introduce el ID del evento: ", "id");
        if (idEventoStr == null)
            return;

        int idEvento = Integer.parseInt(idEventoStr);
        // Comprueba que el evento existe
        if (!eventos.containsKey(idEvento)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }

        Evento evento = eventos.get(idEvento);
        mostrarGalerias(evento);

        String idGaleriaStr = Validador.pedirConIntentos(sc, "Introduce el ID de la galería: ", "id");
        if (idGaleriaStr == null)
            return;

        int idGaleria = Integer.parseInt(idGaleriaStr);
        Galeria aEliminar = null;
        // Busca la galería a eliminar en la colección de galerías
        for (Galeria g : evento.getColeccionGalerias()) {
            if (g.getId() == idGaleria) {
                aEliminar = g;
                break;
            }
        }
        // Si se encuentra la galería, se elimina
        if (aEliminar != null) {
            System.out.print("¿Estás seguro de que quieres eliminar la galería? (S/N): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("S")) {
                evento.getColeccionGalerias().remove(aEliminar);
                System.out.println("\n=====Galería eliminada correctamente=====\n");
            }
        } else {
            System.out.println(Mensajes.ERROR_GALERIA_NO_EXISTE);
        }
    }

    /**
     * Muestra las galerías de un evento
     * 
     * @param evento Evento
     */
    public static void mostrarGalerias(Evento evento) {
        if (evento.getColeccionGalerias().isEmpty()) {
            System.out.println(Mensajes.ERROR_GALERIA_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de galerías=====\n");
        for (Galeria g : evento.getColeccionGalerias()) {
            System.out.println(g);
        }
    }
}