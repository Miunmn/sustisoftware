package test;
import classes.LoginSystem;
import classes.Sistema;
import classes.Usuario;
import classes.database.SensorDatabase;
import classes.database.UserDatabase;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.AppSoluciones;

import java.util.ArrayList;
import java.util.List;

public class SustiTest {
    public final Sistema SYSTEMTOTEST = systemToTest();
    public Sistema systemToTest(){
        UserDatabase userDatabase = UserDatabase.getInstance();
        SensorDatabase sensorDatabase =  SensorDatabase.getInstance();
        LoginSystem loginSystem =  LoginSystem.getInstance();
        List<Usuario> usersToLogin = new ArrayList<>();
        sensorDatabase.crearSensor();
        sensorDatabase.crearSensor();
        sensorDatabase.crearSensor();
        sensorDatabase.crearSensor();
        sensorDatabase.crearSensor();
        usersToLogin.add(new Usuario("Esteban","nabetsE"));
        for (Usuario usuario : usersToLogin) {
            userDatabase.add(usuario);
        }
        return new Sistema(sensorDatabase, loginSystem);
    }

    @Test
    public void test1(){
        AppSoluciones.main(new String[]{});
        Assert.assertTrue(true);
    }
    @Test()
    public void test02(){
        AppSoluciones object = new AppSoluciones();
        AppSoluciones.main(null);
    }
    @Test(invocationCount = 500)
    public void aprendizajeNF01(){
        AppSoluciones.reportescincuenta(SYSTEMTOTEST, new Usuario("Esteban","nabetsE"));
    }

    @Test()
    public void tesaprendizajeNF02() {
        long begginTime = System.currentTimeMillis();
        long maxExecutionTime = 2000;
        AppSoluciones.selectAllOptions(SYSTEMTOTEST, new Usuario("Esteban","nabetsE") );
        long finalTime = System.currentTimeMillis();
        long executionTime = finalTime - begginTime;
        Assert.assertTrue(executionTime < maxExecutionTime);
    }
    @Test()
    public void testaprendizajeNF03(){
        long begginTime = System.currentTimeMillis();
        long maxExecutionTime = 2000;
        AppSoluciones.selectAllOptions(SYSTEMTOTEST, new Usuario("Esteban","nabetsE") );
        long finalTime = System.currentTimeMillis();
        long executionTime = finalTime - begginTime;
        Assert.assertTrue(executionTime < maxExecutionTime);
    }
}
