public class Favoritos {
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
    public Favoritos() {
    }

    // Constructor con parámetros
    public Favoritos(String emailUsuario, int idEvento) {
        this.emailUsuario = emailUsuario;
        this.idEvento = idEvento;
    }

    // toString

    @Override
    public String toString() {
        return "Favoritos [emailUsuario=" + emailUsuario + ", idEvento=" + idEvento + "]";
    }

}
