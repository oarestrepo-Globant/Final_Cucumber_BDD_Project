Feature: Espn web navigation review

  In order to verify the process of login, logout, signup and navigation between pages of the ESPN website
  As a verified user of the espn website
  I want to successfully log in, navigate through the different pages

  Background:
    Given Open browser and enter ESPN url
 #1 #Corregir el given, puedo dejarlo to do en un when. CORREGIR tmbn el then, eliminar palabra modal
  Scenario: Verify modal is present and contains specified elements
    Given I place mouse over the icon user avatar
    When I click  login button
    Then Modal is present and contains specified elements

  #2
  Scenario: Navigate to Watch page and come back to landing page
    Given I am a logged user on the Watch page
    Then I can see specified elements
    And I can go back to the landing page