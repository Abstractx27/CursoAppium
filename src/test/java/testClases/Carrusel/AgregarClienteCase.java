package testClases.Carrusel;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegistroPage;

public class AgregarClienteCase {

    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Renan27";
    String id = "1234";
    String telefono = "99999999";
    String direccion = "calle falsa 123";
    String notas = "sin notas";

    public void flujo(){

        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearCliente();

        crearClientePage.validarVistaDesplegada();
        crearClientePage.completarFormulario(nombre, id, telefono, direccion, notas);
        crearClientePage.tapGuardar();

        registroPage.validarVistaDesplegada();

        registroPage.validarCliente(nombre);
    }
}
