@VPS-1
Feature: VL_QA - EPIC 1 - Règles fonctionnelles (exigences fonctionnelles ou requirements) sur le domaine fonctionnel Authentification
	#*Règles d'authentification imposées :* 
	# * Créer une liste d'utilisateurs privilégiés (de droits) par projet (site web) ainsi que son périmètres d'action
	# ** Super Admin -> Tous les droits
	# ** Admin -> Droits de modifier / supprimer / créer des utilisateurs pour du support par exemple
	# ** Community manager (utilisateur privilégié) -> droit de publier des posts sur la page Articles de presse
	# ** Gestionnaire des achats -> droit de créer des produits / catégories de produits
	#
	# * Si le mot de passe n'est pas correctement saisi, au bout de X tentatives -> blocage de l'utilisateur
	# * Proposer un changement de mot de passe
	# * Afficher un message d'erreur lors de la saisie erronée ou bien un message expliquant qu'on est bien connecté à la plateforme
	# * Un utilisateur qui arrive sur le site est par défaut au statuts invité
	# * 1 seule plateforme (page) pour s'authentifier
	# * Admin se connecte en utilisant son propre compte qui possède des droits spécifiques d'admin -> un seul utilisateur
	# * Tous les utilisateurs peuvent se voir accorder le droit d'administrateur par un "super admin" => spécifier dans le contexte de l'authentification
	# * Définir le niveau de privilège sur la plateforme en fonction du métier (rôles)
	#
	#*Règles inventées :*
	# * Une personne autre que Super Admin ayant un compte admin peut accorder certain droits d'administrateur à certain utilisateurs privilégiés en fonction d'un métier ou rôle particulier (définir une liste de métier et rôles)
	# * Mettre à jour seul son profil utilisateur inscrit (droit de modifier ses informations personnelles)

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