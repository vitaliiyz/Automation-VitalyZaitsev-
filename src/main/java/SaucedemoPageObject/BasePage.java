package SaucedemoPageObject;

import BaseObjects.DriverCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");

    protected BasePage() {
        this.driver = DriverCreation.getDriver();
    }

    protected WebElement findElement(By element) {
        return driver.findElement(element);
    }

    protected void enterText(By element, String text) {
        findElement(element).sendKeys(text);
    }

    protected void enterTextToField(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void click(By element) {
        findElement(element).click();
    }

    protected String getText(By element) {
        return findElement(element).getText();
    }

    protected String getProductName() {
        return getText(productName);
    }

    protected String getProductPrice() {
        return getText(productPrice);
    }
}
