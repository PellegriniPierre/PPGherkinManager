@VPS-6
Feature: VL_QA As an user, I can be blocked after X password trials in the login page
	#DOR : Id an pwd has been created for an user account
	#
	#DOD : After X trials, the user has been blocked to enter a new pwd by a pop up message

	Background:
		

	#The QA tester has to test to be blocked in the login page after X number of password trials.
	@VPS-8 @VPS-47 @Authentication @IMPOSED @Login
	Scenario Outline: VL_QA - Test to be blocked when X password trials
		Given I am at the login page as an user or admin/superAdmin role
		When I write my <id> and
		And I write my <pwd> wrong
		And I click on the login button "Se connecter"
		And I write again my <pwd> wrong until the X limit of passwords trials
		Then a pop up message appears "Limite de tentatives de mot de passe dépassée, veuillez réessayer ultérieurement"
		
		    Examples:
		        |id    | pwd   |
		        |user  | blob  |
		        |admin | blop  |