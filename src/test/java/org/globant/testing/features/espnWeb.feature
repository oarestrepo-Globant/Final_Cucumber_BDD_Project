Feature: Espn web navigation

  In order to verify the process of signup, logout and navigation between pages of the ESPN website
  As a verified user of the espn website
  I want to successfully log in, navigate through the different pages

  @web @espn @espnNavigation
  Scenario Outline: As a user, I able to navigate to the Watch page
    Given I go to ESPN page
    When I want to be new user and fill signup form with <firstname> <lastname> <email> <password>
    And I navigate to the Watch page
    Then I should see the carousel
    But I logout from my ESPN account
    Then I should return to the main page

    Examples:
      | firstname | lastname   | email               | password           |
      | "Oscar"   | "Restrepo" | "16@pruebaosca.com" | "password123*polo" |