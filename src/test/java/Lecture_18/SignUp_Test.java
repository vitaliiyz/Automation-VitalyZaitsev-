package Lecture_18;

import BaseObjects.SelenideBaseTest;
import MoodPanda.Pages.SignUpPage;
import MoodPanda.Pages.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class SignUp_Test extends SelenideBaseTest {

    UserData userData;

    @BeforeMethod
    public void precondition() {
        userData = new UserData();
    }

    @Test(description = "Sign Up with incorrect email")
    public void incorrectSignUp() {
        open("https://moodpanda.com/signup");

        userData.setFirstName("Vitaly");
        userData.setLastName("Z");
        userData.setEmail("email");
        userData.setPassword("user1234");

        getPage(SignUpPage.class)
                .enterFirstName(userData.getFirstName())
                .enterLastName(userData.getLastName())
                .enterEmail(userData.getEmail())
                .enterPassword(userData.getPassword())
                .clickOnCheckbox()
                .clickSignUpButton()
                .clickSignUpButton()
                .verifyErrorEmailNotification("Invalid email address");
    }

}
