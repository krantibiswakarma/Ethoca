package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.BaseUtil;
import Util.PropertyFileUtil;
import cucumber.api.Scenario;
import cucumber.api.java.*;

public class Hooks extends BaseUtil{

	BaseUtil base;
	PropertyFileUtil property;
	WebDriver driver;
	
	public Hooks(BaseUtil base){
		this.base = base;
	}
		@Before
	    public void initializeTest(){
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			base.driver = driver;
			driver.manage().window().maximize();
			property = new PropertyFileUtil();
	        driver.get(property.getApplicationUrl());
	        driver.manage().timeouts().implicitlyWait(property.getImplicitlyWait(), TimeUnit.SECONDS);
	    }
	 
	    @After
	    public void embedScreenshot(Scenario scenario) {
	        if (scenario.isFailed()) {
	            try {
	                // Code to capture and embed images in test reports (if scenario fails)
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    	driver.quit();
	    }
}
