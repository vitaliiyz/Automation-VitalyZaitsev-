package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");

    private final By errorMsg = By.tagName("h3");

    private final String url = "https://www.saucedemo.com";
    private final String username = "standard_user";
    private final String password = "secret_sauce";
    private final String incorrectCredentialsError = "Epic sadface: Username and password do not match any user in this service";

    public LoginPage getPage() {
        driver.get(url);
        return this;
    }

    private final Object[][] CorrectLoginData = new Object[][]{
            {username, password}
    };

    private final Object[][] IncorrectLoginData = new Object[][]{
            {username + " ", password},
            {username, password + " "},
            {username.toUpperCase(), password}
    };

    public Object[][] getCorrectLoginData() {
        return CorrectLoginData;
    }

    public Object[][] getIncorrectLoginData() {
        return IncorrectLoginData;
    }

    private String getErrorMsgText() {
        return findElement(errorMsg).getText();
    }

    public LoginPage login(String username, String password) {
        getPage();
        enterText(usernameField, username);
        enterText(passwordField, password);
        click(loginButton);
        return this;
    }

    public LoginPage positiveLoginTest(String username, String password) {
        login(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        return this;
    }

    public LoginPage negativeLoginTest(String username, String password) {
        login(username, password);
        Assert.assertEquals(getErrorMsgText(), incorrectCredentialsError);
        return this;
    }

}
