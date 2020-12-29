package testSuites;

import drivers.DriverContest;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Report;

import static drivers.DriverContest.setUp;
import static reports.Report.addStep;

public class Example2 {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSession(){
        Report.finalAssert();
        DriverContest.quitDriver();
    }

    @Test
    public void test1(){
        MobileElement botonNext = (MobileElement) DriverContest.getDriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        botonNext.click();
        addStep("Validar tercera Vista Carrusel",true, Status.PASSED,false);
    }
}
