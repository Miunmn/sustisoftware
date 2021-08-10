package main;

import classes.LoginSystem;
import classes.Usuario;
import classes.database.SensorDatabase;
import classes.database.UserDatabase;
import classes.Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AppSoluciones {
    public static final Logger logger = Logger.getLogger(AppSoluciones.class.getName());
    public static final UserDatabase userDatabase = UserDatabase.getInstance();
    public static final SensorDatabase SENSOR_DATABASE =  SensorDatabase.getInstance();
    public static final LoginSystem loginSystem =  LoginSystem.getInstance();
    public static final Sistema SISTEMA = new Sistema(SENSOR_DATABASE, loginSystem);

    public static  void main(String []  args){
        List<Usuario> usersToLogin = new ArrayList<>();
        SENSOR_DATABASE.crearSensor();
        SENSOR_DATABASE.crearSensor();
        SENSOR_DATABASE.crearSensor();
        SENSOR_DATABASE.crearSensor();
        SENSOR_DATABASE.crearSensor();
        usersToLogin.add(new Usuario("Esteban","nabetsE"));
        var system = new Sistema(SENSOR_DATABASE,  loginSystem);
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
                system.selectoption(5,usuario);
            }
            else{
                logger.info("Error en la autenticacion");
            }
        }
    }
    public static void reportescincuenta(Sistema sistema, Usuario usuario){
        sistema.selectoption(1, usuario);
    }
    public static void selectAllOptions(Sistema sistema, Usuario usuario){
        sistema.showOptions();
        sistema.selectoption(1, usuario);
        sistema.selectoption(2, usuario);
        sistema.selectoption(3, usuario);
        sistema.selectoption(4,usuario);
        sistema.selectoption(5,usuario);
    }

}
