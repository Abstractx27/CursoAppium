package Drivers;

import io.appium.java_client.AppiumDriver;

public class DriverContest {

    private static DriverManager driverManager = new DriverManager();

    public static void setUp(String devicename, String sistemaoperativo, String aplicacion, String udid, boolean emulador){
        driverManager.iniciarSession(devicename,sistemaoperativo,aplicacion,udid,emulador);

    }

    public static AppiumDriver getDriver(){

    }
}
