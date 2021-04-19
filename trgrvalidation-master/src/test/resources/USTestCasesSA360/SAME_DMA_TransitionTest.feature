@SAME_DMA_TransitionTest
Feature: SA360 UAT2

  Scenario: POST API for Low
    When I send an API request with geocode = "us-ny-new-york", sickscore = 1 for SA360
    Then I force Upload file
    Then I Download latest records from SA360 after 30 seconds
    And Bid for - "us-ny-new-york" should be "-20%"

#  Scenario: POST API for Medium
#    When I send an API request with geocode = "us-ny-new-york", sickscore = 27 for SA360
#    Then I force Upload file
#    Then I Download latest records from SA360 after 30 seconds
#    And Bid for - "us-ny-new-york" should be "0%"
#
#  Scenario: POST API High
#    When I send an API request with geocode = "us-ny-new-york", sickscore = 51 for SA360
#    Then I force Upload file
#    Then I Download latest records from SA360 after 30 seconds
#    And Bid for - "us-ny-new-york" should be "10%"
#
#  Scenario: POST API very High
#    When I send an API request with geocode = "us-ny-new-york", sickscore = 77 for SA360
#    Then I force Upload file
#    Then I Download latest records from SA360 after 30 seconds
#    And Bid for - "us-ny-new-york" should be "20%"
#	