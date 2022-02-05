package BaseObjects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void precondition(){
        driver = getDriver();
    }

    @AfterTest
    public void postCondition() {
        closeDriver();
    }
}
