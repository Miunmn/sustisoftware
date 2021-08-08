package test;
import classes.Centro;
import classes.LoginSystem;
import classes.Sistema;
import classes.Usuario;
import classes.database.CentroDatabase;
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
        CentroDatabase centroDatabase =  CentroDatabase.getInstance();
        LoginSystem loginSystem =  LoginSystem.getInstance();
        List<Usuario> usersToLogin = new ArrayList<>();
        centroDatabase.add(new Centro("centro1", 1000,true));
        centroDatabase.add(new Centro("centro2", 1000,true));
        centroDatabase.add(new Centro("centro3", 1000,false));
        centroDatabase.add(new Centro("centro4", 1000,true));
        centroDatabase.add(new Centro("centro5", 1000,true));
        usersToLogin.add(new Usuario("Esteban","nabetsE"));
        for (Usuario usuario : usersToLogin) {
            userDatabase.add(usuario);
        }
        return new Sistema(centroDatabase, loginSystem);
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
    @Test(invocationCount = 50)
    public void test03(){
        AppSoluciones.reportescincuenta(SYSTEMTOTEST, new Usuario("Esteban","nabetsE"));
    }

    @Test()
    public void test04() {
        long begginTime = System.currentTimeMillis();
        long maxExecutionTime = 2000;
        AppSoluciones.selectAllOptions(SYSTEMTOTEST, new Usuario("Esteban","nabetsE") );
        long finalTime = System.currentTimeMillis();
        long executionTime = finalTime - begginTime;
        Assert.assertTrue(executionTime < maxExecutionTime);
    }
}
