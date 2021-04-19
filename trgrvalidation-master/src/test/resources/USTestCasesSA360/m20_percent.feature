@m20_percent
Feature: SA360

  Scenario: update cache
    Given I update cache
	
  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode                         | sickscore |
      | us-ny-new-york                  |         1 |
      | us-md-baltimore                 |         2 |
      #| us-me-portland-auburn           |         3 |
      | us-ga-savannah                  |         4 |
      | us-ga-augusta                   |         5 |
      | us-ri-providence-ma-new-bedford |         6 |
      | us-ga-columbus                  |         7 |
      | us-vt-burlington-ny-plattsburgh |         8 |
      | us-ga-atlanta                   |         9 |
      | us-ga-albany                    |        10 |
      | us-ny-utica                     |        11 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 30 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                         | sickscore | Expected Bid |
      | us-ny-new-york                  |         1 | -20%         |
      | us-md-baltimore                 |         2 | -20%         |
      #| us-me-portland-auburn           |         3 | -20%         |
      | us-ga-savannah                  |         4 | -20%         |
      | us-ga-augusta                   |         5 | -20%         |
      | us-ri-providence-ma-new-bedford |         6 | -20%         |
      | us-ga-columbus                  |         7 | -20%         |
      | us-vt-burlington-ny-plattsburgh |         8 | -20%         |
      | us-ga-atlanta                   |         9 | -20%         |
      | us-ga-albany                    |        10 | -20%         |
      | us-ny-utica                     |        11 | -20%         |
