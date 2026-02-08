package com.tests.automation.step_definitions;

import com.tests.automation.actions.SeleniumUtils;
import com.tests.automation.actions.Validations;
import com.tests.automation.page_objects.LoginPage;
import com.tests.automation.utils.ConfigFileReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinition {

    private final SeleniumUtils seleniumUtils;
	private final ConfigFileReader configFileReader;

    Validations validations = new Validations();

	public LoginStepDefinition() {
        LoginPage loginPage = new LoginPage();
		seleniumUtils = new SeleniumUtils();
		configFileReader = new ConfigFileReader();
	}

	/* TC_01 *//*
	@Etantdonnéque("Je suis sur la page de connexion de l'application EasyGes")
	public void iAmOnTheLoginPage() throws InterruptedException {
		seleniumUtils.get(configFileReader.getProperty("home.d"));
		Thread.sleep(5000);
	}
	@Quand("Je saisis une adresse mail {string}")
	public void iFillAUserName(String email) {
		seleniumUtils.writeText(LoginPage.getUsername(), email);
	}

	@Quand("Je saisis un mot de passe {string}")
	public void iFillAPassword(String password) {
		seleniumUtils.writeText(LoginPage.getPasswordField(), password);
	}

	@Quand("Je clique sur le bouton Log in")
	public void iClickOnTheLoginButton() {
		seleniumUtils.click(LoginPage.getBtnLogin());
	}

	@Alors("Je suis redirigé vers la page d'accueil avec l'adresse {string}")
	public void iAmOnTheHomePage(String address) throws InterruptedException {
		Assert.assertTrue("User Address Found", new LoginPage().getUserNameAddress());
		Thread.sleep(5000);
	}*/

    @Given("Je me connecte sur le site Web Demo Shop")
    public void jeMeConnecteSurLeSiteWebDemoShop() {
        seleniumUtils.get(configFileReader.getProperty("home.url"));
    }

    @When("Je clique sur le bouton Log in")
    public void jeCliqueSurLeBoutonLogIn() {
        seleniumUtils.click(LoginPage.getLoginBarMenu());
    }

    @When("Je saisis une adresse mail")
    public void jeSaisisUneAdresseMail() {
        seleniumUtils.writeText(LoginPage.getEmailField(), configFileReader.getProperty("home.email"));
    }

    @When("Je saisis un mot de passe")
    public void jeSaisisUnMotDePasse() {
        seleniumUtils.writeText(LoginPage.getPasswordField(), configFileReader.getProperty("home.password"));
    }

    @When("Je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        seleniumUtils.click(LoginPage.getBtnLogin());
    }

    @Then("Je me redirige vers la page home {string}")
    public void jeMeRedirigeVersLaPageHome(String email) throws InterruptedException {
        Assert.assertTrue("User Address Found", new LoginPage().getUserNameAddress());
        Thread.sleep(5000);
    }

    @When("Je saisis une adresse mail {string}")
    public void jeSaisisUneAdresseMail(String email) {
        seleniumUtils.writeText(LoginPage.getEmailField(), email);
    }

    @When("Je saisis un mot de passe {string}")
    public void jeSaisisUnMotDePasse(String password) {
        seleniumUtils.writeText(LoginPage.getPasswordField(), password);
    }

    @Then("Je visualise le message d'erreur {string}")
    public void jeVisualiseLeMessageDErreur(String expected) throws InterruptedException {
        validations.assertEquals(LoginPage.getErrorMessage(), expected);
    }
}
