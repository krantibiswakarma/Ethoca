package com.automationpractice.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseUtil;

public class OrderPageObjects extends BaseUtil{

	BaseUtil base;
	final WebDriver driver;
	final String title = "Order - My Store";
	
	public OrderPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutBeforeLogin;
	
	@FindBy(how = How.XPATH, using = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutProcessAddress;
	
	@FindBy(how = How.XPATH, using = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckoutProcessCarrier;
	
	@FindBy(how = How.XPATH, using = "//p[@class='product-name']/a")
	WebElement productName;
	
	@FindBy(how = How.XPATH, using = "//small[2]/a")
	WebElement productSize;
	
	public void verifyItIsOrderPage(){
		assertThat(driver.getTitle().toString(), equalToIgnoringCase(title));
	}
	
	public void proceedToCheckoutBeforeLogin(){
		proceedToCheckoutBeforeLogin.click();
		
	}
	
	public void proceedToCheckoutProcessAddress(){
		proceedToCheckoutProcessAddress.click();
		
	}
	
	public void proceedToCheckoutProcessCarrier(){
		proceedToCheckoutProcessCarrier.click();
		
	}
	
	public String getProductName(){
		return productName.getText();
	}
	
	public String getProductSize(){
		return productSize.getText();
	}
}
