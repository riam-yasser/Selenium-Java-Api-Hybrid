package com.tests.automation.page_objects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class RegisterPage extends BasePage {

	/*
	 * Retrieve Web element 
	 */
	@FindBy(how = How.CSS, using = ".ico-register")
	private static WebElement registerBarMenu;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1")
	private static WebElement registerPage;
	
	@FindBy(how = How.XPATH, using = "//input[@id='gender-male']")
	private static WebElement genderChoice;
	
	@FindBy(how = How.XPATH, using = "//input[@id='FirstName']")
	private static WebElement firstNameField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='LastName']")
	private static WebElement lastNameField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	private static WebElement emailField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	private static WebElement passwordField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='ConfirmPassword']")
	private static WebElement confirmPasswordField;
	
	@FindBy(how = How.CSS, using = "#register-button")
	private static WebElement registerButton;
	
	@FindBy(how = How.CSS, using = ".result")
	private static WebElement successMessage;
	
	@FindBy(how = How.CSS, using = "input[value='Continue']")
	private static WebElement continueButton;
	
	@FindBy(how = How.XPATH, using = "div[class='header-links'] a[class='account']")
	private static WebElement homePage;
	
	@FindBy(how = How.CSS, using = "span.field-validation-error")
	private static List<WebElement> errorMessage;
	
	public RegisterPage() {
		super(Setup.getDriver());
	}
	
	public static WebElement getRegisterBarMenu() {
		return registerBarMenu;
	}
	
	public static WebElement getRegisterPage() {
		return registerPage;
	}
	
	public static WebElement getGenderChoice() {
		return genderChoice;
	}
	
	public static WebElement getFirstNameField() {
		return firstNameField;
	}
	
	public static WebElement getLastNameField() {
		return lastNameField;
	}

	public static WebElement getEmailField() {
		return emailField;
	}
	
	public static WebElement getPasswordField() {
		return passwordField;
	}
	
	public static WebElement getConfirmPasswordField() {
		return confirmPasswordField;
	}
	
	public static WebElement getRegisterButton() {
		return registerButton;
	}
	
	public static WebElement getSuccessMessage() {
		return successMessage;
	}
	
	public static WebElement getContinueButton() {
		return continueButton;
	}
	
	public static WebElement getHomePage() {
		return homePage;
	}
	
	//List of error message for each field
	public static boolean isErrorMessageDisplayed(String expectedMessage) {

	    return errorMessage
	            .stream()
	            .map(e -> e.getText().trim())
	            .anyMatch(msg -> msg.equals(expectedMessage));
	}



}
