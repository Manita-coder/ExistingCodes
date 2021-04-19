@10_percent
Feature: SA360
  
#  Scenario: update cache
#    Given I update cache
#	
#  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
#    When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360
#
#    Examples: 
#      | geocode                         | sickscore |
#      | us-ny-new-york                  |        51 |
#      | us-md-baltimore                 |        52 |
#      #| us-me-portland-auburn           |        53 |
#      | us-ga-savannah                  |        54 |
#      | us-ga-augusta                   |        55 |
#      | us-ri-providence-ma-new-bedford |        56 |
#      | us-ga-columbus                  |        57 |
#      | us-vt-burlington-ny-plattsburgh |        58 |
#      | us-ga-atlanta                   |        59 |
#      | us-ga-albany                    |        60 |
#      | us-ny-utica                     |        61 |

  Scenario: Verify Bids after force upload
 #   Then I force Upload file
    Then I Download latest records from SA360 after 30 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on DV360
    And Bid for - "<geocode>" should be "<Expected Bid>"

    Examples: 
      | geocode                         | sickscore | Expected Bid |
      | us-ny-new-york                  |        51 | 10%          |
      | us-md-baltimore                 |        52 | 10%          |
      #| us-me-portland-auburn           |        53 | 10%          |
      | us-ga-savannah                  |        54 | 10%          |
      | us-ga-augusta                   |        55 | 10%          |
      | us-ri-providence-ma-new-bedford |        56 | 10%          |
      | us-ga-columbus                  |        57 | 10%          |
      | us-vt-burlington-ny-plattsburgh |        58 | 10%          |
      | us-ga-atlanta                   |        59 | 10%          |
      | us-ga-albany                    |        60 | 10%          |
      | us-ny-utica                     |        61 | 10%          |
