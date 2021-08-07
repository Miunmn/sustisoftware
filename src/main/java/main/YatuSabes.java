package main;

import java.util.logging.Logger;

public class YatuSabes {
    static final Logger logger = Logger.getLogger(YatuSabes.class.getName());

    public static  void main(String []  args){
        logger.info("Running main");
        logger.info(()->"Cantidad de valores " +  getNumber(4).toString());

    }

    public static Integer getNumber(Integer number){
        return 2 + number;
    }

}
