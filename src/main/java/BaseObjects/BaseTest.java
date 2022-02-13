package BaseObjects;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

public abstract class BaseTest {
    protected WebDriver driver;
    ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        driver = getDriver();
    }

    protected <T> T getPage(Class<T> page) {
        return getPage(page, this.driver);
    }

    protected <T> T getPage(Class<T> page, WebDriver driver) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return instance;
    }

    @AfterTest
    public void postCondition() {
        closeDriver();
    }
}
