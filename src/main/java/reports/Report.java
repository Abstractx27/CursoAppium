package reports;

import drivers.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

public class Report {
    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String descripcion, Boolean screenshot, Status status, Boolean fatal){
        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().setName(descripcion).setStatus(status);
        Allure.getLifecycle().startStep(uuid,result);
        if(screenshot){
            reportScreenshot();
        }
        Allure.getLifecycle().stopStep(uuid);
        softAssert.assertTrue(true, descripcion);

        if(status.equals(Status.FAILED)){
            softAssert.fail(descripcion);
        }

        if(fatal){
            Assert.fail(descripcion);
        }

        System.out.println("[Report] "+descripcion);
    }

    private static void reportScreenshot(){
        File scrfile;
        scrfile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        File foto = new File(scrfile.getPath());
        InputStream image;
        try {
            image = new FileInputStream(foto);
            Allure.addAttachment("Imagen adjunta",image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void finalAssert(){
        softAssert.assertAll();
    }
}
