package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;
	JavascriptExecutor js;
	
	public Selenium(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		action = new Actions(driver);
		js = (JavascriptExecutor) driver;
	}
	
	public void waitUntilVisibleAndClick(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public void waitUntilVisibleAndClickUsingActions(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
		action.moveToElement(element).click().build().perform();
	}
	
	public void waitUntilClickableThenClickUsingJS(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
		js.executeScript("arguments[0].click()", element);
	}
	
	public void moveToElement(WebElement element){
		action.moveToElement(element).build().perform();
	}
	
	public void waitUntilElementInvisible(WebElement element){
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitUntilElementVisible(WebElement element){
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
