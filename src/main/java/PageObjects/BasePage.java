package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By productName = By.cssSelector(".inventory_item_name");

    public WebElement getProductNameElement() {
        return driver.findElement(productName);
    }

    public String getProductNameText() {
        return driver.findElement(productName).getText();
    }
}
