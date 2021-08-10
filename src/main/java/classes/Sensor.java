package classes;

import java.security.SecureRandom;
import java.time.LocalDate;


public class Sensor {
    private String id;
    private Integer latitud;
    private Integer longitud;
    private LocalDate fecha;
    private Integer co;
    private Integer pm;
    private Integer co2;
    private boolean status;

    public Sensor(String id, boolean status) {
        var secureRandom = new SecureRandom();
        this.status = status;
        this.id = id;
        this.latitud = secureRandom.nextInt(1000);
        this.longitud = secureRandom.nextInt(1000);
        this.fecha = createRandomDate(2020, 2022);
        this.co = secureRandom.nextInt(70);
        this.co2 = secureRandom.nextInt(300 +  secureRandom.nextInt(900));
        this.pm = secureRandom.nextInt( secureRandom.nextInt(150));
    }

    public static int createRandomIntBetween(int start, int end) {
        var secureRandom = new SecureRandom();
        return start + secureRandom.nextInt( (end-start)) ;
    }
    public static LocalDate createRandomDate(int startYear, int endYear) {
        var day = createRandomIntBetween(1, 28);
        var month = createRandomIntBetween(1, 12);
        var year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "id='" + id + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", fecha=" + fecha +
                ", co=" + co +
                ", pm=" + pm +
                ", co2=" + co2 +
                ", status=" + status +
                '}';
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLatitud() {
        return latitud;
    }

    public void setLatitud(Integer latitud) {
        this.latitud = latitud;
    }

    public Integer getLongitud() {
        return longitud;
    }

    public void setLongitud(Integer longitud) {
        this.longitud = longitud;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getCo() {
        return co;
    }

    public void setCo(Integer co) {
        this.co = co;
    }

    public Integer getPm() {
        return pm;
    }

    public void setPm(Integer pm) {
        this.pm = pm;
    }

    public Integer getCo2() {
        return co2;
    }

    public void setCo2(Integer co2) {
        this.co2 = co2;
    }
}
