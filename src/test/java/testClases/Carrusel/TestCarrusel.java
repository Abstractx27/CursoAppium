package testClases.Carrusel;

import pages.CarruselPage;

public class TestCarrusel {

    CarruselPage carruselPage = new CarruselPage();
    public void validarCarrusel(){
        carruselPage.validarVistaDesplegada();
        carruselPage.validarTextoVista1Carrusel();
    }

    public void slideCarrusel(){
        carruselPage.recorrerCarrusel();
    }
}
