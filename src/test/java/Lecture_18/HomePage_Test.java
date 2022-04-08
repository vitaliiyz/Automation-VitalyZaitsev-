package Lecture_18;

import BaseObjects.SelenideBaseTest;
import MoodPanda.Pages.HomePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage_Test extends SelenideBaseTest {

    @Parameters({"linkText"})
    @Test(description = "Verifying of home page title, click link to the next page.")
    public void homePage_test(String linkText) {
        getPage(HomePage.class)
//                .verifyTitle()
                .clickBtn(linkText);
    }
}
