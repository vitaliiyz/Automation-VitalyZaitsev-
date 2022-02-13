package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private final By completeHeader = By.className("complete-header");

    public WebElement getCompleteHeader() {
        return driver.findElement(completeHeader);
    }
}
