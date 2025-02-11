package runners;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDefinitions"},
        features = {"src/test/java/features/PlaceValidations.feature"})

public class CucumberTestRunner {
}
