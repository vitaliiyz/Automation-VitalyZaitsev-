package Booking.Pages;

import Booking.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchResults_Page extends BasePage {

    private final By searchInput = By.cssSelector("#ss");
    private final By searchButton = By.cssSelector("button[type = submit]");
    private final By hotelTitle = By.xpath("//div[@data-testid='property-card']//div[@data-testid='title']");
    private final By hotelRating = By.xpath("//div[@data-testid='property-card']//div[contains(@aria-label, 'Scored')]");

    public SearchResults_Page enterSearchText(String text) {
        waitElementVisibility(searchInput);
        findElement(searchInput).sendKeys(text);
        findElement(searchInput).click();
        return this;
    }

    public SearchResults_Page clickSearchButton() {
        clickButton(searchButton);
        return this;
    }

    public SearchResults_Page checkHotelName(String hotelName) {
        boolean isThereHotelName = findElements(hotelTitle).stream().anyMatch(el -> el.getText().contains(hotelName));
        Assert.assertTrue(isThereHotelName);
        return this;
    }

    public SearchResults_Page checkHotelRating(String rating) {
        assertText(hotelRating, rating);
        return this;
    }
}
