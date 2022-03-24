package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CartPage extends BasePage {

    private final By removeButton = By.xpath("//button[text()='Remove']");
    private final By removedCartItemDiv = By.className("removed_cart_item");


    public CartPage removeProduct() {
        click(removeButton);
        return this;
    }

    public CartPage checkRemovedProduct() {
        Assert.assertTrue(findElement(removedCartItemDiv).isEnabled());
        return this;
    }
}
