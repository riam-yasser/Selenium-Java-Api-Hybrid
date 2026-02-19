#language: en
@apparelshoes @tr 
Feature: Je Souhaite Tester L'affichage de la page d'un produit de l'application Web Demo Shop

Background:
Given Je me connecte sur le site Web Demo Shop 
When Je click sur le boutton apparel&shoes 
And Je vois la liste des produits 

@apparelshoes_product_page
Scenario: Je Souhaite Tester L'affichage de la page d'un produit de l'application Web Demo Shop
And Je clique sur un produit pour voir ces details
Then Je me redirige vers la page du produit

@apparelshoes_add_to_cart
Scenario: Je Souhaite Tester le boutton add to cart d'un produit de l'application Web Demo Shop
And Je clique sur un produit pour voir ces details
Then Je click sur le boutton add to cart "apparel"

@apparelshoes_add_to_wishlists
Scenario: Je Souhaite Tester le boutton add to wishlist d'un produit de l'application Web Demo Shop

And Je clique sur un produit pour voir ces details
Then Je click sur le boutton add to wishlists

@apparelshoes_select_size_and_color_and_add_to_cart
Scenario: Je Souhaite Tester la selection de la taille et la couleur d'un produit de l'application Web Demo Shop

And Je clique sur un produit pour voir ces details
And Je selectionne une taille qui se trouve dans la liste deroulante
And Je choisis la couleur du produit souhaitee
Then Je click sur le boutton add to cart "apparel"

@apparelshoes_add_review
Scenario: Je Souhaite Tester le boutton add review d'un produit de l'application Web Demo Shop

And Je clique sur un produit pour voir ces details
And Je click sur le boutton add review
Then Je me redirige vers la page des reviews

@apparelshoes_scroll_to_choose_other_product
Scenario: Je Souhaite scroller sur la page des produits de l'application Web Demo Shop

And Je clique sur un produit pour voir ces details
And Je scrolle sur la page pour choisir un produit
Then Je me redirige vers la page du produit

@apparelshoes_sortByName
Scenario: Je Souhaite scroller sur la page des produits de l'application Web Demo Shop

When Je clique sur sort by je vois une liste deroulante qui est par defaut position je choisis Name Z to A




