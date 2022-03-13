package Lecture_13;

import BaseObjects.BaseTest;
import Herokuapp.Pages.HomeLinks;
import Herokuapp.Pages.HomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Parameters({"linkName"})
    @Test
    public void homePageTest(String linkName) {
        getPage(HomePage.class)
                .open(context.getSuite().getParameter("url"))
                .checkTitle()
                .checkWebpageTitle("The Internet");

        getPage(HomePage.class)
                .clickLink(HomeLinks.valueOf(linkName));
    }
}
