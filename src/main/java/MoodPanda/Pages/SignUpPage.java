package MoodPanda.Pages;

import MoodPanda.BasePage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;

public class SignUpPage extends BasePage {

    SelenideElement firstNameField = $("[placeholder = 'Your first name']");
    SelenideElement lastNameField = $("[placeholder=\"e.g. 'S'\"]");
    SelenideElement emailField = $("[placeholder = 'Your email address']");
    SelenideElement passwordField = $(By.name("password"));
    SelenideElement checkbox = $("[type = 'checkbox']");
    SelenideElement signUpBtn = $(By.tagName("button"));
    SelenideElement errorEmailNotification = $("[class ^= 'notification is-danger is-small']");

    public SignUpPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public SignUpPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public SignUpPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public SignUpPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage clickOnCheckbox() {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        return this;
    }

    public SignUpPage clickSignUpButton() {
        signUpBtn.click();
        return this;
    }

    public SignUpPage verifyErrorEmailNotification(String text) {
        errorEmailNotification.shouldHave(text(text));
        return this;
    }

}
