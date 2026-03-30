public class Favoritos {
    private String correoUsuario;
    private int idEvento;

    // Getters y Setters

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    // Constructor

    public Favoritos(String correoUsuario, int idEvento) {
        this.correoUsuario = correoUsuario;
        this.idEvento = idEvento;
    }

    // toString

    @Override
    public String toString() {
        return "Favoritos [correoUsuario=" + correoUsuario + ", idEvento=" + idEvento + "]";
    }

}
