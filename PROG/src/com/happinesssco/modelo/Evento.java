package com.happinesssco.modelo;

import java.util.ArrayList;

public class Evento {
    private int id;
    private String fecha;
    private String titulo;
    private String ubicacion;
    private String descripcion;
    private ArrayList<Galeria> coleccionGalerias;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void agregarGaleria(Galeria galeria) {
        this.coleccionGalerias.add(galeria);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Galeria> getColeccionGalerias() {
        return coleccionGalerias;
    }

    public void setColeccionGalerias(ArrayList<Galeria> coleccionGalerias) {
        this.coleccionGalerias = coleccionGalerias;
    }

    // Constructor vacío
    public Evento() {
        this.coleccionGalerias = new ArrayList<>();
    }

    // Constructor con parámetros
    public Evento(int id, String fecha, String titulo, String ubicacion, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.coleccionGalerias = new ArrayList<>();
    }

    // toString
    @Override
    public String toString() {
        return "Evento || ID: " + id + " || Fecha: " + fecha + " \nTitulo: " + titulo + " || Ubicacion: " + ubicacion
                + " \nDescripcion: " + descripcion + " \nGalerias: " + coleccionGalerias;
    }

}
