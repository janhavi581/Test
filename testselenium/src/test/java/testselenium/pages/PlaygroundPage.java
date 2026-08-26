package testselenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaygroundPage
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	By iframe=By.xpath("//*[@id='practice-iframe']");
	By iname= By.xpath("//input[@id='iframe-name']");
	
	By alert= By.xpath("(//a[normalize-space()='S09 Alerts'])[1]");
	
	
	public PlaygroundPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public void clickIframe()
	{
	    WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(iframe)
	    );

	    new Actions(driver)
	        .moveToElement(element)
	        .click()
	        .perform();
	}
	public void enterNameIframe(String nameValue)
	{
	    

	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));

	   
	    driver.findElement(iname).sendKeys(nameValue);

	    driver.switchTo().defaultContent();
	}	
	public void clickAlert()
	{
	    WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(alert)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block: 'center'});",
	        element
	    );

	    wait.until(
	        ExpectedConditions.elementToBeClickable(element)
	    );

	    element.click();
	}
}
