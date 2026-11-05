package pe.visorwebb.stepsdefinitions.categoria;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.visorwebb.pagina.categoria.PaginaMantenimientoCategoria;
import pe.visorwebb.pagina.categoria.PaginaRegistrarCategoria;
import pe.visorwebb.pagina.login.PaginaLogin;
import pe.visorwebb.pagina.menu.PaginaMenuPrincipal;



public class RegistrarCategoriaStep {

	@Managed
	private WebDriver driver;
	
	
	private PaginaLogin paginaLogin;
	private PaginaMenuPrincipal paginaMenuPrincipal;
	private PaginaMantenimientoCategoria paginaMantenimientoCategoria;
	private PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	
	public RegistrarCategoriaStep() {
		//this.driver = DriverFactory.obtenerDriver();
	}

//	@Before
//	public void inicializarPaginas() {
//
//		//this.driver = DriverFactory.obtenerDriver();
//		//screenshoots sin usar @Managed
//		//net.thucydides.core.webdriver.ThucydidesWebDriverSupport.useDriver(driver);
//		System.out.println("Driver = " + driver);
//		paginaLogin = new PaginaLogin(driver);
//		paginaMenuPrincipal = new PaginaMenuPrincipal(driver);
//		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
//	}


	@Given("cargo la pagina visor web")
	public void cargaPaginaVisorWeb() {
		
	    System.out.println("environment = " + System.getProperty("environment"));
	    System.out.println("webdriver.driver = " + System.getProperty("webdriver.driver"));


		driver.get("http://localhost:8080/VisorWeb/");

	}

	@And("inicio sesion con usuario {string} y la contraseña {string}")
	public void iniciarSesion(String usuario, String clave) {
		paginaLogin.iniciarSesion(usuario, clave);
	}

	@When("cargo la pagina registrar categoria")
	public void cargaPaginaRegistrarCategoria() {
		paginaMenuPrincipal.cargarPaginaMantenimientoCategoria();
		paginaMantenimientoCategoria.cargarPaginaRegistrarCategoria();

	}

	@And("registro la categoria {string}")
	public void registrarCategoria(String categoria) {
		paginaRegistrarCategoria.registrarCategoria(categoria);
	}

	@Then("el sistema debe mostrar el mensaje {string}")
	public void verificarRegistroCategoria(String mensajeEsperado) {
	  String mensajeObtebido=paginaRegistrarCategoria.obtenerMensajeRegistroCategoria();
	  Assertions.assertThat(mensajeObtebido).isEqualTo(mensajeEsperado);
	}

}
