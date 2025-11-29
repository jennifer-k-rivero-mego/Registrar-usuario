package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinition"},
        plugin = {
                "pretty",                                 // salida bonita en consola
                "html:target/cucumber-report.html",      // reporte HTML
                "json:target/cucumber-report.json"       // opcional, para otros plugins
        },
        tags = "@loginStore"
)
public class TestRunner {
}
