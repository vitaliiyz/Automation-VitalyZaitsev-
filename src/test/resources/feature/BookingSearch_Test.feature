Feature: Booking Search test

  Background: Open search page
    Given i load page "https://www.booking.com/searchresults.en-gb.html"
    When i enter to search "Kempinski Hotel Mall of the Emirates"

  Scenario: Check search page
    And i click search button
    Then i check hotel name "Kempinski Hotel Mall of the Emirates"
    Then i check hotel rating "8.8"