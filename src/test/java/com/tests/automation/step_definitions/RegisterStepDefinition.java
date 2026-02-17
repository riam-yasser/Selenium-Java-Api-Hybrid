package com.tests.automation.step_definitions;

import com.tests.automation.page_objects.RegisterPage;
import com.tests.automation.actions.Validations;
import com.tests.automation.actions.ActionsUtils;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepDefinition {

	RegisterPage registerPage = new RegisterPage();
	ActionsUtils actionsUtils = new ActionsUtils();
	Validations validations = new Validations();


	@When("Je clique sur le bouton Register dans la bar menu")
	public void jeCliqueSurLeBoutonRegisterDansLaBarMenu() {
		actionsUtils.click(RegisterPage.getRegisterBarMenu());
	}

	@When("Je choisis le gender")
	public void jeChoisisLeGender() {
		if (!RegisterPage.getGenderChoice().isSelected()) {
			actionsUtils.click(RegisterPage.getGenderChoice());
		}
	}

	@When("Je saisis un first name")
	public void jeSaisisUnFirstName() {
		actionsUtils.writeText(RegisterPage.getFirstNameField(), "Yasser");
	}

	@When("Je saisis un last name")
	public void jeSaisisUnLastName() {
		actionsUtils.writeText(RegisterPage.getLastNameField(), "Yass");
	}

	@When("Je saisis une adresse mail correcte")
	public void jeSaisisUneAdresseMailCorrecte() {
		actionsUtils.writeText(RegisterPage.getEmailField(), "runhpietk.a.chsoe.t@gmail.com");
	}

	@When("Je saisis un Mot de passe")
	public void jeSaisisUnMotDePasse() {
		actionsUtils.writeText(RegisterPage.getPasswordField(), "Yasser123");
	}

	@When("Je saisis une autre fois le mot de passe pour le confirmer")
	public void jeSaisisUneAutreFoisLeMotDePassePourLeConfirmer() {
		actionsUtils.writeText(RegisterPage.getConfirmPasswordField(), "Yasser123");
	}

	@When("Je clique sur le bouton Register")
	public void jeCliqueSurLeBoutonRegister() {
		actionsUtils.click(RegisterPage.getRegisterButton());
	}

	@Then("Je visualise le message de succes d'inscription {string}")
	public void jeVisualiseLeMessageDeSuccesDInscription(String string) {
		validations.assertEquals(RegisterPage.getSuccessMessage(), string);
	}

	@When("Je click sur le boutton continue")
	public void jeClickSurLeBouttonContinue() {
		actionsUtils.click(RegisterPage.getContinueButton());
	}

	@Then("Je me redirige vers la page home")
	public void jeMeRedirigeVersLaPageHome() {
		RegisterPage.getHomePage();
	}


	@When("Je choisis le gender {string}")
	public void jeChoisisLeGender(String string) {
		if (!RegisterPage.getGenderChoice().isSelected()) {
			actionsUtils.click(RegisterPage.getGenderChoice());
	    }
	}

	@When("Je saisis un first name {string}")
	public void jeSaisisUnFirstName(String string) {
		actionsUtils.writeText(RegisterPage.getFirstNameField(), string);
	}

	@When("Je saisis un last name {string}")
	public void jeSaisisUnLastName(String string) {
		actionsUtils.writeText(RegisterPage.getLastNameField(), string);

	}

	@When("Je saisis une autre fois le mot de passe pour le confirmer {string}")
	public void jeSaisisUneAutreFoisLeMotDePassePourLeConfirmer(String string) {
		actionsUtils.writeText(RegisterPage.getConfirmPasswordField(), string);
	}

	@Then("Je visualise le message d'erreur pour les validations {string}")
	public void jeVisualiseLeMessageDErreurPourLesValidations(String errorMessage) {
	    validations.assertTrue(RegisterPage.isErrorMessageDisplayed(errorMessage), errorMessage);
	}

}
