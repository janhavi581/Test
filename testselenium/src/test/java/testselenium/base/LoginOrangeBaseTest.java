package testselenium.base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import testselenium.utils.ConfigReader;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginOrangeBaseTest
{
	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("orangeurl"));
		
		
		
		
		

		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.name("username")
	    ));

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
