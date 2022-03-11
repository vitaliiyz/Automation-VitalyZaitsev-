package Herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BaseObjects.DriverCreation.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected BasePage() {
        this.driver = getDriver();
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    protected BasePage open(String url) {
        driver.get(url);
        return this;
    }

    protected WebElement findElement(By element) {
        return driver.findElement(element);
    }

    protected String getText(By element) {
        return findElement(element).getText();
    }

    protected boolean isElementPresent(By element) {
        try {
            findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
