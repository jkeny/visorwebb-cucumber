package pe.visorwebb.test.categoria;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import io.cucumber.core.options.Constants;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("/features/categoria")
//@SelectPackages("features.categoria")
@ConfigurationParameter(
		key = Constants.GLUE_PROPERTY_NAME, 
		value = "pe.visorwebb.stepsdefinitions.categoria")//, pe.visorwebb.hooks
@ConfigurationParameter(
		key = Constants.PLUGIN_PROPERTY_NAME, 
		value = "pretty,net.serenitybdd.cucumber.core.plugin.SerenityReporter")
public class RegistrarCategoriaTest {
	
}
