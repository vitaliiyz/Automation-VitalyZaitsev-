package BDD_Tests.steps;

import BaseObjects.BaseTest;
import Booking.Pages.SearchResults_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_Steps extends BaseTest {

    SearchResults_Page searchResults_page = new SearchResults_Page();

    @Given("i load page {string}")
    public void openPage(String url) {
        searchResults_page.openPage(url);
    }

    @When("i enter to search {string}")
    public void enterHotelName(String hotelName) {
        getPage(SearchResults_Page.class).enterSearchText(hotelName);
    }

    @And("i click search button")
    public void clickSearchButton() {
        getPage(SearchResults_Page.class).clickSearchButton();
    }

    @Then("i check hotel name {string}")
    public void checkHotelName(String hotelName) {
        getPage(SearchResults_Page.class).checkHotelName(hotelName);
    }

    @Then("i check hotel rating {string}")
    public void checkHotelRating(String hotelRating) {
        getPage(SearchResults_Page.class).checkHotelRating(hotelRating);
    }

}
