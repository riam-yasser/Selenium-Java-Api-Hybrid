package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.LogoutPage;
import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.actions.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition {

	LogoutPage logoutPage = new LogoutPage();
    ActionsUtils actionsUtils = new ActionsUtils();
	Validations validations = new Validations();
	
	
	@When("Je clique sur le bouton Logout")
	public void jeCliqueSurLeBoutonLogout() {
		// LogoutPage.getLogoutButton().click();
		actionsUtils.click(LogoutPage.getLogoutButton());
	}
	
	@Then("Je me redirige vers la page home login {string}")
	public void jeMeRedirigeVersLaPageHomeLogin(String login) {
		validations.assertEquals(LogoutPage.getLoginPage(), login);
	}

}
