package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FramesPage extends BasePage {
    private final By frame = By.id("mce_0_ifr");
    private final By frameContent = By.tagName("p");

    public FramesPage switchToFrame() {
        driver.switchTo().frame(findElement(frame));
        return this;
    }

    public FramesPage checkFrameContent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(frameContent));
        Assert.assertEquals(findElement(frameContent).getText(), "Your content goes here.");
        return this;
    }

}
