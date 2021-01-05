package testClases.Carrusel;

import pages.CarruselPage;

public class Test_Carrusel {

    CarruselPage carruselPage = new CarruselPage();
    public void validaciones(){
        carruselPage.validarVistaDesplegada();
        carruselPage.validarTextoVista1Carrusel();

    }
}
