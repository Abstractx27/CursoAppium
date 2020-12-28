package testSuites;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ExampleDriver {

    @BeforeMethod
    public void iniciarSession(){
        //AppiumDriver driver;
        //URL server = null;
        //try{
        //    server = new URL("http://127.0.0.1:4723/wb/hub");
        //}catch(MalformedURLException e){
        //    e.printStackTrace();
//
        //}
//
        //DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("deviceName","emulator-5554");
        //cap.setCapability("platformName","android");
        //cap.setCapability("app","C:\\apk\\registroDeUsuarios.apk");
        //cap.setCapability("udid","emulator-5554");
        //driver = new AndroidDriver(server,cap);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        setUp
    }

    @Test
    public void test1(){
        System.out.println("PRUEBA");
    }
}
