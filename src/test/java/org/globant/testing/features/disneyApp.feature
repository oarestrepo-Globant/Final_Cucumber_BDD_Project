Feature: Disney APP Navigation

  In order to verify some features of the disney app
  As a visitor to the application
  I want to navigate through different screens

  Background:
    Given I am in the main screen

  @mobile @disney @MapScreen
  Scenario: Navigate to Map Screen
    Given I am in the Map view
    When I tap category list
    Then I should see a list of categories

  @mobile @disney @Privacy&Legal
  Scenario: Navigate to Privacy & Legal screen
    Given I am in the Menu screen
    When I tap on Privacy & legal
    Then I should see a list of options

  @mobile @disney @AddPlans
    Scenario: Navigate to Add Plans
    When I am in the Add Plans screen
    Then I should see a list of plans to add