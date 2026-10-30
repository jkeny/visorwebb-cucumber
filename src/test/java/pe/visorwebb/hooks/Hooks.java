package pe.visorwebb.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import pe.visorwebb.browsers.DriverFactory;
import pe.visorwebb.browsers.DriverFactory.Navegador;

public class Hooks {
	
	@Before(order = 1)
	public void inicializarDriver() {
		DriverFactory.inicializarDriver(Navegador.CHROME);

				
	}
	
	
	@After
	public void cerrarDriver() {
		DriverFactory.cerrarDriver();
	}

}
