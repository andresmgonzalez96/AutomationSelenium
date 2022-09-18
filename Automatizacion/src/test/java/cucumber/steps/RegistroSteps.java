package cucumber.steps;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import registro.HomePage;
import registro.RegistroPage;
import utilities.BaseSeleniumTest;

public class RegistroSteps extends BaseSeleniumTest {
	
	private String EMAIL = "email"+ Math.random() + "@gmail.com";
	private String PASS = "A123";
	private String CODIGO_POSTAL = "05001";
	private String TELEFONO = "3042322322";
	private String MENSAJE_EXITO_REGISTRO = "Activa tu cuenta ahora";
	private String MENSAJE_ERROR_REGISTRO = "Revisa el formulario, existen errores";
	
	@Given("Un Usuario quiere registrarse")
	public void andres_quiere_registrarse() {
		init();
		HomePage homePage = new HomePage(driver);
		homePage.clicBotonAceptoPrivacidad();
		homePage.clicBotonRegistrarse();
	}

	@When("se envia la informacion requerida")
	public void se_envia_la_informacion_requerida() {
		RegistroPage page = new RegistroPage(driver);
		page.realizarRegistro(EMAIL, CODIGO_POSTAL, TELEFONO, PASS);
	}

	@When("se envia la informacion incompleta")
	public void se_envia_la_informacion_incompleta() {
		RegistroPage page = new RegistroPage(driver);
		page.realizarRegistro(EMAIL, CODIGO_POSTAL, "", PASS);;
	}
	
	@Then("Deberia permitir realizar el registro exitoso")
	public void deberia_permitir_realizar_el_registro_exitoso() {
		RegistroPage page = new RegistroPage(driver);
		assertTrue(MENSAJE_EXITO_REGISTRO.equals(page.getTitleRegistroExitoso()));
		tearDown();
	}
	

	@Then("Deberia retornar un menaje de error en el registro")
	public void deberia_retornar_un_menaje_de_error_en_el_registro() {
		RegistroPage page = new RegistroPage(driver);
		assertTrue(MENSAJE_ERROR_REGISTRO.equals(page.getMensajeErrorRegistro()));
		tearDown();
	}
}
