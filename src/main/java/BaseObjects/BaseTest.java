package BaseObjects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static BaseObjects.DriverCreation.*;

public class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        createDriver();
        driver = getDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void postCondition() {
        closeDriver();
    }
}
