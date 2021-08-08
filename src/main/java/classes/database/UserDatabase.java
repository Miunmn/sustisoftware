package classes.database;

import classes.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    static UserDatabase instance;
    public final List<Usuario> usuarios = new ArrayList<>();

    private UserDatabase(){
    }

    public static synchronized UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public void add (Usuario user) {
        usuarios.add(user);
    }

    public Usuario getUserFromUsername(String username){

        for (Usuario usuario : usuarios) {
            if (usuario.getUser().equals(username))
                return usuario;
        }

        return null;
    }
}