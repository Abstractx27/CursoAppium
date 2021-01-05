package testSuites;

import drivers.DriverContest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Carrusel.AgregarClienteCase;

import static drivers.DriverContest.setUp;
import static reports.Report.finalAssert;

public class RegistrodeUsuarios {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSession(){
        DriverContest.quitDriver();
    }


    @Test
    public void agregarCliente(){
        AgregarClienteCase agregarClienteCase = new AgregarClienteCase();
        agregarClienteCase.flujo();
        finalAssert();
    }
}
