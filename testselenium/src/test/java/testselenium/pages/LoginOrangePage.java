package testselenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrangePage 
{
	public WebDriver driver;
	public WebDriverWait wait;
	
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit' and @class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	WebElement login;
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement invalidLogin;
	
	public LoginOrangePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait (driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void enterUserName(String username)
	{
		wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(username);
		
	}
	
	public void enterPAss(String pasword)
	{
		wait.until(ExpectedConditions.visibilityOf(pass)).sendKeys(pasword);
	}
	public void clickLogn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(login))
        .click();
	}
	
	public String getInvalidMessage()
	{
		 return wait.until(ExpectedConditions.visibilityOf(invalidLogin)).getText();
		
	}
}
