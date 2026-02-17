package com.tests.automation.step_definitions;

import com.tests.automation.actions.ActionsUtils;
import com.tests.automation.actions.Validations;
import com.tests.automation.page_objects.LoginPage;
import com.tests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    private final ActionsUtils actionsUtils;
	private final ConfigFileReader configFileReader;

    Validations validations = new Validations();

	public LoginStepDefinition() {
        LoginPage loginPage = new LoginPage();
		actionsUtils = new ActionsUtils();
		configFileReader = new ConfigFileReader();
	}

	/* TC_01 */
    @Given("Je me connecte sur le site Web Demo Shop")
    public void jeMeConnecteSurLeSiteWebDemoShop() {
        actionsUtils.get(configFileReader.getProperty("home.url"));
    }

    @When("Je clique sur le bouton Log in")
    public void jeCliqueSurLeBoutonLogIn() {
        actionsUtils.click(LoginPage.getLoginBarMenu());
    }

    @When("Je saisis une adresse mail")
    public void jeSaisisUneAdresseMail() {
        actionsUtils.writeText(LoginPage.getEmailField(), configFileReader.getProperty("home.email"));
    }

    @When("Je saisis un mot de passe")
    public void jeSaisisUnMotDePasse() {
        actionsUtils.writeText(LoginPage.getPasswordField(), configFileReader.getProperty("home.password"));
    }

    @When("Je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        actionsUtils.click(LoginPage.getBtnLogin());
    }

    @Then("Je me redirige vers la page home {string}")
    public void jeMeRedirigeVersLaPageHome(String email) throws InterruptedException {
        Assert.assertTrue("User Address Found", new LoginPage().getUserNameAddress());
        Thread.sleep(5000);
    }

    @When("Je saisis une adresse mail {string}")
    public void jeSaisisUneAdresseMail(String email) {
        actionsUtils.writeText(LoginPage.getEmailField(), email);
    }

    @When("Je saisis un mot de passe {string}")
    public void jeSaisisUnMotDePasse(String password) {
        actionsUtils.writeText(LoginPage.getPasswordField(), password);
    }

    @Then("Je visualise le message d'erreur {string}")
    public void jeVisualiseLeMessageDErreur(String expected) throws InterruptedException {
        validations.assertEquals(LoginPage.getErrorMessage(), expected);
    }
}
