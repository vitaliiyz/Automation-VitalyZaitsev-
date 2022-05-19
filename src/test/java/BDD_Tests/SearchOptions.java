package BDD_Tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/resources/feature"}, glue = {"BDD_Tests/steps"})
public class SearchOptions extends AbstractTestNGCucumberTests {

    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
