package pe.visorwebb.stepsdefinitions.producto;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.visorwebb.pagina.login.PaginaLogin;
import pe.visorwebb.pagina.menu.PaginaMenuPrincipal;
import pe.visorwebb.pagina.producto.PaginaMantenimientoProducto;
import pe.visorwebb.pagina.producto.PaginaRegistrarProducto;

public class RegistrarProductoStep {
	
	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaMenuPrincipal paginaMenuPrincipal;
	PaginaMantenimientoProducto paginaMantenimientoProducto;
	PaginaRegistrarProducto paginaRegistrarProducto;
	

	@Given("que el administrador inició sesion con usuario {string} y la contraseña {string}")
	public void que_el_administrador_inició_sesion_con_usuario_y_la_contraseña(String usuario, String contrasena) {
		
		driver.get("http://localhost:8080/VisorWeb/");
		paginaLogin.iniciarSesion(usuario, contrasena);
		

	}
	@When("registra un nuevo producto {string} {string} {string}")
	public void registra_un_nuevo_producto(String producto, String categoria, String precio) {
		paginaMenuPrincipal.cargarPaginaMantenimientoProducto();
		paginaMantenimientoProducto.hacerClicEnBotonNuevo();
		paginaRegistrarProducto.registrarProducto(producto, categoria, precio);

	}
	@Then("el sistema muestra un mensaje {string}")
	public void el_sistema_muestra_un_mensaje(String mensajeEsperado) {
		String mensajeObtenido = paginaRegistrarProducto.obtenerMensajeRegistroProducto();
		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);

	}


}
