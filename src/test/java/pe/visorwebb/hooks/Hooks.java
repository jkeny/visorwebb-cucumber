package pe.visorwebb.hooks;


import static org.mockito.ArgumentMatchers.nullable;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pe.visorwebb.browsers.DriverFactory;
import pe.visorwebb.browsers.DriverFactory.Navegador;

public class Hooks {
	
	@Before(order = 1)
	public void inicializarDriver() {
		Navegador navegadorActual;
		String navegadorSystem= System.getProperty("browser");
		if (navegadorSystem==null||navegadorSystem.trim().isEmpty()) {
			navegadorSystem="CHROME";
			
		}
		try {
			
			navegadorActual=Navegador.valueOf(navegadorSystem.toUpperCase());
			
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"El navegador '" + navegadorSystem + "' no está soportado. Usa CHROME, FIREFOX o EDGE.");
		}
		DriverFactory.inicializarDriver(navegadorActual);

				
	}
	
	
	@After
	public void cerrarDriver() {
		DriverFactory.cerrarDriver();
	}

}
