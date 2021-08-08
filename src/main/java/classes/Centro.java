package classes;
public class Centro {
    private String nombrecentro;
    private int cantidadvacunados;
    private boolean status;

    public Centro(String nombrecentro, int cantidadvacunados, boolean status) {
        this.nombrecentro = nombrecentro;
        this.cantidadvacunados = cantidadvacunados;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }
    public int getCantidadvacunados() {
        return cantidadvacunados;
    }
    public String getNombrecentro(){
        return nombrecentro;
    }
    public void setStatus(boolean newstatus){
        this.status = newstatus;
    }
}
