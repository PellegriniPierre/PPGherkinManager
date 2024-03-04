@requests
Feature: API TESTS
	Scenario: Test Get API
		Given I launch a "get" request

	Scenario: Test Post API
		Given I launch a "post" request

	Scenario: test database
		Given I launch a "mariadb" request

	@Jira
	Scenario Outline: Test Read User Story issue sur Jira API
		Given I create a "User Story"
		When I read "<USKey>" "User Story"
		Then I Edit a "User Story"
		Then I Delete a "User Story"

		Examples:
		|USKey|
		|GR1-331|
		|GR2-395|


