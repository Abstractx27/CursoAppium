package pages;

import drivers.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Report.addStep;
import static utils.Utils.esperarObjeto;

public class CarruselPage {

    private AppiumDriver driver;
    public CarruselPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement botonflecha;

    /**
     * POPUP ANDROID
     */

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement btnpermitir;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnhecho;


    public void recorrerCarrusel(){
        System.out.println("[CarruselPage] recorrerCarrusel");
        int cont = 0;
        do{
            cont++;
            botonflecha.click();
        }while(cont<3);

    }
    public void validarVistaDesplegada(){
        if(iconoVista1.isDisplayed()){
            addStep("Validar Vista 1 de carrusel desplegada",true, Status.PASSED,false);
        }else{
            addStep("Validar Vista 1 de carrusel desplegada",true, Status.FAILED,false);
        }
    }

    public void tapBtnHecho(){
        btnpermitir.click();
        btnhecho.click();
    }

    public void validarTextoVista1Carrusel(){
        if (esperarObjeto(descripcionVista, 5)) {
            String textodescriptivoVista1 = descripcionVista.getText();
            if (textodescriptivoVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")) {
                addStep("Validar Vista 1 de carrusel - descripcion", true, Status.PASSED, false);
            } else {
                addStep("Validar Vista 1 de carrusel - descripcion", true, Status.FAILED, true);
            }
        }else{
            System.out.println("FALLO");
        }
    }
}
