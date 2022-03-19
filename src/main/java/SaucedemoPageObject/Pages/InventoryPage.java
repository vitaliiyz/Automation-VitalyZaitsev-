package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    private final By addToCartButton = By.xpath("//button[text()='Add to cart']");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By productsInCartIndicator = By.className("shopping_cart_badge");
    private final String inventoryPageLink = "https://www.saucedemo.com/inventory.html";
    private final String productName1 = "Sauce Labs Backpack";
    private final String productName2 = "Sauce Labs Bike Light";
    private final String productName3 = "Sauce Labs Bolt T-Shirt";

    private final Object[][] productNames = new Object[][]{
            {productName1},
            {productName2},
            {productName3}
    };

    public Object[][] getProductNames() {
        return productNames;
    }

    public InventoryPage addProductToCart() {
        click(addToCartButton);
        return this;
    }

    public InventoryPage clickShoppingCartLink() {
        click(shoppingCartLink);
        return this;
    }

    public InventoryPage addProductToCartTest() {
        driver.get(inventoryPageLink);
        addProductToCart();
        Assert.assertEquals(getText(productsInCartIndicator), "1");
        String productNameOnInventoryPage = getProductName();
        checkAddedProduct(productNameOnInventoryPage);
        return this;
    }

    public InventoryPage checkAddedProduct(String productNameOnInventoryPage) {
        clickShoppingCartLink();
        String productNameOnCartPage = getProductName();
        Assert.assertEquals(productNameOnInventoryPage, productNameOnCartPage);
        return this;
    }

    public WebElement getAddToCartButtonByProductName(String productName) {
        return findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item_description']//button"));
    }

    public InventoryPage addProductToCartByProductName(String productName) {
        driver.get(inventoryPageLink);
        getAddToCartButtonByProductName(productName).click();
        return this;
    }

}
