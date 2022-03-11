package Herokuapp.Pages;

import Herokuapp.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final By title = By.tagName("h1");

    public HomePage open(String url) {
        super.open(url);
        return this;
    }

    public HomePage checkTitle() {
        Assert.assertEquals(getText(title), "Welcome to the-internet");
        return this;
    }

    public HomePage clickLink(HomeLinks link) {
        findElement(By.partialLinkText(link.getLink())).click();
        return this;
    }

}
