package Lecture_18;

import BaseObjects.SelenideBaseTest;
import MoodPanda.Pages.SignUpPage;
import MoodPanda.Pages.UserData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUp_Test extends SelenideBaseTest {

    @Test(description = "Sign Up with incorrect email", dataProvider = "userData")
    public void incorrectSignUp(UserData userData) {
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

    @DataProvider
    public Object[][] userData() {
        return new Object[][]{
                {new UserData.Builder()
                        .withFirstName("Vitaly")
                        .withLastName("Z")
                        .withEmail("email")
                        .withPassword("user1234")
                        .build()
                }
        };
    }

}
