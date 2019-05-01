package com.automationpractice.PageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseUtil;

public class LoginPageObjects extends BaseUtil{

	BaseUtil base;
	final WebDriver driver;
	final String title = "Login - My Store";
	Actions action;
	
	
	@FindBy(how = How.ID, using = "email_create")
	WebElement createEmail;
	
	@FindBy(how = How.XPATH, using = "//h3[contains(text(),'Your personal information')]")
	WebElement yourPersonalInformationScreen;
	
	@FindBy(how = How.ID, using = "SubmitCreate")
	WebElement createAnAccount;
	
	@FindBy(how = How.ID, using = "id_gender1")
	WebElement genderMale;
	
	@FindBy(how = How.ID, using = "id_gender2")
	WebElement genderFemale;
	
	@FindBy(how = How.ID, using = "customer_firstname")
	WebElement firstname;
	
	@FindBy(how = How.ID, using = "customer_lastname")
	WebElement lastname;
	
	@FindBy(how = How.ID, using = "passwd")
	WebElement password;
	
	@FindBy(how = How.ID, using = "days")
	WebElement day;
	
	@FindBy(how = How.ID, using = "months")
	WebElement month;
	
	@FindBy(how = How.ID, using = "years")
	WebElement year;
	
	@FindBy(how = How.ID, using = "address1")
	WebElement address1;
	
	@FindBy(how = How.ID, using = "city")
	WebElement city;
	
	@FindBy(how = How.ID, using = "id_state")
	WebElement state;
	
	@FindBy(how = How.ID, using = "postcode")
	WebElement postcode;
	
	@FindBy(how = How.ID, using = "id_country")
	WebElement country;
	
	@FindBy(how = How.ID, using = "phone_mobile")
	WebElement mobile;
	
	@FindBy(how = How.ID, using = "alias")
	WebElement alias; 
	
	@FindBy(how = How.ID, using = "submitAccount")
	WebElement register;
	
	@FindBy(how = How.ID, using = "cgv")
	WebElement terms;
	
	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
	}
	
	public void verifyItIsLoginPage(){
		assertThat(driver.getTitle().toString(), equalToIgnoringCase(title));
	}
	
	public void enterEmail(String email){
		createEmail.sendKeys(email);
	}
	
	public void createAccount(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(createAnAccount));
		createAnAccount.click();
	}
	
	public void selectTitleMale(){
		genderMale.click();
	}
	
	public void selectTitleFemale(){
		genderFemale.click();
	}
	
	public void enterFirstName(String first){
		firstname.sendKeys(first);
	}
	
	public void enterLastName(String last){
		lastname.sendKeys(last);
	}
	
	public void enterPassword(String password){
		this.password.sendKeys(password);
	}
	
	public void enterDOB(String day, String month, String year){
		Select s = new Select(this.day);
		this.day.click();
		s.selectByValue(day);
		
		Select s1 = new Select(this.month);
		this.month.click();
		s.selectByValue(month);
		
		Select s2 = new Select(this.year);
		this.year.click();
		s.selectByValue(year);
	}
	
	public void enterAddress(String address){
		address1.sendKeys(address);
	}
	
	public void enterCity(String city){
		this.city.sendKeys(city);
	}
	
	public void enterState(String state){
//		Select s = new Select(this.state);
//		this.state.click();
//		s.deselectByVisibleText(state);
		this.state.sendKeys(state);
		
	}
	
	public void enterPostCode(String postcode){
		this.postcode.sendKeys(postcode);
	}
	
	public void selectCountry(String country){
//		Select s = new Select(this.country);
//		this.country.click();
//		s.deselectByVisibleText(country);
		this.country.sendKeys(country);
	}
	
	public void enterMobileNumber(String mobileNumber){
		mobile.sendKeys(mobileNumber);
	}
	
	public void enterAlias(String alias){
		this.alias.sendKeys(alias);
	}
	
	public void submitAccount(){
		register.click();
	}
	
	public void verifyYourPersonalInformationScreenIsDisplayed(){
		assertTrue(yourPersonalInformationScreen.isDisplayed());
	}
	
	public void acceptTheTerms(){
		terms.click();
	}
}
