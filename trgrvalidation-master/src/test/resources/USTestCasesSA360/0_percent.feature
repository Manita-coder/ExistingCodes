@0_percent
Feature: SA360

#  Scenario: update cache
#    Given I update cache
#	
#  Scenario Outline: Post API requests with  sickscore <sickscore> and geocodes <geocode>
#   When I send an API request with geocode = "<geocode>", sickscore = <sickscore> for SA360
#
#    Examples: 
#      | geocode                         | sickscore |
#      | us-ny-new-york                  |        27 |
#      | us-md-baltimore                 |        28 |
#      | us-me-portland-auburn           |        29 |
#      | us-ga-savannah                  |        30 |
#      | us-ga-augusta                   |        31 |
#      | us-ri-providence-ma-new-bedford |        32 |
#      | us-ga-columbus                  |        33 |
#      | us-vt-burlington-ny-plattsburgh |        34 |
#      | us-ga-atlanta                   |        35 |
#      | us-ga-albany                    |        36 |
#      | us-ny-utica                     |        37 |

    Scenario: Verify Bids after force upload
#    Then I force Upload file
    Then I Download latest records for all campaign from SA360 after 1 seconds and close browser

  Scenario Outline: Verify sickscore <sickscore> and geocodes <geocode> on SA360
    And Bid for - "<geocode>" should be "<Expected Bid>" and "<Account ID>" across all campaign

    Examples: 
      | geocode                         | sickscore | Expected Bid |Account ID|
      | us-ny-new-york                  |        27 | 0%           |700000001668108|
#      | us-md-baltimore                 |        28 | 0%           |
#      | us-me-portland-auburn           |        29 | 0%           |
#      | us-ga-savannah                  |        30 | 0%           |
#      | us-ga-augusta                   |        31 | 0%           |
#      | us-ri-providence-ma-new-bedford |        32 | 0%           |
#      | us-ga-columbus                  |        33 | 0%           |
#      | us-vt-burlington-ny-plattsburgh |        34 | 0%           |
#      | us-ga-atlanta                   |        35 | 0%           |
#      | us-ga-albany                    |        36 | 0%           |
#      | us-ny-utica                     |        37 | 0%           |
