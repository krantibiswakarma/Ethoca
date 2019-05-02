package StepDefinitions;

import com.automationpractice.PageObject.LoginPageObjects;

import Base.BaseUtil;
import Scenarios.CheckoutScenario;
import Scenarios.CreateAccountScenario;
import Util.Log;
import cucumber.api.java.en.*;

public class AccountCreationStepDefinition {

	BaseUtil base;
	CreateAccountScenario createAccountScenario;
	CheckoutScenario checkoutScenario;
	
	public AccountCreationStepDefinition(BaseUtil base){
		this.base = base;
		createAccountScenario = new CreateAccountScenario(base.driver);
		checkoutScenario = new CheckoutScenario(base.driver);
	}
	
	@When("the user enters the email {string} and clicks create an account")
	public void createAnAccount(String email) {
		createAccountScenario.enterEmailToCreateAccount(email);
		Log.info("It's createAnAccount");
	}
	
	@Then("the user should be taken to the {string} screen")
	public void verifyYourPersonalInformationScreenIsDisplayed(String screen) {
		createAccountScenario.verifyYourPersonalInformationScreenIsDisplayed();
		Log.info("It's verifyYourPersonalInformationScreenIsDisplayed");
	}
	
	@Then("the user enters title as {string}, first name as {string}, last name as {string}, password as {string}, address as {string}, city as {string}, state as {string}, postal code as {string}, country as {string}, mobile number as {string} and alias as {string} and clicks register")
	public void enterMandatoryDetails(String title, String first, String last, String password, String address, String city, String state, String postcode, String country, String mobileNumber, String alias) {
		createAccountScenario.enterMandatoryFields(title, first, last, password, address, city, state, postcode, country, mobileNumber, alias);
		createAccountScenario.submitAccount();
		Log.info("It's enterMandatoryDetails");
	}
	
	@Then("the user accepts the terms of service")
	public void acceptTermsOfService() {
		createAccountScenario.acceptTheTerms();
		Log.info("It's acceptTermsOfService");
	}
	
	@Then("the user clicks proceed to checkout button to process address")
	public void proceedToCheckoutProcessAddress() {
		checkoutScenario.clickProceedToCheckOutProcessAddress();
		Log.info("It's proceedToCheckoutProcessAddress");
	}
	
	@Then("the user clicks proceed to checkout button to process carrier")
	public void proceedToCheckoutProcessCarrier() {
		checkoutScenario.clickProceedToCheckOutProcessCarrier();
		Log.info("It's proceedToCheckoutProcessCarrier");
	}
	
}
