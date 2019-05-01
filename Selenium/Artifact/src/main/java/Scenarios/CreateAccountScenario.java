package Scenarios;

import org.openqa.selenium.WebDriver;

import com.automationpractice.PageObject.LoginPageObjects;

public class CreateAccountScenario {

	
	LoginPageObjects loginPageObjects;
	
	public CreateAccountScenario(WebDriver driver){
		loginPageObjects = new LoginPageObjects(driver);
	}
	
	public void enterEmailToCreateAccount(String email){
		loginPageObjects.enterEmail(String.valueOf(Math.round(100000 * Math.random()))+email);
		loginPageObjects.createAccount();
	}
	
	public void enterMandatoryFields(String title, String first, String last, String password, String address, String city, String state, String postcode, String country, String mobileNumber, String alias){
		
		if(title.equalsIgnoreCase("Mr")){
			loginPageObjects.selectTitleMale();
		}
		if(title.equalsIgnoreCase("Mrs")){
			loginPageObjects.selectTitleFemale();
		}
		
		loginPageObjects.enterFirstName(first);
		loginPageObjects.enterLastName(last);
		loginPageObjects.enterPassword(password);
		loginPageObjects.enterAddress(address);
		loginPageObjects.enterCity(city);
		loginPageObjects.enterState(state);
		loginPageObjects.enterPostCode(postcode);
		loginPageObjects.selectCountry(country);
		loginPageObjects.enterMobileNumber(mobileNumber);
		loginPageObjects.enterAlias(alias);
		
	}
	
	public void verifyUserIsOnLoginPage(){
		loginPageObjects.verifyItIsLoginPage();
	}
	
	public void verifyYourPersonalInformationScreenIsDisplayed(){
		loginPageObjects.verifyYourPersonalInformationScreenIsDisplayed();
	}
	
	public void submitAccount(){
		loginPageObjects.submitAccount();
	}
	
	public void acceptTheTerms(){
		loginPageObjects.acceptTheTerms();
	}
}
