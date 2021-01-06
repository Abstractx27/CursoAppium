package testClases.Carrusel;

import pages.CarruselPage;
import pages.DetalleClientePage;
import pages.RegistroPage;

public class AsignarVentaCase {

    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    DetalleClientePage detalleClientePage = new DetalleClientePage();

    String nombre = "Renan1";
    String cantidad = "2";

    public void flujoTest(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapCliente(nombre);

        detalleClientePage.validarVistaDetalleCliente();
        detalleClientePage.tapBtnAnadirVenta();
        detalleClientePage.validarVistaSeleccionProducto();
        detalleClientePage.seleccionarProducto();
        detalleClientePage.validarVistaCompraIndividual();
        detalleClientePage.ingresarCantidadProducto(cantidad);
        detalleClientePage.validarPantallaVenta();
        detalleClientePage.tapBtnEfectivo();
        detalleClientePage.validarPopUp();
        detalleClientePage.tapBtnAceptar();
    }
}
