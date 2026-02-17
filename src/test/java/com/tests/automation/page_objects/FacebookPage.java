package com.tests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class FacebookPage extends BasePage {

	/*
	 * Retrieve Web element 
	 */
	
	@FindBy(how = How.CSS, using = "a[href='http://www.facebook.com/nopCommerce']")
	private static WebElement facebookButton;

	
	@FindBy(how = How.CSS, using = ".ico-login")
	private static WebElement facebookPage;
	
	
	public FacebookPage() {
		super(Setup.getDriver());
	}
	

	public static WebElement getFacebookButton() {
		return facebookButton;
	}
	
	public static WebElement getFacebookPage() {
		return facebookPage;
	}
	

}
