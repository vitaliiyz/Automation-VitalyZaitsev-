package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {
    private final By checkbox = By.xpath("//input[@type='checkbox']");
    private final By message = By.id("message");
    private final By input = By.xpath("//input[@type='text']");

    private WebElement getButton(String buttonText) {
        return findElement(By.xpath("//button[contains(text(), '" + buttonText + "')]"));
    }

    private WebElement getInput() {
        return findElement(input);
    }

    public DynamicControlsPage checkCheckbox(boolean status) {
        if (status) {
            Assert.assertTrue(isElementPresent(checkbox));
        } else {
            Assert.assertFalse(isElementPresent(checkbox));
        }
        return this;
    }

    public DynamicControlsPage clickButton(String buttonText) {
        getButton(buttonText).click();
        return this;
    }

    public DynamicControlsPage checkMessageAfterClicking(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        Assert.assertEquals(getText(message), expectedMessage);
        return this;
    }

    public DynamicControlsPage checkInput(boolean isEnabled) {
        if (!isEnabled) {
            Assert.assertFalse(getInput().isEnabled());
        } else {
            Assert.assertTrue(getInput().isEnabled());
        }
        return this;
    }


}
