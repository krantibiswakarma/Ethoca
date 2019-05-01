package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.*;

public class Hooks extends BaseUtil{

	BaseUtil base;
	WebDriver driver;
	
	public Hooks(BaseUtil base){
		this.base = base;
	}
		@Before
	    public void initializeTest(){
			System.setProperty("webdriver.chrome.driver", "/Users/krantibiswakarma/Documents/Drivers/chromedriver");
			driver = new ChromeDriver();
			base.driver = driver;
			driver.manage().window().maximize();
	        driver.get("http://automationpractice.com/index.php");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	 
	    @After
	    public void embedScreenshot(Scenario scenario) {
	    	//driver.quit();
	        if (scenario.isFailed()) {
	            try {
	                // Code to capture and embed images in test reports (if scenario fails)
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
