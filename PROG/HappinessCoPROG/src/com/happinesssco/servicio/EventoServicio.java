package com.happinesssco.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.happinesssco.modelo.Evento;
import com.happinesssco.utilidad.Validador;
import com.happinesssco.utilidad.Mensajes;

public class EventoServicio {

    private static int contadorIdEventos = 0;

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
        Evento nuevo = new Evento();
        nuevo.setId(contadorIdEventos);
        nuevo.setFecha(fecha);
        nuevo.setTitulo(titulo);
        nuevo.setUbicacion(ubicacion);
        nuevo.setDescripcion(descripcion);
        nuevo.setColeccionGalerias(new ArrayList<>());

        eventos.put(nuevo.getId(), nuevo);
        System.out.println("Evento creado correctamente.");
    }

    public static void eliminarEvento(HashMap<Integer, Evento> eventos, Scanner sc) {
        mostrarEventos(eventos);
        String idString = Validador.pedirConIntentos(sc, "Introduce el ID del evento a eliminar: ", "id");
        if (idString == null)
            return;

        int id = Integer.parseInt(idString);
        if (!eventos.containsKey(id)) {
            System.out.println(Mensajes.ERROR_EVENTO_NO_EXISTE);
            return;
        }
        eventos.remove(id);
        System.out.println("Evento eliminado correctamente.");
    }

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