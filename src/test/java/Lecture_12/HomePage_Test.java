package Lecture_12;

import BaseObjects.BaseTest;
import Herokuapp.Pages.HomeLinks;
import Herokuapp.Pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    HomePage homePage;

    @BeforeTest
    public void preconditions() {
        homePage = new HomePage();
    }

    @Parameters({"linkName"})
    @Test
    public void homePage_Test(String linkName) {
        homePage
                .open(context.getSuite().getParameter("url"))
                .checkTitle()
                .clickLink(HomeLinks.valueOf(linkName));
    }
}
