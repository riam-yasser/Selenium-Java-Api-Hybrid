package com.tests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class NoteBooksPage extends BasePage {

	/*
	 * Retrieve Web element 
	 */
	@FindBy(how = How.XPATH, using = "//ul[@class='top-menu']//a[normalize-space()='Computers']")
	private static WebElement computersBarMenuButton;
	
	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Notebooks']")
	private static WebElement noteBooksPage;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='top-menu']//a[normalize-space()='Notebooks']")
	private static WebElement noteBooksButton;
	
	public NoteBooksPage() {
		super(Setup.getDriver());
		// TODO Auto-generated constructor stub
	}

	public static WebElement getComputersBarMenuButton() {
		return computersBarMenuButton;
	}

	public static WebElement getNoteBooksPage() {
		return noteBooksPage;
	}
	
	public static WebElement getNoteBooksButton() {
		return noteBooksButton;
	}
	

}
