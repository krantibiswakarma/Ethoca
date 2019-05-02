package Scenarios;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.automationpractice.PageObject.LandingPageObjects;
import com.automationpractice.PageObject.OrderPageObjects;
import com.automationpractice.PageObject.SummerDressesPageObjects;

import Util.Log;

public class CheckoutScenario {

	LandingPageObjects landingPageObjects;
	SummerDressesPageObjects summerDressesPageObjects;
	OrderPageObjects orderPageObjects;
	
	public CheckoutScenario(WebDriver driver){
		landingPageObjects = new LandingPageObjects(driver);
		summerDressesPageObjects = new SummerDressesPageObjects(driver);
		orderPageObjects = new OrderPageObjects(driver);
	}
	public void clickSummerDressesonWomenTab(){
		landingPageObjects.clickSummerDressesWomen();
	}
	
	public void verifyThatUserIsOnLandingPage(){
		landingPageObjects.verifyItIsLandingPage();
	}
	
	public void verifyUserIsOnSummerDressesPage(){
		summerDressesPageObjects.verifyItIsSummerDressesPage();
	}
	
	public void quickViewPrintedShiffon(){
		summerDressesPageObjects.clickQuickViewPrintedShiffon();
	}
	
	public void productDetailsOpen(){
		summerDressesPageObjects.verifyPrintedChifonDressProductDetailsOpens();
	}
	
	public void selectSize(String size){
		summerDressesPageObjects.selectSize(size);
	}
	
	public void addToCart(){
		summerDressesPageObjects.addToCartFromQuickView();
	}
	
	public void continueShopping(){
		summerDressesPageObjects.clickContinueShopping();
	}
	
	public void verifyProductSuccessfullyAdded(){
		summerDressesPageObjects.verifyProductSuccessfullyAdded();
	}
	
	public void clickCheckoutFromCart(){
		summerDressesPageObjects.clickCheckoutFromCart();;
	}
	
	public void clickProceedToCheckOutBeforeLogin(){
		orderPageObjects.proceedToCheckoutBeforeLogin();
	}
	
	public void clickProceedToCheckOutProcessAddress(){
		orderPageObjects.proceedToCheckoutProcessAddress();
	}
	
	public void clickProceedToCheckOutProcessCarrier(){
		orderPageObjects.proceedToCheckoutProcessCarrier();
	}
	
	public void verifyUserIsOnOrderPage(){
		orderPageObjects.verifyItIsOrderPage();
	}
	
	public void verifyProductNameAndSize(String productName, String productSize){
		String expectedProduct = orderPageObjects.getProductName().toString();
		String expectedSize = orderPageObjects.getProductSize().toString();
		Log.info("expected and actual products"+expectedProduct+" : "+productName);
		Log.info("expected and actual size"+expectedSize+" "+productSize);
		assertTrue(expectedProduct.equalsIgnoreCase(productName));
		assertTrue(expectedSize.contains(productSize));
	}

}
