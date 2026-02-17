package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.ApparelAndShoesPage;
import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.actions.SelectFromListUtils;
import com.tests.automation.actions.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApparelAndShoesStepDefinition {

	ApparelAndShoesPage apprAndShoesPage = new ApparelAndShoesPage();
	Validations validations = new Validations();
    ActionsUtils actionsUtils = new ActionsUtils();
	SelectFromListUtils selectFromListUtils = new SelectFromListUtils();

	@When("Je click sur le boutton apparel&shoes")
	public void jeClickSurLeBouttonApparelShoes() {
		actionsUtils.click(ApparelAndShoesPage.getApparelAndShoesBarMenu());
	}

	@When("Je vois la liste des produits")
	public void jeVoisLaListeDesProduits() {
		ApparelAndShoesPage.getApparelTitle();
	}

	@When("Je clique sur un produit pour voir ces details")
	public void jeCliqueSurUnProduitPourVoirCesDetails() {
		actionsUtils.click(ApparelAndShoesPage.getProductInfosTitle());
	}

	@Then("Je me redirige vers la page du produit")
	public void jeMeRedirigeVersLaPageDuProduit() {
		ApparelAndShoesPage.getProductInfos();
	}

	@Then("Je click sur le boutton add to wishlists")
	public void jeClickSurLeBouttonAddToWishlists() {
		actionsUtils.click(ApparelAndShoesPage.getAddToWishListButton());
	}

	@When("Je selectionne une taille qui se trouve dans la liste deroulante")
	public void jeSelectionneUneTailleQuiSeTrouveDansLaListeDeroulante() {
		selectFromListUtils.selectDropDownListByVisibleText(ApparelAndShoesPage.getChooseSize(), "9");
	}

	@When("Je choisis la couleur du produit souhaitee")
	public void jeChoisisLaCouleurDuProduitSouhaitee() {
		actionsUtils.click(ApparelAndShoesPage.getChooseColor());
		validations.assertElementColor(ApparelAndShoesPage.getChooseColor(), "#000000");

	}

	@Then("Je click sur le boutton add review")
	public void jeClickSurLeBouttonAddReview() {
		actionsUtils.click(ApparelAndShoesPage.getAddReviewButton());
	}

	@Then("Je click sur le boutton add to cart")
	public void jeClickSurLeBouttonAddToCart() {
		actionsUtils.click(ApparelAndShoesPage.getAddToCartButton());
	}

	@Then("Je me redirige vers la page des reviews")
	public void jeMeRedirigeVersLaPageDesReviews()  {
		ApparelAndShoesPage.getReviewTitlePage();
	}

	@When("Je scrolle sur la page pour choisir un produit")
	public void jeScrolleSurLaPagePourChoisirUnProduit() throws InterruptedException {
	    Thread.sleep(500);
		actionsUtils.scrollToElementAndClick(ApparelAndShoesPage.getElementScrolled());
		Thread.sleep(50);
	}


	@When("Je clique sur sort by je vois une liste deroulante qui est par defaut position je choisis Name Z to A")
	public void jeCliqueSurSortByJeVoisUneListeDeroulanteQuiEstParDefautPositionJeChoisisNameZToA() {
        selectFromListUtils.selectDropDownListByIndex(ApparelAndShoesPage.getDropDownSortBy(), 2);
	}



}
