package Drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private AppiumDriver driver;
    private URL server = null;
    private DesiredCapabilities cap = new DesiredCapabilities();

    protected void iniciarSession(String devicename, String sistemaoperativo, String aplicacion, String udid, boolean emulador){
        try{
            server = new URL("http://127.0.0.1:4723/wb/hub");
        }catch(
                MalformedURLException e){
            e.printStackTrace();

        }

        cap.setCapability("deviceName",devicename);
        cap.setCapability("platformName",sistemaoperativo);
        cap.setCapability("app",aplicacion);
        if (!emulador){
            cap.setCapability("udid","emulator-5554");
        }

        driver = new AndroidDriver(server,cap);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    protected AppiumDriver getDriver(){
        return driver;
    }


}
