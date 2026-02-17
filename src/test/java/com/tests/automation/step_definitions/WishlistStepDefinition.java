package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.WishlistPage;
import com.tests.automation.actions.ActionsUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishlistStepDefinition {

	WishlistPage wishlistPage = new WishlistPage();
    ActionsUtils actionsUtils = new ActionsUtils();
	
	@When("Je click sur le boutton wishlist")
	public void jeClickSurLeBouttonWishlist() {
		actionsUtils.click(WishlistPage.getWishListBarMenuButton());

	}

	@Then("Je vois la liste des produits qui sont dans la wishlist")
	public void jeVoisLaListeDesProduitsQuiSontDansLaWishlist() {
		WishlistPage.getWishListPage();
	}

}
