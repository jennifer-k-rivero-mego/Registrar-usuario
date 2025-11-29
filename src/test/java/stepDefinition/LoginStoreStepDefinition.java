package stepDefinition;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.RegistroPage;

public class LoginStoreStepDefinition {

    private static WebDriver driver;
    private HomePage homePage;
    private RegistroPage registerPage;

    @Dado("estoy en la página de la tienda")
    public void estoy_en_la_pagina_de_la_tienda() {
        if (driver == null) {
            
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        homePage   = new HomePage(driver);
        registerPage = new RegistroPage(driver);

        homePage.openStore();
    }

    @Cuando("doy click en la opción iniciar sesión")
    public void doy_click_en_la_opcion_iniciar_sesion() {
        homePage.clickIniciarSesion();
    }

    @Cuando("doy click en el link text cree una cuenta aquí")
    public void doy_click_en_el_link_text_cree_una_cuenta_aqui() {
        registerPage.clickCrearCuenta();
    }

    @Cuando("lleno los campos del formulario para el registro")
    public void lleno_los_campos_del_formulario_para_el_registro() {
        registerPage.llenarFormularioRegistro();
    }

    @Cuando("doy click en el botón guardar")
    public void doy_click_en_el_boton_guardar() {
        registerPage.clickGuardar();
    }

    @Entonces("debería visualizar mi usuario logeado en la pantalla")
    public void deberia_visualizar_mi_usuario_logeado_en_la_pantalla() {
        String usuarioEnPantalla = registerPage.obtenerNombreUsuarioLogeado();
        Assert.assertTrue("El usuario no se muestra logeado",
                usuarioEnPantalla.contains("Jennifer"));
        // Cerrar el navegador al final
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
