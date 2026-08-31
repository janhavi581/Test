package testselenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingLoginPage
{
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath="//a[normalize-space()='Signup / Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement loginButn;
	
	@FindBy(xpath="//a[contains(.,'Logged in as')]//b")
	WebElement verLog;
	
	
	
	
	public ShoppingLoginPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(login)).click();
		
	}
	
	public void enterEmail(String em)
	{
		 wait.until(ExpectedConditions.visibilityOf(email));
		    email.sendKeys(em);
	}
	public void enterPass(String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(password));
	    password.sendKeys(pass);
	}
	public void clickLoginBt()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginButn)).click();
	}
	public void verifyLogin()
	{
		String ac= verLog.getText();
		System.out.println("The actual text is " +ac);
		String ex="janhavi mestry";
		Assert.assertEquals(ac, ex);
		
		
	}
	public void verifyInvalidLoginErrorMessage()
	{
		
    
		    String ac = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).getText();
		    System.out.println("The Actual Text is " +ac);
		    String ex = "Your email or password is incorrect!";
		    
		    Assert.assertEquals(ac, ex);
		}
		
	}

	
	
	
	


