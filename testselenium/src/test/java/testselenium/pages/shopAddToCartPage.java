package testselenium.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class shopAddToCartPage 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath="//a[@href=\"/view_cart\"]")
	WebElement cartLink;
	
	public shopAddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	public void clickCartLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
	}
	public void verifyCartPage()
	{
		String ac=driver.getCurrentUrl();
		String ex = "https://automationexercise.com/view_cart";
		System.out.println("The Actual Cart Page URL " +ac);
		System.out.println("The Expected Cart Page URL " +ac);
		Assert.assertEquals(ac,ex);
	}
	

}
