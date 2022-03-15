package Herokuapp;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static BaseObjects.DriverCreation.getDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;
    protected Logger logger = Logger.getLogger(BasePage.class);

    protected BasePage() {
        this.driver = getDriver();
        this.actions = new Actions(this.driver);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    protected BasePage open(String url) {
        driver.get(url);
        return this;
    }

    private final By title = By.tagName("h3");

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

    public BasePage clickLinkByText(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
        return this;
    }

    public BasePage checkTitle(String expectedTitle) {
        Assert.assertEquals(findElement(title).getText(), expectedTitle);
        return this;
    }

    public BasePage checkWebpageTitle(String expectedTitle) {
        String webPageTitle = js.executeScript("return document.title;").toString();
        Assert.assertEquals(webPageTitle, expectedTitle);
        return this;
    }

    protected BasePage elementLocatedWait(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return this;
    }

    protected BasePage assertEquals(By element, String expected) {
        Assert.assertEquals(findElement(element).getText(), expected);
        return this;
    }

    protected BasePage assertTrue(Boolean actualResult) {
        Assert.assertTrue(actualResult);
        return this;
    }

    protected BasePage assertFalse(Boolean actualResult) {
        Assert.assertFalse(actualResult);
        return this;
    }

    protected BasePage click(By element) {
        findElement(element).click();
        return this;
    }

}
