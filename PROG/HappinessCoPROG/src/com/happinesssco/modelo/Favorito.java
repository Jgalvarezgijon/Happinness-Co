package com.happinesssco.modelo;

public class Favorito {

    private String emailUsuario;
    private int idEvento;

    // Getters y Setters
    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    // Constructor vacío
    public Favorito() {
    }

    // Constructor con parámetros
    public Favorito(String emailUsuario, int idEvento) {
        this.emailUsuario = emailUsuario;
        this.idEvento = idEvento;
    }

    // toString
    @Override
    public String toString() {
        return "Favorito del usuario " + emailUsuario + "\nEvento: " + idEvento;
    }

}
