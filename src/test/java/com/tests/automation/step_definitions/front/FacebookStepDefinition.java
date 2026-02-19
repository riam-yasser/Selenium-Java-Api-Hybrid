package com.tests.automation.step_definitions.front;

import com.tests.automation.page_objects.FacebookPage;
import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.actions.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookStepDefinition {

	FacebookPage facebookPage = new FacebookPage();
    ActionsUtils actionsUtils = new ActionsUtils();
	Validations validations = new Validations();

	@When("Je click sur le boutton Facebook")
	public void jeClickSurLeBouttonFacebook() {
	    actionsUtils.click(FacebookPage.getFacebookButton());
	}
	
	@Then("Je me redirige vers La page Facebook de l'application")
	public void jeMeRedirigeVersLaPageFacebookDeLApplication() {
	 
	}



}
