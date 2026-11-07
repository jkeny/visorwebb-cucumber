package pe.visorwebb.stepsdefinitions.producto;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import pe.visorwebb.pagina.login.PaginaLogin;
import pe.visorwebb.pagina.menu.PaginaMenuPrincipal;
import pe.visorwebb.pagina.producto.PaginaActualizarProducto;
import pe.visorwebb.pagina.producto.PaginaMantenimientoProducto;
import pe.visorwebb.pagina.producto.PaginaRegistrarProducto;

public class ProductoSteps {

	@Managed
	WebDriver driver;
	PaginaLogin paginaLogin;
	PaginaMenuPrincipal paginaMenuPrincipal;
	PaginaMantenimientoProducto paginaMantenimientoProducto;
	PaginaRegistrarProducto paginaRegistrarProducto;
	PaginaActualizarProducto paginaActualizarProducto;

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

	@Given("que estando en el detalle del producto seleccionado {string}")
	public void que_estando_en_el_detalle_del_producto_seleccionado(String producto) {

		paginaMenuPrincipal.cargarPaginaMantenimientoProducto();
		paginaMantenimientoProducto.filtrarProducto(producto).seleccionarProductoGrilla(producto)
				.hacerClicEnBotonEditar();

	}

	@When("actualiza el producto seleccionado con los valores {string} {string} {string}")
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
	public void obtenerMensajeProductoNoSeleccionado(String mensajeEsperado) {
		String mensajeObtenido = paginaMantenimientoProducto.obtenerMensajeProductoNoSeleccionado();
		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);
	}

	@When("busca el producto {string} a eliminar")
	public void busca_el_producto_a_eliminar(String producto) {
		paginaMenuPrincipal.cargarPaginaMantenimientoProducto();
		paginaMantenimientoProducto.filtrarProducto(producto);

	}

	@When("selecciona el producto {string} de la tabla")
	public void selecciona_el_producto_de_la_tabla(String producto) {
		paginaMantenimientoProducto.seleccionarProductoGrilla(producto);

	}

	@When("hace clic en el botón Eliminar")
	public void hace_clic_en_el_botón_eliminar() {

		paginaMantenimientoProducto.hacerClicEnBotonEliminar();
	}

	@When("acepta el mensaje de confirmación de eliminación")
	public void acepta_el_mensaje_de_confirmación_de_eliminación() {
		paginaMantenimientoProducto.hacerClicEnBotonSi();

	}

	@Then("el sistema mostrará un mensaje {string} de eliminación exitosa")
	public void el_sistema_mostrará_un_mensaje_de_eliminación_exitosa(String mensajeEsperado) {
		String mensajeObtenido = paginaMantenimientoProducto.obtenerMensajeEliminarProducto();

		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);

	}

	@Then("el sistema mostrará un mensaje {string} de producto no seleccionado")
	public void el_sistema_mostrará_un_mensaje_de_producto_no_seleccionado(String mensajeEsperado) {
		String mensajeObtenido = paginaMantenimientoProducto.obtenerMensajeEliminarProductoNoSeleccionado();

		Assertions.assertThat(mensajeObtenido).isEqualTo(mensajeEsperado);

	}

}
