package com.tests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class BooksPage extends BasePage {

	/*
	 * Retrieve Web element 
	 */
	@FindBy(how = How.XPATH, using = "//ul[@class='top-menu']//a[normalize-space()='Books']")
	private static WebElement booksBarMenu;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1")
	private static WebElement booksTitle;
	
	@FindBy(how = How.XPATH, using = "//div[@class='master-wrapper-content']//div[1]//div[1]//div[2]//div[3]//div[2]//input[1]")
	private static WebElement addToCartButton;
	
	@FindBy(how = How.CSS, using = ".content")
	private static WebElement messageConfirmation;
	
	@FindBy(how = How.CSS, using = "p[class='content'] a")
	private static WebElement shopCartButton;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1")
	private static WebElement cartTitle;
	
	@FindBy(how = How.CSS, using = "div[id='terms-of-service-warning-box'] p")
	private static WebElement alertMessage;
	
	@FindBy(how = How.CSS, using = ".ui-button-icon-primary.ui-icon.ui-icon-closethick")
	private static WebElement closeButtonAlert;
	
	@FindBy(how = How.CSS, using = "#termsofservice")
	private static WebElement termsOfServiceCheckbox;
	
	@FindBy(how = How.CSS, using = "#checkout")
	private static WebElement checkoutButton;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1 ")
	private static WebElement loginPageRedirection;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1 ")
	private static WebElement checkoutPageRedirection;
	
	@FindBy(how = How.CSS, using = "#billing-address-select")
	private static WebElement billingAddress;
	
	@FindBy(how = How.CSS, using = "input[onclick='Billing.save()']")
	private static WebElement continueBilling;
	
	@FindBy(how = How.CSS, using = "#shipping-address-select")
	private static WebElement shippingAddress;
	
	@FindBy(how = How.CSS, using = "input[onclick='Shipping.save()']")
	private static WebElement continueShipping;
	
	@FindBy(how = How.CSS, using = "#shippingoption_1")
	private static WebElement shippingOptionsMethod;
	
	@FindBy(how = How.CSS, using = "input[class='button-1 shipping-method-next-step-button']")
	private static WebElement continueShippingMethods;
	
	@FindBy(how = How.CSS, using = "#paymentmethod_1")
	private static WebElement paymentOptionsMethod;
	
	@FindBy(how = How.CSS, using = "input[class='button-1 payment-method-next-step-button']")
	private static WebElement continuePayementMethods;
	
	@FindBy(how = How.CSS, using = "tbody tr td p")
	private static WebElement paymentInformationsMessage;
	
	@FindBy(how = How.CSS, using = "input[class='button-1 payment-info-next-step-button']")
	private static WebElement continuePayementInformations;
	
	@FindBy(how = How.CSS, using = "#checkout-step-confirm-order")
	private static WebElement confirmOrderList;
	
//	@FindBy(how = How.CSS, using = "input[value='Confirm']")
//	private static WebElement confirmButton;
	
	public BooksPage() {
		super(Setup.getDriver());
	}
	
	public static WebElement getBooksBarMenu() {
		return booksBarMenu;
	}

	public static WebElement getBooksTitle() {
		return booksTitle;
	}
	
	public static WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public static WebElement getMessageConfirmation() {
        waitForVisibility(messageConfirmation, 30);
        return messageConfirmation;
	}
	
	public static WebElement getShopCartButton() {
		return shopCartButton;
	}
	
	public static WebElement getCartTitle() {
		return cartTitle;
	}
			
	public static WebElement getAlertMessage() {
		return alertMessage;
	}
	
	public static WebElement getCloseButtonAlert() {
		return closeButtonAlert;
	}
	public static WebElement getTermsOfServiceCheckbox() {
		return termsOfServiceCheckbox;
	}
	
	public static WebElement getCheckoutButton() {
		return checkoutButton;
	}
			
	public static WebElement getLoginPageRedirection() {
		return loginPageRedirection;
	}

	public static WebElement getCheckoutPageRedirection() {
		return checkoutPageRedirection;
	}
	
	public static WebElement getBillingAddress() {
		return billingAddress;
	}
	
	public static WebElement getContinueBilling() {
		return continueBilling;
	}
	
	public static WebElement getShippingAddress() {
        waitForVisibility(shippingAddress, 30);
        return shippingAddress;
	}
	
	public static WebElement getContinueShipping() {
		return continueShipping;
	}
	
	public static WebElement getShippingOptionsMethod() {
        waitForVisibility(shippingOptionsMethod, 30);
        return shippingOptionsMethod;
	}
	
	public static WebElement getContinueShippingMethods() {
		return continueShippingMethods;
	}
	
	public static WebElement getPaymentOptionsMethod() {
        waitForVisibility(paymentOptionsMethod, 30);
        return paymentOptionsMethod;
	}
	
	public static WebElement getContinuePayementMethods() {
		return continuePayementMethods;
	}
	
	public static WebElement getPaymentInformationsMessage() {
        waitForVisibility(paymentInformationsMessage, 30);
        return paymentInformationsMessage;
	}
	
	public static WebElement getContinuePayementInformations() {
        waitForVisibility(continuePayementInformations, 30);
        return continuePayementInformations;
	}
	
	public static WebElement getConfirmOrderList() {
        waitForVisibility(confirmOrderList, 30);
        return confirmOrderList;
	}
	
}
