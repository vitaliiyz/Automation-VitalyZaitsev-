Feature: Booking Search test

  Background: Open search page
    Given i load page "https://www.booking.com/searchresults.en-gb.html"
    When i enter to search Dubai

  Scenario: Check search page
    And i click search button
    Then i check hotel name Dubai
    Then i check hotel rating 8.3