package Lecture_16;

import BaseObjects.BaseTest;
import SaucedemoPageObject.Pages.LoginPage;
import SaucedemoPageObject.Pages.User;
import SaucedemoPageObject.Pages.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage_Test extends BaseTest {

    LoginPage loginPage;
    UserData userData;
    User user;

    @BeforeMethod
    public void precondition() {
        userData = new UserData();
        loginPage = new LoginPage();

        getPage(LoginPage.class).getPage();
    }

    @Test(priority = 1)
    public void positiveLoginByValueObject_test() {
        userData.setUserName("standard_user");
        userData.setPassword("secret_sauce");

        getPage(LoginPage.class)
                .loginByValueObject(userData)
                .verifyTitle();
    }

    @Test(priority = 2)
    public void negativeLoginByValueObject_test() {
        userData.setUserName("user");
        userData.setPassword("pass0");

        getPage(LoginPage.class)
                .loginByValueObject(userData)
                .verifyErrorMsg();
    }

    @Test(priority = 3, dataProvider = "correctData")
    public void positiveLoginByBuilder_test(User user) {
        getPage(LoginPage.class)
                .loginByBuilder(user)
                .verifyTitle();
    }

    @Test(priority = 4, dataProvider = "incorrectData")
    public void negativeLoginByBuilder_test(User user) {
        getPage(LoginPage.class)
                .loginByBuilder(user)
                .verifyErrorMsg();
    }

    @DataProvider
    public Object[][] correctData() {
        return new Object[][]{
                {new User.UserBuilder().withUserName("standard_user").withPassword("secret_sauce").build()}
        };
    }

    @DataProvider
    public Object[][] incorrectData() {
        return new Object[][]{
                {new User.UserBuilder().withUserName("user").withPassword("sauce").build()}
        };
    }

}
