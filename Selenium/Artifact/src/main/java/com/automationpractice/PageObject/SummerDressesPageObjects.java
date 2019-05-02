package com.automationpractice.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Base.BaseUtil;
import Util.Selenium;

public class SummerDressesPageObjects extends BaseUtil{

	BaseUtil base;
	final WebDriver driver;
	final String title = "Summer Dresses - My Store";
	Selenium selenium;
	
	public SummerDressesPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		selenium = new Selenium(driver);
	}
	
	@FindBy(how = How.XPATH, using = ".//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line last-line first-item-of-tablet-line last-item-of-mobile-line last-mobile-line']")
	public WebElement printedShiffonDress;
	
	@FindBy(how = How.XPATH, using = ".//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-in-line last-line first-item-of-tablet-line last-item-of-mobile-line last-mobile-line hovered']//a[@class='quick-view']")
	public WebElement quickView;
	
	@FindBy(how = How.XPATH, using = "//select[@id='group_1']")
	public WebElement size;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add to cart')]")
	public WebElement addToCart;
	
	@FindBy(how = How.XPATH, using = "//span[@class='continue btn btn-default button exclusive-medium']")
	public WebElement continueShopping;
	
	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Printed Chiffon Dress')]")
	public WebElement printedChifonDressProductDetails;
	
	@FindBy(how = How.XPATH, using = "//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]")
	public WebElement productSuccessfullyAdded;
	
	@FindBy(xpath = "//b[contains(text(),'Cart')]")
	public WebElement cart;
	
	@FindBy(xpath = ".//a[@id='button_order_cart']")
	public WebElement checkOut;
	
	
	public void verifyItIsSummerDressesPage(){
			assertThat(driver.getTitle().toString(), equalToIgnoringCase(title));
	}
	
	public void clickQuickViewPrintedShiffon(){
		selenium.moveToElement(printedShiffonDress);
		quickView.click();
	}
	
	public void selectSize(String size){
		Select select = new Select(this.size);
		this.size.click();
		select.selectByVisibleText(size);
	}
	
	public void addToCartFromQuickView(){
		addToCart.click();
	}
	public void clickContinueShopping(){
		selenium.waitUntilClickableThenClickUsingJS(continueShopping);
	}
	public void verifyPrintedChifonDressProductDetailsOpens(){
		selenium.waitUntilElementInvisible(addToCart);
		driver.switchTo().frame(0);
		assertTrue(printedChifonDressProductDetails.isDisplayed());
	}
	
	public void verifyProductSuccessfullyAdded(){
		selenium.waitUntilElementVisible(productSuccessfullyAdded);
	}
	
	public void clickCheckoutFromCart(){
		selenium.moveToElement(cart);
		selenium.waitUntilVisibleAndClickUsingActions(checkOut);
	}
}
