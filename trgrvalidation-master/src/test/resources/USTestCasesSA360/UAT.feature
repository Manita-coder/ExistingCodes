@UAT
Feature: SA360 UAT2

  Scenario: POST API for Low
    When I send an API request with geocode = "us-ny-new-york", sickscore = 1 for SA360
    Then I force Upload file
    Then I Download latest records from SA360 after 30 seconds
    And Bid for - "us-ny-new-york" should be "-20%"
