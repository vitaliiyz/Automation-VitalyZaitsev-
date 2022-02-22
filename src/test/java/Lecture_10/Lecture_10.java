package Lecture_10;

import BaseObjects.BaseTest;
import SaucedemoPageObject.Pages.CartPage;
import SaucedemoPageObject.Pages.InventoryPage;
import SaucedemoPageObject.Pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lecture_10 extends BaseTest {

    @Test(groups = "login", dataProvider = "getCorrectLoginData", priority = 0, timeOut = 2000,
            description = "login-test")
    public void positiveLoginTest(String username, String password) {
        getPage(LoginPage.class).positiveLoginTest(username, password);
    }

    @Test(priority = 1, invocationCount = 2, groups = "products", dependsOnMethods = "positiveLoginTest",
            description = "add 1 product to cart and remove test", alwaysRun = true, threadPoolSize = 2)
    public void addProductToCartAndDeleteTest() {
        getPage(InventoryPage.class).addProductToCartTest();
        getPage(CartPage.class)
                .removeProduct()
                .checkRemovedProduct();
    }

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

    @Test(dataProvider = "getIncorrectLoginData", priority = 2)
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
