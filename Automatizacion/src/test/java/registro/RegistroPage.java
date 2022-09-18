package registro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.SeleniumUtilities;

public class RegistroPage {

	private WebDriver driver;

	private By emailLocator;	
	private By codigoPostalLocator;
	private By telefonoLocator;
	private By tiempoPresentacionExamenLocator;
	private By carnetConduccionLocator;
	private By permisoListLocator;
	private By permisoOptionsLocator;
	private By contrasenaLocator;
	private By repetirContrasenaLocator;
	private By aceptoTerminosLocator;
	private By recibirInformacionLocator;
	private By btnConfirmarRegistroLocator;
	
	private By mensajeErrorRegistroLocator;
	private By tituloRegistroExitosoLocator;

	/**
	 * Constructor.
	 * 
	 * @param driver
	 */
	public RegistroPage(WebDriver driver) {
		this.driver = driver;

		emailLocator = By.id("email");
		codigoPostalLocator = By.id("cp");	
		telefonoLocator = By.id("tel");	
		tiempoPresentacionExamenLocator = By.cssSelector(".radio > label");
		carnetConduccionLocator = By.cssSelector("*.radio [for=mot_perm_a]");		
		permisoListLocator = By.cssSelector("#perm");
		permisoOptionsLocator = By.cssSelector("#lib_si_div > label");
		contrasenaLocator = By.id("contra");
		repetirContrasenaLocator = By.id("contrarep");		
		aceptoTerminosLocator = By.cssSelector("*.checkbox [for=legon]");
		recibirInformacionLocator = By.cssSelector("#pubon_div > label");
		btnConfirmarRegistroLocator = By.id("bot_reg");

		mensajeErrorRegistroLocator = By.cssSelector("#frm_reg > div.regpeu > div.txt_cent > div > div");
		tituloRegistroExitosoLocator = By.className("tit");
	}


	/**
	 * Metodo que ingresa un email
	 */
	public void setEmail(String email) {
		SeleniumUtilities.waitLoadElement(emailLocator, driver);
		driver.findElement(emailLocator).sendKeys(email);
	}
	
	/**
	 * Metodo que ingresa un codigo postal
	 */
	public void setCodigoPostal(String codigoPostal) {
		SeleniumUtilities.waitLoadElement(codigoPostalLocator, driver);
		driver.findElement(codigoPostalLocator).sendKeys(codigoPostal);
	}
	
	/**
	 * Metodo que ingresa un telefono
	 */
	public void setTelefono(String telefono) {
		SeleniumUtilities.waitLoadElement(telefonoLocator, driver);
		driver.findElement(telefonoLocator).sendKeys(telefono);
	}
	
	/**
	 * Metodo que ingresa un telefono
	 */
	public void selectMenos3MesesTiempoPresentacionExamen() {
		SeleniumUtilities.waitLoadElement(tiempoPresentacionExamenLocator, driver);
		driver.findElement(tiempoPresentacionExamenLocator).click();
	}
	
	/**
	 * Metodo que selecciona el motivo de conduccion
	 */
	public void selectMotivoConduccion() {
		SeleniumUtilities.waitLoadElement(carnetConduccionLocator, driver);
		driver.findElement(carnetConduccionLocator).click();
	}
	
	/**
	 * Metodo que selecciona el motivo de conduccion
	 */
	public void selectPermisoLista() {
		SeleniumUtilities.waitLoadElement(permisoListLocator, driver);
		driver.findElement(permisoListLocator).sendKeys("B");
	}
	
	
	/**
	 * Metodo que selecciona si va por libre o esta inscrito en escuela
	 */
	public void selectVaPorLibre() {
		SeleniumUtilities.waitLoadElement(permisoOptionsLocator, driver);
		driver.findElement(permisoOptionsLocator).click();
	}
	
	
	/**
	 * Metodo que ingresa una contraseña
	 */
	public void setContrasena(String pass) {
		SeleniumUtilities.waitLoadElement(contrasenaLocator, driver);
		driver.findElement(contrasenaLocator).sendKeys(pass);
	}
	
	/**
	 * Metodo que repite la contraseña
	 */
	public void setRepetirContrasena(String pass) {
		SeleniumUtilities.waitLoadElement(repetirContrasenaLocator, driver);
		driver.findElement(repetirContrasenaLocator).sendKeys(pass);
	}
	
	/**
	 * Metodo que hace clic en aceptar terminos y condiciones
	 */
	public void clicAceptarTerminos() {
		SeleniumUtilities.waitLoadElement(aceptoTerminosLocator, driver);
		driver.findElement(aceptoTerminosLocator).click();
	}
	
	/**
	 * Metodo que hace clic en aceptar terminos y condiciones
	 */
	public void clicNoRecibirInformacion() {
		SeleniumUtilities.waitLoadElement(recibirInformacionLocator, driver);
		driver.findElement(recibirInformacionLocator).click();
	}
	
	/**
	 * Metodo que hace clic en confirmar registro
	 */
	public void clicConfirmarRegistro() {
		SeleniumUtilities.waitLoadElement(btnConfirmarRegistroLocator, driver);
		driver.findElement(btnConfirmarRegistroLocator).click();
	}
	
	/**
	 * Metodo que retorna el titulo de la ventana cuando se hace un login exitoso
	 */
	public String getMensajeErrorRegistro() {
		SeleniumUtilities.waitLoadElement(mensajeErrorRegistroLocator, driver);
		return driver.findElement(mensajeErrorRegistroLocator).getText();
	}
	
	
	/**
	 * Metodo que retorna el titulo de la ventana cuando se hace un login exitoso
	 */
	public String getTitleRegistroExitoso() {
		SeleniumUtilities.waitTime(1000);
		SeleniumUtilities.waitLoadElement(tituloRegistroExitosoLocator, driver);
		return driver.findElement(tituloRegistroExitosoLocator).getText();
	}
	
	/**
	 * Metodo que realiza un registro con los parametros enviados
	 */
	public void realizarRegistro(String email, String codigoPostal, String telefono, String pass) {
		setEmail(email);
		setCodigoPostal(codigoPostal);
		setTelefono(telefono);
		selectMenos3MesesTiempoPresentacionExamen();
		selectMotivoConduccion();
		selectPermisoLista();
		selectVaPorLibre();
		setContrasena(pass);
		setRepetirContrasena(pass);
		clicAceptarTerminos();
		clicNoRecibirInformacion();
		clicConfirmarRegistro();
	}
	

}
