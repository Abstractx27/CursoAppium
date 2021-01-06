package pages;

import drivers.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.Report.addStep;
import static utils.Utils.esperarObjeto;

public class RegistroPage {

    private AppiumDriver driver;

    public RegistroPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelsNombreCliente;

    public void validarVistaDesplegada(){
        if(esperarObjeto(tituloVistaRegistro,2)){
            addStep("Validar Vista de registro desplegada",true, Status.PASSED,false);
        }else{
            addStep("Error, Validar Vista de registro desplegada",true, Status.FAILED,true);
        }
    }

    public void tapBtnMas(){
        if(esperarObjeto(btnMas,2)){
            addStep("Tap al boton '+'",false, Status.PASSED,false);
            btnMas.click();
        }else{
            addStep("Error, el botón + no se encuentra",true, Status.FAILED,true);
        }
    }


    public void tapBtnCrearCliente(){
        if(esperarObjeto(btnMas,2)){
            addStep("Tap al boton 'Crear cliente'",false, Status.PASSED,false);
            btnCrearCliente.click();
        }else{
            addStep("Error, el botón Crear Cliente no se encuentra",true, Status.FAILED,true);
        }
    }

    public void validarCliente(String nombreCliente){
        System.out.println("[Registro Clientes] Validar Cliente");

        boolean clienteEncontrado = false;
        for (int i = 0; i<=labelsNombreCliente.size();i++){
            String nombreClienteActual = labelsNombreCliente.get(i).getText();
            if(nombreClienteActual.equals(nombreCliente)){
                clienteEncontrado = true;
                break;
            }
        }

        if(clienteEncontrado){
            addStep("cliente "+nombreCliente+" encontrado exitosamente",false, Status.PASSED,false);
        }else{
            addStep("Error, cliente "+nombreCliente+" no encontrado",true, Status.FAILED,true);
        }

//        MobileElement cliente = (MobileElement) DriverContest.getDriver().findElement(By.xpath("//*[contains(@text,\""+nombreCliente+"\")]"));
//        if (cliente.getText().equals(nombreCliente)){
//            cliente.click();
//            addStep("cliente "+nombreCliente+" encontrado exitosamente",false, Status.PASSED,false);
//        }else{
//            addStep("Error, cliente "+nombreCliente+" no encontrado",true, Status.FAILED,true);
//        }

    }

    public void tapCliente(String nombreCliente){
        System.out.println("[Registro Clientes] tap Cliente");

        MobileElement cliente = (MobileElement) DriverContext.getDriver().findElement(By.xpath("//*[contains(@text,\""+nombreCliente+"\")]"));
        if (cliente.getText().equals(nombreCliente)){
            cliente.click();
            addStep("cliente "+nombreCliente+" seleccionado exitosamente",false, Status.PASSED,false);
        }else{
            addStep("Error, cliente "+nombreCliente+" no encontrado",true, Status.FAILED,true);
        }
    }
}
