package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private final By addToCartButton = By.cssSelector(".btn");
    private final By productsInCartIndicator = By.cssSelector(".shopping_cart_badge");
    private final By cartPageLink = By.cssSelector(".shopping_cart_link");


    private WebElement getAddToCartButton() {
        return driver.findElement(addToCartButton);
    }

    public String getUrl() {
        return "https://www.saucedemo.com/inventory.html";
    }

    public void clickAddToCartButton() {
        getAddToCartButton().click();
    }

    public String getAddToCartButtonText() {
        return getAddToCartButton().getText();
    }

    public WebElement getProductsInCartIndicator() {
        return driver.findElement(productsInCartIndicator);
    }

    public String getProductsInCartIndicatorQty() {
        return getProductsInCartIndicator().getText();
    }

    public void clickCartPageLink() {
        driver.findElement(cartPageLink).click();
    }

}
