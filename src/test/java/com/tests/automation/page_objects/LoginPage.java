package com.tests.automation.page_objects;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage extends BasePage {

	/* Retrieve Web Element */
    @FindBy(how = How.CSS, using = ".ico-login")
    private static WebElement loginBarMenu;

	@FindBy(how = How.ID, using = "Email")
	private static WebElement emailField;

	@FindBy(how = How.ID, using = "Password")
	private static WebElement passwordField;

	@FindBy(how = How.XPATH, using = "//input[@value='Log in']")
	private static WebElement btnLogin;

	@FindBy(how = How.XPATH, using = "//a[normalize-space()='ziedhannachi0@gmail.com']")
	private static WebElement toolbarItemUser;

    @FindBy(how = How.CSS, using = "div[class='validation-summary-errors'] span")
    private static WebElement errorMessage;


	public LoginPage() {
		super(Setup.getDriver());
	}

	public static WebElement getEmailField() {
		waitForElementToBeVisible(emailField);
		return emailField;
	}

	public static WebElement getPasswordField() {
		waitForElementToBeVisible(passwordField);
		return passwordField;
	}

	public static WebElement getBtnLogin() {
		waitForElementToBeClickable(btnLogin);
		return btnLogin;
	}

	public boolean getUserNameAddress() {
		return find(toolbarItemUser, 1000);
	}

    public static WebElement getErrorMessage() {
        return errorMessage;
    }

    public static WebElement getLoginBarMenu() {
       // waitForElementToBeClickable(loginBarMenu);
        return loginBarMenu;
    }

}
