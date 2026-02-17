package com.tests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.tests.automation.base.BasePage;
import com.tests.automation.hooks.Setup;

public class ApparelAndShoesPage extends BasePage{

	/*
	 * Retrieve Web element 
	 */
	@FindBy(how = How.CSS, using = "ul[class='top-menu'] li:nth-child(4) a:nth-child(1)")
	private static WebElement apparelAndShoesBarMenu;
	
	@FindBy(how = How.CSS, using = "div[class='page-title'] h1")
	private static WebElement apparelTitle;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Blue and green Sneaker']")
	private static WebElement productInfosTitle;
	
	@FindBy(how = How.CSS, using = "h1[itemprop='name']")
	private static WebElement productInfos;
	
	@FindBy(how = How.CSS, using = "#add-to-wishlist-button-28") 
	private static WebElement addToWishListButton;
	
	@FindBy(how = How.CSS, using = "#add-to-cart-button-28") 
	private static WebElement addToCartButton;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Add your review']") 
	private static WebElement addReviewButton;
	
	@FindBy(how = How.CSS, using = "#product_attribute_28_7_10") 
	private static WebElement chooseSize;
	
	@FindBy(how = How.CSS, using = "span[title='Black'] span[class='color']") 
	private static WebElement chooseColor;
	
	@FindBy(how = How.CSS, using = "div[id='review-form'] strong") 
	private static WebElement reviewTitlePage;
	
	@FindBy(how = How.CSS, using = "div:nth-child(7) div:nth-child(1) div:nth-child(2) h2:nth-child(1) a:nth-child(1)") 
	private static WebElement elementScrolled;
	
	@FindBy(how = How.CSS, using = "#products-orderby") 
	private static WebElement dropDownSortBy;
	
	public ApparelAndShoesPage() {
		super(Setup.getDriver());
	} 
	
	public static WebElement getApparelAndShoesBarMenu() {
		return apparelAndShoesBarMenu;
	}

	public static WebElement getApparelTitle() {
		return apparelTitle;
	}
	
	public static WebElement getProductInfosTitle() {
		return productInfosTitle;
	}
	
	public static WebElement getProductInfos() {
		return productInfos;
	}
	
	public static WebElement getAddToWishListButton() {
		return addToWishListButton;
	}

	public static WebElement getAddReviewButton() {
		return addReviewButton;
	}
	
	public static WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public static WebElement getChooseSize() {
		return chooseSize;
	}
	
	public static WebElement getChooseColor() {
		return chooseColor;
	}
	
	public static WebElement getReviewTitlePage() {
        waitForElementToBeVisible(reviewTitlePage);
        return reviewTitlePage;
	}
	
	public static WebElement getElementScrolled() {
		return elementScrolled;
	}
	
	public static WebElement getDropDownSortBy() {
		return dropDownSortBy;
	}
}
