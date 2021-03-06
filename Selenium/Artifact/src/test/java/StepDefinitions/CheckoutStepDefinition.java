package StepDefinitions;



import Base.BaseUtil;
import Scenarios.CheckoutScenario;
import Scenarios.CreateAccountScenario;
import Util.Log;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutStepDefinition extends BaseUtil{

	BaseUtil base;
	CheckoutScenario checkoutScenario;
	CreateAccountScenario createAccountScenario;
	
	public CheckoutStepDefinition(BaseUtil base){
		this.base = base;
		checkoutScenario = new CheckoutScenario(base.driver);
		createAccountScenario = new CreateAccountScenario(base.driver);
	}
	@Given("^that the user is in the landing page$")
	public void landingPage() throws Throwable {
		checkoutScenario.verifyThatUserIsOnLandingPage();
		Log.info("It's connected.....landing page");
		
	}

	@When("the user clicks the {string} tab and selects {string}")
	public void selectTabAndCategory(String tab, String category) {
		checkoutScenario.clickSummerDressesonWomenTab();
		Log.info("It's connected....."+tab+" "+category);
	}

	@Then("the {string} page should open")
	public void verifyPage(String page) {
		if(page.equalsIgnoreCase("Summer Dresses")){
			checkoutScenario.verifyUserIsOnSummerDressesPage();
			Log.info("It's connected....."+page);
		}
		if(page.equalsIgnoreCase("Order")){
			checkoutScenario.verifyUserIsOnOrderPage();
			Log.info("It's connected....."+page);
		}
		if(page.equalsIgnoreCase("Login")){
			createAccountScenario.verifyUserIsOnLoginPage();
			Log.info("It's connected....."+page);
		}
		
	}
	@Then("the user quick views the {string}")
	public void quickView(String item) {
		base.productChosen = item;
		checkoutScenario.quickViewPrintedShiffon();
		Log.info("It's connected....."+item);
	}
	@Then("the {string} product details should open")
	public void productWindowOpens(String item) {
		checkoutScenario.productDetailsOpen();
		Log.info("It's connected....."+item);
	}
	@When("the user selects size {string} and adds it to cart")
	public void addProductToCart(String size) {
		base.productSize = size;
		checkoutScenario.selectSize(size);
		checkoutScenario.addToCart();
		checkoutScenario.continueShopping();
		Log.info("It's connected....."+size);
	}
	@Then("the product should be successfully added to the cart")
	public void productSuccessfullyAdded() {
		checkoutScenario.verifyProductSuccessfullyAdded();
		Log.info("It's connected.....");
	}
	@Then("the user goes to the cart and clics checkout")
	public void checkoutFromCart() {
		checkoutScenario.clickCheckoutFromCart();
		Log.info("It's checkoutFromCart");
	}
	@When("the user clicks proceed to checkout button")
	public void proceedToCheckout() {
		checkoutScenario.clickProceedToCheckOutBeforeLogin();
		Log.info("It's proceedToCheckout");
	}
	@When("the user should be be able to see the correct order on the payment tab")
	public void verifyCorrectProductOnPaymentTab() {
		checkoutScenario.verifyProductNameAndSize(base.productChosen, base.productSize);
		Log.info("It's verifyCorrectProductOnPaymentTab");
	}
	
}
