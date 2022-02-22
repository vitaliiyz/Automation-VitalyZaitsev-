package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By incorrectLoginMessage = By.cssSelector("[data-test=error]");

    private final String username1 = "standard_user";
    private final String username2 = "locked_out_user";
    private final String username3 = "problem_user";
    private final String username4 = "performance_glitch_user";
    private final String password = "secret_sauce";

    private final Object[][] CorrectLoginData = new Object[][]{
            {username1, password},
            {username2, password},
            {username3, password},
            {username4, password}
    };

    private final Object[][] WithoutPasswordData = new Object[][]{
            {username1, ""},
            {username2, ""},
            {username3, ""},
            {username4, ""}
    };

    private final Object[][] IncorrectPasswordData = new Object[][]{
            {username1, password + "a"},
            {username2, password + "a"},
            {username3, password + "a"},
            {username4, password + "a"}
    };


    public Object[][] getCorrectLoginData() {
        return CorrectLoginData;
    }

    public Object[][] getWithoutPasswordData() {
        return WithoutPasswordData;
    }

    public Object[][] getIncorrectPasswordData() {
        return IncorrectPasswordData;
    }

    public void getPage() {
        String url = "https://www.saucedemo.com/";
        driver.get(url);
    }

    public void enterLogin(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public LoginPage login(String username, String password) {
        getPage();
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
        return this;
    }

    public String getIncorrectLoginMessage() {
        return driver.findElement(incorrectLoginMessage).getText();
    }

    public String getPasswordRequiredText() {
        return "Epic sadface: Password is required";
    }

    public String getUsernameOrPasswordIncorrectText() {
        return "Epic sadface: Username and password do not match any user in this service";
    }
}
