package Booking;

import BaseObjects.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage (){
        this.driver = DriverCreation.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitElementVisibility(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void openPage(String url) {
        driver.get(url);
    }

    protected WebElement findElement(By element) {
        return driver.findElement(element);
    }

    protected void clickButton(By element) {
        findElement(element).click();
    }

    protected List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    protected void assertText(By element, String text) {
        Assert.assertEquals(findElement(element).getText(), text);
    }
}
