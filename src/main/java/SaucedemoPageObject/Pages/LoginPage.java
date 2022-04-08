package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "[id = user-name]")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    private final By errorMsg = By.tagName("h3");

    private final String username = "standard_user";
    private final String password = "secret_sauce";
    private final String incorrectCredentialsError = "Epic sadface: Username and password do not match any user in this service";

    public LoginPage getPage() {
        driver.get(properties.getProperty("url"));
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
        enterTextToField(usernameField, username);
        enterTextToField(passwordField, password);
        loginButton.click();
        return this;
    }

    public LoginPage loginByValueObject(UserData userData) {
        getPage();
        enterTextToField(usernameField, userData.getUserName());
        enterTextToField(passwordField, userData.getPassword());
        loginButton.click();
        return this;
    }

    public LoginPage loginByBuilder(User user) {
        getPage();
        enterTextToField(usernameField, user.getUserName());
        enterTextToField(passwordField, user.getPassword());
        loginButton.click();
        return this;
    }

    public LoginPage verifyErrorMsg() {
        Assert.assertEquals(getErrorMsgText(), incorrectCredentialsError);
        return this;
    }

}
