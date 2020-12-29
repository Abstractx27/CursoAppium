package utils;

import drivers.DriverContest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    public static boolean esperarObjeto(MobileElement elemento, int segundos){
        try{
            System.out.println("Buscamos elemento : "+elemento+", esperamos "+segundos+" segundos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContest.getDriver(), segundos);
            //wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontró el elemento ("+elemento+"), se retorna true");
            return true;
        }catch (Exception e){
            System.out.println("No se encontró el elemento ("+elemento+"), se retorna false");
            return false;
        }

    }
}
