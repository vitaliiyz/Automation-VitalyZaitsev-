package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By removedCartItem = By.className("removed_cart_item");
    private final By checkoutButton = By.id("checkout");

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public WebElement getRemovedCartItem() {
        return driver.findElement(removedCartItem);
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
        ;
    }

}
