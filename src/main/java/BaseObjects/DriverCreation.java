package BaseObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Locale;

public class DriverCreation {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createDriver() {
        if (driver.get() == null) {
            driver.set(WebDriverManager.getInstance(DriverManagerType.CHROME).create());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).quit();
    }
}
