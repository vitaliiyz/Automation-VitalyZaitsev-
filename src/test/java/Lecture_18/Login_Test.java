package Lecture_18;

import BaseObjects.SelenideBaseTest;
import MoodPanda.Pages.LoginPage;
import org.testng.annotations.Test;

public class Login_Test extends SelenideBaseTest {

    @Test(description = "Negative login test")
    public void negativeLoginTest() {
        getPage(LoginPage.class)
                .enterEmail("user@user.com")
                .enterPassword("user123")
                .clickLoginBtn()
                .verifyErrorNotification();
    }
}
