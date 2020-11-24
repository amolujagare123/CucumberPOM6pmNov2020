Feature: Hotels.com website testing

  Background: opening the web page
    Given I am on hotels.com home page

# 1
  @StarRatings
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |

#2

  Scenario: List of all of hotel within 6 km radius of airport
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "6" Km radius of airport
    And I verify "ibis Mumbai" is within radius


#3
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than "5000" rs

#4
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    When I select <select_rooms> from room dropdown
    Then I verify <number_of_room_dropdown> is displayed

    Examples:
      |select_rooms            | number_of_room_dropdown |
      | 2                    		| 2              			         |
      | 5                     		 | 5               			        |
      | 9+                    		 | 0                   			    |