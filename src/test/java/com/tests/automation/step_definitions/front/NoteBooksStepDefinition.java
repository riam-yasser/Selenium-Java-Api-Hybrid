package com.tests.automation.step_definitions.front;

import com.tests.automation.page_objects.NoteBooksPage;
import com.tests.automation.actions.ActionsUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NoteBooksStepDefinition {

	NoteBooksPage noteBooksPage = new NoteBooksPage();
	ActionsUtils actionsUtils = new ActionsUtils();

	@When("Je positionne sur la bar menu des computers je vois la liste deroulante des choix des computers")
	public void jePositionneSurLaBarMenuDesComputersJeVoisLaListeDeroulanteDesChoixDesComputers() {
		actionsUtils.mouseHover(NoteBooksPage.getComputersBarMenuButton());
	}
	
	@When("Je choisis Notebooks")
	public void jeChoisisNotebooks() {
	    actionsUtils.click(NoteBooksPage.getNoteBooksButton());
	}

	@Then("Je me redirige vers la page des Notebooks")
	public void jeMeRedirigeVersLaPageDesNotebooks() {
		NoteBooksPage.getNoteBooksPage();
	}



}
