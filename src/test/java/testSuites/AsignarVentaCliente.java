package testSuites;

import drivers.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Carrusel.AsignarVentaCase;

import static drivers.DriverContext.setUp;
import static reports.Report.finalAssert;

public class AsignarVentaCliente {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSession(){
        DriverContext.quitDriver();
    }

    @Test(priority = 1, description = "Asignar Venta a Cliente")
    public void test2(){

        AsignarVentaCase asignarVentaCase = new AsignarVentaCase();

        asignarVentaCase.flujoTest();
        finalAssert();
    }
}
