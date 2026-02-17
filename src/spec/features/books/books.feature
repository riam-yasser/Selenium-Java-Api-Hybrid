#language: en
@books @tr
Feature: Je Souhaite Tester L'affichage des books de l'application Web Demo Shop

Background:
Given Je me connecte sur le site Web Demo Shop
When Je clique sur le bouton Log in
And Je saisis une adresse mail 
And Je saisis un mot de passe
And Je clique sur le bouton Login
Then Je me redirige vers la page home "ziedhannachi0@gmail.com"
When Je clique sur le boutton Books

@books_validScenario
Scenario: Je Souhaite Tester l'affichage des books

Then Je vois l'affichage des cahiers dans l'application

@books_addToCart
Scenario: Je Souhaite Tester l'ajout des books sur le panier

And Je vois l'affichage des cahiers dans l'application
And Je click sur le boutton add to cart "books"
And je vois le message que le produit est ajoutee sur le panier "The product has been added to your shopping cart"
When je click sur le boutton shopping cart
Then je vois la page du shopping cart

@books_checkoutPage_as_guest
Scenario: Je Souhaite Tester l'ajout des books sur le panier et faire checkout

And Je vois l'affichage des cahiers dans l'application
And Je click sur le boutton add to cart "books"
And je vois le message que le produit est ajoutee sur le panier "The product has been added to your shopping cart"

# 1) Click checkout → déclenche l’alerte
And Je clique sur le boutton shopping cart
And je vois la page du shopping cart
When je click sur le boutton checkout
Then Je vois le message d'alerte qu'il faut accepter les terms of use "Please accept the terms of service before the next step."

# 2) Fermer l’alerte + cocher terms
And Je ferme l'alerte terms of use
And Je coche sur la case accept terms of use

# 3) Re-click checkout → continuer le flow
And Je clique sur le boutton checkout
Then Je me redirige vers la page d'authentification

@books_checkoutPage
Scenario: Je Souhaite Tester l'ajout des books sur le panier et faire checkout pour un utilisateur connecte

And Je vois l'affichage des cahiers dans l'application
And Je click sur le boutton add to cart "books"
And je vois le message que le produit est ajoutee sur le panier "The product has been added to your shopping cart"

# 1) Click checkout → déclenche l’alerte
And Je clique sur le boutton shopping cart
And je vois la page du shopping cart
When je click sur le boutton checkout
Then Je vois le message d'alerte qu'il faut accepter les terms of use "Please accept the terms of service before the next step."

# 2) Fermer l’alerte + cocher terms
And Je ferme l'alerte terms of use
And Je coche sur la case accept terms of use

# 3) Re-click checkout → continuer le flow
And Je clique sur le boutton checkout
Then Je me redirige vers la page du checkout

And Je choisis une adresse de facturation depuis une liste deroulante si j'ai plusieurs adresse
Then Je click sur le boutton continue de facturation

And Je choisis une adresse de residence depuis une liste deroulante si j'ai plusieurs adresse
Then Je click sur le boutton continue pour adresse de residence

And Je choisis une methode de livraison en cochant sur un radio button qui est par defaut Ground
Then Je click sur le boutton continue pour methode de livraison

And Je choisis une methode de paiement en cochant sur un radio button qui est par defaut Cash on delivery
Then Je click sur le boutton continue pour methode de paiement

And Je vois un message du mon choix de methode de paiement
Then Je click sur le boutton continue pour le message du choix de paiement

And Je vois une liste des informations que j'ai saisis dans tout le formulaire avec les produits dans mon panier
#Then Je click sur le boutton confirm