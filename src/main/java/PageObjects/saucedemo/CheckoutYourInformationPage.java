package PageObjects.saucedemo;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {
    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    private final String firstName = "First";
    private final String lastName = "Last";
    private final String postalCode = "123456";


    private final Object[][] CheckoutYourInformationData = new Object[][]{
            {firstName, lastName, postalCode}
    };

    public Object[][] getCheckoutYourInformationData() {
        return CheckoutYourInformationData;
    }

    public void enterCheckoutData(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);

    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void fillDataAndClickContinue(String firstName, String lastName, String postalCode) {
        enterCheckoutData(firstName, lastName, postalCode);
        clickContinueButton();
    }
}
