package classes;

import classes.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class LoginSystem {
    static LoginSystem instance;
    static UserDatabase userDatabase = UserDatabase.getInstance();

    static List<Usuario> loggedusers = new ArrayList<>();

    private LoginSystem(){

    }
    public boolean authenticate(Usuario usuario){
        var user = userDatabase.getUserFromUsername(usuario.getUser());
        if (user != null  && user.getPassword().equals(usuario.getPassword())){
            instance.add(usuario);
            return true;
        }
        return false;
    }

    public static synchronized LoginSystem getInstance() {
        if (instance == null) {
            instance = new LoginSystem();
        }
        return instance;
    }

    private void add (Usuario user) {
        loggedusers.add(user);
    }

    public void remove(Usuario user){
        loggedusers.remove(user);
    }

}