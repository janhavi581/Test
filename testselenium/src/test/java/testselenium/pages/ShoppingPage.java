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

public class ShoppingPage
{
	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(xpath="//a[text()=' Products']")
	WebElement produ;
	
	@FindBy(xpath="//a[@href='/product_details/1']")
	WebElement viewProd;
	
	@FindBy (xpath="//button[@class='btn btn-default cart']")
	WebElement addtoCa;
	
	@FindBy(xpath="//a/u[text()='View Cart']")
	WebElement viewca;
	
	@FindBy(xpath="//a[text()='Blue Top']")
	WebElement veriProd;
	
	@FindBy(xpath="//a[@class='btn btn-default check_out']")
	WebElement checbut;
	
	@FindBy(xpath="//u[normalize-space()='Register / Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement loginButn;
	
	
	
	
	@FindBy(xpath="//a[contains(.,'Logged in as')]//b")
	WebElement verLog;
	
	
	public ShoppingPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickProd()
	{
		wait.until(ExpectedConditions.elementToBeClickable(produ)).click();
	}
	
	public void selectProduct()
	{
	    WebElement product = wait.until(
	            ExpectedConditions.visibilityOf(viewProd)
	    );

	    ((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView({block:'center'});",
	            product
	    );

	    try
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(product));
	        product.click();
	    }
	    catch (Exception e)
	    {
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].click();",
	                product
	        );
	    }

	    wait.until(ExpectedConditions.elementToBeClickable(addtoCa)).click();
	}
	
	public void viewCart()
	{
		wait.until(ExpectedConditions.elementToBeClickable(viewca)).click();
	}
	public void verifyCart()
	{
		String ex="Blue Top";
		String ac=veriProd.getText();
		System.out.println("The Actual Text is " +ac);
		Assert.assertEquals(ac,ex);
		
	}
	public void checkOutBut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(checbut)).click();
	}
	public void clickLoginLink()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
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
	
}
