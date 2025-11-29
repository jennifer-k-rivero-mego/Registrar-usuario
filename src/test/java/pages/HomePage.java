package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // URL de la tienda
    private final String URL_STORE = "https://qalab.bensg.com/store";

    // Locators (revísalos con F12 en el navegador por si cambian)
    private By btnIniciarSesion = By.linkText("Iniciar sesión");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openStore() {
        driver.get(URL_STORE);
        driver.manage().window().maximize();
    }

    public void clickIniciarSesion() {
        WebElement btnLogin = driver.findElement(btnIniciarSesion);
        btnLogin.click();
    }
}
