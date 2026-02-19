#language: en
@notebooks @tr 
Feature: Je Souhaite Tester La Page Notebooks de l'application Web Demo Shop

Background:
Given Je me connecte sur le site Web Demo Shop 

@notebooks
Scenario: Je Souhaite Tester La Page Notebooks de l'application

When Je positionne sur la bar menu des computers je vois la liste deroulante des choix des computers 
And Je choisis Notebooks
Then Je me redirige vers la page des Notebooks
