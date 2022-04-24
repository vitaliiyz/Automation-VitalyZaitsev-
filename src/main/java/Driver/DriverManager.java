package Driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected abstract void createDriver();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
