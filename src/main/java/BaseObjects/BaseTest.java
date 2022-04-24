package BaseObjects;

import Utils.Listener;
import Driver.DriverManager;
import Driver.DriverManagerFactory;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import static BaseObjects.DriverCreation.closeDriver;
import static BaseObjects.DriverCreation.getDriver;

@Listeners({Listener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected ITestContext context;
    protected DriverManager driverManager;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.driverManager = DriverManagerFactory.getManager(DriverManagerType.valueOf(context.getSuite().getParameter("browser").toUpperCase(Locale.ROOT)));
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
