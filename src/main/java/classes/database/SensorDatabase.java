package classes.database;

import classes.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SensorDatabase {
    static SensorDatabase instance;
    public final List<Sensor> sensors = new ArrayList<>();
    public static final Logger logger = Logger.getLogger(SensorDatabase.class.getName());

    private SensorDatabase(){
    }

    public static synchronized SensorDatabase getInstance() {
        if (instance == null) {
            instance = new SensorDatabase();
        }
        return instance;
    }

    String getLastsensorid(){
         var lastid = Integer.parseInt(sensors.get(sensors.size()-1).getId());
         return   Integer.toString(lastid+1);
    }

    public String crearSensor(){
        var lastid= "";
        try {
            lastid = getLastsensorid();
        }
        catch (Exception e) {
            sensors.add(new Sensor("0", true));
            return "0";
        }
        sensors.add(new Sensor(lastid, true));
        String finalLastid = lastid;
        logger.info(()-> "Sensor creado con id: "+ finalLastid);
        return lastid;
    }

    public void eliminarSensor(String sensorId){
        for(Sensor sensor : sensors){
            if(sensor.getId().equals(sensorId)){
                sensor.setStatus(false);
            }
        }
    }



    public String getMaximoCo(){
        Integer maxco = sensors.get(0).getCo();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxco < sensor.getCo() ){
               maxco  = sensor.getCo();
            }
        }
        return Integer.toString(maxco);
    }
    public String getMaximoPm(){
        Integer maxpm = sensors.get(0).getPm();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxpm < sensor.getPm() ){
                maxpm  = sensor.getPm();
            }
        }
        return  Integer.toString(maxpm);
    }
    public String getMaximoCo2(){
        Integer maxco2 = sensors.get(0).getCo2();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxco2 < sensor.getCo2() ){
                maxco2  = sensor.getCo2();
            }
        }
        return Integer.toString(maxco2);
    }
    public String getMinimoCo(){
        Integer maxco = sensors.get(0).getCo();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxco > sensor.getCo() ){
                maxco  = sensor.getCo();
            }
        }
        return Integer.toString(maxco);
    }
    public String getMinimoPm(){
        Integer maxpm = sensors.get(0).getPm();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxpm > sensor.getPm() ){
                maxpm  = sensor.getPm();
            }
        }
        return Integer.toString(maxpm);
    }
    public String getMinimoCo2(){
        Integer maxco2 = sensors.get(0).getCo2();
        for (Sensor sensor : sensors){
            if(sensor.isStatus() && maxco2 > sensor.getCo2() ){
                maxco2  = sensor.getCo2();
            }
        }
        return Integer.toString(maxco2);
    }

    public void showAllSensors(){
        var allsensorsinfo  = new StringBuilder();
        for(Sensor sensor : sensors){
            if(sensor.isStatus()){
               var sensorinfo =  sensor.toString();
               allsensorsinfo.append(sensorinfo).append("\n");
            }
        }
        logger.info(()->String.valueOf(allsensorsinfo));
    }
}
