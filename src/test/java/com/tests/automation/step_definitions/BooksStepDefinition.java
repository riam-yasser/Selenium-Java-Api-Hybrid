package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.ApparelAndShoesPage;
import com.tests.automation.page_objects.BooksPage;
import com.tests.automation.page_objects.DesktopsPage;
import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.actions.SelectFromListUtils;
import com.tests.automation.actions.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BooksStepDefinition {

	BooksPage booksPage = new BooksPage();
    ActionsUtils actionsUtils = new ActionsUtils();
	Validations validations = new Validations();
	SelectFromListUtils selectFromListUtils = new SelectFromListUtils();
	
	@When("Je clique sur le boutton Books")
	public void jeCliqueSurLeBouttonBooks() {
		actionsUtils.click(BooksPage.getBooksBarMenu());
	}

	@Then("Je vois l'affichage des cahiers dans l'application")
	public void jeVoisLAffichageDesCahiersDansLApplication() {
		BooksPage.getBooksTitle();
	}

	// books add to cart
	@When("Je click sur le boutton add to cart {string}")
	public void jeClickSurLeBouttonAddToCart(String page) {
		
		 if (page.equalsIgnoreCase("books")) {
		        actionsUtils.click(BooksPage.getAddToCartButton());
		    } else if (page.equalsIgnoreCase("apparel")) {
		    	actionsUtils.click(ApparelAndShoesPage.getAddToCartButton());
		    } else if (page.equalsIgnoreCase("desktops")) {
		    	actionsUtils.click(DesktopsPage.getAddToCartButton());
			}
		actionsUtils.click(BooksPage.getAddToCartButton());
	}

	@When("je vois le message que le produit est ajoutee sur le panier {string}")
	public void jeVoisLeMessageQueLeProduitEstAjouteeSurLePanier(String message) {
		validations.assertEquals(BooksPage.getMessageConfirmation(),message);
	}

	@When("je click sur le boutton shopping cart")
	public void jeClickSurLeBouttonShoppingCart() {
		actionsUtils.click(BooksPage.getShopCartButton());
	}

	@Then("je vois la page du shopping cart")
	public void jeVoisLaPageDuShoppingCart() {
		BooksPage.getCartTitle();
	}
	
	//checkoutpage

	@When("Je clique sur le boutton shopping cart")
	public void jeCliqueSurLeBouttonShoppingCart() {
		actionsUtils.click(BooksPage.getShopCartButton());
	}

	@When("Je clique sur le boutton checkout")
	public void jeCliqueSurLeBouttonCheckout() {
		actionsUtils.click(BooksPage.getCheckoutButton());
	}

	@Then("Je vois le message d'alerte qu'il faut accepter les terms of use {string}")
	public void jeVoisLeMessageDAlerteQuIlFautAccepterLesTermsOfUse(String message) {
		validations.assertEquals(BooksPage.getAlertMessage(), message);
		}

	@When("Je ferme l'alerte terms of use") 
	public void jeFermeLAlerteTermsOfUse() { 
		actionsUtils.click(BooksPage.getCloseButtonAlert());
	  }

	@Then("Je coche sur la case accept terms of use")
	public void jeCocheSurLaCaseAcceptTermsOfUse()throws InterruptedException {
		if (!BooksPage.getTermsOfServiceCheckbox().isSelected()) {
			actionsUtils.click(BooksPage.getTermsOfServiceCheckbox());
	    }
	}
	
	@When("je click sur le boutton checkout")
	public void jeClickSurLeBouttonCheckout() {
		actionsUtils.click(BooksPage.getCheckoutButton());
	}
	
	@Then("Je me redirige vers la page d'authentification")
	public void jeMeRedirigeVersLaPageDAuthentification() throws InterruptedException {
		Thread.sleep(10);
		actionsUtils.click(BooksPage.getLoginPageRedirection());
		Thread.sleep(10);

	}
	
	//checkout steps

	@Then("Je me redirige vers la page du checkout")
	public void jeMeRedirigeVersLaPageDuCheckout() {
	    BooksPage.getCheckoutPageRedirection();
	}
	
	@Then("Je choisis une adresse de facturation depuis une liste deroulante si j'ai plusieurs adresse")
	public void jeChoisisUneAdresseDeFacturationDepuisUneListeDeroulanteSiJAiPlusieursAdresse() {
	    selectFromListUtils.selectDropDownListByIndex(BooksPage.getBillingAddress(), 0);
	}
	
	@Then("Je click sur le boutton continue de facturation")
	public void jeClickSurLeBouttonContinueDeFacturation() {
	   actionsUtils.click(BooksPage.getContinueBilling());
	}
	
	@Then("Je choisis une adresse de residence depuis une liste deroulante si j'ai plusieurs adresse")
	public void jeChoisisUneAdresseDeResidenceDepuisUneListeDeroulanteSiJAiPlusieursAdresse() {
	    selectFromListUtils.selectDropDownListByIndex(BooksPage.getShippingAddress(), 0);
	}
	
	@Then("Je click sur le boutton continue pour adresse de residence")
	public void jeClickSurLeBouttonContinuePourAdresseDeResidence() {
	    actionsUtils.click(BooksPage.getContinueShipping());
	}
	
	@Then("Je choisis une methode de livraison en cochant sur un radio button qui est par defaut Ground")
	public void jeChoisisUneMethodeDeLivraisonEnCochantSurUnRadioButtonQuiEstParDefautGround() {
		actionsUtils.click(BooksPage.getShippingOptionsMethod());
	}
	
	@Then("Je click sur le boutton continue pour methode de livraison")
	public void jeClickSurLeBouttonContinuePourMethodeDeLivraison() {
		actionsUtils.click(BooksPage.getContinueShippingMethods());
	}
	
	@Then("Je choisis une methode de paiement en cochant sur un radio button qui est par defaut Cash on delivery")
	public void jeChoisisUneMethodeDePaiementEnCochantSurUnRadioButtonQuiEstParDefautCashOnDelivery() {
		actionsUtils.click(BooksPage.getPaymentOptionsMethod());
	}
	
	@Then("Je click sur le boutton continue pour methode de paiement")
	public void jeClickSurLeBouttonContinuePourMethodeDePaiement() {
		actionsUtils.click(BooksPage.getContinuePayementMethods());
	}
	
	@Then("Je vois un message du mon choix de methode de paiement")
	public void jeVoisUnMessageDuMonChoixDeMethodeDePaiement() {
		BooksPage.getPaymentInformationsMessage();
	}
	
	@Then("Je click sur le boutton continue pour le message du choix de paiement")
	public void jeClickSurLeBouttonContinuePourLeMessageDuChoixDePaiement() {
		actionsUtils.click(BooksPage.getContinuePayementInformations());
	}
	
	@Then("Je vois une liste des informations que j'ai saisis dans tout le formulaire avec les produits dans mon panier")
	public void jeVoisUneListeDesInformationsQueJAiSaisisDansToutLeFormulaireAvecLesProduitsDansMonPanier() {
		BooksPage.getConfirmOrderList();
	}

}
