package registro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.SeleniumUtilities;

public class HomePage {

	private WebDriver driver;
	private By registrarseBotonLocator;
	
	private By aceptoPrivacidadLocator;
	
	
	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		registrarseBotonLocator = By.className("op_d");
		aceptoPrivacidadLocator = By.className("css-znwy3a");
	}

	
	/**
	 * Metodo que hace clic en el boton registrarse
	 */
	public void clicBotonRegistrarse() {
		SeleniumUtilities.waitClickeableElement(registrarseBotonLocator, driver);
		driver.findElement(registrarseBotonLocator).click();
	}
	
	/**
	 * Metodo que hace clic en el boton Acepto Privacidad
	 */
	public void clicBotonAceptoPrivacidad() {
		SeleniumUtilities.waitClickeableElement(aceptoPrivacidadLocator, driver);
		driver.findElement(aceptoPrivacidadLocator).click();
	}

}
