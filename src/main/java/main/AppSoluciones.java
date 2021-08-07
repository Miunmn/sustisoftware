package main;

import java.util.logging.Logger;

public class AppSoluciones {
    public  static final Logger logger = Logger.getLogger(AppSoluciones.class.getName());

    public static  void main(String []  args){
        logger.info("Running main");
        logger.info(()->"Cantidad de valores " +  getNumber(4));

    }

    public static Integer getNumber(Integer number){
        return 2 + number;
    }

}
