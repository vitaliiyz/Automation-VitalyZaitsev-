package Lecture_9;

import BaseObjects.BaseTest;
import PageObjects.saucedemo.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {

    @Test(dataProvider = "getCorrectLoginData", priority = 1)
    public void correctLoginTest(String login, String password) {
        getPage(LoginPage.class).login(login, password);

        Assert.assertEquals(driver.getCurrentUrl(), getPage(InventoryPage.class).getUrl());
    }

    @Test(priority = 2)
    public void addProductToCartTest() {
        getPage(InventoryPage.class).clickAddToCartButton();
        String productName = getPage(InventoryPage.class).getProductNameText();

        Assert.assertEquals(getPage(InventoryPage.class).getAddToCartButtonText(), "REMOVE");
        Assert.assertTrue(getPage(InventoryPage.class).getProductsInCartIndicator().isDisplayed());
        Assert.assertEquals(getPage(InventoryPage.class).getProductsInCartIndicatorQty(), "1");

        getPage(InventoryPage.class).clickCartPageLink();

        Assert.assertEquals(productName, getPage(CartPage.class).getProductNameText());
    }

    @Test(dataProvider = "getCheckoutInformationData", priority = 3)
    public void createOrderTest(String firstName, String lastName, String postalCode) {
        getPage(CartPage.class).clickCheckoutButton();
        getPage(CheckoutYourInformationPage.class).fillDataAndClickContinue(firstName, lastName, postalCode);

        System.out.println(getPage(InventoryPage.class).getProductNameText());

        Assert.assertEquals(getPage(CheckoutOverviewPage.class).getProductNameText(), getPage(InventoryPage.class).getProductNameText());

        getPage(CheckoutOverviewPage.class).clickFinishButton();

        Assert.assertTrue(getPage(CheckoutCompletePage.class).getCompleteHeader().getText().contains("THANK YOU"));
    }

    @Test(priority = 4)
    public void deleteProductFromCart() {
        driver.get(getPage(InventoryPage.class).getUrl());
        addProductToCartTest();

        getPage(CartPage.class).clickRemoveButton();

        Assert.assertTrue(getPage(CartPage.class).getRemovedCartItem().isEnabled());
    }

    @Test(dataProvider = "getWithoutPasswordLoginData", priority = 5)
    public void withoutPasswordLoginTest(String login, String password) {
        getPage(LoginPage.class).login(login, password);

        Assert.assertEquals(getPage(LoginPage.class).getIncorrectLoginMessage(),
                getPage(LoginPage.class).getPasswordRequiredText());
    }

    @Test(dataProvider = "getIncorrectPasswordData", priority = 6)
    public void incorrectPasswordTest(String login, String password) {
        getPage(LoginPage.class).login(login, password);

        Assert.assertEquals(getPage(LoginPage.class).getIncorrectLoginMessage(),
                getPage(LoginPage.class).getUsernameOrPasswordIncorrectText());
    }

    @DataProvider
    public Object[][] getCorrectLoginData() {
        return getPage(LoginPage.class).getCorrectLoginData();
    }

    @DataProvider
    public Object[][] getWithoutPasswordLoginData() {
        return getPage(LoginPage.class).getWithoutPasswordData();
    }

    @DataProvider
    public Object[][] getIncorrectPasswordData() {
        return getPage(LoginPage.class).getIncorrectPasswordData();
    }

    @DataProvider
    public Object[][] getCheckoutInformationData() {
        return getPage(CheckoutYourInformationPage.class).getCheckoutYourInformationData();
    }
}
