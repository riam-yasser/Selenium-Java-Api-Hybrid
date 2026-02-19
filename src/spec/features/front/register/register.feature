#language: en
@register @tr
Feature: Je Souhaite Tester La Page Inscription de l'application Web Demo Shop

Background:

Given Je me connecte sur le site Web Demo Shop
When Je clique sur le bouton Register dans la bar menu

@register_validCredentials
Scenario: Je Souhaite Tester la Page Inscription avec Des Données Valides

And Je choisis le gender
And Je saisis un first name
And Je saisis un last name
And Je saisis une adresse mail correcte
And Je saisis un Mot de passe
And Je saisis une autre fois le mot de passe pour le confirmer
And Je clique sur le bouton Register
Then Je visualise le message de succes d'inscription "Your registration completed" 
When Je click sur le boutton continue
Then Je me redirige vers la page home

@register_invalidCredentials
Scenario Outline: Je Souhaite Tester la Page Inscription avec Des Données invalides

And Je choisis le gender "<gender>"
And Je saisis un first name "<first_name>"
And Je saisis un last name "<last_name>"
And Je saisis une adresse mail "<email>" 
And Je saisis un mot de passe "<password>"
And Je saisis une autre fois le mot de passe pour le confirmer "<confirm_password>"
And Je clique sur le bouton Register
Then Je visualise le message d'erreur pour les validations "<error_message>"

Examples:
|gender |first_name |last_name |email                  |password  |confirm_password |error_message								         |
|male   |yasser123  |          |yasser.abc@gmail.com   |123456 	  |123456 			|Last name is required.		 				         |
|male   |rami123    |rami	   |rami.abc@gmail.com 	   |123 	  |123 				|The password should have at least 6 characters.     |
|female | 			|kawther   |kawther.abc@gmail.com  |123456 	  |123456 		    |First name is required.			  			     |
|male   |Yasser 	|Yass      |runhpietk.a.chsoe.t@gmail.com     |Yasser123 |Yasser123 	|The specified email already exists			  	     |
|female |ichraf123 	|ichraf    |ichraf.abc@gmail.com   |123456 	  | 				|Password is required.			  		             |
|female |rahma 	    |rahma123  |rahma.abc/gmail.com    |123456 	  |123456 			|Wrong email							  		     |
|female |mayssa 	|mayssa123 |mayssa.abc@gmail.com   |123456 	  |123 			    |The password and confirmation password do not match.|












