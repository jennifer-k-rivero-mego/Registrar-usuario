package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistroPage {

    private WebDriver driver;


    private By linkCrearCuenta = By.linkText("¿No tiene una cuenta? Cree una aquí");

    private By radioTratamientoSra = By.xpath("//label[@for='field-id_gender-2']");       
    private By txtNombre          = By.id("field-firstname");
    private By txtApellidos       = By.id("field-lastname");
    private By txtCorreo          = By.id("field-email");
    private By txtContrasena      = By.id("field-password");
    private By txtFechaNacimiento = By.id("field-birthday");
    private By chkTerminos        = By.xpath("//label[input[@name='psgdpr']]");
    private By chkPrivacidad      = By.xpath("//label[input[@name='customer_privacy']]");
    private By btnGuardar         = By.xpath("//button[@type='submit' and @data-link-action='save-customer']");

    
    private By lblUsuarioLogeado  = By.cssSelector("a.account span");

    public RegistroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCrearCuenta() {
        driver.findElement(linkCrearCuenta).click();
    }

    public void llenarFormularioRegistro() {
        // Datos según el documento que enviaste :contentReference[oaicite:0]{index=0}
        driver.findElement(radioTratamientoSra).click();
        driver.findElement(txtNombre).sendKeys("Jennifer");
        driver.findElement(txtApellidos).sendKeys("RM");
        driver.findElement(txtCorreo).sendKeys("jennifer_rm_57@gmail.com");
        driver.findElement(txtContrasena).sendKeys("Jennifer_rm_01#$");
        driver.findElement(txtFechaNacimiento).sendKeys("27/07/1997");
        driver.findElement(chkTerminos).click();
        driver.findElement(chkPrivacidad).click();
    }

    public void clickGuardar() {
        driver.findElement(btnGuardar).click();
    }

    public String obtenerNombreUsuarioLogeado() {
        return driver.findElement(lblUsuarioLogeado).getText();
    }
}
