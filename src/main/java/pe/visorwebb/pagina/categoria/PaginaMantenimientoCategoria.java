package pe.visorwebb.pagina.categoria;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import pe.visorwebb.pagina.base.BasePage;

public class PaginaMantenimientoCategoria extends BasePage {

	@FindBy(id = "btnNuevo")
	WebElement btnNuevo;

	public PaginaMantenimientoCategoria(WebDriver driver) {
		super(driver);

	}

	public PaginaRegistrarCategoria cargarPaginaRegistrarCategoria() {
		
		click(btnNuevo);
		
		return new PaginaRegistrarCategoria(driver);
	
	}

}
