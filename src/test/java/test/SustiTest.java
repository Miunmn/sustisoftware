package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.AppSoluciones;

import java.io.IOException;

public class SustiTest {
    @Test
    void test1(){
        AppSoluciones.main(new String[]{});
        Assert.assertTrue(true);
    }
    @Test()
    public void test02() throws IOException
    {
        AppSoluciones object = new AppSoluciones();
        AppSoluciones.main(null);
    }
}
