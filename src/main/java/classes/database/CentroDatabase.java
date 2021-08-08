package classes.database;

import classes.Centro;

import java.util.ArrayList;
import java.util.List;

public class CentroDatabase {
    static CentroDatabase instance;
    public final List<Centro> centros = new ArrayList<>();


    private CentroDatabase(){

    }

    public static synchronized CentroDatabase getInstance() {
        if (instance == null) {
            instance = new CentroDatabase();
        }
        return instance;
    }

    public void darDeAlta(String centrobuscar){
        for(Centro centro : centros){
            if(centro.getNombrecentro().equals(centrobuscar)){
                centro.setStatus(true);
            }
        }
    }

    public void darDeBaja(String centrobuscar){
        for(Centro centro : centros){
            if(centro.getNombrecentro().equals(centrobuscar)){
                centro.setStatus(false);
            }
        }
    }
    public Integer cantidadCentros(){
        return centros.size();
    }

    public Integer cantidaDeVacunados(){
        var suma=0;
        for (Centro centro : centros) {
            if (centro.isStatus()) {
                suma = suma + centro.getCantidadvacunados();
            }
        }
        return suma;
    }
    public void add(Centro centro){
        centros.add(centro);
    }
}
