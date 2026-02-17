#language: en
@desktops @tr 
Feature: Je Souhaite Tester L Notebooks de l'application Web Demo Shop

Background:
Given Je me connecte sur le site Web Demo Shop 
When Je me positionne sur la bar menu des computers je vois la liste deroulante des choix des computers 
And Je choisis Desktops
Then Je me redirige vers la page des Desktops
And Je choisis un produit et je click pour rediriger vers product page
And Je click sur le boutton add to cart "desktops"

@desktops_invalid_add_to_cart
Scenario: Je Souhaite Ajouter un produit depuis la liste des computers un desktop de l'application

Then Je vois une alerte que le processeur n'est pas selectionner

@desktops_valid_add_to_cart
Scenario: Je Souhaite Ajouter un produit depuis la liste des computers dans son panier et l'acheter desktop de l'application

Then Je vois une alerte que le processeur n'est pas selectionner
And Je dois fermer la notification du message d'alerte
When Je coche sur un processeur 
Then Je click sur le boutton add to cart "desktops"
