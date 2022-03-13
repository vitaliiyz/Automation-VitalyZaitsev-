package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

public class JavascriptAlertsPage extends BasePage {
    private final By confirmButton = By.xpath("//button[@onclick='jsConfirm()']");
    private final By promptButton = By.xpath("//button[@onclick='jsPrompt()']");
    private final By promptResult = By.id("result");
    private final String promptText = "Some text...";

    public enum Button {CONFIRM, PROMPT}

    public JavascriptAlertsPage clickButton(Button button) {
        By alertButton = null;
        switch (button){
            case CONFIRM:
                alertButton = confirmButton;
                break;
            case PROMPT:
                alertButton = promptButton;
                break;
        }
        js.executeScript("arguments[0].click();", findElement(alertButton));
        return this;
    }

    public JavascriptAlertsPage checkAlertText(String alertText) {
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), alertText);
        return this;
    }

    public JavascriptAlertsPage confirmAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public JavascriptAlertsPage enterPromptText() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(promptText);
        return this;
    }

    public JavascriptAlertsPage verifyPromptResult() {
        Assert.assertEquals(findElement(promptResult).getText(), "You entered: " + promptText);
        return this;
    }
}
