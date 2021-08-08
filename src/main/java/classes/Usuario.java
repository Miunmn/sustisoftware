package classes;

public class Usuario {
    private final String user;
    private final String password;
    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
}
