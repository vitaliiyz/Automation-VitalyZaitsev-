package Lecture_15;

import BaseObjects.BaseTest;
import Configuration.PropertyReader;
import SaucedemoPageObject.Pages.LoginPage;
import SaucedemoPageObject.Pages.User;
import SaucedemoPageObject.Pages.UserData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginTest extends BaseTest {

    UserData userData;
    LoginPage loginPage;

    @BeforeTest
    public void preconditions() {
        userData = new UserData();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginTest() {
        userData.setUserName("user");
        userData.setPassword("password");

        loginPage
                .getPage()
                .loginByValueObject(userData)
                .verifyErrorMsg();
    }

    @Test(priority = 2, dataProvider = "data", enabled = false)
    public void loginTestByBuilder(User user) {

        loginPage
                .getPage()
                .loginByBuilder(user);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{{
                new User.UserBuilder().withUserName("user").withPassword("password").build()
        }};
    }
}
