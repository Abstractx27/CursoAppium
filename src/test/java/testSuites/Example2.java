package testSuites;

import drivers.DriverContest;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.Carrusel.Test_Carrusel;
import static drivers.DriverContest.setUp;
import static reports.Report.addStep;
import static reports.Report.finalAssert;

public class Example2 {

    @BeforeMethod
    public void iniciarSession(){
        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSession(){
        //Report.finalAssert();
        DriverContest.quitDriver();
    }


    public void test1(){
        MobileElement botonNext = (MobileElement) DriverContest.getDriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        botonNext.click();
        addStep("Validar tercera Vista Carrusel",true, Status.FAILED,false);
        finalAssert();
    }

    @Test(description = "Validación Carrusel")
    public void Test_Carrusel(){
        Test_Carrusel test = new Test_Carrusel();
        test.validaciones();

    }
}
