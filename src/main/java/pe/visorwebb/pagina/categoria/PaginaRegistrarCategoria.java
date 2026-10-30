package pe.visorwebb.pagina.categoria;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pe.visorwebb.pagina.base.BasePage;

public class PaginaRegistrarCategoria extends BasePage {

	@FindBy(id = "txtNombre")
	WebElement txtNombre;

	@FindBy(id = "btnGuardar")
	WebElement btnGuardar;

	@FindBy(xpath = "//span[@class='ui-messages-info-summary']")
	WebElement lblMensajeExitoso;

	@FindBy(xpath = "//span[@class='ui-messages-error-summary']")
	WebElement lblMensajeErroneo;

	@FindBy(xpath = "//span[@class='ui-messages-info-summary'] | //span[@class='ui-messages-error-summary']")
	WebElement lblMensaje;

	public PaginaRegistrarCategoria(WebDriver driver) {
		super(driver);
		// menuPrincipal = new MenuPrincipal(driver);

	}

	public void registrarCategoria(String categoria) {
		limpiar(txtNombre);
		escribir(txtNombre, categoria);
		click(btnGuardar);
	}

	public String obtenerMensajeRegistroCategoria() {

        return obtenerTexto(lblMensaje);


	}

	public String getMensajeExitoso() {
		
		return obtenerTexto(lblMensajeExitoso);

	}

	public String getMensajeErroneo() {
	
		return obtenerTexto(lblMensajeErroneo);

	}

}
