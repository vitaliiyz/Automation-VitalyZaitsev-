package SaucedemoPageObject.Pages;

import SaucedemoPageObject.BasePage;

public class User extends BasePage {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        User user;

        public Builder() {
            user = new User();
        }

        public Builder withUserName(String userName) {
            user.userName = userName;
            return this;
        }

        public Builder withPassword(String password) {
            user.password = password;
            return this;
        }

        public User build() {
            return user;
        }
    }
}
