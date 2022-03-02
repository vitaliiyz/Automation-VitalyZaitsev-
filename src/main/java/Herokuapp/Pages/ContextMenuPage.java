package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ContextMenuPage extends BasePage {
    private final By box = By.id("hot-spot");

    public ContextMenuPage rightClickOnBox() {
        actions.contextClick(findElement(box)).perform();
        return this;
    }

    public ContextMenuPage checkAlertText() {
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You selected a context menu");
        return this;
    }

    public ContextMenuPage closeAlert() {
        driver.switchTo().alert().accept();
        return this;
    }
}
