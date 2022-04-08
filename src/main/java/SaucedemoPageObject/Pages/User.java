package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "UserBuilder", setterPrefix = "with")
public class User extends BasePage {
    private String userName;
    private String password;

    public static class UserBuilder {
        public UserBuilder() {

        }
    }
}
