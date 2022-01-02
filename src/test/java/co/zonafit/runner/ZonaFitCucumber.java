package co.zonafit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/feature/zonaFit.feature"},
        glue = {"co.zonafit.stepdefinition"},
        tags = "",
        publish = true
)

public class ZonaFitCucumber {
}
