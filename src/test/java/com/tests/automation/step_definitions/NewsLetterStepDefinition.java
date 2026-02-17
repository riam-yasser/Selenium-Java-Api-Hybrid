package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.NewsLetterPage;
import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.utils.ConfigFileReader;
import com.tests.automation.actions.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewsLetterStepDefinition {

	NewsLetterPage newsLetterPage = new NewsLetterPage();
	ConfigFileReader configFileReader = new ConfigFileReader();
	Validations validations = new Validations();
    ActionsUtils actionsUtils = new ActionsUtils();

	@When("Je me redirige vers la rubrique newsletter")
	public void jeMeRedirigeVersLaRubriqueNewsletter() {
		NewsLetterPage.getNewsLetterBarMenu();
	}
	
	@When("Je saisis une adresse mail valide")
	public void jeSaisisUneAdresseMailValide() {
		NewsLetterPage.getEmailField().sendKeys(configFileReader.getProperty("home.email"));
	}
	
	@When("Je clique sur le bouton subscribe")
	public void jeCliqueSurLeBoutonSubscribe() {
		NewsLetterPage.getSubscribeButton().click();
	}
	
	@Then("Je vois un msg de confirmation {string}")
	public void jeVoisUnMsgDeConfirmation(String message) {
	      NewsLetterPage.getConfirmationMessage();
		  validations.assertEquals(NewsLetterPage.getConfirmationMessage(), message);

	}
}
