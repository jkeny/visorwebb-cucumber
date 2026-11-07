package pe.visorwebb.stepsdefinitions.producto;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import pe.visorwebb.pagina.login.PaginaLogin;
import pe.visorwebb.pagina.menu.PaginaMenuPrincipal;
import pe.visorwebb.pagina.producto.PaginaActualizarProducto;
import pe.visorwebb.pagina.producto.PaginaMantenimientoProducto;

public class ActualizarProductoStep {

	@Managed
	WebDriver driver;

	@Steps
	PaginaLogin paginaLogin;
	@Steps
	PaginaMenuPrincipal paginaMenuPrincipal;
	@Steps
	PaginaMantenimientoProducto paginaMantenimientoProducto;
	@Steps
	PaginaActualizarProducto paginaActualizarProducto;

	@Given("que estando en el detalle del producto seleccionado {string}")
	public void que_estando_en_el_detalle_del_producto_seleccionado(String producto) {

		paginaMenuPrincipal.cargarPaginaMantenimientoProducto();
		paginaMantenimientoProducto.filtrarProducto(producto).seleccionarProductoGrilla(producto)
				.hacerClicEnBotonEditar();

	}

	@When("actualiza el nombre del producto seleccionado con los valores {string} {string} {string}")
	public void actualiza_el_nombre_del_producto_seleccionado_con_los_valores(String nuevoNombreProduto,
			String nuevaCategoria, String nuevoPrecio) {
		paginaActualizarProducto.actualizarProducto(nuevoNombreProduto, nuevaCategoria, nuevoPrecio);

	}

	@Then("el sistema debe mostrar el mensaje {string}")
	public void el_sistema_debe_mostrar_el_mensaje(String mensajeEsperado) {

		String mensajeObtenido = paginaActualizarProducto.obtenerMensajeActualizarProducto();
		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);

	}
	
	@Given("que el sistema muestra el catálogo de mantenimiento de productos")
	public void irPaginaManteninientoProductos() {
		paginaMenuPrincipal.cargarPaginaMantenimientoProducto();
		
	}
	@When("se intenta editar un producto {string} sin haberlo seleccionado de la lista")
	public void editarProductoSinSeleccionarEnLaGrilla(String producto) {
		paginaMantenimientoProducto.filtrarProducto(producto);
		paginaMantenimientoProducto.hacerClicEnBotonEditarSinSeleccionar();
		
	}
	@Then("el sistema debe mostrar el mensaje de advertencia {string}")
	public void obtenerMensajeProdcutoNoSeleccionado(String mensajeEsperado) {
		String mensajeObtenido= paginaMantenimientoProducto.obtenerMensajeProductoNoSeleccionado();
		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);
	}

}