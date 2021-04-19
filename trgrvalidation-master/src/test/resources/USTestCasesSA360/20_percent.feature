@20_percent
Feature: SA360

  Scenario: update cache
    Given I update cache
	
  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360

    Examples: 
      | geocode                         | sickscore |
      | us-ny-new-york                  |        76 |
      | us-md-baltimore                 |        77 |
      #| us-me-portland-auburn           |        78 |
      | us-ga-savannah                  |        79 |
      | us-ga-augusta                   |        80 |
      | us-ri-providence-ma-new-bedford |        81 |
      | us-ga-columbus                  |        82 |
      | us-vt-burlington-ny-plattsburgh |        83 |
      | us-ga-atlanta                   |        84 |
      | us-ga-albany                    |        85 |
      | us-ny-utica                     |        86 |

  Scenario: Verify Bids after force upload
    Then I force Upload file
    Then I Download latest records from SA360 after 30 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                         | sickscore | Expected Bid |
      | us-ny-new-york                  |        76 | 20%          |
      | us-md-baltimore                 |        77 | 20%          |
      #| us-me-portland-auburn           |        78 | 20%          |
      | us-ga-savannah                  |        79 | 20%          |
      | us-ga-augusta                   |        80 | 20%          |
      | us-ri-providence-ma-new-bedford |        81 | 20%          |
      | us-ga-columbus                  |        82 | 20%          |
      | us-vt-burlington-ny-plattsburgh |        83 | 20%          |
      | us-ga-atlanta                   |        84 | 20%          |
      | us-ga-albany                    |        85 | 20%          |
      | us-ny-utica                     |        86 | 20%          |
