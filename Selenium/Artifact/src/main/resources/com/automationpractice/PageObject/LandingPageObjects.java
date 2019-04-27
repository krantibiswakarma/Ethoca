import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class LandingPageObjects {

	final WebDriver driver;
	
	@FindBy(how=How.NAME, using = "Women")
	@CacheLookup
	public WebElement women_Tab;
	
	@FindBy(how = How.NAME, using = "Women")
	@CacheLookup
	public WebElement summer_Dresses;
	
	public LandingPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSummerDressesWomen() {
		Actions action = new Actions(driver);
		action.moveToElement(women_Tab).moveToElement(summer_Dresses).build().perform();
	}
	
}
