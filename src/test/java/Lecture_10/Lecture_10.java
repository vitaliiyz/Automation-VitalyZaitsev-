package Lecture_10;

import BaseObjects.BaseTest;
import SaucedemoPageObject.Pages.CartPage;
import SaucedemoPageObject.Pages.InventoryPage;
import SaucedemoPageObject.Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lecture_10 extends BaseTest {

    @Description("Login page")
    @Step("Correct login")
    @Link("https://www.saucedemo.com/")
    @Issue("SD-0001")
    @TmsLink("SDTest-0001")
    @Attachment(value = "screenshot", type = "image/png")
    @Test(groups = "login", dataProvider = "getCorrectLoginData", priority = 0, timeOut = 5000,
            description = "Positive login test")
    public void positiveLoginTest(String username, String password) {
        getPage(LoginPage.class).positiveLoginTest(username, password);
    }

    @Description("Products")
    @Step("Adding product to cart and remove")
    @Link("https://www.saucedemo.com/")
    @Issue("SD-0002")
    @TmsLink("SDTest-0002")
    @Attachment(value = "screenshot", type = "image/png")
    @Test(priority = 1, invocationCount = 2, groups = "products", dependsOnMethods = "positiveLoginTest",
            description = "add 1 product to cart and remove test", alwaysRun = true)
    public void addProductToCartAndDeleteTest() {
        getPage(InventoryPage.class).addProductToCartTest();
        getPage(CartPage.class)
                .removeProduct()
                .checkRemovedProduct();
    }

    @Description("Products")
    @Step("Adding product to cart and remove")
    @Link("https://www.saucedemo.com/")
    @Issue("SD-0003")
    @TmsLink("SDTest-0003")
    @Attachment(value = "screenshot", type = "image/png")
    @Test(priority = 3, dataProvider = "getProductNames", groups = "products",
            dependsOnMethods = "addProductToCartAndDeleteTest",
            description = "add 3 product to cart and remove test")
    public void addProductToCartByProductNameTest(String productName) {
        getPage(InventoryPage.class)
                .addProductToCartByProductName(productName)
                .checkAddedProduct(productName);

        getPage(CartPage.class)
                .removeProduct()
                .checkRemovedProduct();
    }

    @Description("Login page")
    @Step("Incorrect login")
    @Link("https://www.saucedemo.com/")
    @Issue("SD-0004")
    @TmsLink("SDTest-0004")
    @Attachment(value = "screenshot", type = "image/png")
    @Test(dataProvider = "getIncorrectLoginData", priority = 2, description = "Negative login test")
    public void negativeLoginTest(String username, String password) {
        getPage(LoginPage.class).negativeLoginTest(username, password);
    }

    @DataProvider
    public Object[][] getCorrectLoginData() {
        return getPage(LoginPage.class).getCorrectLoginData();
    }

    @DataProvider
    public Object[][] getIncorrectLoginData() {
        return getPage(LoginPage.class).getIncorrectLoginData();
    }

    @DataProvider
    public Object[][] getProductNames() {
        return getPage(InventoryPage.class).getProductNames();
    }
}
