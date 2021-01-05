package utils;

import drivers.DriverContest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static boolean esperarObjeto(MobileElement elemento, int segundos){
        try{
            System.out.println("Buscamos elemento : "+elemento+", esperamos "+segundos+" segundos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContest.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontró el elemento ("+elemento+"), se retorna true");
            return true;
        }catch (Exception e){
            System.out.println("No se encontró el elemento ("+elemento+"), se retorna false");
            return false;
        }

    }

    public static void swipeAbajo(){
        int ancho = (int) (DriverContest.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriverContest.getDriver().manage().window().getSize().height * 0*9D);
        int endPoint = (int) (DriverContest.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction(DriverContest.getDriver());
        touchAction.press(PointOption.point(ancho,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(ancho,endPoint)).release().perform();
        System.out.println("[Utils] Swipe hacia abajo");
    }
}
