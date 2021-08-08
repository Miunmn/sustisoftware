package main;

import classes.Centro;
import classes.LoginSystem;
import classes.Usuario;
import classes.database.CentroDatabase;
import classes.database.UserDatabase;
import classes.System;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppSoluciones {
    public  static final Logger logger = Logger.getLogger(AppSoluciones.class.getName());

    public static  void main(String []  args){
        var userDatabase = UserDatabase.getInstance();
        var loginSystem = LoginSystem.getInstance();
        var centroDatabase = CentroDatabase.getInstance();
        List<Usuario> usersToLogin = new ArrayList<>();
        centroDatabase.add(new Centro("centro1", 1000,true));
        centroDatabase.add(new Centro("centro2", 1000,true));
        centroDatabase.add(new Centro("centro3", 1000,false));
        centroDatabase.add(new Centro("centro4", 1000,true));
        centroDatabase.add(new Centro("centro5", 1000,true));
        usersToLogin.add(new Usuario("Esteban","nabetsE"));
        var system = new System(centroDatabase,  loginSystem);
        for (Usuario usuario : usersToLogin) {
            userDatabase.add(usuario);
        }
        var logged = false;
        logger.info("Ingrese su usuario y password");
        for (Usuario usuario : usersToLogin) {
            logger.info(usuario.getUser());
            logger.info(usuario.getPassword());
            logged = loginSystem.authenticate(usuario);
            if (logged){
                system.showOptions();
                system.selectoption(1, usuario);
                system.selectoption(2, usuario);
                system.selectoption(3, usuario);
                system.selectoption(4,usuario);
            }
            else{
                logger.info("Error en la autenticacion");
            }
        }
    }
}
