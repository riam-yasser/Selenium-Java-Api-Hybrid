package com.tests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class DesktopsPage extends BasePage {

	/*
	 * Retrieve Web element 
	 */
	@FindBy(how = How.XPATH, using = "//ul[@class='top-menu']//a[normalize-space()='Computers']")
	private static WebElement computersBarMenuButton;
	
	@FindBy(how = How.XPATH, using = "//ul[@class='top-menu']//a[normalize-space()='Desktops']")
	private static WebElement desktopsButton;
	
	@FindBy(how = How.XPATH, using = "//h1[normalize-space()='Desktops']")
	private static WebElement desktopsListProductPage;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Simple Computer']")
	private static WebElement desktopsProductsChoiceButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='add-to-cart-button-75']")
	private static WebElement addToCartButton;
	
	@FindBy(how = How.CSS, using = ".content")
	private static WebElement alertMessage;
	
	@FindBy(how = How.CSS , using = "span[title='Close']")
	private static WebElement closeAlertMessage;
	
	@FindBy(how = How.CSS , using = "#product_attribute_75_5_31_96")
	private static WebElement processorCheckBox;
	
	@FindBy(how = How.CSS , using = "p[class='content'] a")
	private static WebElement shoppingCartButton;

	public DesktopsPage() {
		super(Setup.getDriver());
	}

	public static WebElement getComputersBarMenuButton() {
		return computersBarMenuButton;
	}

	public static WebElement getDesktopsButton() {
		return desktopsButton;
	}
	
	public static WebElement getDesktopsListProductPage() {
		return desktopsListProductPage;
	}

	public static WebElement getDesktopsProductsChoiceButton() {
		return desktopsProductsChoiceButton;
	}
	
	public static WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public static WebElement getAlertMessage() {
        waitForVisibility(alertMessage, 10);
        return alertMessage;
	}
	
	public static WebElement getCloseAlertMessage() {
		return closeAlertMessage;
	}
	
	public static WebElement getProcessorCheckBox() {
		return processorCheckBox;
	}
	
	public static WebElement getShoppingCartButton() {
		return shoppingCartButton;
	}
	
	

}
