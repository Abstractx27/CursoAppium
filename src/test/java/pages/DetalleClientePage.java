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

public class DetalleClientePage {

    private AppiumDriver driver;

    public DetalleClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/subtitulo")
    private MobileElement lblSubtitulo;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement btnAnadirVenta;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Seleccione Un Producto\")]")
    private MobileElement tituloSeleccionProducto;

    @AndroidFindBy(xpath = "//*[contains(@text,\"pizza\")]")
    private MobileElement productoPizza;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Compra Individual\")]")
    private MobileElement lblCompraIndividual;

    @AndroidFindBy(id = "com.rodrigo.registro:id/cp_cantidad")
    private MobileElement inputCantidad;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ci_add")
    private MobileElement btnAgregar;

    @AndroidFindBy(xpath = "//*[contains(@text,\"Total\")]")
    private MobileElement lblTotal;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmarydinero")
    private MobileElement btnEfectivo;

    @AndroidFindBy(id = "com.rodrigo.registro:id/buttonDefaultPositive")
    private MobileElement btnAceptarVenta;

    public void validarVistaDetalleCliente(){
        if(esperarObjeto(lblSubtitulo,3)){
            addStep("Validar Vista detalle cliente",true, Status.PASSED,false);
        }else{
            addStep("Error, No se pudo desplegar vista detalle cliente",true, Status.FAILED,true);
        }
    }

    public void tapBtnAnadirVenta(){
        if(esperarObjeto(btnAnadirVenta,3)){
            addStep("Tap en botón 'Añadir nueva Venta'",false, Status.PASSED,false);
            btnAnadirVenta.click();
        }else{
            addStep("Error, No se pudo hacer tap en botón 'Añadir nueva Venta'",true, Status.FAILED,true);
        }
    }

    public void validarVistaSeleccionProducto(){
        if(esperarObjeto(tituloSeleccionProducto,3)){
            addStep("Validar Vista Selección de producto",true, Status.PASSED,false);
        }else{
            addStep("Error, No se pudo desplegar vista de Selección de producto",true, Status.FAILED,true);
        }
    }

    public void seleccionarProducto(){
        if(esperarObjeto(productoPizza,3)){
            addStep("Tap en el producto",false, Status.PASSED,false);
            productoPizza.click();
        }else{
            addStep("Error, No se pudo hacer tap en el producto",true, Status.FAILED,true);
        }
    }

    public void validarVistaCompraIndividual(){
        if(esperarObjeto(lblCompraIndividual,3)){
            addStep("Validar Vista Selección de producto",true, Status.PASSED,false);
        }else{
            addStep("Error, No se pudo desplegar vista de Selección de producto",true, Status.FAILED,true);
        }
    }

    public void ingresarCantidadProducto(String cantidad){
        try{
            System.out.println("[Compra Individual] Ingresar Cantidad de Producto");
            inputCantidad.setValue(cantidad);
            this.driver.hideKeyboard();
            btnAgregar.click();
            addStep("Cantidad de producto ingresada satisfactoriamente",false, Status.PASSED,false);
        }catch (Exception e){
            addStep("Error, No se pudo ingresar la cantidad de productos",true, Status.FAILED,true);
        }

    }

    public void validarPantallaVenta(){
        if(esperarObjeto(lblTotal,3)){
            addStep("Validar Vista de Venta",true, Status.PASSED,false);
        }else{
            addStep("Error, No se pudo desplegar vista de Venta",true, Status.FAILED,true);
        }

    }

    public void tapBtnEfectivo(){
        if(esperarObjeto(btnEfectivo,3)){
            addStep("Tap en el botón '$'",false, Status.PASSED,false);
            btnEfectivo.click();
        }else{
            addStep("Error, No se pudo hacer tap en el botón '$'",true, Status.FAILED,true);
        }
    }

    public void validarPopUp(){
        if(esperarObjeto(btnAceptarVenta,3)){
            addStep("Validar Popup de confirmación de venta",true, Status.PASSED,false);
        }else{
            addStep("Error, No se pudo desplegar Popup de confirmación de Venta",true, Status.FAILED,true);
        }
    }

    public void tapBtnAceptar(){
        if(esperarObjeto(btnAceptarVenta,3)){
            addStep("Tap en el botón 'Aceptar' del popup",false, Status.PASSED,false);
            btnAceptarVenta.click();
        }else{
            addStep("Error, No se pudo hacer tap en el botón 'Aceptar' del popup",true, Status.FAILED,true);
        }
    }



}
