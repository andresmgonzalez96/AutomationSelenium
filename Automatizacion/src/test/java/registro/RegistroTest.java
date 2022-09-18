package registro;


import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.BaseSeleniumTest;
import utilities.SeleniumUtilities;

public class RegistroTest extends BaseSeleniumTest {
	
	private String EMAIL = "email"+ Math.random() + "@gmail.com";
	private String PASS = "A123";
	private String CODIGO_POSTAL = "05001";
	private String TELEFONO = "3042322322";
	private String MENSAJE_EXITO_REGISTRO = "Activa tu cuenta ahora";
	private String MENSAJE_ERROR_REGISTRO = "Revisa el formulario, existen errores";
	
	@Test
	/**
	 * Test que valida que se permita registrar correctamente
	 */
	public void validarRegistroExitoso() {
		RegistroPage page = new RegistroPage(driver);
		page.setEmail(EMAIL);
		page.setCodigoPostal(CODIGO_POSTAL);
		page.setTelefono(TELEFONO);
		page.selectMenos3MesesTiempoPresentacionExamen();
		page.selectMotivoConduccion();
		page.selectPermisoLista();
		page.selectVaPorLibre();
		page.setContrasena(PASS);
		page.setRepetirContrasena(PASS);
		page.clicAceptarTerminos();
		page.clicNoRecibirInformacion();
		page.clicConfirmarRegistro();
		
		assertTrue(MENSAJE_EXITO_REGISTRO.equals(page.getTitleRegistroExitoso()));

	}	
	
	@Test
	/**
	 * Test que validar muestre mensaje de error
	 */
	public void validarErroresRegistro() {
		RegistroPage page = new RegistroPage(driver);
		page.setEmail(EMAIL);
		page.setCodigoPostal(CODIGO_POSTAL);
		page.selectMenos3MesesTiempoPresentacionExamen();
		page.selectMotivoConduccion();
		page.selectPermisoLista();
		page.selectVaPorLibre();
		page.setContrasena(PASS);
		page.setRepetirContrasena(PASS);
		page.clicAceptarTerminos();
		page.clicNoRecibirInformacion();
		page.clicConfirmarRegistro();
		
		assertTrue(MENSAJE_ERROR_REGISTRO.equals(page.getMensajeErrorRegistro()));

	}	
	
	
	@Before
	public void arrange() {
		HomePage page = new HomePage(driver);
		page.clicBotonAceptoPrivacidad();
		page.clicBotonRegistrarse();

	}

}
