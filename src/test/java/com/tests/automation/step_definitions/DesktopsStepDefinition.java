package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.DesktopsPage;
import com.tests.automation.actions.ActionsUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DesktopsStepDefinition {

	DesktopsPage desktopsPage = new DesktopsPage();
    ActionsUtils actionsUtils = new ActionsUtils();
	
	@When("Je me positionne sur la bar menu des computers je vois la liste deroulante des choix des computers")
	public void jeMePositionneSurLaBarMenuDesComputersJeVoisLaListeDeroulanteDesChoixDesComputers() {
		actionsUtils.mouseHover(DesktopsPage.getComputersBarMenuButton());
	}
	
	@When("Je choisis Desktops")
	public void jeChoisisDesktops() {
	    actionsUtils.click(DesktopsPage.getDesktopsButton());
	}
	
	@Then("Je me redirige vers la page des Desktops")
	public void jeMeRedirigeVersLaPageDesDesktops() {
	    DesktopsPage.getDesktopsListProductPage();
	}
	
	@Then("Je choisis un produit et je click pour rediriger vers product page")
	public void jeChoisisUnProduitEtJeClickPourRedirigerVersProductPage() {
		actionsUtils.scrollToElementAndClick(DesktopsPage.getDesktopsProductsChoiceButton());
	}
	
	@Then("Je vois une alerte que le processeur n'est pas selectionner")
	public void jeVoisUneAlerteQueLeProcesseurNEstPasSelectionner() {
	    DesktopsPage.getAlertMessage();
	}

	@Then("Je dois fermer la notification du message d'alerte")
	public void jeDoisFermerLaNotificationDuMessageDAlerte() {
	    actionsUtils.click(DesktopsPage.getCloseAlertMessage());
	}

	@When("Je coche sur un processeur")
	public void jeCocheSurUnProcesseur() {
		if (!DesktopsPage.getProcessorCheckBox().isSelected()) {
			actionsUtils.click(DesktopsPage.getProcessorCheckBox());
	    }
	}





}
