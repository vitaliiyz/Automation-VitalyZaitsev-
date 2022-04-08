package MoodPanda.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    SelenideElement getStartedButton = $("[class ^= 'button is-white']");
    SelenideElement title = $("[class ^= 'title is-size-1']");
    SelenideElement signUpBtn = $("[class ^= 'button is-danger']");

    public HomePage verifyTitle() {
        title.shouldHave(text("MoodPanda"));
        return this;
    }

    public HomePage clickBtn(String linkText) {
        $(By.partialLinkText(linkText)).click();
        return this;
    }
}