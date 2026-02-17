#language: en
@facebook @tr 
Feature: Je Souhaite Tester L'affichage de la page du facebook de l'application Web Demo Shop

Background:
Given Je me connecte sur le site Web Demo Shop 

@facebook_redirection
Scenario: Je Souhaite Tester L'affichage de la page du facebook de l'application Web Demo Shop

When Je click sur le boutton Facebook 
Then Je me redirige vers La page Facebook de l'application





