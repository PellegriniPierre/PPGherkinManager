@TIPS-83  @Guest_statut @Login @Password @Registration @Registration_succeed
Feature: L'utilisateur s'enregistre pour la première fois

  @TIPS-86
  Scenario: As a guest who never register I try to register myself on the website
    Given I am on the "account" page
    When I enter my login
    And I click on the button "s'enregistrer"
    And My personal account appear
    Then I delete the user created
