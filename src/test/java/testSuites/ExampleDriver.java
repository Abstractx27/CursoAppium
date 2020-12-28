package testSuites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static drivers.DriverContest.setUp;

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

        setUp("emulator-5554","android","C:\\apk\\registroDeUsuarios.apk","emulator-5554",true);
    }

    @Test
    public void test1(){
        System.out.println("PRUEBA");
    }
}
