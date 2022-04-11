package BaseObjects;

import Utils.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;

import static BaseObjects.DriverCreation.*;

@Listeners({Listener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        createDriver();
        driver = getDriver();
        driver.manage().window().maximize();
    }

    protected <T> T getPage(Class<T> page) {
        T instance = null;
        try {
            instance = page.getDeclaredConstructor().newInstance();
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
