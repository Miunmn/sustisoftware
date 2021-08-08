package classes;

import classes.database.CentroDatabase;

import java.util.logging.Logger;

public class Sistema {
    static Logger logger = Logger.getLogger(Sistema.class.getName());
    public static final String SEPARATOR = "------------------";

    private final LoginSystem loginSystem;
    private final CentroDatabase centroDatabase;

    public Sistema(CentroDatabase centroDatabase , LoginSystem loginSystem) {
        this.centroDatabase = centroDatabase;
        this.loginSystem = loginSystem;
    }

    private void showAvanceVacunacion(){
        logger.info(()->"Cantidad de vacunados " +  centroDatabase.cantidaDeVacunados());
        logger.info(()->"Cantidad de centro de vacunacion " + centroDatabase.cantidadCentros());
    }
    public static void printSeparator(){
        logger.info(SEPARATOR);
    }

    public void showOptions(){
        logger.info(
                "Mostrando opciones\n" +
                "1 ---> Ver Toda la informacion\n" +
                "2 ---> Dar de alta a centro de vacunacion\n" +
                "3 ---> Dar de baja a centro de vacunacion\n" +
                "Cualquier otro simbolo ---> Cerrar sesion"
        );
        printSeparator();
    }

    public void selectoption(int option, Usuario user){
        switch (option){
            case 1:
                showAvanceVacunacion();
                printSeparator();
                break;
            case 2:
                logger.info(()->"Dar de alta a un centro");
                var centroDarAlta = "centro3";
                centroDatabase.darDeAlta(centroDarAlta);
                logger.info(()-> "El centro "+ centroDarAlta + " ha sido dado de baja");
                showAvanceVacunacion();
                printSeparator();
                break;
            case 3:
                logger.info(()->"Dar de baja a un centro");
                var centroDarBaja = "centro3";
                logger.info(()-> "El centro "+ centroDarBaja + " ha sido dado de baja");
                centroDatabase.darDeBaja(centroDarBaja);
                showAvanceVacunacion();
                printSeparator();
                break;
            case 4:

                break;
            default:
                logger.info(()->"Cerrar sesion");
                logout(user);
                logger.info(()->"El usuario: " + user.getUser() + " acaba de cerrar sesión");
                printSeparator();
                break;
        }


    }
    public void logout(Usuario user){
        loginSystem.remove(user);
    }

}