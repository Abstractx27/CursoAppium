package testSuites;

import drivers.DriverContest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static drivers.DriverContest.setUp;

public class ExampleDriver {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @Test
    public void test1(){
        System.out.println("PRUEBA");
    }

    @AfterMethod
    public void cerrarSession(){
        DriverContest.quitDriver();

    }
}
