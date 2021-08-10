package classes;

import classes.database.SensorDatabase;

import java.util.logging.Logger;

public class Sistema {
    static Logger logger = Logger.getLogger(Sistema.class.getName());
    public static final String SEPARATOR = "-----------------------------------";

    private final LoginSystem loginSystem;
    private final SensorDatabase sensorDatabase;

    public Sistema(SensorDatabase sensorDatabase, LoginSystem loginSystem) {
        this.sensorDatabase = sensorDatabase;
        this.loginSystem = loginSystem;
    }

    private void showInformacionCompleta(){
        sensorDatabase.showAllSensors();
    }
    public static void printSeparator(){
        logger.info(SEPARATOR);
    }

    public void showOptions(){
        logger.info(
                "Mostrando opciones\n" +
                "1 ---> Ver Toda la detallada de los sensores\n" +
                "2 ---> Crear sensor\n" +
                "3 ---> Eliminar sensor\n" +
                "4 ---> Información consolidada\n" +
                "Cualquier otro simbolo ---> Cerrar sesion"
        );
        printSeparator();
    }

    public void selectoption(int option, Usuario user){
        switch (option){
            case 1:
                showInformacionCompleta();
                printSeparator();
                break;
            case 2:
                logger.info(()->"Crear sensor");
                var newid = sensorDatabase.crearSensor();
                logger.info(()-> "El sensor "+ newid + " ha sido creado");
                showInformacionCompleta();
                printSeparator();
                break;
            case 3:
                logger.info(()->"Eliminar sensor");
                var centroDarBaja = "1";
                logger.info(()-> "El sensor "+ centroDarBaja + " ha sido eliminado");
                sensorDatabase.eliminarSensor(centroDarBaja);
                showInformacionCompleta();
                printSeparator();
                break;
            case 4:
                logger.info(()->"Mostrar cantidad maxima, minima y desviacion estandar de cada gas registrado");
                logger.info(()->
                        "El maximo CO registrado es\n"+
                        sensorDatabase.getMaximoCo() + "\n"+
                        "El maximo CO2 registrado es\n"+
                        sensorDatabase.getMaximoCo2()+ "\n"+
                        "El maximo PM registrado es\n"+
                        sensorDatabase.getMaximoPm() +"\n"+
                        "El minimo CO registrado es\n "+
                        sensorDatabase.getMinimoCo() +"\n"+
                        "El minimo CO2 registrado es\n "+
                        sensorDatabase.getMinimoCo2() + "\n"+
                        "El minimo PM registrado es\n "+
                        sensorDatabase.getMinimoPm() + "\n"
                );
                printSeparator();
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