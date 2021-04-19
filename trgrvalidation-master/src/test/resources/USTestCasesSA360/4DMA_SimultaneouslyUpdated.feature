@4DMA_SimultaneouslyUpdated
Feature: SA360

  Scenario: update cache
    Given I update cache

  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode               | sickscore |
      #| us-me-portland-auburn |         1 |
      | us-ny-new-york        |        30 |
      | us-ny-binghamton      |        60 |
      | us-ga-macon           |        77 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 10 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode               | sickscore | Expected Bid |
      #| us-me-portland-auburn |         1 | -20%         |
      | us-ny-new-york        |        30 | 0%           |
      | us-ny-binghamton      |        60 | 10%          |
      | us-ga-macon           |        77 | 20%          |
