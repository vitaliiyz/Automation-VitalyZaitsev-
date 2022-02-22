package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By finishButton = By.id("finish");

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
