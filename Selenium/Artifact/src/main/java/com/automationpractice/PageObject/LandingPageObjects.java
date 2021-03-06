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
import Util.Selenium;

public class LandingPageObjects extends BaseUtil{

	final WebDriver driver;
	final String title = "My Store";
	Selenium selenium;
	
	@FindBy(how=How.XPATH, using = "//a[@class='sf-with-ul'][contains(text(),'Women')]")
	public WebElement women_Tab;
	
	@FindBy(how = How.XPATH, using = ".//a[contains(text(),'Summer Dresses')]")
	public WebElement summer_Dresses;
	
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		selenium = new Selenium(driver);
	}
	
	public void verifyItIsLandingPage(){
		assertThat(driver.getTitle().toString(), equalToIgnoringCase(title));
		
	}
	
	public void clickSummerDressesWomen() {		
		selenium.moveToElement(women_Tab);
		selenium.waitUntilVisibleAndClickUsingActions(summer_Dresses);
	}

}
