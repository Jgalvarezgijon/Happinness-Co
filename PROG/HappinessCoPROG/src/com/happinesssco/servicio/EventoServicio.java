package com.happinesssco.servicio;

import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.utilidad.Validador;
import com.happinesssco.utilidad.Mensajes;

public class EventoServicio {

    private static int contadorIdEventos = 0;

    /**
     * Creación y agregación al Hashmap de Eventos de un nuevo Evento. Hace uso de
     * distintos métodos de las clases de Servicio para
     * validar las entradas del constructor (fecha, título, ubicación y
     * descripción). El usuario tiene tres intentos para introducir
     * cada uno de los parámetros. Si no, sale de la opción.
     * 
     * @param eventos HashMap de Eventos
     * @param sc      Scanner para entrada de datos por teclado
     */
    public static void agregarEvento(HashMap<Integer, Evento> eventos, Scanner sc) {
        System.out.println("=====Creación de evento=====");

        String fecha = Validador.pedirConIntentos(sc, "Introduce la fecha del evento (dd/mm/aaaa): ", "fecha");
        if (fecha == null) {
            System.out.println(Mensajes.ERROR_EVENTO_CREACION);
            return;
        }

        String titulo = Validador.pedirConIntentos(sc, "Introduce el título del evento: ", "generico");
        if (titulo == null) {
            System.out.println(Mensajes.ERROR_EVENTO_CREACION);
            return;
        }

        String ubicacion = Validador.pedirConIntentos(sc, "Introduce la ubicación del evento: ", "generico");
        if (ubicacion == null) {
            System.out.println(Mensajes.ERROR_EVENTO_CREACION);
            return;
        }

        String descripcion = Validador.pedirConIntentos(sc, "Introduce la descripción del evento: ", "generico");
        if (descripcion == null) {
            System.out.println(Mensajes.ERROR_EVENTO_CREACION);
            return;
        }

        contadorIdEventos++;
        // Objeto Evento creado con los atributos solicitados.
        Evento eventoNuevo = new Evento(contadorIdEventos, fecha, titulo, ubicacion, descripcion);

        eventos.put(eventoNuevo.getId(), eventoNuevo);
        System.out.println("Evento creado correctamente.");
    }

    /**
     * Elimina un evento del HashMap de eventos. Misma lógica de validación que en
     * agregarEvento.
     * 
     * @param eventos HashMap de eventos
     * @param sc      Scanner para entrada de datos por teclado
     */
    public static void eliminarEvento(HashMap<Integer, Evento> eventos, Scanner sc) {
        System.out.println("=====Eliminación de evento=====");
        mostrarEventos(eventos);
        String idString = Validador.pedirConIntentos(sc, "Introduce el ID del evento a eliminar: ", "id");
        if (!eventos.containsKey(Integer.parseInt(idString)) || idString == null) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }
        eventos.remove(Integer.parseInt(idString));
        System.out.println("Evento eliminado correctamente.");
    }

    /**
     * Muestra todos los eventos del HashMap de eventos. Si el HashMap está vacío,
     * muestra un mensaje de error.
     * 
     * @param eventos HashMap de eventos
     */
    public static void mostrarEventos(HashMap<Integer, Evento> eventos) {
        if (eventos.isEmpty()) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_HAY);
            return;
        }
        System.out.println("\n=====Lista de eventos=====");
        for (Evento e : eventos.values()) {
            System.out.println(e);
        }
    }
}