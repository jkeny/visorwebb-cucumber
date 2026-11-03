package pe.visorwebb.pagina.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorwebb.pagina.base.BasePage;
import pe.visorwebb.pagina.categoria.PaginaMantenimientoCategoria;
import pe.visorwebb.pagina.producto.PaginaMantenimientoProducto;


public class PaginaMenuPrincipal extends BasePage {

	@FindBy(xpath = "//div[@class='menu']/div")
	WebElement menuHamburguesa;

	@FindBy(xpath = "//span[contains(text(),'Mod. de Almacén ')]")
	WebElement menuModAlmacen;

	@FindBy(xpath = "//a[@href='/VisorWeb/mntAdmProducto.xhtml']")
	WebElement menuMantProducto;
	
	@FindBy(partialLinkText = "Mnt. de Categoría")
	WebElement menuMantCategoria;

	public PaginaMenuPrincipal() {
		super();
	}

	public PaginaMantenimientoProducto cargarPaginaMantenimientoProducto() {

		
		click(menuHamburguesa);
		click(menuModAlmacen);
		click(menuMantProducto);
		

		return new PaginaMantenimientoProducto();

	}
	
	public PaginaMantenimientoCategoria cargarPaginaMantenimientoCategoria() {
		
		click(menuHamburguesa);
		click(menuModAlmacen);
		click(menuMantCategoria);
		return new PaginaMantenimientoCategoria();
	
	}

}
