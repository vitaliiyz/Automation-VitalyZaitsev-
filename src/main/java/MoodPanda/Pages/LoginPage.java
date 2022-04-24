package MoodPanda.Pages;

import MoodPanda.BasePage;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    SelenideElement emailField = $("[type = text]");
    SelenideElement passwordField = $("[type = password]");
    SelenideElement loginButton = $("[class ^= 'button is-vcentered']");
    SelenideElement notification = $("[class ^= 'notification']");

    public LoginPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginButton.click();
        return this;
    }

    public LoginPage verifyErrorNotification() {
        notification.shouldHave(text("Your email or password is wrong"));
        return this;
    }
}
